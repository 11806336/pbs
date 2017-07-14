package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeAccountExt;

import java.util.List;
import java.util.Map;

public interface AmsTradeAccountExtMapper {

    List<Map> selectAmsTradeAccountExtWithDetail(Map map);

    long selectAmsTradeAccountExtWithDetailCount(Map map);

    int deleteByPrimaryKey(Long tradeAccountId);

    int insert(AmsTradeAccountExt record);

    int insertSelective(AmsTradeAccountExt record);

    AmsTradeAccountExt selectByPrimaryKey(Long tradeAccountId);

    int updateByPrimaryKeySelective(AmsTradeAccountExt record);

    int updateByPrimaryKey(AmsTradeAccountExt record);
}