package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockCategory;

/**
* AmsStockCategoryService接口
* Created by ams on 2017/7/25.
*/
public interface AmsStockCategoryService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockCategory record);

    int insertSelective(AmsStockCategory record);

    AmsStockCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockCategory record);

    int updateByPrimaryKeySelective(AmsStockCategory record);

    int insertToAmsStockCategorySnaps();
}