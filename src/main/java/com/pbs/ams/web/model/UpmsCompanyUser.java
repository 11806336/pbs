package com.pbs.ams.web.model;

import java.io.Serializable;

public class UpmsCompanyUser implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Integer companyUserId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(Integer companyUserId) {
        this.companyUserId = companyUserId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}