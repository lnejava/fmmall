package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.CategoryMapper;
import com.lne.fmmall.entity.CategoryVo;
import com.lne.fmmall.entity.ProductCommentsVo;
import com.lne.fmmall.service.CategoryService;
import com.lne.fmmall.vo.PageHelper;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: CategoryServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/3 21:35
 * Description: 分类信息管理接口实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResultVo selectAllCategories() {
        List<CategoryVo> categoryVos = categoryMapper.selectAllCategories();
        Map<String,Object> result = new HashMap<>();
        result.put("items",categoryVos);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);
    }
}
