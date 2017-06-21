package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsStockHoldingSnaps implements Serializable {
    /**
     * 证券持仓ID
     *
     * @mbg.generated
     */
    private Integer stockHoldingId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Integer brokerId;

    /**
     * 证券账号ID
     *
     * @mbg.generated
     */
    private Integer stockAccountId;

    /**
     * 市场ID
     *
     * @mbg.generated
     */
    private Integer marketId;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Integer stockId;

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
    private Integer operatorId;

    /**
     * 快照时间
     *
     * @mbg.generated
     */
    private Long snapsTime;

    private static final long serialVersionUID = 1L;

    public Integer getStockHoldingId() {
        return stockHoldingId;
    }

    public void setStockHoldingId(Integer stockHoldingId) {
        this.stockHoldingId = stockHoldingId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getStockAccountId() {
        return stockAccountId;
    }

    public void setStockAccountId(Integer stockAccountId) {
        this.stockAccountId = stockAccountId;
    }

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Long getSnapsTime() {
        return snapsTime;
    }

    public void setSnapsTime(Long snapsTime) {
        this.snapsTime = snapsTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stockHoldingId=").append(stockHoldingId);
        sb.append(", companyId=").append(companyId);
        sb.append(", brokerId=").append(brokerId);
        sb.append(", stockAccountId=").append(stockAccountId);
        sb.append(", marketId=").append(marketId);
        sb.append(", stockId=").append(stockId);
        sb.append(", marketCode=").append(marketCode);
        sb.append(", marketName=").append(marketName);
        sb.append(", stockCode=").append(stockCode);
        sb.append(", stockName=").append(stockName);
        sb.append(", currentStockHolding=").append(currentStockHolding);
        sb.append(", positionDate=").append(positionDate);
        sb.append(", positionCost=").append(positionCost);
        sb.append(", costValue=").append(costValue);
        sb.append(", singleCostValue=").append(singleCostValue);
        sb.append(", profitLoss=").append(profitLoss);
        sb.append(", marketValue=").append(marketValue);
        sb.append(", stockholderAccount=").append(stockholderAccount);
        sb.append(", frozenAmount=").append(frozenAmount);
        sb.append(", remaining=").append(remaining);
        sb.append(", transitShares=").append(transitShares);
        sb.append(", shareRemaining=").append(shareRemaining);
        sb.append(", latestPrice=").append(latestPrice);
        sb.append(", profitRate=").append(profitRate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", snapsTime=").append(snapsTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AmsStockHoldingSnaps other = (AmsStockHoldingSnaps) that;
        return (this.getStockHoldingId() == null ? other.getStockHoldingId() == null : this.getStockHoldingId().equals(other.getStockHoldingId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getBrokerId() == null ? other.getBrokerId() == null : this.getBrokerId().equals(other.getBrokerId()))
            && (this.getStockAccountId() == null ? other.getStockAccountId() == null : this.getStockAccountId().equals(other.getStockAccountId()))
            && (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getStockId() == null ? other.getStockId() == null : this.getStockId().equals(other.getStockId()))
            && (this.getMarketCode() == null ? other.getMarketCode() == null : this.getMarketCode().equals(other.getMarketCode()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getStockCode() == null ? other.getStockCode() == null : this.getStockCode().equals(other.getStockCode()))
            && (this.getStockName() == null ? other.getStockName() == null : this.getStockName().equals(other.getStockName()))
            && (this.getCurrentStockHolding() == null ? other.getCurrentStockHolding() == null : this.getCurrentStockHolding().equals(other.getCurrentStockHolding()))
            && (this.getPositionDate() == null ? other.getPositionDate() == null : this.getPositionDate().equals(other.getPositionDate()))
            && (this.getPositionCost() == null ? other.getPositionCost() == null : this.getPositionCost().equals(other.getPositionCost()))
            && (this.getCostValue() == null ? other.getCostValue() == null : this.getCostValue().equals(other.getCostValue()))
            && (this.getSingleCostValue() == null ? other.getSingleCostValue() == null : this.getSingleCostValue().equals(other.getSingleCostValue()))
            && (this.getProfitLoss() == null ? other.getProfitLoss() == null : this.getProfitLoss().equals(other.getProfitLoss()))
            && (this.getMarketValue() == null ? other.getMarketValue() == null : this.getMarketValue().equals(other.getMarketValue()))
            && (this.getStockholderAccount() == null ? other.getStockholderAccount() == null : this.getStockholderAccount().equals(other.getStockholderAccount()))
            && (this.getFrozenAmount() == null ? other.getFrozenAmount() == null : this.getFrozenAmount().equals(other.getFrozenAmount()))
            && (this.getRemaining() == null ? other.getRemaining() == null : this.getRemaining().equals(other.getRemaining()))
            && (this.getTransitShares() == null ? other.getTransitShares() == null : this.getTransitShares().equals(other.getTransitShares()))
            && (this.getShareRemaining() == null ? other.getShareRemaining() == null : this.getShareRemaining().equals(other.getShareRemaining()))
            && (this.getLatestPrice() == null ? other.getLatestPrice() == null : this.getLatestPrice().equals(other.getLatestPrice()))
            && (this.getProfitRate() == null ? other.getProfitRate() == null : this.getProfitRate().equals(other.getProfitRate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getSnapsTime() == null ? other.getSnapsTime() == null : this.getSnapsTime().equals(other.getSnapsTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStockHoldingId() == null) ? 0 : getStockHoldingId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getBrokerId() == null) ? 0 : getBrokerId().hashCode());
        result = prime * result + ((getStockAccountId() == null) ? 0 : getStockAccountId().hashCode());
        result = prime * result + ((getMarketId() == null) ? 0 : getMarketId().hashCode());
        result = prime * result + ((getStockId() == null) ? 0 : getStockId().hashCode());
        result = prime * result + ((getMarketCode() == null) ? 0 : getMarketCode().hashCode());
        result = prime * result + ((getMarketName() == null) ? 0 : getMarketName().hashCode());
        result = prime * result + ((getStockCode() == null) ? 0 : getStockCode().hashCode());
        result = prime * result + ((getStockName() == null) ? 0 : getStockName().hashCode());
        result = prime * result + ((getCurrentStockHolding() == null) ? 0 : getCurrentStockHolding().hashCode());
        result = prime * result + ((getPositionDate() == null) ? 0 : getPositionDate().hashCode());
        result = prime * result + ((getPositionCost() == null) ? 0 : getPositionCost().hashCode());
        result = prime * result + ((getCostValue() == null) ? 0 : getCostValue().hashCode());
        result = prime * result + ((getSingleCostValue() == null) ? 0 : getSingleCostValue().hashCode());
        result = prime * result + ((getProfitLoss() == null) ? 0 : getProfitLoss().hashCode());
        result = prime * result + ((getMarketValue() == null) ? 0 : getMarketValue().hashCode());
        result = prime * result + ((getStockholderAccount() == null) ? 0 : getStockholderAccount().hashCode());
        result = prime * result + ((getFrozenAmount() == null) ? 0 : getFrozenAmount().hashCode());
        result = prime * result + ((getRemaining() == null) ? 0 : getRemaining().hashCode());
        result = prime * result + ((getTransitShares() == null) ? 0 : getTransitShares().hashCode());
        result = prime * result + ((getShareRemaining() == null) ? 0 : getShareRemaining().hashCode());
        result = prime * result + ((getLatestPrice() == null) ? 0 : getLatestPrice().hashCode());
        result = prime * result + ((getProfitRate() == null) ? 0 : getProfitRate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getSnapsTime() == null) ? 0 : getSnapsTime().hashCode());
        return result;
    }
}