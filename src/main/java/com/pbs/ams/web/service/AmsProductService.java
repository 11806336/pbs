package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsProduct;

/**
* AmsProductService接口
* Created by ams on 2017/6/28.
*/
public interface AmsProductService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsProduct record);

    int insertSelective(AmsProduct record);

    AmsProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsProduct record);

    int updateByPrimaryKeySelective(AmsProduct record);

    int insertToAmsProductSnaps();
}