package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockHolding;

public interface AmsStockHoldingMapper {
    int deleteByPrimaryKey(Long stockHoldingId);

    int insert(AmsStockHolding record);

    int insertSelective(AmsStockHolding record);

    AmsStockHolding selectByPrimaryKey(Long stockHoldingId);

    int updateByPrimaryKeySelective(AmsStockHolding record);

    int updateByPrimaryKey(AmsStockHolding record);
}