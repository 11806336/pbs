package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockSnaps;
import com.pbs.ams.web.model.AmsStockSnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsStockSnapsMapper {
    long countByExample(AmsStockSnapsExample example);

    int deleteByExample(AmsStockSnapsExample example);

    int deleteByPrimaryKey(Integer stockId);

    int insert(AmsStockSnaps record);

    int insertSelective(AmsStockSnaps record);

    List<AmsStockSnaps> selectByExample(AmsStockSnapsExample example);

    AmsStockSnaps selectByPrimaryKey(Integer stockId);

    int updateByExampleSelective(@Param("record") AmsStockSnaps record, @Param("example") AmsStockSnapsExample example);

    int updateByExample(@Param("record") AmsStockSnaps record, @Param("example") AmsStockSnapsExample example);

    int updateByPrimaryKeySelective(AmsStockSnaps record);

    int updateByPrimaryKey(AmsStockSnaps record);
}