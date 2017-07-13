package com.pbs.ams.web.service;

import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.model.UpmsUserExample;

import java.util.List;

/**
* UpmsUserService接口
* Created by ams on 2017/3/20.
*/

public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {

    UpmsUser insert2(UpmsUser upmsUser);

    List<UpmsUser> selectUsersById(List<Long> userIds);

//    UpmsUser selectByPrimaryKey(Integer id);

//    List<UpmsUser> selectByExample(UpmsUserExample example);
//
//    int countByExample(UpmsUserExample example);
//
//    int insertSelective(UpmsUser record);
//
//    int deleteByPrimaryKeys(String ids);
//
//    int updateByPrimaryKeySelective(UpmsUser record);
}