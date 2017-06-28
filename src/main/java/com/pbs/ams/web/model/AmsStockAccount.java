package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsStockAccount implements Serializable {
    /**
     * 证券账号ID
     *
     * @mbg.generated
     */
    private Long stockAccountId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 账号类型
     *
     * @mbg.generated
     */
    private Integer stockAccountType;

    /**
     * 证券资金账号
     *
     * @mbg.generated
     */
    private Long stockAccount;

    /**
     * 证券账号名称
     *
     * @mbg.generated
     */
    private String stockAccountName;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String stockAccountPassword;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Long brokerId;

    /**
     * 产品IDID
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * 证券账号状态
     *
     * @mbg.generated
     */
    private String stockAccountStatus;

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

    public Long getStockAccountId() {
        return stockAccountId;
    }

    public void setStockAccountId(Long stockAccountId) {
        this.stockAccountId = stockAccountId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getStockAccountType() {
        return stockAccountType;
    }

    public void setStockAccountType(Integer stockAccountType) {
        this.stockAccountType = stockAccountType;
    }

    public Long getStockAccount() {
        return stockAccount;
    }

    public void setStockAccount(Long stockAccount) {
        this.stockAccount = stockAccount;
    }

    public String getStockAccountName() {
        return stockAccountName;
    }

    public void setStockAccountName(String stockAccountName) {
        this.stockAccountName = stockAccountName;
    }

    public String getStockAccountPassword() {
        return stockAccountPassword;
    }

    public void setStockAccountPassword(String stockAccountPassword) {
        this.stockAccountPassword = stockAccountPassword;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getStockAccountStatus() {
        return stockAccountStatus;
    }

    public void setStockAccountStatus(String stockAccountStatus) {
        this.stockAccountStatus = stockAccountStatus;
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