package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStock;

public interface AmsStockMapper {
    int deleteByPrimaryKey(Long stockId);

    int insert(AmsStock record);

    int insertSelective(AmsStock record);

    AmsStock selectByPrimaryKey(Long stockId);

    int updateByPrimaryKeySelective(AmsStock record);

    int updateByPrimaryKey(AmsStock record);
}