package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.RskBlackwhiteList;

public interface RskBlackwhiteListMapper {
    int deleteByPrimaryKey(Long blackwhiteId);

    int insert(RskBlackwhiteList record);

    int insertSelective(RskBlackwhiteList record);

    RskBlackwhiteList selectByPrimaryKey(Long blackwhiteId);

    int updateByPrimaryKeySelective(RskBlackwhiteList record);

    int updateByPrimaryKey(RskBlackwhiteList record);
}