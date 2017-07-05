package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeAccount;

import java.util.List;
import java.util.Map;

public interface AmsTradeAccountMapper {
    int deleteByPrimaryKey(Long tradeAccountId);

    int insert(AmsTradeAccount record);

    int insertSelective(AmsTradeAccount record);

    AmsTradeAccount selectByPrimaryKey(Long tradeAccountId);

    int updateByPrimaryKeySelective(AmsTradeAccount record);

    int updateByPrimaryKey(AmsTradeAccount record);

    List<Map> selectTradeAccoutWithDetail(Map map);

    int selectTradeAccoutWithDetailCount(Map map);

    int insertIntoAmsTradeAccountSnaps(AmsTradeAccount record);
}