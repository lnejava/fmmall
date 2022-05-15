package com.lne.fmmall.dao;

import com.lne.fmmall.entity.IndexImg;
import com.lne.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {
    /***
     * 查询轮播图信息：查询status=1，按照seq排序
     */
    List<IndexImg> listIndexImg();
}