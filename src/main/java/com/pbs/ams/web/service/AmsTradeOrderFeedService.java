package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeOrderFeed;

/**
* AmsTradeOrderFeedService接口
* Created by ams on 2017/7/21.
*/
public interface AmsTradeOrderFeedService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeOrderFeed record);

    int insertSelective(AmsTradeOrderFeed record);

    AmsTradeOrderFeed selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeOrderFeed record);

    int updateByPrimaryKeySelective(AmsTradeOrderFeed record);

    int insertToAmsTradeOrderFeedSnaps();
}