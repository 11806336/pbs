package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeInstructStock;

/**
* AmsTradeInstructStockService接口
* Created by ams on 2017/7/21.
*/
public interface AmsTradeInstructStockService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeInstructStock record);

    int insertSelective(AmsTradeInstructStock record);

    AmsTradeInstructStock selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeInstructStock record);

    int updateByPrimaryKeySelective(AmsTradeInstructStock record);

    int insertToAmsTradeInstructStockSnaps();
}