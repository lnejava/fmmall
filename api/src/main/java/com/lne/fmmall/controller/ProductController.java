package com.lne.fmmall.controller;

import com.lne.fmmall.service.ProductService;
import com.lne.fmmall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * FileName: ProductController
 * Author:   fengsulin
 * Date:     2022/5/3 22:57
 * Description:
 */
@RestController
@RequestMapping("/product")
@Api(value = "",tags = "商品管理")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/listByCategoryId")
    @ApiOperation("根据三级类别id分页查询商品")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Long",value = "三级类别id" ,name = "categoryId",required = true,example = "1"),
            @ApiImplicitParam(dataType = "Integer",value = "分页位置" ,name = "start",required = true,example = "1"),
            @ApiImplicitParam(dataType = "Integer",value = "每页记录数" ,name = "limit",required = true,example = "1")
    })
    public ResultVo listProductsByCategoryId(@RequestParam("categoryId") Long categoryId,
                                             @RequestParam("start") Integer start,
                                             @RequestParam("limit") Integer limit){
        return productService.listProductsByCategoryId(categoryId,start,limit);
    }

    @GetMapping("/listByKeywords")
    @ApiOperation("根据关键字查询")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",value = "关键字" ,name = "kw",required = true),
            @ApiImplicitParam(dataType = "Integer",value = "分页位置" ,name = "start",required = true,example = "1"),
            @ApiImplicitParam(dataType = "Integer",value = "每页记录数" ,name = "limit",required = true,example = "1")
    })
    public ResultVo listProductsByKeywords(@RequestParam("kw") String kw,
                                             @RequestParam("start") Integer start,
                                             @RequestParam("limit") Integer limit){
        return productService.listProductsByKeyword(kw,start,limit);
    }

}
