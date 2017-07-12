package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsProductAccount;

/**
* AmsProducAccounttService
* Created by ams on 2017/6/28.
*/
public interface AmsProductAccountService {

    AmsProductAccount getProductIdByAccountId(Long acountId);

    int deleteByPrimaryKey(Long productTradeAccountId);

    int insert(AmsProductAccount record);

    int insertSelective(AmsProductAccount record);

    AmsProductAccount selectByPrimaryKey(Long productTradeAccountId);

    int updateByPrimaryKeySelective(AmsProductAccount record);

    int updateByPrimaryKey(AmsProductAccount record);
}