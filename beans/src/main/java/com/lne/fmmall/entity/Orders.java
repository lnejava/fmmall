package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Orders {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 产品（多个产品，逗号分隔）
     */
    private String untitled;

    /**
     * 收货人快照
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收货人电话快照
     */
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    /**
     * 收货地址快走
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * 总金额
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 支付方式
     */
    @Column(name = "pay_type")
    private Byte payType;

    /**
     * 备注
     */
    @Column(name = "order_remark")
    private String orderRemark;

    /**
     * 订单状态（1-待付款，2-代发货，3-待收货，4-待评价，5-已完成，6-已关闭）
     */
    private Byte status;

    /**
     * 物流类型
     */
    @Column(name = "delivery_type")
    private Byte deliveryType;

    /**
     * 物流单号
     */
    @Column(name = "delivery_flow_id")
    private Long deliveryFlowId;

    /**
     * 订单运费
     */
    @Column(name = "order_freight")
    private BigDecimal orderFreight;

    /**
     * 订单删除状态
     */
    @Column(name = "delete_status")
    private Byte deleteStatus;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

    /**
     * 完成时间
     */
    @Column(name = "fish_time")
    private LocalDateTime fishTime;

    /**
     * 订单取消时间
     */
    @Column(name = "cancel_time")
    private LocalDateTime cancelTime;

    /**
     * 订单关闭类型（1-超时，2-退款，4-买家取消，5已完成）
     */
    @Column(name = "close_type")
    private Byte closeType;

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
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
     * 获取产品（多个产品，逗号分隔）
     *
     * @return untitled - 产品（多个产品，逗号分隔）
     */
    public String getUntitled() {
        return untitled;
    }

    /**
     * 设置产品（多个产品，逗号分隔）
     *
     * @param untitled 产品（多个产品，逗号分隔）
     */
    public void setUntitled(String untitled) {
        this.untitled = untitled;
    }

    /**
     * 获取收货人快照
     *
     * @return receiver_name - 收货人快照
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收货人快照
     *
     * @param receiverName 收货人快照
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 获取收货人电话快照
     *
     * @return receiver_mobile - 收货人电话快照
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * 设置收货人电话快照
     *
     * @param receiverMobile 收货人电话快照
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    /**
     * 获取收货地址快走
     *
     * @return receiver_address - 收货地址快走
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置收货地址快走
     *
     * @param receiverAddress 收货地址快走
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    /**
     * 获取总金额
     *
     * @return total_amount - 总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置总金额
     *
     * @param totalAmount 总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取支付方式
     *
     * @return pay_type - 支付方式
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     * 设置支付方式
     *
     * @param payType 支付方式
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     * 获取备注
     *
     * @return order_remark - 备注
     */
    public String getOrderRemark() {
        return orderRemark;
    }

    /**
     * 设置备注
     *
     * @param orderRemark 备注
     */
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    /**
     * 获取订单状态（1-待付款，2-代发货，3-待收货，4-待评价，5-已完成，6-已关闭）
     *
     * @return status - 订单状态（1-待付款，2-代发货，3-待收货，4-待评价，5-已完成，6-已关闭）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置订单状态（1-待付款，2-代发货，3-待收货，4-待评价，5-已完成，6-已关闭）
     *
     * @param status 订单状态（1-待付款，2-代发货，3-待收货，4-待评价，5-已完成，6-已关闭）
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取物流类型
     *
     * @return delivery_type - 物流类型
     */
    public Byte getDeliveryType() {
        return deliveryType;
    }

    /**
     * 设置物流类型
     *
     * @param deliveryType 物流类型
     */
    public void setDeliveryType(Byte deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * 获取物流单号
     *
     * @return delivery_flow_id - 物流单号
     */
    public Long getDeliveryFlowId() {
        return deliveryFlowId;
    }

    /**
     * 设置物流单号
     *
     * @param deliveryFlowId 物流单号
     */
    public void setDeliveryFlowId(Long deliveryFlowId) {
        this.deliveryFlowId = deliveryFlowId;
    }

    /**
     * 获取订单运费
     *
     * @return order_freight - 订单运费
     */
    public BigDecimal getOrderFreight() {
        return orderFreight;
    }

    /**
     * 设置订单运费
     *
     * @param orderFreight 订单运费
     */
    public void setOrderFreight(BigDecimal orderFreight) {
        this.orderFreight = orderFreight;
    }

    /**
     * 获取订单删除状态
     *
     * @return delete_status - 订单删除状态
     */
    public Byte getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置订单删除状态
     *
     * @param deleteStatus 订单删除状态
     */
    public void setDeleteStatus(Byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public LocalDateTime getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return delivery_time - 发货时间
     */
    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliveryTime 发货时间
     */
    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 获取完成时间
     *
     * @return fish_time - 完成时间
     */
    public LocalDateTime getFishTime() {
        return fishTime;
    }

    /**
     * 设置完成时间
     *
     * @param fishTime 完成时间
     */
    public void setFishTime(LocalDateTime fishTime) {
        this.fishTime = fishTime;
    }

    /**
     * 获取订单取消时间
     *
     * @return cancel_time - 订单取消时间
     */
    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置订单取消时间
     *
     * @param cancelTime 订单取消时间
     */
    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 获取订单关闭类型（1-超时，2-退款，4-买家取消，5已完成）
     *
     * @return close_type - 订单关闭类型（1-超时，2-退款，4-买家取消，5已完成）
     */
    public Byte getCloseType() {
        return closeType;
    }

    /**
     * 设置订单关闭类型（1-超时，2-退款，4-买家取消，5已完成）
     *
     * @param closeType 订单关闭类型（1-超时，2-退款，4-买家取消，5已完成）
     */
    public void setCloseType(Byte closeType) {
        this.closeType = closeType;
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