package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsStockAccountMapper;
import com.pbs.ams.web.model.AmsStockAccount;
import com.pbs.ams.web.model.AmsStockAccountExample;
import com.pbs.ams.web.service.AmsStockAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsStockAccountService实现
* Created by ams on 2017/6/27.
*/
@Service
@Transactional
@BaseService
public class AmsStockAccountServiceImpl extends BaseServiceImpl<AmsStockAccount, AmsStockAccountExample> implements AmsStockAccountService {

    private static Logger _log = LoggerFactory.getLogger(AmsStockAccountServiceImpl.class);

    @Autowired
    private AmsStockAccountMapper amsStockAccountMapper;

    @Override
    public Object getMapper() { return amsStockAccountMapper; }

}