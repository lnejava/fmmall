package com.lne.fmmall.service.impl;

import com.lne.fmmall.dao.IndexImgMapper;
import com.lne.fmmall.entity.IndexImg;
import com.lne.fmmall.service.IndexImgService;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: IndexImgImpl
 * Author:   fengsulin
 * Date:     2022/5/2 22:26
 * Description: 轮播图管理实现类
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {
    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultVo listIndexImg() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImg();
        Map<String,Object> result = new HashMap<>();
        result.put("items",indexImgs);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);

    }
}
