package com.lne.fmmall.dao;

import com.lne.fmmall.entity.ProductImg;
import com.lne.fmmall.general.GeneralDAO;

import java.util.List;

public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    List<ProductImg> selectImgByProduct(long productId);
}