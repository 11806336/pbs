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
    private String brokerId;

    /**
     * 产品IDID
     *
     * @mbg.generated
     */
    private String productId;

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

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stockAccountId=").append(stockAccountId);
        sb.append(", companyId=").append(companyId);
        sb.append(", stockAccountType=").append(stockAccountType);
        sb.append(", stockAccount=").append(stockAccount);
        sb.append(", stockAccountName=").append(stockAccountName);
        sb.append(", stockAccountPassword=").append(stockAccountPassword);
        sb.append(", brokerId=").append(brokerId);
        sb.append(", productId=").append(productId);
        sb.append(", stockAccountStatus=").append(stockAccountStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operatorId=").append(operatorId);
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
        AmsStockAccount other = (AmsStockAccount) that;
        return (this.getStockAccountId() == null ? other.getStockAccountId() == null : this.getStockAccountId().equals(other.getStockAccountId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getStockAccountType() == null ? other.getStockAccountType() == null : this.getStockAccountType().equals(other.getStockAccountType()))
            && (this.getStockAccount() == null ? other.getStockAccount() == null : this.getStockAccount().equals(other.getStockAccount()))
            && (this.getStockAccountName() == null ? other.getStockAccountName() == null : this.getStockAccountName().equals(other.getStockAccountName()))
            && (this.getStockAccountPassword() == null ? other.getStockAccountPassword() == null : this.getStockAccountPassword().equals(other.getStockAccountPassword()))
            && (this.getBrokerId() == null ? other.getBrokerId() == null : this.getBrokerId().equals(other.getBrokerId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getStockAccountStatus() == null ? other.getStockAccountStatus() == null : this.getStockAccountStatus().equals(other.getStockAccountStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStockAccountId() == null) ? 0 : getStockAccountId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getStockAccountType() == null) ? 0 : getStockAccountType().hashCode());
        result = prime * result + ((getStockAccount() == null) ? 0 : getStockAccount().hashCode());
        result = prime * result + ((getStockAccountName() == null) ? 0 : getStockAccountName().hashCode());
        result = prime * result + ((getStockAccountPassword() == null) ? 0 : getStockAccountPassword().hashCode());
        result = prime * result + ((getBrokerId() == null) ? 0 : getBrokerId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getStockAccountStatus() == null) ? 0 : getStockAccountStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        return result;
    }
}