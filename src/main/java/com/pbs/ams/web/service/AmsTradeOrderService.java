package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeOrder;

/**
* AmsTradeOrderService接口
* Created by ams on 2017/7/21.
*/
public interface AmsTradeOrderService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeOrder record);

    int insertSelective(AmsTradeOrder record);

    AmsTradeOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeOrder record);

    int updateByPrimaryKeySelective(AmsTradeOrder record);

    int insertToAmsTradeOrderSnaps();
}