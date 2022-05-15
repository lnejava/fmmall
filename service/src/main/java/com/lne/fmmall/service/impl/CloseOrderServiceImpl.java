package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.OrderItemMapper;
import com.lne.fmmall.dao.OrdersMapper;
import com.lne.fmmall.dao.ProductSkuMapper;
import com.lne.fmmall.entity.OrderItem;
import com.lne.fmmall.entity.Orders;
import com.lne.fmmall.entity.ProductSku;
import com.lne.fmmall.service.CloseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: CloseOrderServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/14 23:15
 * Description: 关闭订单业务实现类
 */
@Service
@Slf4j
public class CloseOrderServiceImpl implements CloseOrderService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ProductSkuMapper productSkuMapper;

    /**修改库存
     * 这里为了防止其他人同步修改库存，需要加锁；
     * 有两种方案：
     * 1.事务锁(Isolation.SERIALIZABLE)
     * 2.jvm锁（synchronized）
     * */
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void closeOrder(Long orderId) {
        synchronized (this){
            // 关闭订单
            Orders orders = new Orders();
            orders.setOrderId(orderId);
            orders.setStatus((byte)6);
            orders.setCloseType((byte)1);

            ordersMapper.updateByPrimaryKeySelective(orders);

            //还原库存
            // 查询订单快照
            Example example = new Example(OrderItem.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("orderId",String.valueOf(orderId));

            List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
            for(OrderItem orderItem:orderItems){
                // 查询商品属性表获取库存
                Example example1 = new Example(ProductSku.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria.andEqualTo("sku_id",orderItem.getSkuId());
                List<ProductSku> productSkus = productSkuMapper.selectByExample(example);

                ProductSku productSku = new ProductSku();
                productSku.setSkuId(orderItem.getSkuId());
                productSku.setStock(productSkus.get(0).getStock() + orderItem.getBuyCounts());

                productSkuMapper.updateByPrimaryKeySelective(productSku);
            }
        }
    }
}
