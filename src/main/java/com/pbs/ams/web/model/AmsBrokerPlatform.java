package com.pbs.ams.web.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/22.
 */
public class AmsBrokerPlatform implements Serializable {
    /**
     * 经纪公司ID
     *
     * @mbg.generated
     */
    private Integer brokerId;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private Integer brokerType;



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
     * 平台ID
     *
     * @mbg.generated
     */
    private Integer platformId;

    /**
     * 平台LOGO
     *
     * @mbg.generated
     */
    private String platformLogo;

    /**
     * 平台名称
     *
     * @mbg.generated
     */
    private String platformName;

    /**
     * 平台名称缩写
     *
     * @mbg.generated
     */
    private String platformAbbrName;

    /**
     * 平台类型
     *
     * @mbg.generated
     */
    private Integer platformType;

    /**
     * 是否可信 1:可信 0:不可信
     *
     * @mbg.generated
     */
    private Boolean creditable;

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


    public String getPlatformLogo() {
        return platformLogo;
    }

    public void setPlatformLogo(String platformLogo) {
        this.platformLogo = platformLogo;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformAbbrName() {
        return platformAbbrName;
    }

    public void setPlatformAbbrName(String platformAbbrName) {
        this.platformAbbrName = platformAbbrName;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(Integer brokerType) {
        this.brokerType = brokerType;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }


}
