package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.com.ruixin:pbs-ams-management:war:1.0Mapper;
import com.pbs.ams.web.model.com.ruixin:pbs-ams-management:war:1.0;
import com.pbs.ams.web.model.com.ruixin:pbs-ams-management:war:1.0Example;
import com.pbs.ams.web.service.com.ruixin:pbs-ams-management:war:1.0Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* com.ruixin:pbs-ams-management:war:1.0Service实现
* Created by ams on 2017/6/26.
*/
@Service
@Transactional
@BaseService
public class com.ruixin:pbs-ams-management:war:1.0ServiceImpl extends BaseServiceImpl<com.ruixin:pbs-ams-management:war:1.0, com.ruixin:pbs-ams-management:war:1.0Example> implements com.ruixin:pbs-ams-management:war:1.0Service {

    private static Logger _log = LoggerFactory.getLogger(com.ruixin:pbs-ams-management:war:1.0ServiceImpl.class);

    @Autowired
    private com.ruixin:pbs-ams-management:war:1.0Mapper amsStockAccountMapper;

    @Override
    public Object getMapper() { return amsStockAccountMapper; }

}