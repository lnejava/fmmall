package com.lne.fmmall.controller;

import com.lne.fmmall.service.UserService;
import com.lne.fmmall.vo.CMSException;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * FileName: UserController
 * Author:   fengsulin
 * Date:     2022/4/23 23:24
 * Description: 用户管理控制器
 */
@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录和注册接口",tags = "用户管理")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",value = "用户名",name = "username",required = true),
            @ApiImplicitParam(dataType = "String",value = "登录密码",name = "password",required = true)
    })
    public ResultVo register(@RequestParam(name = "username") String name,
                             @RequestParam(name = "password") String pwd){
        return userService.userRegister(name,pwd);
    }

    @GetMapping("/login")
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",value = "用户名",name = "username",required = true),
            @ApiImplicitParam(dataType = "String",value = "登录密码",name = "password",required = true)
    })
    public ResultVo login(@RequestParam(name = "username") String name,
                          @RequestParam(name = "password") String pwd){
        return userService.userLogin(name,pwd);
    }

    /**测试全局异常处理器*/
    @GetMapping("/get")
    public ResultVo getException(){
        throw new CMSException(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMsg());
    }
    /**测试全局异常处理器*/
    @GetMapping("/get1")
    public ResultVo getException1() throws Exception {
        throw new Exception();
    }

}
