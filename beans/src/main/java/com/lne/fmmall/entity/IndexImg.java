package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "index_img")
public class IndexImg {
    /**
     * 轮播图主键
     */
    @Id
    @Column(name = "img_id")
    private Long imgId;

    /**
     * 轮播图url
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 背景颜色
     */
    @Column(name = "img_bg_color")
    private String imgBgColor;

    /**
     * 商品id
     */
    @Column(name = "prod_id")
    private Long prodId;

    /**
     * 商品分类id
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 轮播图类型，1是商品，0是类别
     */
    @Column(name = "index_type")
    private Byte indexType;

    /**
     * 轮播图排序
     */
    private Integer seq;

    /**
     * 状态，1正常，0无效
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
    @Column(name = "upLocalDateTime_time")
    private LocalDateTime updateTime;

    /**
     * 获取轮播图主键
     *
     * @return img_id - 轮播图主键
     */
    public Long getImgId() {
        return imgId;
    }

    /**
     * 设置轮播图主键
     *
     * @param imgId 轮播图主键
     */
    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取轮播图url
     *
     * @return img_url - 轮播图url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置轮播图url
     *
     * @param imgUrl 轮播图url
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取背景颜色
     *
     * @return img_bg_color - 背景颜色
     */
    public String getImgBgColor() {
        return imgBgColor;
    }

    /**
     * 设置背景颜色
     *
     * @param imgBgColor 背景颜色
     */
    public void setImgBgColor(String imgBgColor) {
        this.imgBgColor = imgBgColor == null ? null : imgBgColor.trim();
    }

    /**
     * 获取商品id
     *
     * @return prod_id - 商品id
     */
    public Long getProdId() {
        return prodId;
    }

    /**
     * 设置商品id
     *
     * @param prodId 商品id
     */
    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    /**
     * 获取商品分类id
     *
     * @return category_id - 商品分类id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品分类id
     *
     * @param categoryId 商品分类id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取轮播图类型，1是商品，0是类别
     *
     * @return index_type - 轮播图类型，1是商品，0是类别
     */
    public Byte getIndexType() {
        return indexType;
    }

    /**
     * 设置轮播图类型，1是商品，0是类别
     *
     * @param indexType 轮播图类型，1是商品，0是类别
     */
    public void setIndexType(Byte indexType) {
        this.indexType = indexType;
    }

    /**
     * 获取轮播图排序
     *
     * @return seq - 轮播图排序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置轮播图排序
     *
     * @param seq 轮播图排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取状态，1正常，0无效
     *
     * @return status - 状态，1正常，0无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态，1正常，0无效
     *
     * @param status 状态，1正常，0无效
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