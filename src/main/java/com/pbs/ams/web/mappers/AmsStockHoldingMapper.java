package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockHolding;

import java.util.List;
import java.util.Map;

public interface AmsStockHoldingMapper {

    List<Map> selectStockHoldingWithDetail(Map map);

    int selectStockHoldingWithDetailCount(Map map);

    int deleteByPrimaryKey(Long stockHoldingId);

    int insert(AmsStockHolding record);

    int insertSelective(AmsStockHolding record);

    AmsStockHolding selectByPrimaryKey(Long stockHoldingId);

    int updateByPrimaryKeySelective(AmsStockHolding record);

    int updateByPrimaryKey(AmsStockHolding record);
}