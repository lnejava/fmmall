package com.lne.fmmall.service;

import com.lne.fmmall.vo.ResultVo;


/**
 * FileName: UserAddrService
 * Author:   fengsulin
 * Date:     2022/5/8 23:41
 * Description: 用户地址管理dao接口
 */
public interface UserAddressService {
    /**根据用户id查询用户收货地址*/
    ResultVo listUserAddress(Long userId);
}
