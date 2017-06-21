package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsStockHoldingMapper;
import com.pbs.ams.web.model.AmsStockHolding;
import com.pbs.ams.web.model.AmsStockHoldingExample;
import com.pbs.ams.web.service.AmsStockHoldingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsStockHoldingService实现
* Created by ams on 2017/6/21.
*/
@Service
@Transactional
@BaseService
public class AmsStockHoldingServiceImpl extends BaseServiceImpl<AmsStockHolding, AmsStockHoldingExample> implements AmsStockHoldingService {

    private static Logger _log = LoggerFactory.getLogger(AmsStockHoldingServiceImpl.class);

    @Autowired
    private AmsStockHoldingMapper amsStockHoldingMapper;

    @Override
    public Object getMapper() { return amsStockHoldingMapper; }

}