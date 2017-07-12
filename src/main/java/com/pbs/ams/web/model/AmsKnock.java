package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsKnock implements Serializable {
    /**
     * 成交ID
     *
     * @mbg.generated
     */
    private Long knockId;

    /**
     * 证券ID
     *
     * @mbg.generated
     */
    private Long stockId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

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
    private BigDecimal knockPrice;

    /**
     * 成交数量
     *
     * @mbg.generated
     */
    private Integer knockVolume;

    /**
     * 委托ID
     *
     * @mbg.generated
     */
    private Long entrustId;

    /**
     * 成交时间
     *
     * @mbg.generated
     */
    private Long knockDate;

    /**
     * 成交金额
     *
     * @mbg.generated
     */
    private BigDecimal knockAmount;

    /**
     * 买卖标记
     *
     * @mbg.generated
     */
    private String buySell;

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
    private Long operatorId;

    private static final long serialVersionUID = 1L;

    public Long getKnockId() {
        return knockId;
    }

    public void setKnockId(Long knockId) {
        this.knockId = knockId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getKnockPrice() {
        return knockPrice;
    }

    public void setKnockPrice(BigDecimal knockPrice) {
        this.knockPrice = knockPrice;
    }

    public Integer getKnockVolume() {
        return knockVolume;
    }

    public void setKnockVolume(Integer knockVolume) {
        this.knockVolume = knockVolume;
    }

    public Long getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Long entrustId) {
        this.entrustId = entrustId;
    }

    public Long getKnockDate() {
        return knockDate;
    }

    public void setKnockDate(Long knockDate) {
        this.knockDate = knockDate;
    }

    public BigDecimal getKnockAmount() {
        return knockAmount;
    }

    public void setKnockAmount(BigDecimal knockAmount) {
        this.knockAmount = knockAmount;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}