package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.AmsTradeAccountSnaps;

import java.util.List;
import java.util.Map;

/**
* AmsTradeAccountService接口
* Created by ams on 2017/6/29.
*/
public interface AmsTradeAccountService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(List<Long> ids);

    int insert(AmsTradeAccount record);

    int insertSelective(AmsTradeAccount record);

    AmsTradeAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeAccount record);

    int updateByPrimaryKeySelective(AmsTradeAccount record);

    int insertToAmsTradeAccountSnaps(AmsTradeAccountSnaps amsTradeAccountSnaps);

    List<Map> selectTradeAccoutWithDetail(Map map);

    int selectTradeAccoutWithDetailCount(Map map);
}