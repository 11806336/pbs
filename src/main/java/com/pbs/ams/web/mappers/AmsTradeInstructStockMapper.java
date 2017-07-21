package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeInstructStock;

public interface AmsTradeInstructStockMapper {
    int deleteByPrimaryKey(Long amsTradeInstructStockId);

    int insert(AmsTradeInstructStock record);

    int insertSelective(AmsTradeInstructStock record);

    AmsTradeInstructStock selectByPrimaryKey(Long amsTradeInstructStockId);

    int updateByPrimaryKeySelective(AmsTradeInstructStock record);

    int updateByPrimaryKey(AmsTradeInstructStock record);
}