package com.lne.fmmall.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lne.fmmall.vo.ResultVo;
import io.swagger.models.auth.In;

/**
 * FileName: ProductService
 * Author:   fengsulin
 * Date:     2022/5/3 22:54
 * Description:
 */
public interface ProductService {
    public ResultVo listRecommendProducts();

    /**根据三级类别id分页查询商品*/
    public ResultVo listProductsByCategoryId(Long categoryId, Integer start,Integer limit);

    /**关键字分页查询*/
    public ResultVo listProductsByKeyword(String kw,Integer start,Integer limit);

    /**查询商品详情*/
    public ResultVo getProductBasicInfo(String productId) throws JsonProcessingException;
}
