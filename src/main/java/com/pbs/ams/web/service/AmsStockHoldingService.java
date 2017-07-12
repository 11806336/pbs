package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockHolding;

import java.util.List;
import java.util.Map;

/**
* AmsStockHoldingService接口
* Created by ams on 2017/7/11.
*/
public interface AmsStockHoldingService{

    List<Map> selectStockHoldingWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectStockHoldingWithDetailCount(Map map);/**/

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockHolding record);

    int insertSelective(AmsStockHolding record);

    AmsStockHolding selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockHolding record);

    int updateByPrimaryKeySelective(AmsStockHolding record);

    int insertToAmsStockHoldingSnaps();
}