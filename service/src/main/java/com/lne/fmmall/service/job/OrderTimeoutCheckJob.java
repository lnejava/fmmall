package com.lne.fmmall.service.job;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.lne.fmmall.dao.OrdersMapper;
import com.lne.fmmall.entity.Orders;
import com.lne.fmmall.service.CloseOrderService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: OrderTimeoutCheckJob
 * Author:   fengsulin
 * Date:     2022/5/14 21:34
 * Description: 订单超时定时任务
 */
//@Component
//@EnableScheduling
//public class OrderTimeoutCheckJob {
//    @Resource
//    private OrdersMapper ordersMapper;
//    @Resource
//    private CloseOrderService closeOrderService;
//
//    private WXPayConfig payConfig = new WXPayConfig(){
//        @Override
//        public String getAppID() {
//            return null;
//        }
//
//        @Override
//        public String getMchID() {
//            return null;
//        }
//
//        @Override
//        public String getKey() {
//            return null;
//        }
//
//        @Override
//        public InputStream getCertStream() {
//            return null;
//        }
//
//        @Override
//        public int getHttpConnectTimeoutMs() {
//            return 0;
//        }
//
//        @Override
//        public int getHttpReadTimeoutMs() {
//            return 0;
//        }
//    };
//
//    WXPay wxPay = new WXPay(payConfig);
//
//    /**
//     * 1.查询超过30分钟订单任仍为支付的订单
//     * @param:
//     * @return:
//     */
//    @Scheduled(cron = "* 0/30 * * * ?")
//    public void checkAndCloseOrder() throws Exception {
//        Example example = new Example(Orders.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("status",1);
//
//        Date time = new Date(System.currentTimeMillis() - 30 * 60 * 1000);
//        criteria.andLessThan("createTime",time);
//        // 得到可能是超时订单，访问微信平台接口，确认当前订单最终支付状态
//        List<Orders> orders = ordersMapper.selectByExample(example);
//
//        // 确认订单最终支付支付状态
//        for(Orders orders1: orders){
//            Map<String,String> params = new HashMap<>();
//            params.put("out_trade_no", String.valueOf(orders1.getOrderId()));
//            Map<String, String> stringStringMap = wxPay.orderQuery(params);
//            if("success".equalsIgnoreCase(stringStringMap.get("trade_state"))){
//                // 订单支付成功，修改订单状态为status=2 待发货
//                Orders orders2 = new Orders();
//                orders2.setOrderId(orders1.getOrderId());
//                orders2.setStatus((byte) 2);
//                ordersMapper.updateByPrimaryKeySelective(orders2);
//            }else if("NOTPAY".equalsIgnoreCase(stringStringMap.get("trade_state"))){
//                // 为了防止在修改库存时用户支付，关闭访问微信支付平台关闭订单
//                wxPay.closeOrder(params);
//                // 超时订单最终未支付，修改订单状态为status=6，close_type=1
//                closeOrderService.closeOrder(orders1.getOrderId());
//
//            }
//        }
//        //1.得到为超时未支付的订单后取消订单（修改订单状态），status=6 关闭订单，close_tye=1 超时未支付
//        // 2.还原库存
//
//    }
//}
