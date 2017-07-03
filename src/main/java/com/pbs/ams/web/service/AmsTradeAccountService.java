package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeAccount;

/**
* AmsTradeAccountService接口
* Created by ams on 2017/6/29.
*/
public interface AmsTradeAccountService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeAccount record);

    int insertSelective(AmsTradeAccount record);

    AmsTradeAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeAccount record);

    int updateByPrimaryKeySelective(AmsTradeAccount record);

    int insertToAmsTradeAccountSnaps();
}