package com.lne.fmmall.service;

import com.lne.fmmall.vo.ResultVo;
import io.swagger.models.auth.In;

/**
 * FileName: ProductCommentsService
 * Author:   fengsulin
 * Date:     2022/5/7 22:07
 * Description: 商品评价接口
 */
public interface ProductCommentsService {
    /**根据商品id查询商品评价*/
    ResultVo listComments(Long ProductId, Integer start,Integer limit);
}
