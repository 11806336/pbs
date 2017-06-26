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

import java.util.List;

/**
* AmsBrokerService实现
* Created by ams on 2017/6/22.
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


    @Override
    public int insertToSnaps(){
        return 1;
    }

   /* @Override
    public List<AmsBroker> selectByExample(AmsBrokerExample amsBrokerExample){
        return amsBrokerMapper.selectByExample(amsBrokerExample);
    }*/
    @Override
    public int insertSelective(AmsBroker amsBroker){
        return amsBrokerMapper.insertSelective(amsBroker);
    }

    @Override
    public List<AmsBroker> selectByExample(AmsBrokerExample amsBrokerExample){
        return amsBrokerMapper.selectByExample(amsBrokerExample);
    }

//    public int updateByPrimaryKeySelective(AmsBroker amsBroker){
//        return amsBrokerMapper.updateByPrimaryKeySelective(amsBroker);
//    }
}