package com.pbs.ams.web.model;

import java.io.Serializable;

public class SysGlobalConst implements Serializable {
    /**
     * 全局常量编码
     *
     * @mbg.generated
     */
    private String globalConstCode;

    /**
     * 常量名
     *
     * @mbg.generated
     */
    private String globalConstName;

    /**
     * 常量描述
     *
     * @mbg.generated
     */
    private String globalConstDescribe;

    private static final long serialVersionUID = 1L;

    public String getGlobalConstCode() {
        return globalConstCode;
    }

    public void setGlobalConstCode(String globalConstCode) {
        this.globalConstCode = globalConstCode;
    }

    public String getGlobalConstName() {
        return globalConstName;
    }

    public void setGlobalConstName(String globalConstName) {
        this.globalConstName = globalConstName;
    }

    public String getGlobalConstDescribe() {
        return globalConstDescribe;
    }

    public void setGlobalConstDescribe(String globalConstDescribe) {
        this.globalConstDescribe = globalConstDescribe;
    }
}