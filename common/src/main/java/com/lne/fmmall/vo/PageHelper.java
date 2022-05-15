package com.lne.fmmall.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * FileName: PageHelper
 * Author:   fengsulin
 * Date:     2022/5/7 22:37
 * Description: 分页
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper<T> {
    /**总记录数*/
    private Integer count;

    /**总页数*/
    private Integer pageCount;

    /**分页数据*/
    private List<T> list;
}
