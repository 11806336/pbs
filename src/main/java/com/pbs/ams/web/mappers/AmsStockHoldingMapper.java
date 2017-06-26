package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockHolding;
import com.pbs.ams.web.model.AmsStockHoldingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsStockHoldingMapper {
    long countByExample(AmsStockHoldingExample example);

    int deleteByExample(AmsStockHoldingExample example);

    int deleteByPrimaryKey(Long stockHoldingId);

    int insert(AmsStockHolding record);

    int insertSelective(AmsStockHolding record);

    List<AmsStockHolding> selectByExample(AmsStockHoldingExample example);

    AmsStockHolding selectByPrimaryKey(Long stockHoldingId);

    int updateByExampleSelective(@Param("record") AmsStockHolding record, @Param("example") AmsStockHoldingExample example);

    int updateByExample(@Param("record") AmsStockHolding record, @Param("example") AmsStockHoldingExample example);

    int updateByPrimaryKeySelective(AmsStockHolding record);

    int updateByPrimaryKey(AmsStockHolding record);
}