package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsTradeAccountExt implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long tradeAccountId;

    /**
     * 盈亏
     *
     * @mbg.generated
     */
    private String profitLoss;

    /**
     * 可用资金
     *
     * @mbg.generated
     */
    private BigDecimal availableFund;

    /**
     * 冻结资金
     *
     * @mbg.generated
     */
    private BigDecimal frozenFund;

    /**
     * 手续费
     *
     * @mbg.generated
     */
    private BigDecimal fee;

    /**
     * 总资金
     *
     * @mbg.generated
     */
    private BigDecimal totalFund;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Long updateTime;

    /**
     * 操作人id
     *
     * @mbg.generated
     */
    private Long operatorId;

    private static final long serialVersionUID = 1L;

    public Long getTradeAccountId() {
        return tradeAccountId;
    }

    public void setTradeAccountId(Long tradeAccountId) {
        this.tradeAccountId = tradeAccountId;
    }

    public String getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(String profitLoss) {
        this.profitLoss = profitLoss;
    }

    public BigDecimal getAvailableFund() {
        return availableFund;
    }

    public void setAvailableFund(BigDecimal availableFund) {
        this.availableFund = availableFund;
    }

    public BigDecimal getFrozenFund() {
        return frozenFund;
    }

    public void setFrozenFund(BigDecimal frozenFund) {
        this.frozenFund = frozenFund;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getTotalFund() {
        return totalFund;
    }

    public void setTotalFund(BigDecimal totalFund) {
        this.totalFund = totalFund;
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

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}