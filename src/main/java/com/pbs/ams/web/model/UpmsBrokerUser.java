package com.pbs.ams.web.model;

import java.io.Serializable;

public class UpmsBrokerUser implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long brokerUserId;

    /**
     * 经纪公司ID
     *
     * @mbg.generated
     */
    private Long brokerId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    public Long getBrokerUserId() {
        return brokerUserId;
    }

    public void setBrokerUserId(Long brokerUserId) {
        this.brokerUserId = brokerUserId;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}