package com.lne.fmmall.service;

import com.lne.fmmall.vo.ResultVo;

/**
 * FileName: UserService
 * Author:   fengsulin
 * Date:     2022/4/23 19:06
 * Description: 用户管理接口
 */
public interface UserService {
    /**用户注册接口*/
    ResultVo userRegister(String name,String password);
    /**用户登录接口*/
    ResultVo userLogin(String name,String password);
}
