package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "product_params")
public class ProductParams {
    /**
     * 参数主键id
     */
    @Id
    @Column(name = "param_id")
    private Long paramId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 生产地址
     */
    @Column(name = "product_place")
    private String productPlace;

    /**
     * 保质期
     */
    @Column(name = "foot_period")
    private String footPeriod;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 生产商
     */
    @Column(name = "factory_name")
    private String factoryName;

    /**
     * 生产地址
     */
    @Column(name = "factory_address")
    private String factoryAddress;

    /**
     * 包装方式
     */
    @Column(name = "packaging_method")
    private String packagingMethod;

    /**
     * 规格重量
     */
    private String weight;

    /**
     * 存储方式
     */
    @Column(name = "storage_method")
    private String storageMethod;

    /**
     * 使用方法
     */
    @Column(name = "eat_method")
    private String eatMethod;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "upLocalDateTime_time")
    private LocalDateTime upLocalDateTimeTime;

    /**
     * 获取参数主键id
     *
     * @return param_id - 参数主键id
     */
    public Long getParamId() {
        return paramId;
    }

    /**
     * 设置参数主键id
     *
     * @param paramId 参数主键id
     */
    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    /**
     * 获取商品id
     *
     * @return product_id - 商品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     *
     * @param productId 商品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取生产地址
     *
     * @return product_place - 生产地址
     */
    public String getProductPlace() {
        return productPlace;
    }

    /**
     * 设置生产地址
     *
     * @param productPlace 生产地址
     */
    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace == null ? null : productPlace.trim();
    }

    /**
     * 获取保质期
     *
     * @return foot_period - 保质期
     */
    public String getFootPeriod() {
        return footPeriod;
    }

    /**
     * 设置保质期
     *
     * @param footPeriod 保质期
     */
    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod == null ? null : footPeriod.trim();
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取生产商
     *
     * @return factory_name - 生产商
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * 设置生产商
     *
     * @param factoryName 生产商
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    /**
     * 获取生产地址
     *
     * @return factory_address - 生产地址
     */
    public String getFactoryAddress() {
        return factoryAddress;
    }

    /**
     * 设置生产地址
     *
     * @param factoryAddress 生产地址
     */
    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress == null ? null : factoryAddress.trim();
    }

    /**
     * 获取包装方式
     *
     * @return packaging_method - 包装方式
     */
    public String getPackagingMethod() {
        return packagingMethod;
    }

    /**
     * 设置包装方式
     *
     * @param packagingMethod 包装方式
     */
    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod == null ? null : packagingMethod.trim();
    }

    /**
     * 获取规格重量
     *
     * @return weight - 规格重量
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置规格重量
     *
     * @param weight 规格重量
     */
    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    /**
     * 获取存储方式
     *
     * @return storage_method - 存储方式
     */
    public String getStorageMethod() {
        return storageMethod;
    }

    /**
     * 设置存储方式
     *
     * @param storageMethod 存储方式
     */
    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod == null ? null : storageMethod.trim();
    }

    /**
     * 获取使用方法
     *
     * @return eat_method - 使用方法
     */
    public String getEatMethod() {
        return eatMethod;
    }

    /**
     * 设置使用方法
     *
     * @param eatMethod 使用方法
     */
    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod == null ? null : eatMethod.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return upLocalDateTime_time - 更新时间
     */
    public LocalDateTime getUpLocalDateTimeTime() {
        return upLocalDateTimeTime;
    }

    /**
     * 设置更新时间
     *
     * @param upLocalDateTimeTime 更新时间
     */
    public void setUpLocalDateTimeTime(LocalDateTime upLocalDateTimeTime) {
        this.upLocalDateTimeTime = upLocalDateTimeTime;
    }
}