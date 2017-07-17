package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeAccountExt;

import java.util.List;
import java.util.Map;


/**
* AmsTradeAccountExtService接口
* Created by ams on 2017/7/13.
*/
public interface AmsTradeAccountExtService{

    List<Map> selectAmsTradeAccountExtWithDetail(Map map);

    long selectAmsTradeAccountExtWithDetailCount(Map map);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeAccountExt record);

    int insertSelective(AmsTradeAccountExt record);

    AmsTradeAccountExt selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeAccountExt record);

    int updateByPrimaryKeySelective(AmsTradeAccountExt record);

    int insertToAmsTradeAccountExtSnaps();
}