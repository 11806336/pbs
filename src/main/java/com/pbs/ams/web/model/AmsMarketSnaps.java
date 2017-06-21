package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsMarketSnaps implements Serializable {
    /**
     * 市场ID
     *
     * @mbg.generated
     */
    private Integer marketId;

    /**
     * 市场名称
     *
     * @mbg.generated
     */
    private String marketName;

    /**
     * 市场代码
     *
     * @mbg.generated
     */
    private String marketCode;

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

    private Long snapsTime;

    private static final long serialVersionUID = 1L;

    public Integer getMarketId() {
        return marketId;
    }

    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
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
        sb.append(", marketId=").append(marketId);
        sb.append(", marketName=").append(marketName);
        sb.append(", marketCode=").append(marketCode);
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
        AmsMarketSnaps other = (AmsMarketSnaps) that;
        return (this.getMarketId() == null ? other.getMarketId() == null : this.getMarketId().equals(other.getMarketId()))
            && (this.getMarketName() == null ? other.getMarketName() == null : this.getMarketName().equals(other.getMarketName()))
            && (this.getMarketCode() == null ? other.getMarketCode() == null : this.getMarketCode().equals(other.getMarketCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getSnapsTime() == null ? other.getSnapsTime() == null : this.getSnapsTime().equals(other.getSnapsTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMarketId() == null) ? 0 : getMarketId().hashCode());
        result = prime * result + ((getMarketName() == null) ? 0 : getMarketName().hashCode());
        result = prime * result + ((getMarketCode() == null) ? 0 : getMarketCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getSnapsTime() == null) ? 0 : getSnapsTime().hashCode());
        return result;
    }
}