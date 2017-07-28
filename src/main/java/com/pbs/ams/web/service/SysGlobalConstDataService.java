package com.pbs.ams.web.service;

import com.pbs.ams.web.model.SysGlobalConstData;

import java.util.List;
import java.util.Map;

/**
* AmsBrokerService接口
* Created by ams on 2017/6/29.
*/
public interface SysGlobalConstDataService {

    List<SysGlobalConstData> selectDataByCode(Map<String, Object> params);
}