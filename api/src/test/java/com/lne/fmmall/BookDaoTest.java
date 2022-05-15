package com.lne.fmmall;

import cn.hutool.core.util.IdUtil;
import com.lne.fmmall.controller.UserController;
import com.lne.fmmall.dao.CategoryMapper;
import com.lne.fmmall.dao.ProductCommentsMapper;
import com.lne.fmmall.entity.Category;
import com.lne.fmmall.entity.CategoryVo;
import com.lne.fmmall.entity.ProductCommentsVo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * FileName: BooksDaoTest
 * Author:   fengsulin
 * Date:     2022/4/17 9:55
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class BookDaoTest {

//    @Autowired
//    private UserController userController;
//    @Autowired
//    private CategoryDAO categoryDAO;
//    @Autowired
//    private OrderDAO orderDAO;
//    @Autowired
//    private UserDAO userDAO;
//    @Test
//    public void login() {
//        userController.login("fengsulin","123456");
//    }
//    @Test
//    public void register(){
//        userController.register("fengsulin","123456");
//    }
//
//    @Test
//    public void testInsert(){
//        long snowflakeNextId = IdUtil.getSnowflakeNextId();
//        Category category = new Category(snowflakeNextId, "测试类别2", 1, 0, "01.png", "hello", "app.jpg", "black");
//
////        int insert = categoryDAO.insert(category);    // 普通插入
//        int keys = categoryDAO.insertUseGeneratedKeys(category); // 插入后主键回填
//        System.out.println(category.getCategoryId());
//        System.out.println(keys);
//    }
//
//    @Test
//    public void testUpdate(){
//        long snowflakeNextId = IdUtil.getSnowflakeNextId();
//        Category category = new Category(1518250112643063808L, "测试类别3", 1, 0, "01.png", "hello", "app.jpg", "black");
//        int i = categoryDAO.updateByPrimaryKey(category);   // 通过主键更新
//        System.out.println(i);
//
//        // 通过条件更新
//    }
//
//    @Test
//    public void testDelete(){
//        int i = categoryDAO.deleteByPrimaryKey(1518250112643063808L);
//        System.out.println(i);
//    }
//
//    @Test
//    public void testSelectAll(){
//        List<Category> categories = categoryDAO.selectAll();
//        categories.forEach(category -> System.out.println(category));
//        categoryDAO.selectByPrimaryKey(1518250112643063808L); // 根据主键查询
//        // 条件查询
//        Example example = new Example(Category.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("categoryLevel","1");
//        criteria.orLike("categoryName","%干");
//        List<Category> categories1 = categoryDAO.selectByExample(example);
//    }
//    @Test
//    public void testPage(){
//        //分页查询
//        int pageNum = 2;
//        int pageSize = 3;
//        int start = (pageNum-1)*pageSize;
//        RowBounds rowBounds = new RowBounds(start, pageSize);
//        Example example = new Example(Category.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andLike("categoryLevel","%1%");
//        List<Category> categories = categoryDAO.selectByExampleAndRowBounds(example, rowBounds);
//        //查询满足条件的总记录数
//        categoryDAO.selectCountByExample(example);
//    }
//    @Test
//    public void testRelationSelect(){
//        User user = userDAO.queryUserByName("fengsulin");
//        long userId = user.getUserId();
//        Example example = new Example(Orders.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("userId",userId);
//        List<Orders> orders = orderDAO.selectByExample(example);
//        orders.forEach(orders1 -> System.out.println(orders1));
//    }
//    @Test
//    public void testSelectByUsername(){
//        User fengsulin = userDAO.selectByUsername("fengsulin");
//        String s = fengsulin.toString();
//    }
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductCommentsMapper productCommentsMapper;

    @Test
    public void selectAllCategories(){
        List<CategoryVo> categories = categoryMapper.selectAllCategories();
//        Optional.ofNullable(categories).orElse(Collections.emptyList()).stream().forEach(category -> System.out.println(category));
    }
    @Test
    public void selectCategoriesByParent(){
        List<CategoryVo> categories = categoryMapper.selectCategoriesByParent(0);
//        Optional.ofNullable(categories).orElse(Collections.emptyList()).stream().forEach(category -> System.out.println(category));
    }
    // 商品评价
    @Test
    public void selectComments(){
        List<ProductCommentsVo> productCommentsVos = productCommentsMapper.selectCommentsByProductId(3L,2,2);
        Optional.ofNullable(productCommentsVos).orElse(Collections.emptyList()).stream().forEach(System.out::println);
    }

}