package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsMarketMapper;
import com.pbs.ams.web.model.AmsMarket;
import com.pbs.ams.web.model.AmsMarketExample;
import com.pbs.ams.web.service.AmsMarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsMarketService实现
* Created by ams on 2017/6/21.
*/
@Service
@Transactional
@BaseService
public class AmsMarketServiceImpl extends BaseServiceImpl<AmsMarket, AmsMarketExample> implements AmsMarketService {

    private static Logger _log = LoggerFactory.getLogger(AmsMarketServiceImpl.class);

    @Autowired
    private AmsMarketMapper amsMarketMapper;

    @Override
    public Object getMapper() { return amsMarketMapper; }

}