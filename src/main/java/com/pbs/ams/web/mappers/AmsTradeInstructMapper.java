package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeInstruct;

public interface AmsTradeInstructMapper {
    int deleteByPrimaryKey(Long instructId);

    int insert(AmsTradeInstruct record);

    int insertSelective(AmsTradeInstruct record);

    AmsTradeInstruct selectByPrimaryKey(Long instructId);

    int updateByPrimaryKeySelective(AmsTradeInstruct record);

    int updateByPrimaryKey(AmsTradeInstruct record);
}