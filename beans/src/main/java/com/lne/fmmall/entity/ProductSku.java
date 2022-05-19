package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "product_sku")
public class ProductSku {
    /**
     * sku编号
     */
    @Id
    @Column(name = "sku_id")
    private Long skuId;

    @Column(name = "product_id")
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * sku名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * sku图片
     */
    @Column(name = "sku_img")
    private String skuImg;

    /**
     * 属性组合
     */
    private String untitled;

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * 原价
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * 折扣
     */
    private Double discounts;

    @Column(name = "sell_price")
    private BigDecimal sellPrice;


    /**
     * 库存
     */
    private Integer stock;

    /**
     * 状态（1启用，0禁用，-1删除）
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 获取sku编号
     *
     * @return sku_id - sku编号
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置sku编号
     *
     * @param skuId sku编号
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取sku名称
     *
     * @return sku_name - sku名称
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * 设置sku名称
     *
     * @param skuName sku名称
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    /**
     * 获取sku图片
     *
     * @return sku_img - sku图片
     */
    public String getSkuImg() {
        return skuImg;
    }

    /**
     * 设置sku图片
     *
     * @param skuImg sku图片
     */
    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg == null ? null : skuImg.trim();
    }

    /**
     * 获取属性组合
     *
     * @return untitled - 属性组合
     */
    public String getUntitled() {
        return untitled;
    }

    /**
     * 设置属性组合
     *
     * @param untitled 属性组合
     */
    public void setUntitled(String untitled) {
        this.untitled = untitled == null ? null : untitled.trim();
    }

    /**
     * 获取原价
     *
     * @return original_price - 原价
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价
     *
     * @param originalPrice 原价
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取折扣
     *
     * @return discounts - 折扣
     */
    public Double getDiscounts() {
        return discounts;
    }

    /**
     * 设置折扣
     *
     * @param discounts 折扣
     */
    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取状态（1启用，0禁用，-1删除）
     *
     * @return status - 状态（1启用，0禁用，-1删除）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态（1启用，0禁用，-1删除）
     *
     * @param status 状态（1启用，0禁用，-1删除）
     */
    public void setStatus(Byte status) {
        this.status = status;
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
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}