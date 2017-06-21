package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductDetailSnaps;
import com.pbs.ams.web.model.AmsProductDetailSnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsProductDetailSnapsMapper {
    long countByExample(AmsProductDetailSnapsExample example);

    int deleteByExample(AmsProductDetailSnapsExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(AmsProductDetailSnaps record);

    int insertSelective(AmsProductDetailSnaps record);

    List<AmsProductDetailSnaps> selectByExample(AmsProductDetailSnapsExample example);

    AmsProductDetailSnaps selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") AmsProductDetailSnaps record, @Param("example") AmsProductDetailSnapsExample example);

    int updateByExample(@Param("record") AmsProductDetailSnaps record, @Param("example") AmsProductDetailSnapsExample example);

    int updateByPrimaryKeySelective(AmsProductDetailSnaps record);

    int updateByPrimaryKey(AmsProductDetailSnaps record);
}