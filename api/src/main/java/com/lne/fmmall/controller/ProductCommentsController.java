package com.lne.fmmall.controller;

import com.lne.fmmall.service.ProductCommentsService;
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
 * FileName: ProductCommentsController
 * Author:   fengsulin
 * Date:     2022/5/7 22:13
 * Description: 商品评价控制器类
 */
@RestController
@RequestMapping("/product")
@Api(value = "提供商品评价管理接口",tags = "商品评价管理")
public class ProductCommentsController {
    @Resource
    private ProductCommentsService productCommentsService;

    //swagger中dataType类型为数字时，要给属性example，否则swagger会报数字类型错误
    @GetMapping("/comments")
    @ApiOperation("查询商品评价接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "long",name = "productId",value = "商品id",required = true,example = "1234566666666"),
            @ApiImplicitParam(dataType = "int",name = "start",value = "分页位置",required = true,example = "1"),
            @ApiImplicitParam(dataType = "int",name = "limit",value = "每页记录数",required = true,example = "1")
    })
    public ResultVo listComments(@RequestParam(name = "productId") long productId,
                                 @RequestParam(name = "start") int start,
                                 @RequestParam(name = "limit") int limit){
        return productCommentsService.listComments(productId,start,limit);
    }
}
