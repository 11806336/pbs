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
}