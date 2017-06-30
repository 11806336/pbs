package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsBroker implements Serializable {
    /**
     * 经纪公司ID
     *
     * @mbg.generated
     */
    private Long brokerId;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private Integer brokerType;

    /**
     * 平台ID
     *
     * @mbg.generated
     */
    private Long platformId;

    /**
     * 缩写名称
     *
     * @mbg.generated
     */
    private String brokerAbbrName;

    /**
     * 券商LOGO
     *
     * @mbg.generated
     */
    private String brokerLogo;

    /**
     * 券商名称
     *
     * @mbg.generated
     */
    private String brokerName;

    /**
     * 是否可信 1:可信 0:不可信
     *
     * @mbg.generated
     */
    private Boolean creditable;

    /**
     * 日盘开始时间
     *
     * @mbg.generated
     */
    private Long dayBegin;

    /**
     * 日盘结束时间
     *
     * @mbg.generated
     */
    private Long dayEnd;

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

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(Integer brokerType) {
        this.brokerType = brokerType;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getBrokerAbbrName() {
        return brokerAbbrName;
    }

    public void setBrokerAbbrName(String brokerAbbrName) {
        this.brokerAbbrName = brokerAbbrName;
    }

    public String getBrokerLogo() {
        return brokerLogo;
    }

    public void setBrokerLogo(String brokerLogo) {
        this.brokerLogo = brokerLogo;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public Boolean getCreditable() {
        return creditable;
    }

    public void setCreditable(Boolean creditable) {
        this.creditable = creditable;
    }

    public Long getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(Long dayBegin) {
        this.dayBegin = dayBegin;
    }

    public Long getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Long dayEnd) {
        this.dayEnd = dayEnd;
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