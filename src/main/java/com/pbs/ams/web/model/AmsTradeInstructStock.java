package com.pbs.ams.web.model;

import java.io.Serializable;

public class AmsTradeInstructStock implements Serializable {
    /**
     * 主键id
     *
     * @mbg.generated
     */
    private Long amsTradeInstructStockId;

    /**
     * 指令id
     *
     * @mbg.generated
     */
    private Long amsTradeInstructId;

    /**
     * 股票id
     *
     * @mbg.generated
     */
    private Long stockId;

    private static final long serialVersionUID = 1L;

    public Long getAmsTradeInstructStockId() {
        return amsTradeInstructStockId;
    }

    public void setAmsTradeInstructStockId(Long amsTradeInstructStockId) {
        this.amsTradeInstructStockId = amsTradeInstructStockId;
    }

    public Long getAmsTradeInstructId() {
        return amsTradeInstructId;
    }

    public void setAmsTradeInstructId(Long amsTradeInstructId) {
        this.amsTradeInstructId = amsTradeInstructId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
}