package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.UpmsUserMapper;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.model.UpmsUserExample;
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

}