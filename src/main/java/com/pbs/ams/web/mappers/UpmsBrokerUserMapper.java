package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.UpmsBrokerUser;

public interface UpmsBrokerUserMapper {
    int deleteByPrimaryKey(Long brokerUserId);

    int insert(UpmsBrokerUser record);

    int insertSelective(UpmsBrokerUser record);

    UpmsBrokerUser selectByPrimaryKey(Long brokerUserId);

    int updateByPrimaryKeySelective(UpmsBrokerUser record);

    int updateByPrimaryKey(UpmsBrokerUser record);
}