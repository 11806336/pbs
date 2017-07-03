package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.UpmsCompanyUser;

public interface UpmsCompanyUserMapper {
    int deleteByPrimaryKey(Integer companyUserId);

    int insert(UpmsCompanyUser record);

    int insertSelective(UpmsCompanyUser record);

    UpmsCompanyUser selectByPrimaryKey(Integer companyUserId);

    int updateByPrimaryKeySelective(UpmsCompanyUser record);

    int updateByPrimaryKey(UpmsCompanyUser record);
}