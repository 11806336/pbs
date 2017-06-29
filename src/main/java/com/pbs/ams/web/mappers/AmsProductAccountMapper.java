package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductAccount;

public interface AmsProductAccountMapper {
    int deleteByPrimaryKey(Long productTradeAccountId);

    int insert(AmsProductAccount record);

    int insertSelective(AmsProductAccount record);

    AmsProductAccount selectByPrimaryKey(Long productTradeAccountId);

    int updateByPrimaryKeySelective(AmsProductAccount record);

    int updateByPrimaryKey(AmsProductAccount record);
}