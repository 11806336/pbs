package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.mappers.AmsProductUserMapper;
import com.pbs.ams.web.mappers.UpmsCompanyUserMapper;
import com.pbs.ams.web.mappers.UpmsUserMapper;
import com.pbs.ams.web.model.*;
import com.pbs.ams.web.service.AmsProductUserService;
import com.pbs.ams.web.service.UpmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* UpmsUserService实现
* Created by ams on 2017/3/20.
*/
@Service
@Transactional
@BaseService
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUser,UpmsUserExample> implements UpmsUserService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    UpmsUserMapper upmsUserMapper;

    @Autowired
    private AmsProductUserMapper amsProductUserMapper;

    @Autowired
    private UpmsCompanyUserMapper upmsCompanyUserMapper;

    @Override
    public List<UpmsUser> selectUsersById(List<Long> userIds) {
        return upmsUserMapper.selectUsersById(userIds);
    }

    @Override
    public UpmsUser insert2(UpmsUser upmsUser) {
        upmsUserMapper.insert(upmsUser);
        return upmsUser;
    }

    @Override
    public Object getMapper() {
        return upmsUserMapper;
    }

    /**
     * insert a user and user-product relation
     *
     * @param upmsUser
     * @param amsProductUser
     * @return insert count
     */
    @Override
    public int insertUserAndProductRelation(UpmsUser upmsUser, AmsProductUser amsProductUser, Long companyId) {
        if (null != upmsUser && null != amsProductUser) {
            int result;
            int count = upmsUserMapper.insertSelective(upmsUser);
            if (count > 0) {
                amsProductUser.setUserId(upmsUser.getUserId());//保存成功取userid
                result = amsProductUserMapper.insert(amsProductUser);
                if (result > 0) {
                    UpmsCompanyUser upmsCompanyUser = new UpmsCompanyUser();
                    upmsCompanyUser.setUserId(upmsUser.getUserId());
                    upmsCompanyUser.setCompanyId(companyId);
                    upmsCompanyUser.setCompanyUserId(IdGeneratorUtil.getKey("upms_company_user"));
                    int res = upmsCompanyUserMapper.insert(upmsCompanyUser);
                    if (res > 0) {
                        return result;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * update a user and user-product relation
     *
     * @param upmsUser
     * @param amsProductUser
     * @return update count
     */
    @Override
    public int updateUserAndProductRelation(UpmsUser upmsUser, AmsProductUser amsProductUser, Long companyId) {
        if (null != upmsUser && null != amsProductUser) {
            int result;
            int count = upmsUserMapper.updateByPrimaryKeySelective(upmsUser);
            if (count > 0) {
                result = amsProductUserMapper.updateByPrimaryKeySelective(amsProductUser);
                UpmsCompanyUser upmsCompanyUser = new UpmsCompanyUser();
                Long userId = upmsUser.getUserId();
                upmsCompanyUser.setUserId(userId);
                List<UpmsCompanyUser> upmsCompanyUsers = upmsCompanyUserMapper.getCompaniesByUserId(userId);
                int res = upmsCompanyUserMapper.updateByPrimaryKeySelective(upmsCompanyUsers.get(0));
                if (res > 0) {
                    return result;
                }
            }
        }
        return 0;
    }
}