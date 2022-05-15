package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Category {
    /**
     * 商品类型主键id
     */
    @Id
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 类别名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 类别
     */
    @Column(name = "category_level")
    private Integer categoryLevel;

    /**
     * 父层级id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 图标id
     */
    @Column(name = "category_icon")
    private String categoryIcon;

    /**
     * 口号id
     */
    @Column(name = "category_slogan")
    private String categorySlogan;

    /**
     * 分类图id
     */
    @Column(name = "category_pic")
    private String categoryPic;

    /**
     * 背景颜色
     */
    @Column(name = "category_bg_color")
    private String categoryBgColor;

    /**
     * 获取商品类型主键id
     *
     * @return category_id - 商品类型主键id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品类型主键id
     *
     * @param categoryId 商品类型主键id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取类别名称
     *
     * @return category_name - 类别名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置类别名称
     *
     * @param categoryName 类别名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取类别
     *
     * @return category_level - 类别
     */
    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    /**
     * 设置类别
     *
     * @param categoryLevel 类别
     */
    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    /**
     * 获取父层级id
     *
     * @return parent_id - 父层级id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父层级id
     *
     * @param parentId 父层级id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取图标id
     *
     * @return category_icon - 图标id
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * 设置图标id
     *
     * @param categoryIcon 图标id
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();
    }

    /**
     * 获取口号id
     *
     * @return category_slogan - 口号id
     */
    public String getCategorySlogan() {
        return categorySlogan;
    }

    /**
     * 设置口号id
     *
     * @param categorySlogan 口号id
     */
    public void setCategorySlogan(String categorySlogan) {
        this.categorySlogan = categorySlogan == null ? null : categorySlogan.trim();
    }

    /**
     * 获取分类图id
     *
     * @return category_pic - 分类图id
     */
    public String getCategoryPic() {
        return categoryPic;
    }

    /**
     * 设置分类图id
     *
     * @param categoryPic 分类图id
     */
    public void setCategoryPic(String categoryPic) {
        this.categoryPic = categoryPic == null ? null : categoryPic.trim();
    }

    /**
     * 获取背景颜色
     *
     * @return category_bg_color - 背景颜色
     */
    public String getCategoryBgColor() {
        return categoryBgColor;
    }

    /**
     * 设置背景颜色
     *
     * @param categoryBgColor 背景颜色
     */
    public void setCategoryBgColor(String categoryBgColor) {
        this.categoryBgColor = categoryBgColor == null ? null : categoryBgColor.trim();
    }
}