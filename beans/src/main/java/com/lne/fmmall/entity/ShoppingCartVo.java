package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "shopping_cart")
public class ShoppingCartVo {
    /**
     * 购物车id主键
     */
    @Id
    @Column(name = "cart_id")
    private Long cartId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Long productId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;


    /**
     * 规格id
     */
    @Column(name = "sku_id")
    private Long skuId;

    /**
     * 选择的套餐属性
     */
    @Column(name = "sku_props")
    private String skuProps;

    /**
     * 购物车数量
     */
    @Column(name = "cart_num")
    private Integer cartNum;

    /**
     * 添加购物车时间
     */
    @Column(name = "cart_time")
    private LocalDateTime cartTime;

    /**
     * 添加购物车时价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 库存
     */
    private Integer skuStock;

    /**
     * 商品名称
     */
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;


    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    private String productImg;
    private BigDecimal originalPrice;
    private BigDecimal sellPrice;
    private String skuName;

    /**
     * 获取购物车id主键
     *
     * @return cart_id - 购物车id主键
     */
    public Long getCartId() {
        return cartId;
    }

    /**
     * 设置购物车id主键
     *
     * @param cartId 购物车id主键
     */
    public void setCartId(Long cartId) {
        this.cartId = cartId;
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
     * 获取规格id
     *
     * @return sku_id - 规格id
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置规格id
     *
     * @param skuId 规格id
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * 获取选择的套餐属性
     *
     * @return sku_props - 选择的套餐属性
     */
    public String getSkuProps() {
        return skuProps;
    }

    /**
     * 设置选择的套餐属性
     *
     * @param skuProps 选择的套餐属性
     */
    public void setSkuProps(String skuProps) {
        this.skuProps = skuProps == null ? null : skuProps.trim();
    }

    /**
     * 获取购物车数量
     *
     * @return cart_num - 购物车数量
     */
    public Integer getCartNum() {
        return cartNum;
    }

    /**
     * 设置购物车数量
     *
     * @param cartNum 购物车数量
     */
    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum ;
    }

    /**
     * 获取添加购物车时间
     *
     * @return cart_time - 添加购物车时间
     */
    public LocalDateTime getCartTime() {
        return cartTime;
    }

    /**
     * 设置添加购物车时间
     *
     * @param cartTime 添加购物车时间
     */
    public void setCartTime(LocalDateTime cartTime) {
        this.cartTime = cartTime ;
    }

    /**
     * 获取添加购物车时价格
     *
     * @return product_price - 添加购物车时价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置添加购物车时价格
     *
     * @param productPrice 添加购物车时价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
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
     * @return update_time - 更新时间
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