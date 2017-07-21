package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeInstruct;

/**
* AmsTradeInstructService接口
* Created by ams on 2017/7/21.
*/
public interface AmsTradeInstructService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeInstruct record);

    int insertSelective(AmsTradeInstruct record);

    AmsTradeInstruct selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeInstruct record);

    int updateByPrimaryKeySelective(AmsTradeInstruct record);

    int insertToAmsTradeInstructSnaps();
}