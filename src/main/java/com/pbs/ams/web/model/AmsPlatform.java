package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsPlatform implements Serializable {
    /**
     * 平台ID
     *
     * @mbg.generated
     */
    private Long platformId;

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
    private Long operatorId;

    private static final long serialVersionUID = 1L;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

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

    public Boolean getCreditable() {
        return creditable;
    }

    public void setCreditable(Boolean creditable) {
        this.creditable = creditable;
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
        sb.append(", platformId=").append(platformId);
        sb.append(", platformLogo=").append(platformLogo);
        sb.append(", platformName=").append(platformName);
        sb.append(", platformAbbrName=").append(platformAbbrName);
        sb.append(", platformType=").append(platformType);
        sb.append(", creditable=").append(creditable);
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
        AmsPlatform other = (AmsPlatform) that;
        return (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getPlatformLogo() == null ? other.getPlatformLogo() == null : this.getPlatformLogo().equals(other.getPlatformLogo()))
            && (this.getPlatformName() == null ? other.getPlatformName() == null : this.getPlatformName().equals(other.getPlatformName()))
            && (this.getPlatformAbbrName() == null ? other.getPlatformAbbrName() == null : this.getPlatformAbbrName().equals(other.getPlatformAbbrName()))
            && (this.getPlatformType() == null ? other.getPlatformType() == null : this.getPlatformType().equals(other.getPlatformType()))
            && (this.getCreditable() == null ? other.getCreditable() == null : this.getCreditable().equals(other.getCreditable()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getPlatformLogo() == null) ? 0 : getPlatformLogo().hashCode());
        result = prime * result + ((getPlatformName() == null) ? 0 : getPlatformName().hashCode());
        result = prime * result + ((getPlatformAbbrName() == null) ? 0 : getPlatformAbbrName().hashCode());
        result = prime * result + ((getPlatformType() == null) ? 0 : getPlatformType().hashCode());
        result = prime * result + ((getCreditable() == null) ? 0 : getCreditable().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        return result;
    }
}