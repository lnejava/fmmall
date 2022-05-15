package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.ProductCommentsMapper;
import com.lne.fmmall.entity.ProductComments;
import com.lne.fmmall.entity.ProductCommentsVo;
import com.lne.fmmall.service.ProductCommentsService;
import com.lne.fmmall.vo.PageHelper;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: ProductCommnetsServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/7 22:09
 * Description:
 */
@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {
    @Resource
    private ProductCommentsMapper productCommentsMapper;

    @Override
    public ResultVo listComments(Long productId,Integer pageNum,Integer pageSize) {
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        // productId指的是类的属性
        criteria.andEqualTo("productId",productId);
        // 根据商品id查询总评论数
        int count = productCommentsMapper.selectCountByExample(example);
        // 总分页数
        int pageCount = count / pageSize == 0 ? count/pageSize:count/pageSize + 1;
        //查询start位置
        int start = (pageNum-1)*pageCount;
        //当前页记录数据
        List<ProductCommentsVo> productCommentsVos = productCommentsMapper.selectCommentsByProductId(productId, start, pageSize);
        Map<String,Object> result = new HashMap<>();
        result.put("items",new PageHelper<ProductCommentsVo>(count,pageCount,productCommentsVos));
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);
    }
}
