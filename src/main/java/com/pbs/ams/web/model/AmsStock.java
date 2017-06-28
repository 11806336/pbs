package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsStock implements Serializable {
    /**
     * 证券ID
     *
     * @mbg.generated
     */
    private Long stockId;

    /**
     * 证券名称
     *
     * @mbg.generated
     */
    private String stockName;

    /**
     * 证券代码
     *
     * @mbg.generated
     */
    private String stockCode;

    /**
     * 证券分类ID
     *
     * @mbg.generated
     */
    private Long stockCategoryId;

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

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Long getStockCategoryId() {
        return stockCategoryId;
    }

    public void setStockCategoryId(Long stockCategoryId) {
        this.stockCategoryId = stockCategoryId;
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