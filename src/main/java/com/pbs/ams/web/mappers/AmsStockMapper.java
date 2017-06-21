package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStock;
import com.pbs.ams.web.model.AmsStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsStockMapper {
    long countByExample(AmsStockExample example);

    int deleteByExample(AmsStockExample example);

    int deleteByPrimaryKey(Integer stockId);

    int insert(AmsStock record);

    int insertSelective(AmsStock record);

    List<AmsStock> selectByExample(AmsStockExample example);

    AmsStock selectByPrimaryKey(Integer stockId);

    int updateByExampleSelective(@Param("record") AmsStock record, @Param("example") AmsStockExample example);

    int updateByExample(@Param("record") AmsStock record, @Param("example") AmsStockExample example);

    int updateByPrimaryKeySelective(AmsStock record);

    int updateByPrimaryKey(AmsStock record);
}