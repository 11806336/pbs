package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsProductDetail implements Serializable {
    /**
     * 产品ID
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 产品净值
     *
     * @mbg.generated
     */
    private BigDecimal productNetValue;

    /**
     * 单位净值
     *
     * @mbg.generated
     */
    private BigDecimal netAssetValue;

    /**
     * 证券总资产
     *
     * @mbg.generated
     */
    private BigDecimal stockTotalAssets;

    /**
     * 证券总市值
     *
     * @mbg.generated
     */
    private BigDecimal securityTotalValue;

    /**
     * 证券总市值
     *
     * @mbg.generated
     */
    private BigDecimal stockTotalValue;

    /**
     * 空单总市值
     *
     * @mbg.generated
     */
    private BigDecimal shortTotalValue;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getProductNetValue() {
        return productNetValue;
    }

    public void setProductNetValue(BigDecimal productNetValue) {
        this.productNetValue = productNetValue;
    }

    public BigDecimal getNetAssetValue() {
        return netAssetValue;
    }

    public void setNetAssetValue(BigDecimal netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public BigDecimal getStockTotalAssets() {
        return stockTotalAssets;
    }

    public void setStockTotalAssets(BigDecimal stockTotalAssets) {
        this.stockTotalAssets = stockTotalAssets;
    }

    public BigDecimal getSecurityTotalValue() {
        return securityTotalValue;
    }

    public void setSecurityTotalValue(BigDecimal securityTotalValue) {
        this.securityTotalValue = securityTotalValue;
    }

    public BigDecimal getStockTotalValue() {
        return stockTotalValue;
    }

    public void setStockTotalValue(BigDecimal stockTotalValue) {
        this.stockTotalValue = stockTotalValue;
    }

    public BigDecimal getShortTotalValue() {
        return shortTotalValue;
    }

    public void setShortTotalValue(BigDecimal shortTotalValue) {
        this.shortTotalValue = shortTotalValue;
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