package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsTradeInstruct implements Serializable {
    /**
     * 指令ID
     *
     * @mbg.generated
     */
    private Integer instructId;

    /**
     * 交易类别(股票1/期货2/期权3)
     *
     * @mbg.generated
     */
    private Byte tradePlatformType;

    /**
     * 委托类别(买1/卖2)
     *
     * @mbg.generated
     */
    private Byte tradeOrderType;

    /**
     * 下达指令的用户ID
     *
     * @mbg.generated
     */
    private Integer instructUserId;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 已委托数量(已购买了多少份)
     *
     * @mbg.generated
     */
    private Integer executedQty;

    /**
     * 指令状态 0:待接收 1:已接收 2:已撤销 3:已委托
     *
     * @mbg.generated
     */
    private Byte instructStatus;

    /**
     * 开始时间
     *
     * @mbg.generated
     */
    private Long startTime;

    /**
     * 结束时间
     *
     * @mbg.generated
     */
    private Long endTime;

    /**
     * IP来源
     *
     * @mbg.generated
     */
    private String ipSource;

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
    private Integer operatorId;

    private static final long serialVersionUID = 1L;

    public Integer getInstructId() {
        return instructId;
    }

    public void setInstructId(Integer instructId) {
        this.instructId = instructId;
    }

    public Byte getTradePlatformType() {
        return tradePlatformType;
    }

    public void setTradePlatformType(Byte tradePlatformType) {
        this.tradePlatformType = tradePlatformType;
    }

    public Byte getTradeOrderType() {
        return tradeOrderType;
    }

    public void setTradeOrderType(Byte tradeOrderType) {
        this.tradeOrderType = tradeOrderType;
    }

    public Integer getInstructUserId() {
        return instructUserId;
    }

    public void setInstructUserId(Integer instructUserId) {
        this.instructUserId = instructUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(Integer executedQty) {
        this.executedQty = executedQty;
    }

    public Byte getInstructStatus() {
        return instructStatus;
    }

    public void setInstructStatus(Byte instructStatus) {
        this.instructStatus = instructStatus;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}