package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockBlackWhiteList;

import java.util.List;
import java.util.Map;

/**
* AmsStockBlackWhiteListService接口
* Created by ams on 2017/7/11.
*/
public interface AmsStockBlackWhiteListService{

    List<Map> selectProductWithDetail(Map map);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockBlackWhiteList record);

    int insertSelective(AmsStockBlackWhiteList record);

    AmsStockBlackWhiteList selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockBlackWhiteList record);

    int updateByPrimaryKeySelective(AmsStockBlackWhiteList record);

    int insertToAmsStockBlackWhiteListSnaps();
}