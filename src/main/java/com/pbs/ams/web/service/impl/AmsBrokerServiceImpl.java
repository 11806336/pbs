package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsBrokerMapper;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerExample;
import com.pbs.ams.web.service.AmsBrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsBrokerService实现
* Created by ams on 2017/6/19.
*/
@Service
@Transactional
@BaseService
public class AmsBrokerServiceImpl extends BaseServiceImpl<AmsBroker, AmsBrokerExample> implements AmsBrokerService {

    private static Logger _log = LoggerFactory.getLogger(AmsBrokerServiceImpl.class);

    @Autowired
    private AmsBrokerMapper amsBrokerMapper;

    @Override
    public Object getMapper() { return amsBrokerMapper; }

}