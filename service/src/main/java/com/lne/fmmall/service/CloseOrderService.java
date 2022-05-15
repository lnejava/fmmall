package com.lne.fmmall.service;

/**
 * FileName: CloseOrderService
 * Author:   fengsulin
 * Date:     2022/5/14 23:13
 * Description: 关闭订单
 */
public interface CloseOrderService {

    /**超时关闭订单，修改库存*/
    public void closeOrder(Long orderId);
}
