package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockAccountSnaps;
import com.pbs.ams.web.model.AmsStockAccountSnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsStockAccountSnapsMapper {
    long countByExample(AmsStockAccountSnapsExample example);

    int deleteByExample(AmsStockAccountSnapsExample example);

    int deleteByPrimaryKey(Integer stockAccountId);

    int insert(AmsStockAccountSnaps record);

    int insertSelective(AmsStockAccountSnaps record);

    List<AmsStockAccountSnaps> selectByExample(AmsStockAccountSnapsExample example);

    AmsStockAccountSnaps selectByPrimaryKey(Integer stockAccountId);

    int updateByExampleSelective(@Param("record") AmsStockAccountSnaps record, @Param("example") AmsStockAccountSnapsExample example);

    int updateByExample(@Param("record") AmsStockAccountSnaps record, @Param("example") AmsStockAccountSnapsExample example);

    int updateByPrimaryKeySelective(AmsStockAccountSnaps record);

    int updateByPrimaryKey(AmsStockAccountSnaps record);
}