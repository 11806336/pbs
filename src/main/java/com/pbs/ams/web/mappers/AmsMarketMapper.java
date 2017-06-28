package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsMarket;



public interface AmsMarketMapper {
    int deleteByPrimaryKey(Long marketId);

    int insert(AmsMarket record);

    int insertSelective(AmsMarket record);

    AmsMarket selectByPrimaryKey(Long marketId);

    int updateByPrimaryKeySelective(AmsMarket record);

    int updateByPrimaryKey(AmsMarket record);
}