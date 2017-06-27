package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsMarket;
import com.pbs.ams.web.model.AmsMarketExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmsPlatformMapper {
    long countByExample(AmsMarketExample example);

    int deleteByExample(AmsMarketExample example);

    int deleteByPrimaryKey(Long marketId);

    int insert(AmsMarket record);

    int insertSelective(AmsMarket record);

    List<AmsMarket> selectByExample(AmsMarketExample example);

    AmsMarket selectByPrimaryKey(Long marketId);

    int updateByExampleSelective(@Param("record") AmsMarket record, @Param("example") AmsMarketExample example);

    int updateByExample(@Param("record") AmsMarket record, @Param("example") AmsMarketExample example);

    int updateByPrimaryKeySelective(AmsMarket record);

    int updateByPrimaryKey(AmsMarket record);
}