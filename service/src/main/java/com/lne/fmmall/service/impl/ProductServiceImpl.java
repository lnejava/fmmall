package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.ProductMapper;
import com.lne.fmmall.entity.Product;
import com.lne.fmmall.entity.ProductVo;
import com.lne.fmmall.service.ProductService;
import com.lne.fmmall.vo.PageHelper;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: ProductServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/3 22:55
 * Description:
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResultVo listRecommendProducts() {
        List<ProductVo> productVos = productMapper.selectRecommendProduct();
        Map<String,Object> result = new HashMap<>();
        result.put("items",productVos);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);
    }

    @Override
    public ResultVo listProductsByCategoryId(Long categoryId, Integer start, Integer limit) {
        int count = (start - 1)*limit;
        List<ProductVo> productVos = productMapper.selectProductByCategoryId(categoryId, count, limit);
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",categoryId);
        // 总记录数
        int count1 = productMapper.selectCountByExample(example);
        // 总页数
        int pageNum = count1 % limit == 0 ? count1 / limit:count1 / count1 + 1;
        PageHelper<ProductVo> helper = new PageHelper<>(count1,pageNum,productVos);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("page",helper);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), objectObjectHashMap);
    }

    @Override
    public ResultVo listProductsByKeyword(String kw, Integer start, Integer limit) {
        kw = "%" + kw+"%";
        int count = (start - 1)*limit;
        List<ProductVo> productVos = productMapper.selectProductsByKeyword(kw, count, limit);
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productName",kw);
        // 总记录数
        int pageSize = productMapper.selectCountByExample(example);
        // 总页数
        int pageNum = pageSize % limit == 0 ? pageSize / limit:pageSize / limit + 1;
        PageHelper<ProductVo> helper = new PageHelper<>(pageSize,pageNum,productVos);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("page",helper);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), objectObjectHashMap);
    }
}
