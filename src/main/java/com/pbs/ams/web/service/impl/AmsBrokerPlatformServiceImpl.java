package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsBrokerPlatformMapper;
import com.pbs.ams.web.model.AmsBrokerPlatform;
import com.pbs.ams.web.model.AmsBrokerPlatformExample;
import com.pbs.ams.web.service.AmsBrokerPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
@Service
@Transactional
@BaseService
public class AmsBrokerPlatformServiceImpl extends BaseServiceImpl<AmsBrokerPlatform, AmsBrokerPlatformExample> implements AmsBrokerPlatformService {
    @Autowired
    private AmsBrokerPlatformMapper amsBrokerPlatformMapper;
    @Override
    public Object getMapper() { return amsBrokerPlatformMapper; }

    public List<AmsBrokerPlatform> selectAmsBrokerPlatform(AmsBrokerPlatformExample amsBrokerPlatformExample){
        return amsBrokerPlatformMapper.selectBrokerPlatform(amsBrokerPlatformExample);
    }
    public Long selectCountByExample(AmsBrokerPlatformExample amsBrokerPlatformExample){
        return amsBrokerPlatformMapper.selectCountByExample(amsBrokerPlatformExample);
    }

}
