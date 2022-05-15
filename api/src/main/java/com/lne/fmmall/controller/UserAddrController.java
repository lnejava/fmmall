package com.lne.fmmall.controller;

import com.lne.fmmall.service.UserAddressService;
import com.lne.fmmall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * FileName: UserAddrController
 * Author:   fengsulin
 * Date:     2022/5/8 23:50
 * Description: 用户收货地址管理控制器
 */
@RestController
@RequestMapping("/address")
@Api(value = "",tags = "用户收货地址管理")
public class UserAddrController {
    @Resource
    private UserAddressService userAddressService;

    @GetMapping("/list")
    @ApiOperation("查询用户收货地址接口")
    @ApiImplicitParam(dataType = "Long",value = "用户id",name = "userId",required = true,example = "1")
    public ResultVo ListUserAddr(Long userId){
        return userAddressService.listUserAddress(userId);
    }
}
