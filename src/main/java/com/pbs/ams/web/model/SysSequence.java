package com.pbs.ams.web.model;

import java.io.Serializable;

public class SysSequence implements Serializable {

    private static final long serialVersionUID = -3026023849391667350L;

    /**
     * 序列code
     */
    private String sequenceCode;

    /**
     * 最大的序列值
     */
    private Long maxValue;

    public SysSequence() {
    }

    public SysSequence(String sequenceCode) {
        this.sequenceCode = sequenceCode;
    }

    public String getSequenceCode() {
        return sequenceCode;
    }

    public void setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }
}