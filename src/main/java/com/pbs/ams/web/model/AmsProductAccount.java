package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsProductAccount implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long productTradeAccountId;

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
    private Long tradeAccountId;

    private static final long serialVersionUID = 1L;

    public Long getProductTradeAccountId() {
        return productTradeAccountId;
    }

    public void setProductTradeAccountId(Long productTradeAccountId) {
        this.productTradeAccountId = productTradeAccountId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTradeAccountId() {
        return tradeAccountId;
    }

    public void setTradeAccountId(Long tradeAccountId) {
        this.tradeAccountId = tradeAccountId;
    }
}