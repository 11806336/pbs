package com.pbs.ams.web.model;

import java.io.Serializable;

public class RskBlackwhiteList implements Serializable {
    /**
     * 黑白名单ID
     *
     * @mbg.generated
     */
    private Long blackwhiteId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 金融工具ID
     *
     * @mbg.generated
     */
    private Long finInstrId;

    /**
     * 金融工具类型
     *
     * @mbg.generated
     */
    private Boolean finInstrType;

    /**
     * 黑白名单范围(字典表查询)
     *
     * @mbg.generated
     */
    private Boolean blackwhiteListType;

    /**
     * 1:黑名单 0:白名单
     *
     * @mbg.generated
     */
    private Boolean isBlack;

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

    public Long getBlackwhiteId() {
        return blackwhiteId;
    }

    public void setBlackwhiteId(Long blackwhiteId) {
        this.blackwhiteId = blackwhiteId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getFinInstrId() {
        return finInstrId;
    }

    public void setFinInstrId(Long finInstrId) {
        this.finInstrId = finInstrId;
    }

    public Boolean getFinInstrType() {
        return finInstrType;
    }

    public void setFinInstrType(Boolean finInstrType) {
        this.finInstrType = finInstrType;
    }

    public Boolean getBlackwhiteListType() {
        return blackwhiteListType;
    }

    public void setBlackwhiteListType(Boolean blackwhiteListType) {
        this.blackwhiteListType = blackwhiteListType;
    }

    public Boolean getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(Boolean isBlack) {
        this.isBlack = isBlack;
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