package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsStockMapper;
import com.pbs.ams.web.model.AmsStock;
import com.pbs.ams.web.model.AmsStockExample;
import com.pbs.ams.web.service.AmsStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsStockService实现
* Created by ams on 2017/6/21.
*/
@Service
@Transactional
@BaseService
public class AmsStockServiceImpl extends BaseServiceImpl<AmsStock, AmsStockExample> implements AmsStockService {

    private static Logger _log = LoggerFactory.getLogger(AmsStockServiceImpl.class);

    @Autowired
    private AmsStockMapper amsStockMapper;

    @Override
    public Object getMapper() { return amsStockMapper; }

}