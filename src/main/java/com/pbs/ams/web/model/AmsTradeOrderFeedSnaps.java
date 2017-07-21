package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsTradeOrderFeedSnaps implements Serializable {
    /**
     * 快照时间
     *
     * @mbg.generated
     */
    private Long snapsTime;

    /**
     * 成交ID
     *
     * @mbg.generated
     */
    private Integer tradeOrderFeedId;

    /**
     * 合同编号
     *
     * @mbg.generated
     */
    private String contractId;

    /**
     * 成交价格
     *
     * @mbg.generated
     */
    private BigDecimal tradePrice;

    /**
     * 成交数量
     *
     * @mbg.generated
     */
    private Integer tradeVolume;

    /**
     * 成交时间
     *
     * @mbg.generated
     */
    private Long tradeDate;

    /**
     * 成交金额
     *
     * @mbg.generated
     */
    private BigDecimal tradeOrderFeedAmount;

    /**
     * 买卖标记
     *
     * @mbg.generated
     */
    private String tradeMark;

    /**
     * 手续费
     *
     * @mbg.generated
     */
    private BigDecimal fee;

    /**
     * 操作人ID
     *
     * @mbg.generated
     */
    private Integer operatorId;

    private static final long serialVersionUID = 1L;

    public Long getSnapsTime() {
        return snapsTime;
    }

    public void setSnapsTime(Long snapsTime) {
        this.snapsTime = snapsTime;
    }

    public Integer getTradeOrderFeedId() {
        return tradeOrderFeedId;
    }

    public void setTradeOrderFeedId(Integer tradeOrderFeedId) {
        this.tradeOrderFeedId = tradeOrderFeedId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Integer getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(Integer tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public Long getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Long tradeDate) {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getTradeOrderFeedAmount() {
        return tradeOrderFeedAmount;
    }

    public void setTradeOrderFeedAmount(BigDecimal tradeOrderFeedAmount) {
        this.tradeOrderFeedAmount = tradeOrderFeedAmount;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}