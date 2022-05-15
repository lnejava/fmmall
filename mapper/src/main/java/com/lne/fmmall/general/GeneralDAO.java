package com.lne.fmmall.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * FileName: GeneralDAO
 * Author:   fengsulin
 * Date:     2022/4/26 21:23
 * Description:
 */
public interface GeneralDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
