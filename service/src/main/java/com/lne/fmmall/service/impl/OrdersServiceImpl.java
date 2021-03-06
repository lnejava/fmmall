package com.lne.fmmall.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lne.fmmall.dao.OrderItemMapper;
import com.lne.fmmall.dao.OrdersMapper;
import com.lne.fmmall.dao.ProductSkuMapper;
import com.lne.fmmall.dao.ShoppingCartMapper;
import com.lne.fmmall.entity.*;
import com.lne.fmmall.service.OrdersService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * FileName: OrdersServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/10 22:37
 * Description: 订单管理业务接口实现类
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private RedissonClient redissonClient;

    /**
     *订单保存业务(基于分布式的话，需要在该业务设置分布式锁)
     * @param: [cartIds, orders]
     * @return: com.lne.fmmall.vo.ResultVo
     */
    @Override
    @Transactional
    public ResultVo addOrder(String cartIds, Orders orders) {
        String[] ids = cartIds.split(",");
        List<Integer> collect = Arrays.asList(ids).stream().map(id -> Integer.parseInt(id)).collect(Collectors.toList());

        // 查询购物车记录
        List<ShoppingCartVo> cartVos = shoppingCartMapper.selectShoppingCartById(collect);
        // 利用redisson设置分布式锁
        Map<String,RLock> locks = new HashMap<>();
        boolean isLock = false;
        for(int i = 0;i<cartVos.size();i ++){
            String skuId = String.valueOf(cartVos.get(i).getSkuId());
            RLock lock = redissonClient.getLock(skuId);
             isLock = false;
            try {
                boolean b = lock.tryLock(10, 3, TimeUnit.SECONDS);
                if(b){
                    locks.put(skuId,lock);
                }
                isLock = b;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(isLock){
            // 加锁成功，执行业务操作
            // 为了防止高并发下，a用户刚查询完库存后，b用户修改库存，这里再次重新查库
            cartVos = shoppingCartMapper.selectShoppingCartById(collect);
            // flag用来获取库存比较
            Boolean flag = true;
            StringBuilder builder = new StringBuilder();
            int i = 0;
            // 比较库存
            for(ShoppingCartVo cartVo:cartVos){
                if(cartVo.getCartNum() > cartVo.getSkuStock()){
                    flag = false;
                }
                if(i == 0){
                    builder.append(cartVo.getProductName());
                }else {
                    builder.append(",").append(cartVo.getProductName());
                }
                i ++;
            }
            if(!flag){
                return new ResultVo(false,10001,"库存不足",null);
            }
            // 保存订单
            String untitled = new String(builder);
            long snowflakeNextId = IdUtil.getSnowflakeNextId();
            orders.setOrderId(snowflakeNextId);
            orders.setUntitled(untitled);
            orders.setStatus((byte) 1);
            orders.setCreateTime(LocalDateTime.now());
            orders.setPayType((byte) 1);
            int insert = ordersMapper.insert(orders);
            if(insert < 1){

            }
            // 修改库存
            for(ShoppingCartVo cartVo:cartVos){
                ProductSku productSku = new ProductSku();
                productSku.setSkuId(cartVo.getSkuId());
                int stockNum = cartVo.getSkuStock()-cartVo.getCartNum();
                productSku.setStock(stockNum);
                int isUpdate = productSkuMapper.updateByPrimaryKeySelective(productSku);
                if(isUpdate < 1){
                    flag = false;
                }

            }
            if(!flag){
                return new ResultVo(false,10001,"修改库存失败",null);
            }
            // 生成订单快照
            for(ShoppingCartVo cartVo:cartVos){
                OrderItem orderItem = new OrderItem();
                orderItem.setItemId(IdUtil.getSnowflakeNextId());
                orderItem.setOrderId(orders.getOrderId());
                orderItem.setBasketDate(cartVo.getCartTime());
                orderItem.setBuyCounts(cartVo.getCartNum());
                orderItem.setBuyTime(cartVo.getCreateTime());
                orderItem.setProductId(cartVo.getProductId());
                orderItem.setProductImg(cartVo.getProductImg());
                orderItem.setProductName(cartVo.getProductName());
                orderItem.setProductPrice(cartVo.getSellPrice());
                BigDecimal price = cartVo.getSellPrice();
                BigDecimal bigDecimal = new BigDecimal(cartVo.getCartNum());
                orderItem.setTotalAmount(price.multiply(bigDecimal));
                int isInsert = orderItemMapper.insert(orderItem);
                if(!flag){
                    flag = false;
                }
            }
            if(!flag){
                return new ResultVo(false,10001,"生成订单快照失败",null);
            }
            // 删除购物车记录
            for(ShoppingCartVo cartVo:cartVos){
                shoppingCartMapper.deleteByPrimaryKey(cartVo.getCartId());
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("orderId",orders.getOrderId());
            hashMap.put("untitled",orders.getUntitled());
            return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),hashMap);

        }else {
            // 购买的商品id没有全部加锁，则解锁
            for(int m = 0;m < cartVos.size();m ++){
                String skuId = String.valueOf(cartVos.get(m).getSkuId());
                if(skuId != null && !" ".equals(skuId)){
                    locks.get(skuId).unlock();
                }
            }
            return new ResultVo(false,10003,"库存不足",null);
        }
    }

    @Override
    public Integer updateOrderStatus(Long orderId, String status) {
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setStatus(Byte.valueOf(status));
        int isUpdate = ordersMapper.updateByPrimaryKey(orders);
        return isUpdate;
    }
}
