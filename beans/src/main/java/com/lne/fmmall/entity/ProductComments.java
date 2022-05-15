package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "product_comments")
public class ProductComments {
    /**
     * 评论主键id
     */
    @Id
    @Column(name = "comm_id")
    private Long commId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 订单项
     */
    @Column(name = "order_item_id")
    private Long orderItemId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 是否匿名
     */
    @Column(name = "is_anonymous")
    private Byte isAnonymous;

    /**
     * 评论类型（1-好评，0中评，-1差评）
     */
    @Column(name = "comm_type")
    private Byte commType;

    /**
     * 评论等级
     */
    @Column(name = "comm_level")
    private Byte commLevel;

    /**
     * 评论晒图
     */
    @Column(name = "comm_imgs")
    private String commImgs;

    /**
     * 评论时间
     */
    @Column(name = "spec_name")
    private LocalDateTime specName;

    /**
     * 是否回复（0-未回复，1-已回复）
     */
    @Column(name = "reply_status")
    private Byte replyStatus;

    /**
     * 回复时间
     */
    @Column(name = "reply_time")
    private LocalDateTime replyTime;

    /**
     * 是否展示
     */
    @Column(name = "is_show")
    private Byte isShow;

    /**
     * 评论内容
     */
    @Column(name = "comm_content")
    private String commContent;

    /**
     * 回复内容
     */
    @Column(name = "reply_content")
    private String replyContent;


    /**
     * 获取评论主键id
     *
     * @return comm_id - 评论主键id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置评论主键id
     *
     * @param commId 评论主键id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
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
     * 获取订单项
     *
     * @return order_item_id - 订单项
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 设置订单项
     *
     * @param orderItemId 订单项
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取是否匿名
     *
     * @return is_anonymous - 是否匿名
     */
    public Byte getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置是否匿名
     *
     * @param isAnonymous 是否匿名
     */
    public void setIsAnonymous(Byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 获取评论类型（1-好评，0中评，-1差评）
     *
     * @return comm_type - 评论类型（1-好评，0中评，-1差评）
     */
    public Byte getCommType() {
        return commType;
    }

    /**
     * 设置评论类型（1-好评，0中评，-1差评）
     *
     * @param commType 评论类型（1-好评，0中评，-1差评）
     */
    public void setCommType(Byte commType) {
        this.commType = commType;
    }

    /**
     * 获取评论等级
     *
     * @return comm_level - 评论等级
     */
    public Byte getCommLevel() {
        return commLevel;
    }

    /**
     * 设置评论等级
     *
     * @param commLevel 评论等级
     */
    public void setCommLevel(Byte commLevel) {
        this.commLevel = commLevel;
    }

    /**
     * 获取评论晒图
     *
     * @return comm_imgs - 评论晒图
     */
    public String getCommImgs() {
        return commImgs;
    }

    /**
     * 设置评论晒图
     *
     * @param commImgs 评论晒图
     */
    public void setCommImgs(String commImgs) {
        this.commImgs = commImgs == null ? null : commImgs.trim();
    }

    /**
     * 获取评论时间
     *
     * @return spec_name - 评论时间
     */
    public LocalDateTime getSpecName() {
        return specName;
    }

    /**
     * 设置评论时间
     *
     * @param specName 评论时间
     */
    public void setSpecName(LocalDateTime specName) {
        this.specName = specName;
    }

    /**
     * 获取是否回复（0-未回复，1-已回复）
     *
     * @return reply_status - 是否回复（0-未回复，1-已回复）
     */
    public Byte getReplyStatus() {
        return replyStatus;
    }

    /**
     * 设置是否回复（0-未回复，1-已回复）
     *
     * @param replyStatus 是否回复（0-未回复，1-已回复）
     */
    public void setReplyStatus(Byte replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 获取回复时间
     *
     * @return reply_time - 回复时间
     */
    public LocalDateTime getReplyTime() {
        return replyTime;
    }

    /**
     * 设置回复时间
     *
     * @param replyTime 回复时间
     */
    public void setReplyTime(LocalDateTime replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * 获取是否展示
     *
     * @return is_show - 是否展示
     */
    public Byte getIsShow() {
        return isShow;
    }

    /**
     * 设置是否展示
     *
     * @param isShow 是否展示
     */
    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取评论内容
     *
     * @return comm_content - 评论内容
     */
    public String getCommContent() {
        return commContent;
    }

    /**
     * 设置评论内容
     *
     * @param commContent 评论内容
     */
    public void setCommContent(String commContent) {
        this.commContent = commContent == null ? null : commContent.trim();
    }

    /**
     * 获取回复内容
     *
     * @return reply_content - 回复内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 设置回复内容
     *
     * @param replyContent 回复内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}