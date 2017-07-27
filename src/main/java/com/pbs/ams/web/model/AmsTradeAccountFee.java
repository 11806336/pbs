package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsTradeAccountFee implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long amsTradeAccountFeeId;

    /**
     * 账号id
     *
     * @mbg.generated
     */
    private Long amsTradeAccountId;

    /**
     * 手续费id
     *
     * @mbg.generated
     */
    private Long amsTradeFeeTemplateId;

    private static final long serialVersionUID = 1L;

    public Long getAmsTradeAccountFeeId() {
        return amsTradeAccountFeeId;
    }

    public void setAmsTradeAccountFeeId(Long amsTradeAccountFeeId) {
        this.amsTradeAccountFeeId = amsTradeAccountFeeId;
    }

    public Long getAmsTradeAccountId() {
        return amsTradeAccountId;
    }

    public void setAmsTradeAccountId(Long amsTradeAccountId) {
        this.amsTradeAccountId = amsTradeAccountId;
    }

    public Long getAmsTradeFeeTemplateId() {
        return amsTradeFeeTemplateId;
    }

    public void setAmsTradeFeeTemplateId(Long amsTradeFeeTemplateId) {
        this.amsTradeFeeTemplateId = amsTradeFeeTemplateId;
    }
}