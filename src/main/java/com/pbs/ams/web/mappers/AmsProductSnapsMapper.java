package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductSnaps;
import com.pbs.ams.web.model.AmsProductSnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsProductSnapsMapper {
    long countByExample(AmsProductSnapsExample example);

    int deleteByExample(AmsProductSnapsExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(AmsProductSnaps record);

    int insertSelective(AmsProductSnaps record);

    List<AmsProductSnaps> selectByExample(AmsProductSnapsExample example);

    AmsProductSnaps selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") AmsProductSnaps record, @Param("example") AmsProductSnapsExample example);

    int updateByExample(@Param("record") AmsProductSnaps record, @Param("example") AmsProductSnapsExample example);

    int updateByPrimaryKeySelective(AmsProductSnaps record);

    int updateByPrimaryKey(AmsProductSnaps record);
}