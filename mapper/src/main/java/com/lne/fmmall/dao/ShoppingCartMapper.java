package com.lne.fmmall.dao;

import com.lne.fmmall.entity.ShoppingCart;
import com.lne.fmmall.entity.ShoppingCartVo;
import com.lne.fmmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {
    /**通哥购物车id查询购物车记录*/
    List<ShoppingCartVo> selectShoppingCartById(@Param("cartIds") List<Integer> cartIds);
}