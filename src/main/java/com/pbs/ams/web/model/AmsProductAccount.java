package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsProductAccount implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long productAccountId;

    /**
     * 产品ID
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * 账号ID
     *
     * @mbg.generated
     */
    private Long stockAccountId;

    private static final long serialVersionUID = 1L;

    public Long getProductAccountId() {
        return productAccountId;
    }

    public void setProductAccountId(Long productAccountId) {
        this.productAccountId = productAccountId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStockAccountId() {
        return stockAccountId;
    }

    public void setStockAccountId(Long stockAccountId) {
        this.stockAccountId = stockAccountId;
    }
}