package com.lne.fmmall.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.lne.fmmall.service.OrdersService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: PayController
 * Author:   fengsulin
 * Date:     2022/5/13 17:20
 * Description:
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    private OrdersService ordersService;

    /**支付回调
     * 1.接收微信支付平台传递的数据
     * */
    @RequestMapping("/success")
    public String payNotify(HttpServletRequest request) throws Exception {
        // 读取流(响应的数据是xml格式)
        ServletInputStream is = request.getInputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        StringBuilder builder = new StringBuilder();
        while ((len = is.read(bytes)) != -1){
            String s = new String(bytes, 0, len);
            builder.append(s);
        }
        // 将微信平台的通知转换为map类型
        Map<String, String> xmlToMap = WXPayUtil.xmlToMap(builder.toString());

        if(xmlToMap != null && "success".equalsIgnoreCase(xmlToMap.get("result_code"))){
            // 支付成功，修改数据库订单状态
            Integer tradeNo = ordersService.updateOrderStatus(Long.valueOf(xmlToMap.get("out_trade_no")), "2");
            WebSocketServer.sendMsg(xmlToMap.get("appid"),"Ok");
            if(tradeNo > 0){
                // 响应微信通知，如果不响应微信平台会一直发通知
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("return_code","success");
                hashMap.put("return_msg","OK");
                hashMap.put("appid",xmlToMap.get("appid"));
                hashMap.put("result_code","success");
                return WXPayUtil.mapToXml(hashMap);
            }
        }
        return null;
    }
}
