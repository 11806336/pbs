package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsStockHolding implements Serializable {
    /**
     * 证券持仓ID
     *
     * @mbg.generated
     */
    private Long stockHoldingId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Long brokerId;

    /**
     * 证券账号ID
     *
     * @mbg.generated
     */
    private Long stockAccountId;

    /**
     * 市场ID
     *
     * @mbg.generated
     */
    private Long marketId;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Long stockId;

    /**
     * 市场代码
     *
     * @mbg.generated
     */
    private String marketCode;

    /**
     * 市场名称
     *
     * @mbg.generated
     */
    private String marketName;

    /**
     * 证券代码
     *
     * @mbg.generated
     */
    private String stockCode;

    /**
     * 证券名称
     *
     * @mbg.generated
     */
    private String stockName;

    /**
     * 当前拥股
     *
     * @mbg.generated
     */
    private Integer currentStockHolding;

    /**
     * 持仓日期
     *
     * @mbg.generated
     */
    private Long positionDate;

    /**
     * 持仓成本
     *
     * @mbg.generated
     */
    private BigDecimal positionCost;

    /**
     * 成本价
     *
     * @mbg.generated
     */
    private BigDecimal costValue;

    /**
     * 单股成本价
     *
     * @mbg.generated
     */
    private BigDecimal singleCostValue;

    /**
     * 盈亏
     *
     * @mbg.generated
     */
    private String profitLoss;

    /**
     * 市值
     *
     * @mbg.generated
     */
    private BigDecimal marketValue;

    /**
     * 股东账号
     *
     * @mbg.generated
     */
    private String stockholderAccount;

    /**
     * 冻结数量
     *
     * @mbg.generated
     */
    private Integer frozenAmount;

    /**
     * 可用余额
     *
     * @mbg.generated
     */
    private BigDecimal remaining;

    /**
     * 在途股份
     *
     * @mbg.generated
     */
    private Integer transitShares;

    /**
     * 股份余额
     *
     * @mbg.generated
     */
    private BigDecimal shareRemaining;

    /**
     * 最新价
     *
     * @mbg.generated
     */
    private BigDecimal latestPrice;

    /**
     * 盈亏比例
     *
     * @mbg.generated
     */
    private String profitRate;

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
    private Long operatorId;

    private static final long serialVersionUID = 1L;

    public Long getStockHoldingId() {
        return stockHoldingId;
    }

    public void setStockHoldingId(Long stockHoldingId) {
        this.stockHoldingId = stockHoldingId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public Long getStockAccountId() {
        return stockAccountId;
    }

    public void setStockAccountId(Long stockAccountId) {
        this.stockAccountId = stockAccountId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Integer getCurrentStockHolding() {
        return currentStockHolding;
    }

    public void setCurrentStockHolding(Integer currentStockHolding) {
        this.currentStockHolding = currentStockHolding;
    }

    public Long getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(Long positionDate) {
        this.positionDate = positionDate;
    }

    public BigDecimal getPositionCost() {
        return positionCost;
    }

    public void setPositionCost(BigDecimal positionCost) {
        this.positionCost = positionCost;
    }

    public BigDecimal getCostValue() {
        return costValue;
    }

    public void setCostValue(BigDecimal costValue) {
        this.costValue = costValue;
    }

    public BigDecimal getSingleCostValue() {
        return singleCostValue;
    }

    public void setSingleCostValue(BigDecimal singleCostValue) {
        this.singleCostValue = singleCostValue;
    }

    public String getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(String profitLoss) {
        this.profitLoss = profitLoss;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getStockholderAccount() {
        return stockholderAccount;
    }

    public void setStockholderAccount(String stockholderAccount) {
        this.stockholderAccount = stockholderAccount;
    }

    public Integer getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Integer frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public Integer getTransitShares() {
        return transitShares;
    }

    public void setTransitShares(Integer transitShares) {
        this.transitShares = transitShares;
    }

    public BigDecimal getShareRemaining() {
        return shareRemaining;
    }

    public void setShareRemaining(BigDecimal shareRemaining) {
        this.shareRemaining = shareRemaining;
    }

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(BigDecimal latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(String profitRate) {
        this.profitRate = profitRate;
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