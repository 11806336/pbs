package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProduct;

public interface AmsProductMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(AmsProduct record);

    int insertSelective(AmsProduct record);

    AmsProduct selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(AmsProduct record);

    int updateByPrimaryKey(AmsProduct record);
}