package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeOrder;

import java.util.List;
import java.util.Map;

public interface AmsTradeOrderMapper {
    List<Map> selectAmsTradeOrderWithDetail(Map map);

    int deleteByPrimaryKey(Long tradeOrderId);

    int insert(AmsTradeOrder record);

    int insertSelective(AmsTradeOrder record);

    AmsTradeOrder selectByPrimaryKey(Long tradeOrderId);

    int updateByPrimaryKeySelective(AmsTradeOrder record);

    int updateByPrimaryKey(AmsTradeOrder record);
}