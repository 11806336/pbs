package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.web.mappers.AmsProductDetailMapper;
import com.pbs.ams.web.model.AmsProductDetail;
import com.pbs.ams.web.model.AmsProductDetailExample;
import com.pbs.ams.web.service.AmsProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsProductDetailService实现
* Created by ams on 2017/6/22.
*/
@Service
@Transactional
@BaseService
public class AmsProductDetailServiceImpl extends BaseServiceImpl<AmsProductDetail, AmsProductDetailExample> implements AmsProductDetailService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductDetailServiceImpl.class);

    @Autowired
    private AmsProductDetailMapper amsProductDetailMapper;

    @Override
    public Object getMapper() { return amsProductDetailMapper; }


        @Override
    public int insertToSnaps(){
        return 1;
    }
    

}