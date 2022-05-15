package com.lne.fmmall.dao;

import com.lne.fmmall.entity.Product;
import com.lne.fmmall.entity.ProductVo;
import com.lne.fmmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDAO<Product> {
    /**查询商品推荐*/
    List<ProductVo> selectRecommendProduct();

    /**根据三级类别id分页查询商品*/
    List<ProductVo> selectProductByCategoryId(@Param("categoryId") Long categoryId,
                                              @Param("start") Integer start,
                                              @Param("limit") Integer limit);

    /**查询某个类别下所有商品的品牌*/
    List<String> selectBrandsByCategoryId(Long categoryId);

    /**根据关键字查询，分页*/
    List<ProductVo> selectProductsByKeyword(@Param("kw") String kw,
                                            @Param("start") Integer start,
                                            @Param("limit") Integer limit);
}