package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeOrderSnaps;

public interface AmsTradeOrderSnapsMapper {
    int deleteByPrimaryKey(Long snapsTime);

    int insert(AmsTradeOrderSnaps record);

    int insertSelective(AmsTradeOrderSnaps record);

    AmsTradeOrderSnaps selectByPrimaryKey(Long snapsTime);

    int updateByPrimaryKeySelective(AmsTradeOrderSnaps record);

    int updateByPrimaryKey(AmsTradeOrderSnaps record);
}