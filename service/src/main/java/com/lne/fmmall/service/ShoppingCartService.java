package com.lne.fmmall.service;

import com.lne.fmmall.entity.ShoppingCart;
import com.lne.fmmall.vo.ResultVo;

import java.util.List;

/**
 * FileName: ShoppingCartService
 * Author:   fengsulin
 * Date:     2022/5/8 22:02
 * Description: 定义购物车管理dao接口
 */
public interface ShoppingCartService {
    /**添加购物车接口*/
    ResultVo saveShoppingCart(ShoppingCart shoppingCart);

    /**查询购物车记录接口*/
    ResultVo listShoppingCart(String cartIds);
}
