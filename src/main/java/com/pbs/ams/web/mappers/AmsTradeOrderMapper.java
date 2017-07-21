package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeOrder;

public interface AmsTradeOrderMapper {
    int deleteByPrimaryKey(Long tradeOrderId);

    int insert(AmsTradeOrder record);

    int insertSelective(AmsTradeOrder record);

    AmsTradeOrder selectByPrimaryKey(Long tradeOrderId);

    int updateByPrimaryKeySelective(AmsTradeOrder record);

    int updateByPrimaryKey(AmsTradeOrder record);
}