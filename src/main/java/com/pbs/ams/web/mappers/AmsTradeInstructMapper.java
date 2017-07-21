package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeInstruct;

public interface AmsTradeInstructMapper {
    int deleteByPrimaryKey(Integer instructId);

    int insert(AmsTradeInstruct record);

    int insertSelective(AmsTradeInstruct record);

    AmsTradeInstruct selectByPrimaryKey(Integer instructId);

    int updateByPrimaryKeySelective(AmsTradeInstruct record);

    int updateByPrimaryKey(AmsTradeInstruct record);
}