package com.lne.fmmall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lne.fmmall.dao.ProductImgMapper;
import com.lne.fmmall.dao.ProductMapper;
import com.lne.fmmall.dao.ProductSkuMapper;
import com.lne.fmmall.entity.Product;
import com.lne.fmmall.entity.ProductImg;
import com.lne.fmmall.entity.ProductSku;
import com.lne.fmmall.entity.ProductVo;
import com.lne.fmmall.service.ProductService;
import com.lne.fmmall.vo.PageHelper;
import com.lne.fmmall.vo.ResultVo;
import com.lne.fmmall.vo.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: ProductServiceImpl
 * Author:   fengsulin
 * Date:     2022/5/3 22:55
 * Description:
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImgMapper productImgMapper;
    @Autowired
    private ProductSkuMapper productSkuMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResultVo listRecommendProducts() {
        List<ProductVo> productVos = productMapper.selectRecommendProduct();
        Map<String,Object> result = new HashMap<>();
        result.put("items",productVos);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(),ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), result);
    }

    @Override
    public ResultVo listProductsByCategoryId(Long categoryId, Integer start, Integer limit) {
        int count = (start - 1)*limit;
        List<ProductVo> productVos = productMapper.selectProductByCategoryId(categoryId, count, limit);
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",categoryId);
        // ????????????
        int count1 = productMapper.selectCountByExample(example);
        // ?????????
        int pageNum = count1 % limit == 0 ? count1 / limit:count1 / count1 + 1;
        PageHelper<ProductVo> helper = new PageHelper<>(count1,pageNum,productVos);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("page",helper);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), objectObjectHashMap);
    }

    @Override
    public ResultVo listProductsByKeyword(String kw, Integer start, Integer limit) {
        kw = "%" + kw+"%";
        int count = (start - 1)*limit;
        List<ProductVo> productVos = productMapper.selectProductsByKeyword(kw, count, limit);
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("productName",kw);
        // ????????????
        int pageSize = productMapper.selectCountByExample(example);
        // ?????????
        int pageNum = pageSize % limit == 0 ? pageSize / limit:pageSize / limit + 1;
        PageHelper<ProductVo> helper = new PageHelper<>(pageSize,pageNum,productVos);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("page",helper);
        return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), objectObjectHashMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVo getProductBasicInfo(String productId) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        // ???redis???????????????
        log.info("===========????????????????????????===========");
        String productsInfo = (String) stringRedisTemplate.boundHashOps("product").get(productId);
        Map<String,Object> map = new HashMap<>();
        if(productsInfo != null){
            log.info("redis???????????????????????????productId??????????????????");
            Product product = objectMapper.readValue(productsInfo, Product.class);

            //productImgs
            String productImgs = (String) stringRedisTemplate.boundHashOps("productImgs").get(productId);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductImg.class);
            List<ProductImg> productImgs1 = objectMapper.readValue(productImgs, javaType);

            // productSku
            String productSkus = (String)stringRedisTemplate.boundHashOps("productSkus").get(productId);
            JavaType javaType1 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ProductSku.class);
            List<ProductSku> productSkus1 = objectMapper.readValue(productSkus, javaType1);

            // ????????????
            map.put("product",product);
            map.put("productImgs",productImgs1);
            map.put("productSkus",productSkus1);
            log.info("???redis????????????????????????");
            return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),map);


        }else {
            log.info("redis?????????????????????????????????????????????");
            Example example = new Example(Product.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("productId",productId);
            criteria.andEqualTo("productStatus",1);
            List<Product> products = productMapper.selectByExample(example);
            if(products.size() > 0){
                log.info("??????????????????");
                //????????????
                Example example1 = new Example(ProductImg.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("itemId",productId);
                List<ProductImg> productImgs = productImgMapper.selectByExample(example1);

                // ????????????
                Example example2 = new Example(ProductSku.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("productId",productId);
                criteria2.andEqualTo("status",1);
                List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);

                // ???????????????redis
                Product p = products.get(0);
                // product
                String p1 = objectMapper.writeValueAsString(p);
                stringRedisTemplate.boundHashOps("product").put(String.valueOf(p.getProductId()),p1);

                // productImgs
                String p2 = objectMapper.writeValueAsString(productImgs);
                stringRedisTemplate.boundHashOps("productImgs").put(String.valueOf(p.getProductId()),p2);

                // productSkus
                String p3 = objectMapper.writeValueAsString(productSkus);
                stringRedisTemplate.boundHashOps("productSkus").put(String.valueOf(p.getProductId()),p3);
                log.info("??????????????????reids??????");
                // ????????????,???????????????????????????
                map.put("product",products);
                map.put("productImgs",productImgs);
                map.put("productSkus",productSkus);
                log.info("?????????????????????????????????");
                return new ResultVo(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),map);
            }
            return new ResultVo(false,1001,"?????????????????????",null);
        }
    }
}
