package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.mappers.SysGlobalConstDataMapper;
import com.pbs.ams.web.model.SysGlobalConstData;
import com.pbs.ams.web.service.SysGlobalConstDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * AmsBrokerService实现
 * Created by ams on 2017/6/28.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysGlobalConstDataServiceImpl implements SysGlobalConstDataService {

    private static Logger _log = LoggerFactory.getLogger(SysGlobalConstDataServiceImpl.class);

    @Autowired
    private SysGlobalConstDataMapper sysGlobalConstDataMapper;

    @Override
    public List<SysGlobalConstData> selectDataByCode(Map<String, Object> params) {

        return sysGlobalConstDataMapper.selectDataByCode(params);
    }
}