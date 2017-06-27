package com.pbs.ams.web.model;

import java.io.Serializable;

public class UpmsCompany implements Serializable {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", managerId=").append(managerId);
        sb.append(", managerPhone=").append(managerPhone);
        sb.append(", managerAddress=").append(managerAddress);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companyFax=").append(companyFax);
        sb.append(", managerEmail=").append(managerEmail);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        UpmsCompany other = (UpmsCompany) that;
        return (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getManagerId() == null ? other.getManagerId() == null : this.getManagerId().equals(other.getManagerId()))
            && (this.getManagerPhone() == null ? other.getManagerPhone() == null : this.getManagerPhone().equals(other.getManagerPhone()))
            && (this.getManagerAddress() == null ? other.getManagerAddress() == null : this.getManagerAddress().equals(other.getManagerAddress()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCompanyFax() == null ? other.getCompanyFax() == null : this.getCompanyFax().equals(other.getCompanyFax()))
            && (this.getManagerEmail() == null ? other.getManagerEmail() == null : this.getManagerEmail().equals(other.getManagerEmail()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
        result = prime * result + ((getManagerPhone() == null) ? 0 : getManagerPhone().hashCode());
        result = prime * result + ((getManagerAddress() == null) ? 0 : getManagerAddress().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCompanyFax() == null) ? 0 : getCompanyFax().hashCode());
        result = prime * result + ((getManagerEmail() == null) ? 0 : getManagerEmail().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}