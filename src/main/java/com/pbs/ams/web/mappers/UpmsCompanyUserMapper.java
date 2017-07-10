package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanyUser;

import java.util.List;

public interface UpmsCompanyUserMapper {
    int deleteByPrimaryKey(Long companyUserId);

    int insert(UpmsCompanyUser record);

    int insertSelective(UpmsCompanyUser record);

    UpmsCompanyUser selectByPrimaryKey(Long companyUserId);

    int updateByPrimaryKeySelective(UpmsCompanyUser record);

    int updateByPrimaryKey(UpmsCompanyUser record);

    /**
     * get a company or company list  for current user
     * @param userId
     * @return List<UpmsCompanyUser>
     */
    List<UpmsCompanyUser> getCompaniesByUserId(Long userId);
}