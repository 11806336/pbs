package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsStockCategory implements Serializable {
    /**
     * 证券分类ID
     *
     * @mbg.generated
     */
    private Long stockCategoryId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 证券分类名称
     *
     * @mbg.generated
     */
    private String stockCategoryName;

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

    public Long getStockCategoryId() {
        return stockCategoryId;
    }

    public void setStockCategoryId(Long stockCategoryId) {
        this.stockCategoryId = stockCategoryId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getStockCategoryName() {
        return stockCategoryName;
    }

    public void setStockCategoryName(String stockCategoryName) {
        this.stockCategoryName = stockCategoryName;
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