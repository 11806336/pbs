package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeAccount;

public interface AmsTradeAccountMapper {
    int deleteByPrimaryKey(Long tradeAccountId);

    int insert(AmsTradeAccount record);

    int insertSelective(AmsTradeAccount record);

    AmsTradeAccount selectByPrimaryKey(Long tradeAccountId);

    int updateByPrimaryKeySelective(AmsTradeAccount record);

    int updateByPrimaryKey(AmsTradeAccount record);
}