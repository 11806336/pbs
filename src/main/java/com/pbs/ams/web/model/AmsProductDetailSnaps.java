package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsProductDetailSnaps implements Serializable {
    /**
     * 产品ID
     *
     * @mbg.generated
     */
    private Integer productId;

    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Integer companyId;

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
     * 产品份额
     *
     * @mbg.generated
     */
    private Integer productShares;

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
    private Integer operatorId;

    /**
     * 快照时间
     *
     * @mbg.generated
     */
    private Long snapsTime;

    private static final long serialVersionUID = 1L;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
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

    public Integer getProductShares() {
        return productShares;
    }

    public void setProductShares(Integer productShares) {
        this.productShares = productShares;
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Long getSnapsTime() {
        return snapsTime;
    }

    public void setSnapsTime(Long snapsTime) {
        this.snapsTime = snapsTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", companyId=").append(companyId);
        sb.append(", productNetValue=").append(productNetValue);
        sb.append(", netAssetValue=").append(netAssetValue);
        sb.append(", productShares=").append(productShares);
        sb.append(", stockTotalAssets=").append(stockTotalAssets);
        sb.append(", securityTotalValue=").append(securityTotalValue);
        sb.append(", stockTotalValue=").append(stockTotalValue);
        sb.append(", shortTotalValue=").append(shortTotalValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", snapsTime=").append(snapsTime);
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
        AmsProductDetailSnaps other = (AmsProductDetailSnaps) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getProductNetValue() == null ? other.getProductNetValue() == null : this.getProductNetValue().equals(other.getProductNetValue()))
            && (this.getNetAssetValue() == null ? other.getNetAssetValue() == null : this.getNetAssetValue().equals(other.getNetAssetValue()))
            && (this.getProductShares() == null ? other.getProductShares() == null : this.getProductShares().equals(other.getProductShares()))
            && (this.getStockTotalAssets() == null ? other.getStockTotalAssets() == null : this.getStockTotalAssets().equals(other.getStockTotalAssets()))
            && (this.getSecurityTotalValue() == null ? other.getSecurityTotalValue() == null : this.getSecurityTotalValue().equals(other.getSecurityTotalValue()))
            && (this.getStockTotalValue() == null ? other.getStockTotalValue() == null : this.getStockTotalValue().equals(other.getStockTotalValue()))
            && (this.getShortTotalValue() == null ? other.getShortTotalValue() == null : this.getShortTotalValue().equals(other.getShortTotalValue()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getSnapsTime() == null ? other.getSnapsTime() == null : this.getSnapsTime().equals(other.getSnapsTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getProductNetValue() == null) ? 0 : getProductNetValue().hashCode());
        result = prime * result + ((getNetAssetValue() == null) ? 0 : getNetAssetValue().hashCode());
        result = prime * result + ((getProductShares() == null) ? 0 : getProductShares().hashCode());
        result = prime * result + ((getStockTotalAssets() == null) ? 0 : getStockTotalAssets().hashCode());
        result = prime * result + ((getSecurityTotalValue() == null) ? 0 : getSecurityTotalValue().hashCode());
        result = prime * result + ((getStockTotalValue() == null) ? 0 : getStockTotalValue().hashCode());
        result = prime * result + ((getShortTotalValue() == null) ? 0 : getShortTotalValue().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getSnapsTime() == null) ? 0 : getSnapsTime().hashCode());
        return result;
    }
}