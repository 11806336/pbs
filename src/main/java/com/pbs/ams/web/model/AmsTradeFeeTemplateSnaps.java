package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsTradeFeeTemplateSnaps implements Serializable {
    /**
     * 快照时间
     *
     * @mbg.generated
     */
    private Long snapsTime;

    /**
     * 手续费模版ID
     *
     * @mbg.generated
     */
    private Long feeTemplateteId;

    /**
     * 证券分类
     *
     * @mbg.generated
     */
    private Long stockCategoryId;

    /**
     * 佣金率(%)
     *
     * @mbg.generated
     */
    private String commissionRate;

    /**
     * 最小佣金额
     *
     * @mbg.generated
     */
    private String minimumCommission;

    /**
     * 过户费率(%)
     *
     * @mbg.generated
     */
    private String transferFeeRate;

    /**
     * 计算过户费用最小量
     *
     * @mbg.generated
     */
    private String minimumChargeCount;

    /**
     * 买入印花税率(%)
     *
     * @mbg.generated
     */
    private String buyStampDutyRate;

    /**
     * 卖出印花税率(%)
     *
     * @mbg.generated
     */
    private String sellStampDutyRate;

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

    public Long getSnapsTime() {
        return snapsTime;
    }

    public void setSnapsTime(Long snapsTime) {
        this.snapsTime = snapsTime;
    }

    public Long getFeeTemplateteId() {
        return feeTemplateteId;
    }

    public void setFeeTemplateteId(Long feeTemplateteId) {
        this.feeTemplateteId = feeTemplateteId;
    }

    public Long getStockCategoryId() {
        return stockCategoryId;
    }

    public void setStockCategoryId(Long stockCategoryId) {
        this.stockCategoryId = stockCategoryId;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getMinimumCommission() {
        return minimumCommission;
    }

    public void setMinimumCommission(String minimumCommission) {
        this.minimumCommission = minimumCommission;
    }

    public String getTransferFeeRate() {
        return transferFeeRate;
    }

    public void setTransferFeeRate(String transferFeeRate) {
        this.transferFeeRate = transferFeeRate;
    }

    public String getMinimumChargeCount() {
        return minimumChargeCount;
    }

    public void setMinimumChargeCount(String minimumChargeCount) {
        this.minimumChargeCount = minimumChargeCount;
    }

    public String getBuyStampDutyRate() {
        return buyStampDutyRate;
    }

    public void setBuyStampDutyRate(String buyStampDutyRate) {
        this.buyStampDutyRate = buyStampDutyRate;
    }

    public String getSellStampDutyRate() {
        return sellStampDutyRate;
    }

    public void setSellStampDutyRate(String sellStampDutyRate) {
        this.sellStampDutyRate = sellStampDutyRate;
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