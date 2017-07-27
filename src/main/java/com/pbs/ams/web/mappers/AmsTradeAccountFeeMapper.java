package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeAccountFee;

public interface AmsTradeAccountFeeMapper {
    int deleteByPrimaryKey(Long amsTradeAccountFeeId);

    int insert(AmsTradeAccountFee record);

    int insertSelective(AmsTradeAccountFee record);

    AmsTradeAccountFee selectByPrimaryKey(Long amsTradeAccountFeeId);

    int updateByPrimaryKeySelective(AmsTradeAccountFee record);

    int updateByPrimaryKey(AmsTradeAccountFee record);
}