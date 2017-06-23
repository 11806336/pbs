package com.pbs.ams.web.service;

import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.AmsProductDetail;
import com.pbs.ams.web.model.AmsProductDetailExample;

/**
* AmsProductDetailService接口
* Created by ams on 2017/6/22.
*/
public interface AmsProductDetailService extends BaseService<AmsProductDetail, AmsProductDetailExample> {

                    int insertToSnaps();
        }