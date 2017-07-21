package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsTradeOrder implements Serializable {
    /**
     * 委托ID
     *
     * @mbg.generated
     */
    private Integer tradeOrderId;

    /**
     * 合约编号
     *
     * @mbg.generated
     */
    private String contractId;

    /**
     * 委托状态
     *
     * @mbg.generated
     */
    private Byte tradeOrderStatus;

    /**
     * 委托时间
     *
     * @mbg.generated
     */
    private Long tradeOrderDate;

    /**
     * 成交均价
     *
     * @mbg.generated
     */
    private BigDecimal knockAvgPrice;

    /**
     * 已撤数量
     *
     * @mbg.generated
     */
    private Integer cancelAmount;

    /**
     * 委托类别(买1/卖2)
     *
     * @mbg.generated
     */
    private Byte tradeOrderType;

    /**
     * ip来源
     *
     * @mbg.generated
     */
    private String ipSource;

    /**
     * MAC地址
     *
     * @mbg.generated
     */
    private String macAddress;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Long updateTime;

    /**
     * 操作人ID
     *
     * @mbg.generated
     */
    private Integer operatorId;

    private static final long serialVersionUID = 1L;

    public Integer getTradeOrderId() {
        return tradeOrderId;
    }

    public void setTradeOrderId(Integer tradeOrderId) {
        this.tradeOrderId = tradeOrderId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Byte getTradeOrderStatus() {
        return tradeOrderStatus;
    }

    public void setTradeOrderStatus(Byte tradeOrderStatus) {
        this.tradeOrderStatus = tradeOrderStatus;
    }

    public Long getTradeOrderDate() {
        return tradeOrderDate;
    }

    public void setTradeOrderDate(Long tradeOrderDate) {
        this.tradeOrderDate = tradeOrderDate;
    }

    public BigDecimal getKnockAvgPrice() {
        return knockAvgPrice;
    }

    public void setKnockAvgPrice(BigDecimal knockAvgPrice) {
        this.knockAvgPrice = knockAvgPrice;
    }

    public Integer getCancelAmount() {
        return cancelAmount;
    }

    public void setCancelAmount(Integer cancelAmount) {
        this.cancelAmount = cancelAmount;
    }

    public Byte getTradeOrderType() {
        return tradeOrderType;
    }

    public void setTradeOrderType(Byte tradeOrderType) {
        this.tradeOrderType = tradeOrderType;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}