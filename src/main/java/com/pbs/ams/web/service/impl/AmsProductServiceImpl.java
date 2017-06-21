package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsProductMapper;
import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductExample;
import com.pbs.ams.web.service.AmsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsProductService实现
* Created by ams on 2017/6/21.
*/
@Service
@Transactional
@BaseService
public class AmsProductServiceImpl extends BaseServiceImpl<AmsProduct, AmsProductExample> implements AmsProductService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductServiceImpl.class);

    @Autowired
    private AmsProductMapper amsProductMapper;

    @Override
    public Object getMapper() { return amsProductMapper; }

}