package com.pbs.ams.web.service;

import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanyUser;

import java.util.List;

/**
* 基金公司与用户关系服务接口
* Created by ams on 2017/6/20.
*/
public interface UpmsCompanyUserService {


    /**
     * get company by user`s id
     * @param userId
     * @return List<UpmsCompany>
     */
    List<UpmsCompanyUser> getCompaniesByUserId(Long userId);

    /**
     * get user by company id
     * @param companyIds
     * @return List<UpmsCompany>
     */
    List<UpmsCompanyUser> getUsersByCompanyId(List<Long> companyIds);
}