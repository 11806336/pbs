package com.pbs.ams.web.model;

import java.io.Serializable;

public class SysGlobalConstData implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long globalConstDataId;

    /**
     * 常量数据枚举值
     *
     * @mbg.generated
     */
    private String globalConstDataValue;

    /**
     * 全局常量编码
     *
     * @mbg.generated
     */
    private String globalConstCode;

    /**
     * 常量数据枚举名称
     *
     * @mbg.generated
     */
    private String globalConstDataName;

    /**
     * 是否删除 1：删除 0：未删除
     *
     * @mbg.generated
     */
    private Boolean isDelete;

    /**
     * 父id
     *
     * @mbg.generated
     */
    private Long parentGlobalDataId;

    private static final long serialVersionUID = 1L;

    public Long getGlobalConstDataId() {
        return globalConstDataId;
    }

    public void setGlobalConstDataId(Long globalConstDataId) {
        this.globalConstDataId = globalConstDataId;
    }

    public String getGlobalConstDataValue() {
        return globalConstDataValue;
    }

    public void setGlobalConstDataValue(String globalConstDataValue) {
        this.globalConstDataValue = globalConstDataValue;
    }

    public String getGlobalConstCode() {
        return globalConstCode;
    }

    public void setGlobalConstCode(String globalConstCode) {
        this.globalConstCode = globalConstCode;
    }

    public String getGlobalConstDataName() {
        return globalConstDataName;
    }

    public void setGlobalConstDataName(String globalConstDataName) {
        this.globalConstDataName = globalConstDataName;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getParentGlobalDataId() {
        return parentGlobalDataId;
    }

    public void setParentGlobalDataId(Long parentGlobalDataId) {
        this.parentGlobalDataId = parentGlobalDataId;
    }
}