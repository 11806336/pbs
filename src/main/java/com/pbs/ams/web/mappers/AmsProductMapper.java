package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsProductMapper {
    long countByExample(AmsProductExample example);

    int deleteByExample(AmsProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(AmsProduct record);

    int insertSelective(AmsProduct record);

    List<AmsProduct> selectByExample(AmsProductExample example);

    AmsProduct selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") AmsProduct record, @Param("example") AmsProductExample example);

    int updateByExample(@Param("record") AmsProduct record, @Param("example") AmsProductExample example);

    int updateByPrimaryKeySelective(AmsProduct record);

    int updateByPrimaryKey(AmsProduct record);
}