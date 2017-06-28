package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsStockAccount;

/**
* AmsStockAccountService接口
* Created by ams on 2017/6/28.
*/
public interface AmsStockAccountService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsStockAccount record);

    int insertSelective(AmsStockAccount record);

    AmsStockAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsStockAccount record);

    int updateByPrimaryKeySelective(AmsStockAccount record);

    int insertToAmsStockAccountSnaps();
}