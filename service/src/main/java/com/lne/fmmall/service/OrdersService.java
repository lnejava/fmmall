package com.lne.fmmall.service;

import com.lne.fmmall.entity.Orders;
import com.lne.fmmall.vo.ResultVo;

/**
 * FileName: OrderService
 * Author:   fengsulin
 * Date:     2022/5/10 22:35
 * Description: 订单管理业务接口
 */
public interface OrdersService {
    /**添加订单接口*/
    ResultVo addOrder(String cartIds, Orders orders);

    /**修改订单状态*/
    Integer updateOrderStatus(Long orderId,String status);
}
