package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "order_item")
public class OrderItem {
    /**
     * 订单快照主键id
     */
    @Id
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "order_id")
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 商品快照id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 商品名称快照
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品图片快照
     */
    @Column(name = "product_img")
    private String productImg;

    /**
     * sku规格的id
     */
    @Column(name = "sku_id")
    private Long skuId;

    /**
     * sku名称
     */
    @Column(name = "sku_name")
    private String skuName;

    /**
     * 商品价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    @Column(name = "buy_counts")
    private Integer buyCounts;

    /**
     * 商品总金额
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 加入购物车时间
     */
    @Column(name = "basket_date")
    private LocalDateTime basketDate;

    /**
     * 购买时间
     */
    @Column(name = "buy_time")
    private LocalDateTime buyTime;

    /**
     * 是否评论过
     * 0否，1是
     */
    @Column(name = "is_comment")
    private Byte isComment;

    /**
     * 获取订单快照主键id
     *
     * @return item_id - 订单快照主键id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * 设置订单快照主键id
     *
     * @param itemId 订单快照主键id
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取商品快照id
     *
     * @return product_id - 商品快照id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品快照id
     *
     * @param productId 商品快照id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称快照
     *
     * @return product_name - 商品名称快照
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称快照
     *
     * @param productName 商品名称快照
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取商品图片快照
     *
     * @return product_img - 商品图片快照
     */
    public String getProductImg() {
        return productImg;
    }

    /**
     * 设置商品图片快照
     *
     * @param productImg 商品图片快照
     */
    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    /**
     * 获取sku规格的id
     *
     * @return sku_id - sku规格的id
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * 设置sku规格的id
     *
     * @param skuId sku规格的id
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
     * 获取商品价格
     *
     * @return product_price - 商品价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置商品价格
     *
     * @param productPrice 商品价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取购买数量
     *
     * @return buy_counts - 购买数量
     */
    public Integer getBuyCounts() {
        return buyCounts;
    }

    /**
     * 设置购买数量
     *
     * @param buyCounts 购买数量
     */
    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    /**
     * 获取商品总金额
     *
     * @return total_amount - 商品总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置商品总金额
     *
     * @param totalAmount 商品总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取加入购物车时间
     *
     * @return basket_LocalDateTime - 加入购物车时间
     */
    public LocalDateTime getBasketDate() {
        return basketDate;
    }

    /**
     * 设置加入购物车时间
     *
     * @param basketDate 加入购物车时间
     */
    public void setBasketDate(LocalDateTime basketDate) {
        this.basketDate = basketDate;
    }

    /**
     * 获取购买时间
     *
     * @return buy_time - 购买时间
     */
    public LocalDateTime getBuyTime() {
        return buyTime;
    }

    /**
     * 设置购买时间
     *
     * @param buyTime 购买时间
     */
    public void setBuyTime(LocalDateTime buyTime) {
        this.buyTime = buyTime;
    }

    /**
     * 获取是否评论过
     *
     * @return is_comment - 是否评论过
     */
    public Byte getIsComment() {
        return isComment;
    }

    /**
     * 设置是否评论过
     *
     * @param isComment 是否评论过
     */
    public void setIsComment(Byte isComment) {
        this.isComment = isComment;
    }
}