package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductDetail;
import com.pbs.ams.web.model.AmsProductDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsProductDetailMapper {
    long countByExample(AmsProductDetailExample example);

    int deleteByExample(AmsProductDetailExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(AmsProductDetail record);

    int insertSelective(AmsProductDetail record);

    List<AmsProductDetail> selectByExample(AmsProductDetailExample example);

    AmsProductDetail selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") AmsProductDetail record, @Param("example") AmsProductDetailExample example);

    int updateByExample(@Param("record") AmsProductDetail record, @Param("example") AmsProductDetailExample example);

    int updateByPrimaryKeySelective(AmsProductDetail record);

    int updateByPrimaryKey(AmsProductDetail record);
}