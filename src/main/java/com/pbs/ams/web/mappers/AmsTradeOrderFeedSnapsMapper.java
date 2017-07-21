package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeOrderFeedSnaps;

public interface AmsTradeOrderFeedSnapsMapper {
    int deleteByPrimaryKey(Long snapsTime);

    int insert(AmsTradeOrderFeedSnaps record);

    int insertSelective(AmsTradeOrderFeedSnaps record);

    AmsTradeOrderFeedSnaps selectByPrimaryKey(Long snapsTime);

    int updateByPrimaryKeySelective(AmsTradeOrderFeedSnaps record);

    int updateByPrimaryKey(AmsTradeOrderFeedSnaps record);
}