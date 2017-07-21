package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeOrderFeed;

public interface AmsTradeOrderFeedMapper {
    int deleteByPrimaryKey(Long tradeOrderFeedId);

    int insert(AmsTradeOrderFeed record);

    int insertSelective(AmsTradeOrderFeed record);

    AmsTradeOrderFeed selectByPrimaryKey(Long tradeOrderFeedId);

    int updateByPrimaryKeySelective(AmsTradeOrderFeed record);

    int updateByPrimaryKey(AmsTradeOrderFeed record);
}