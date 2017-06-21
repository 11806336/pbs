package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsMarketSnaps;
import com.pbs.ams.web.model.AmsMarketSnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsMarketSnapsMapper {
    long countByExample(AmsMarketSnapsExample example);

    int deleteByExample(AmsMarketSnapsExample example);

    int deleteByPrimaryKey(Integer marketId);

    int insert(AmsMarketSnaps record);

    int insertSelective(AmsMarketSnaps record);

    List<AmsMarketSnaps> selectByExample(AmsMarketSnapsExample example);

    AmsMarketSnaps selectByPrimaryKey(Integer marketId);

    int updateByExampleSelective(@Param("record") AmsMarketSnaps record, @Param("example") AmsMarketSnapsExample example);

    int updateByExample(@Param("record") AmsMarketSnaps record, @Param("example") AmsMarketSnapsExample example);

    int updateByPrimaryKeySelective(AmsMarketSnaps record);

    int updateByPrimaryKey(AmsMarketSnaps record);
}