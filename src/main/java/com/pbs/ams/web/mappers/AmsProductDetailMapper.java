package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductDetail;

public interface AmsProductDetailMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(AmsProductDetail record);

    int insertSelective(AmsProductDetail record);

    AmsProductDetail selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(AmsProductDetail record);

    int updateByPrimaryKey(AmsProductDetail record);
}