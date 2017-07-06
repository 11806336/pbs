package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsTradeAccount implements Serializable {
    /**
     * 账号ID
     *
     * @mbg.generated
     */
    private Long tradeAccountId;

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
    private Boolean tradeAccountType;

    /**
     * 交易账号
     *
     * @mbg.generated
     */
    private Long tradeAccount;

    /**
     * 账号名称
     *
     * @mbg.generated
     */
    private String tradeAccountName;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String tradeAccountPassword;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Long brokerId;

    /**
     * 证券公司ID
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * 账号状态
     *
     * @mbg.generated
     */
    private String tradeAccountStatus;

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
    /**
     * 登录状态  0:未登录1：登录
     *
     * @mbg.generated
     */
    private Integer isLogin;

    private static final long serialVersionUID = 1L;

    public Long getTradeAccountId() {
        return tradeAccountId;
    }

    public void setTradeAccountId(Long tradeAccountId) {
        this.tradeAccountId = tradeAccountId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getTradeAccountType() {
        return tradeAccountType;
    }

    public void setTradeAccountType(Boolean tradeAccountType) {
        this.tradeAccountType = tradeAccountType;
    }

    public Long getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(Long tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getTradeAccountName() {
        return tradeAccountName;
    }

    public void setTradeAccountName(String tradeAccountName) {
        this.tradeAccountName = tradeAccountName;
    }

    public String getTradeAccountPassword() {
        return tradeAccountPassword;
    }

    public void setTradeAccountPassword(String tradeAccountPassword) {
        this.tradeAccountPassword = tradeAccountPassword;
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

    public String getTradeAccountStatus() {
        return tradeAccountStatus;
    }

    public void setTradeAccountStatus(String tradeAccountStatus) {
        this.tradeAccountStatus = tradeAccountStatus;
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

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }
}