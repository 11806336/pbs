package com.pbs.ams.web.model;

import java.io.Serializable;

public class UpmsCompanySnapshot implements Serializable {
    /**
     * 快照时间
     *
     * @mbg.generated
     */
    private Long snapsTime;

    /**
     * 公司id
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 公司名称
     *
     * @mbg.generated
     */
    private String companyName;

    /**
     * 操作人ID
     *
     * @mbg.generated
     */
    private Long operatorId;

    /**
     * 负责人ID
     *
     * @mbg.generated
     */
    private Long managerId;

    /**
     * 负责人电话
     *
     * @mbg.generated
     */
    private Integer managerPhone;

    /**
     * 负责人地址
     *
     * @mbg.generated
     */
    private String managerAddress;

    /**
     * 公司地址
     *
     * @mbg.generated
     */
    private String companyAddress;

    /**
     * 公司传真
     *
     * @mbg.generated
     */
    private String companyFax;

    /**
     * 负责人邮件
     *
     * @mbg.generated
     */
    private String managerEmail;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String description;

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

    private static final long serialVersionUID = 1L;

    public Long getSnapsTime() {
        return snapsTime;
    }

    public void setSnapsTime(Long snapsTime) {
        this.snapsTime = snapsTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Integer getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(Integer managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerAddress() {
        return managerAddress;
    }

    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}