package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductAccount;

public interface AmsProductAccountMapper {

    AmsProductAccount getProductIdByAccountId(Long acountId);

    int deleteByPrimaryKey(Long productTradeAccountId);

    /**
     * This method is used to bind Account and Product
     * @param record
     * @return
     */
    int insert(AmsProductAccount record);

    int insertSelective(AmsProductAccount record);

    AmsProductAccount selectByPrimaryKey(Long productTradeAccountId);

    int updateByPrimaryKeySelective(AmsProductAccount record);

    int updateByPrimaryKey(AmsProductAccount record);
}