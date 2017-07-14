package com.pbs.ams.web.service;

import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductUser;
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

    /**
     * insert a user and user-product relation
     * @param upmsUser
     * @param amsProductUser
     * @return insert count
     */
    int insertUserAndProductRelation(UpmsUser upmsUser, AmsProductUser amsProductUser, Long companyId);

    /**
     * update a user and user-product relation
     * @param upmsUser
     * @param amsProductUser
     * @return update count
     */
    int updateUserAndProductRelation(UpmsUser upmsUser, AmsProductUser amsProductUser, Long companyId);
}