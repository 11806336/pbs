package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsPlatformMapper;
import com.pbs.ams.web.model.AmsPlatform;
import com.pbs.ams.web.model.AmsPlatformExample;
import com.pbs.ams.web.service.AmsPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* com.ruixin:pbs-ams-management:war:1.0Service实现
* Created by ams on 2017/6/22.
*/
@Service
@Transactional
@BaseService
public class AmsPlatformServiceImpl extends BaseServiceImpl<AmsPlatform, AmsPlatformExample> implements AmsPlatformService {

    private static Logger _log = LoggerFactory.getLogger(AmsPlatformServiceImpl.class);

    @Autowired
    private AmsPlatformMapper amsPlatformMapper;

    @Override
    public Object getMapper() { return amsPlatformMapper; }

    @Override
    public int insertToSnaps(){
        return 1;
    }

    /**
     * 查询平台列表
     * @return list AmsPlatform
     */
/*    @Override
    public  List<AmsPlatform> selectByExample(AmsPlatformExample amsPlatformExample){
        return amsPlatformMapper.selectByExample(amsPlatformExample);
    }*/

}