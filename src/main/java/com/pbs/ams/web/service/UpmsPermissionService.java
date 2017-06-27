package com.pbs.ams.web.service;

import com.alibaba.fastjson.JSONArray;
import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.UpmsPermission;
import com.pbs.ams.web.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* Created by ams on 2017/3/20.
*/

public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {

    JSONArray getTreeByRoleId(Long roleId);

    JSONArray getTreeByUserId(Long usereId, Byte type);

}