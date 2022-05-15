package com.lne.fmmall.dao;

import com.lne.fmmall.entity.ProductSku;
import com.lne.fmmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSkuMapper extends GeneralDAO<ProductSku> {
    /**根据商品id查询价格最低的套餐*/
    List<ProductSku> selectByProductIds(@Param("productId") Long productId);
}