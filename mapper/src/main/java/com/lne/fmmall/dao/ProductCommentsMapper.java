package com.lne.fmmall.dao;

import com.lne.fmmall.entity.ProductComments;
import com.lne.fmmall.entity.ProductCommentsVo;
import com.lne.fmmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.List;

@Repository
public interface ProductCommentsMapper extends GeneralDAO<ProductComments> {
    /**根据商品id查询评价*/
    List<ProductCommentsVo> selectCommentsByProductId(@Param("productId") Long productId,
                                                      @Param("start") Integer start,
                                                      @Param("limit") Integer limit);
}