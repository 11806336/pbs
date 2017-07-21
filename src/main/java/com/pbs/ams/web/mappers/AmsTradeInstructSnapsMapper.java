package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeInstructSnaps;

public interface AmsTradeInstructSnapsMapper {
    int deleteByPrimaryKey(Long snapsTime);

    int insert(AmsTradeInstructSnaps record);

    int insertSelective(AmsTradeInstructSnaps record);

    AmsTradeInstructSnaps selectByPrimaryKey(Long snapsTime);

    int updateByPrimaryKeySelective(AmsTradeInstructSnaps record);

    int updateByPrimaryKey(AmsTradeInstructSnaps record);
}