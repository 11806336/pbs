package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsEntrust implements Serializable {
    /**
     * 委托ID
     *
     * @mbg.generated
     */
    private Long entrustId;

    /**
     * 证券ID
     *
     * @mbg.generated
     */
    private Long stockId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 委托状态
     *
     * @mbg.generated
     */
    private Boolean entrustStatus;

    /**
     * 委托时间
     *
     * @mbg.generated
     */
    private Long entrustDate;

    /**
     * 委托价格
     *
     * @mbg.generated
     */
    private BigDecimal entrustPrice;

    /**
     * 成交均价
     *
     * @mbg.generated
     */
    private BigDecimal tradedPrice;

    /**
     * 已撤数量
     *
     * @mbg.generated
     */
    private Integer cancelAmount;

    /**
     * 买卖标记
     *
     * @mbg.generated
     */
    private String buySell;

    /**
     * 委托类别
     *
     * @mbg.generated
     */
    private String entrustType;

    /**
     * ip来源
     *
     * @mbg.generated
     */
    private String ipSource;

    /**
     * MAC地址
     *
     * @mbg.generated
     */
    private String macAddress;

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

    public Long getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Long entrustId) {
        this.entrustId = entrustId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Boolean getEntrustStatus() {
        return entrustStatus;
    }

    public void setEntrustStatus(Boolean entrustStatus) {
        this.entrustStatus = entrustStatus;
    }

    public Long getEntrustDate() {
        return entrustDate;
    }

    public void setEntrustDate(Long entrustDate) {
        this.entrustDate = entrustDate;
    }

    public BigDecimal getEntrustPrice() {
        return entrustPrice;
    }

    public void setEntrustPrice(BigDecimal entrustPrice) {
        this.entrustPrice = entrustPrice;
    }

    public BigDecimal getTradedPrice() {
        return tradedPrice;
    }

    public void setTradedPrice(BigDecimal tradedPrice) {
        this.tradedPrice = tradedPrice;
    }

    public Integer getCancelAmount() {
        return cancelAmount;
    }

    public void setCancelAmount(Integer cancelAmount) {
        this.cancelAmount = cancelAmount;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }

    public String getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(String entrustType) {
        this.entrustType = entrustType;
    }

    public String getIpSource() {
        return ipSource;
    }

    public void setIpSource(String ipSource) {
        this.ipSource = ipSource;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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