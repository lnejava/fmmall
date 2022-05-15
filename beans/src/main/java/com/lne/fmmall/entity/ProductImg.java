package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "product_img")
public class ProductImg {
    /**
     * 图片主键id
     */
    @Id
    private Long id;

    /***
     * 商品id
     */
    private Long itemId;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 排序
     */
    private String sort;

    /**
     * 是否主图
     */
    @Column(name = "is_main")
    private Byte isMain;

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
     * 获取图片主键id
     *
     * @return id - 图片主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置图片主键id
     *
     * @param id 图片主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取图片地址
     *
     * @return url - 图片地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片地址
     *
     * @param url 图片地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 获取是否主图
     *
     * @return is_main - 是否主图
     */
    public Byte getIsMain() {
        return isMain;
    }

    /**
     * 设置是否主图
     *
     * @param isMain 是否主图
     */
    public void setIsMain(Byte isMain) {
        this.isMain = isMain;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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