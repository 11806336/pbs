package com.pbs.ams.web.model;

import java.io.Serializable;

public class UpmsCompanyUser implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long companyUserId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    public Long getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(Long companyUserId) {
        this.companyUserId = companyUserId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}