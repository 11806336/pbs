package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeOrder;

public interface AmsTradeOrderMapper {
    int deleteByPrimaryKey(Integer tradeOrderId);

    int insert(AmsTradeOrder record);

    int insertSelective(AmsTradeOrder record);

    AmsTradeOrder selectByPrimaryKey(Integer tradeOrderId);

    int updateByPrimaryKeySelective(AmsTradeOrder record);

    int updateByPrimaryKey(AmsTradeOrder record);
}