package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsStockBlackWhiteList implements Serializable {
    /**
     * 黑白名单ID
     *
     * @mbg.generated
     */
    private Long blackWhiteId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 证券ID
     *
     * @mbg.generated
     */
    private Long stockId;

    /**
     * 市场ID
     *
     * @mbg.generated
     */
    private Long marketId;

    /**
     * 是否全局 1:是 0:否
     *
     * @mbg.generated
     */
    private Boolean isGlobal;

    /**
     * 1:黑名单 0:白名单
     *
     * @mbg.generated
     */
    private Boolean isBlack;

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

    public Long getBlackWhiteId() {
        return blackWhiteId;
    }

    public void setBlackWhiteId(Long blackWhiteId) {
        this.blackWhiteId = blackWhiteId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Boolean getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(Boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public Boolean getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(Boolean isBlack) {
        this.isBlack = isBlack;
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