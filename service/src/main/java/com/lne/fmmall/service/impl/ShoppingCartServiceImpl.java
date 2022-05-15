package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.ShoppingCartMapper;
import com.lne.fmmall.entity.ShoppingCart;
import com.lne.fmmall.service.ShoppingCartService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * FileName: ShoppingCartServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/8 22:04
 * Description: dao购物车管理接口实现类
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public ResultVo saveShoppingCart(ShoppingCart shoppingCart) {
        int insert = shoppingCartMapper.insert(shoppingCart);
        if(insert >0){
            return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
        }
        return new ResultVo(ResultEnum.UNKNOWN_ERROR.getSuccess(), ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg(), null);
    }

    @Override
    public ResultVo listShoppingCart(String cartIds) {
        String[] cids = cartIds.split(",");
        List<Integer> nums = new ArrayList<>();
        for(int i = 0;i<cids.length;i++){
            int i1 = Integer.parseInt(cids[i]);
            nums.add(i1);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("items",shoppingCartMapper.selectShoppingCartById(nums));
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);
    }
}
