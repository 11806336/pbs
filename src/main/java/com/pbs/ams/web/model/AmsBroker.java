package com.pbs.ams.web.model;

import java.io.Serializable;
import java.util.List;

public class AmsBroker implements Serializable {
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
     * 平台ID
     *
     * @mbg.generated
     */
    private Integer platformId;

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
    private Integer operatorId;

    private List<AmsPlatform> amsPlatform;

    private static final long serialVersionUID = 1L;

    public List<AmsPlatform> getAmsPlatform() {
        return amsPlatform;
    }

    public void setAmsPlatform(List<AmsPlatform> amsPlatform) {
        this.amsPlatform = amsPlatform;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", brokerId=").append(brokerId);
        sb.append(", brokerType=").append(brokerType);
        sb.append(", platformId=").append(platformId);
        sb.append(", brokerAbbrName=").append(brokerAbbrName);
        sb.append(", brokerLogo=").append(brokerLogo);
        sb.append(", brokerName=").append(brokerName);
        sb.append(", creditable=").append(creditable);
        sb.append(", dayBegin=").append(dayBegin);
        sb.append(", dayEnd=").append(dayEnd);
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
        AmsBroker other = (AmsBroker) that;
        return (this.getBrokerId() == null ? other.getBrokerId() == null : this.getBrokerId().equals(other.getBrokerId()))
            && (this.getBrokerType() == null ? other.getBrokerType() == null : this.getBrokerType().equals(other.getBrokerType()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getBrokerAbbrName() == null ? other.getBrokerAbbrName() == null : this.getBrokerAbbrName().equals(other.getBrokerAbbrName()))
            && (this.getBrokerLogo() == null ? other.getBrokerLogo() == null : this.getBrokerLogo().equals(other.getBrokerLogo()))
            && (this.getBrokerName() == null ? other.getBrokerName() == null : this.getBrokerName().equals(other.getBrokerName()))
            && (this.getCreditable() == null ? other.getCreditable() == null : this.getCreditable().equals(other.getCreditable()))
            && (this.getDayBegin() == null ? other.getDayBegin() == null : this.getDayBegin().equals(other.getDayBegin()))
            && (this.getDayEnd() == null ? other.getDayEnd() == null : this.getDayEnd().equals(other.getDayEnd()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBrokerId() == null) ? 0 : getBrokerId().hashCode());
        result = prime * result + ((getBrokerType() == null) ? 0 : getBrokerType().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getBrokerAbbrName() == null) ? 0 : getBrokerAbbrName().hashCode());
        result = prime * result + ((getBrokerLogo() == null) ? 0 : getBrokerLogo().hashCode());
        result = prime * result + ((getBrokerName() == null) ? 0 : getBrokerName().hashCode());
        result = prime * result + ((getCreditable() == null) ? 0 : getCreditable().hashCode());
        result = prime * result + ((getDayBegin() == null) ? 0 : getDayBegin().hashCode());
        result = prime * result + ((getDayEnd() == null) ? 0 : getDayEnd().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        return result;
    }
}