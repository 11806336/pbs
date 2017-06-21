package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockHoldingSnaps;
import com.pbs.ams.web.model.AmsStockHoldingSnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsStockHoldingSnapsMapper {
    long countByExample(AmsStockHoldingSnapsExample example);

    int deleteByExample(AmsStockHoldingSnapsExample example);

    int deleteByPrimaryKey(Integer stockHoldingId);

    int insert(AmsStockHoldingSnaps record);

    int insertSelective(AmsStockHoldingSnaps record);

    List<AmsStockHoldingSnaps> selectByExample(AmsStockHoldingSnapsExample example);

    AmsStockHoldingSnaps selectByPrimaryKey(Integer stockHoldingId);

    int updateByExampleSelective(@Param("record") AmsStockHoldingSnaps record, @Param("example") AmsStockHoldingSnapsExample example);

    int updateByExample(@Param("record") AmsStockHoldingSnaps record, @Param("example") AmsStockHoldingSnapsExample example);

    int updateByPrimaryKeySelective(AmsStockHoldingSnaps record);

    int updateByPrimaryKey(AmsStockHoldingSnaps record);
}