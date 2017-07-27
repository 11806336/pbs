package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockCategory;

import java.util.List;
import java.util.Map;

public interface AmsStockCategoryMapper {
    int deleteByPrimaryKey(Long stockCategoryId);

    int insert(AmsStockCategory record);

    int insertSelective(AmsStockCategory record);

    AmsStockCategory selectByPrimaryKey(Long stockCategoryId);

    int updateByPrimaryKeySelective(AmsStockCategory record);

    int updateByPrimaryKey(AmsStockCategory record);

    List<Map<String, Object>> selectAmsStockCategory(Map map);
}