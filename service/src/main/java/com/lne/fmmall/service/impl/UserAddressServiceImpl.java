package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.UserAddrMapper;
import com.lne.fmmall.entity.UserAddr;
import com.lne.fmmall.service.UserAddressService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: UserAddressServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/8 23:44
 * Description: 用户收货地址管理dao接口实现类
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddrMapper userAddrMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVo listUserAddress(Long userId) {
        Example example = new Example(UserAddr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        criteria.andEqualTo("status",1);    // 1  默认地址，这里可以查询所有
        List<UserAddr> userAddrs = userAddrMapper.selectByExample(example);
        Map<String,Object> result = new HashMap<>();
        result.put("items",userAddrs);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);
    }
}
