package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsProductAccountMapper;
import com.pbs.ams.web.model.AmsProductAccount;
import com.pbs.ams.web.model.AmsProductAccountExample;
import com.pbs.ams.web.service.AmsProductAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsProductAccountService实现
* Created by ams on 2017/6/21.
*/
@Service
@Transactional
@BaseService
public class AmsProductAccountServiceImpl extends BaseServiceImpl<AmsProductAccount, AmsProductAccountExample> implements AmsProductAccountService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductAccountServiceImpl.class);

    @Autowired
    private AmsProductAccountMapper amsProductAccountMapper;

    @Override
    public Object getMapper() { return amsProductAccountMapper; }

}