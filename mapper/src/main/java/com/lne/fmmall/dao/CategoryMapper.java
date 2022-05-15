package com.lne.fmmall.dao;

import com.lne.fmmall.entity.Category;
import com.lne.fmmall.entity.CategoryVo;
import com.lne.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDAO<Category> {
    /***
     * 查询分类信息接口(基于连接查询)
     */
    List<CategoryVo> selectAllCategories();

    /***
     * 查询分类信息接口（基于子查询）
     */
    List<CategoryVo> selectCategoriesByParent(long parentId);
}