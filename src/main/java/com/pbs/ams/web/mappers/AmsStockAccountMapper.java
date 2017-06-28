package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockAccount;

public interface AmsStockAccountMapper {
    int deleteByPrimaryKey(Long stockAccountId);

    int insert(AmsStockAccount record);

    int insertSelective(AmsStockAccount record);

    AmsStockAccount selectByPrimaryKey(Long stockAccountId);

    int updateByPrimaryKeySelective(AmsStockAccount record);

    int updateByPrimaryKey(AmsStockAccount record);
}