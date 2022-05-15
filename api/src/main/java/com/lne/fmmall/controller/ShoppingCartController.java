package com.lne.fmmall.controller;

import com.lne.fmmall.entity.ShoppingCart;
import com.lne.fmmall.service.ShoppingCartService;
import com.lne.fmmall.vo.CMSException;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * FileName: ChartController
 * Author:   fengsulin
 * Date:     2022/4/30 11:06
 * Description: 购物车
 */
@RestController
@RequestMapping("/cart")
@Api(value = "提供购物车管理等接口",tags="购物车管理")
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;


    @PostMapping("/save")
    @ApiOperation("添加购物车接口")
    public ResultVo saveShoppingCart(@RequestBody ShoppingCart shoppingCart,@RequestHeader String token){
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @GetMapping("/list")
    @ApiOperation("查询购物车记录接口")
    @ApiImplicitParam(dataType = "String",name = "cartIds",value = "购物车记录id")
    public ResultVo listShoppingCart(@RequestParam(name = "cartIds") String cartIds,
                                     @RequestHeader String token){   // 前端不容易传集合类型，所以这里以字符串替代集合，然后在service层，将字符串转换集合传入mapper
        return shoppingCartService.listShoppingCart(cartIds);
    }

}
