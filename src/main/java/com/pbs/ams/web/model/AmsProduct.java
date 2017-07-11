package com.pbs.ams.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmsProduct implements Serializable {

    private Long productId;
    /**
     * 公司ID
     *
     * @mbg.generated
     */
    private Long companyId;

    /**
     * 产品名称
     *
     * @mbg.generated
     */
    private String productName;

    /**
     * 产品类型
     *
     * @mbg.generated
     */
    private Integer productType;

    /**
     * 产品代码
     *
     * @mbg.generated
     */
    private String productCode;

    /**
     * 产品管理人
     *
     * @mbg.generated
     */
    private String productSupervisor;

    /**
     * 产品经理
     *
     * @mbg.generated
     */
    private String productManager;

    /**
     * 产品状态
     *
     * @mbg.generated
     */
    private Integer productStatus;

    /**
     * 产品份额来源,1:自定义,2:032读取
     *
     * @mbg.generated
     */
    private Integer productShareSource;

    /**
     * 产品开始时间
     *
     * @mbg.generated
     */
    private Long startDate;

    /**
     * 产品结束时间
     *
     * @mbg.generated
     */
    private Long endDate;

    /**
     * 产品份额
     *
     * @mbg.generated
     */
    private BigDecimal productShares;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String productDesc;

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

    /**
     * O32ID
     *
     * @mbg.generated
     */
    private Long o32Id;


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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductManager() {
        return productManager;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager;
    }

    public String getProductSupervisor() {
        return productSupervisor;
    }

    public void setProductSupervisor(String productSupervisor) {
        this.productSupervisor = productSupervisor;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductShareSource() {
        return productShareSource;
    }

    public void setProductShareSource(Integer productShareSource) {
        this.productShareSource = productShareSource;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getProductShares() {
        return productShares;
    }

    public void setProductShares(BigDecimal productShares) {
        this.productShares = productShares;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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

    public Long getO32Id() {
        return o32Id;
    }

    public void setO32Id(Long o32Id) {
        this.o32Id = o32Id;
    }
}