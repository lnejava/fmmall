package com.lne.fmmall.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.lne.fmmall.entity.Orders;
import com.lne.fmmall.service.OrdersService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.Name;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: OrdersController
 * Author:   fengsulin
 * Date:     2022/5/10 23:59
 * Description: 订单管理控制类接口
 */
@RestController
@Api(value = "",tags = "订单管理")
@RequestMapping("/api/v1/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @PostMapping("/save")
    @ApiOperation("保存订单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",value = "购物车id",name = "cartIds"),
            @ApiImplicitParam(dataType = "com.lne.fmmall.entity.Orders",value = "订单实体类对象",name = "orders")
    })
    public ResultVo addOrders(String cartIds, @RequestBody Orders orders){
        // 保存订单

        ResultVo resultVo = ordersService.addOrder(cartIds, orders);
        Object orderId = null;
        orderId = resultVo.getData().get("orderId");
        String productName = (String) resultVo.getData().get("untitled");
        if(orderId == null){
            return new ResultVo(false,10001,"订单保存失败",null);
        }
        // 请求微信支付短链接
        WXPayConfig wxPayConfig = new WXPayConfig(){
            @Override
            public String getAppID() {
                return null;
            }

            @Override
            public String getMchID() {
                return null;
            }

            @Override
            public String getKey() {
                return null;
            }

            @Override
            public InputStream getCertStream() {
                return null;
            }

            @Override
            public int getHttpConnectTimeoutMs() {
                return 0;
            }

            @Override
            public int getHttpReadTimeoutMs() {
                return 0;
            }
        };
        WXPay wxPay = new WXPay(wxPayConfig);

        // 设置当前订单信息
        HashMap<String,String> data = new HashMap<>();
        data.put("body",productName ); // 商品描述
        data.put("out_trade_no", String.valueOf(orderId)); // 交易号（这里用订单编号作为交易号）
        data.put("fee_type","CNY"); //支付币种
        data.put("total_fee","1"); // 支付金额
        data.put("trade_type","NATIVE"); // 交易类型
        data.put("notify_url","/pay/success"); // 设置支付完成后的回调地址
        // 发送请求，获取响应
        Map<String, String> stringStringMap = null;
        try {
            stringStringMap = wxPay.unifiedOrder(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap<>();
        String code_url = stringStringMap.get("code_url");
        map.put("orderId",orderId);
        map.put("untitled",productName);
        map.put("code_url",code_url);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), resultVo.getMsg(), map);
    }
}
