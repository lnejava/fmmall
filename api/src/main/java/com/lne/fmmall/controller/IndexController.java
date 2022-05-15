package com.lne.fmmall.controller;

import com.lne.fmmall.service.CategoryService;
import com.lne.fmmall.service.IndexImgService;
import com.lne.fmmall.service.ProductService;
import com.lne.fmmall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: IndexImgController
 * Author:   fengsulin
 * Date:     2022/5/2 22:32
 * Description: 首页管理控制器类
 */
@RestController
@RequestMapping("/index")
@Api(value = "提供首页所需的数据接口",tags = "首页管理")
public class IndexController {
    @Autowired
    private IndexImgService indexImgService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/slideshow")
    @ApiOperation("首页轮播图查询接口")
    public ResultVo listIndexImg(){
        return indexImgService.listIndexImg();
    }

    @GetMapping("/category")
    @ApiOperation("商品分类信息查询接口")
    public ResultVo listCategory(){
        ResultVo resultVo = categoryService.selectAllCategories();
        return resultVo;
    }

    @GetMapping("/recommend")
    @ApiOperation("商品推荐接口")
    public ResultVo listRecommendProducts(){
        return productService.listRecommendProducts();
    }
}
