package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "user_addr")
public class UserAddr {
    /**
     * 地址主键id
     */
    @Id
    @Column(name = "addr_id")
    private Long addrId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 收件人姓名
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收件人电话
     */
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地区
     */
    private String area;

    /**
     * 详细地址
     */
    private String addr;

    /**
     * 邮编
     */
    @Column(name = "post_code")
    private String postCode;

    /**
     * 状态，1正常，0无效
     */
    private Byte status;

    /**
     * 是否默认地址，1是
     */
    @Column(name = "common_addr")
    private Byte commonAddr;

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
     * 获取地址主键id
     *
     * @return addr_id - 地址主键id
     */
    public Long getAddrId() {
        return addrId;
    }

    /**
     * 设置地址主键id
     *
     * @param addrId 地址主键id
     */
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
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
     * 获取收件人姓名
     *
     * @return receiver_name - 收件人姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收件人姓名
     *
     * @param receiverName 收件人姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 获取收件人电话
     *
     * @return receiver_mobile - 收件人电话
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * 设置收件人电话
     *
     * @param receiverMobile 收件人电话
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取详细地址
     *
     * @return addr - 详细地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置详细地址
     *
     * @param addr 详细地址
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 获取邮编
     *
     * @return post_code - 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置邮编
     *
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
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
     * 获取是否默认地址，1是
     *
     * @return common_addr - 是否默认地址，1是
     */
    public Byte getCommonAddr() {
        return commonAddr;
    }

    /**
     * 设置是否默认地址，1是
     *
     * @param commonAddr 是否默认地址，1是
     */
    public void setCommonAddr(Byte commonAddr) {
        this.commonAddr = commonAddr;
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