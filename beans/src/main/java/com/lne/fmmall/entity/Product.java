package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Product {
    /**
     * 商品主键id
     */
    @Id
    @Column(name = "product_id")
    private Long productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品类别id
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 一级类别id
     */
    @Column(name = "root_category_id")
    private Long rootCategoryId;

    /**
     * 销量
     */
    @Column(name = "sold_num")
    private Integer soldNum;

    /**
     * 状态，1正常，0下架
     */
    @Column(name = "product_status")
    private Byte productStatus;

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
     * 商品内容
     */
    private String content;

    /**
     * 获取商品主键id
     *
     * @return product_id - 商品主键id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品主键id
     *
     * @param productId 商品主键id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取商品类别id
     *
     * @return category_id - 商品类别id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品类别id
     *
     * @param categoryId 商品类别id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取一级类别id
     *
     * @return root_category_id - 一级类别id
     */
    public Long getRootCategoryId() {
        return rootCategoryId;
    }

    /**
     * 设置一级类别id
     *
     * @param rootCategoryId 一级类别id
     */
    public void setRootCategoryId(Long rootCategoryId) {
        this.rootCategoryId = rootCategoryId;
    }

    /**
     * 获取销量
     *
     * @return sold_num - 销量
     */
    public Integer getSoldNum() {
        return soldNum;
    }

    /**
     * 设置销量
     *
     * @param soldNum 销量
     */
    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    /**
     * 获取状态，1正常，0下架
     *
     * @return product_status - 状态，1正常，0下架
     */
    public Byte getProductStatus() {
        return productStatus;
    }

    /**
     * 设置状态，1正常，0下架
     *
     * @param productStatus 状态，1正常，0下架
     */
    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
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

    /**
     * 获取商品内容
     *
     * @return content - 商品内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置商品内容
     *
     * @param content 商品内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}