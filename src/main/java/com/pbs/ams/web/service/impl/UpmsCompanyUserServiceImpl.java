package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.mappers.UpmsCompanyMapper;
import com.pbs.ams.web.mappers.UpmsCompanyUserMapper;
import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanySnapshot;
import com.pbs.ams.web.model.UpmsCompanyUser;
import com.pbs.ams.web.service.UpmsCompanyService;
import com.pbs.ams.web.service.UpmsCompanyUserService;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
* 基金公司与用户关系服务实现类
* Created by ams on 2017/6/20.
*/
@Service
@Transactional
public class UpmsCompanyUserServiceImpl implements UpmsCompanyUserService {

    private static Logger log = LoggerFactory.getLogger(UpmsCompanyUserServiceImpl.class);

    @Autowired
    private UpmsCompanyUserMapper upmsCompanyUserMapper;


    @Override
    public List<UpmsCompanyUser> getCompaniesByUserId(Long userId) {
        return upmsCompanyUserMapper.getCompaniesByUserId(userId);
    }

    @Override
    public List<UpmsCompanyUser> getUsersByCompanyId(List<Long> companyIds) {
        return upmsCompanyUserMapper.getUsersByCompanyId(companyIds);
    }
}