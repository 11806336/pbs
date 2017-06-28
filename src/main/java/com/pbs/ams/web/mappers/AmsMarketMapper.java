package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsMarket;
<<<<<<< HEAD
import com.pbs.ams.web.model.AmsMarketExample;
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> cccc120e7658fc2e74a95c493e7a2a10d6d118a8

import java.util.List;

public interface AmsMarketMapper {
    int deleteByPrimaryKey(Long marketId);

    int insert(AmsMarket record);

    int insertSelective(AmsMarket record);

    AmsMarket selectByPrimaryKey(Long marketId);

    int updateByPrimaryKeySelective(AmsMarket record);

    int updateByPrimaryKey(AmsMarket record);
}