package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsProductUser implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long productUserId;

    /**
     * 产品id
     *
     * @mbg.generated
     */
    private Long productId;

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Long userId;

    private static final long serialVersionUID = 1L;

    public Long getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(Long productUserId) {
        this.productUserId = productUserId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}