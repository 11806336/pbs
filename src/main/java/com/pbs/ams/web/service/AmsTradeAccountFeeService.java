package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeAccountFee;

/**
* AmsTradeAccountFeeService接口
* Created by ams on 2017/7/26.
*/
public interface AmsTradeAccountFeeService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeAccountFee record);

    int insertSelective(AmsTradeAccountFee record);

    AmsTradeAccountFee selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeAccountFee record);

    int updateByPrimaryKeySelective(AmsTradeAccountFee record);

    int insertToAmsTradeAccountFeeSnaps();
}