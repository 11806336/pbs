package com.pbs.ams.web.service;

import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerExample;
import org.springframework.beans.factory.annotation.Autowired;

/**
* AmsBrokerService接口
* Created by ams on 2017/6/22.
*/
public interface AmsBrokerService extends BaseService<AmsBroker, AmsBrokerExample> {

            int insertToSnaps();
            @Autowired
          public  int insertSelective(AmsBroker amsBroker);

        }