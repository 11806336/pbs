package com.pbs.ams.web.service;

import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.AmsBrokerPlatform;
import com.pbs.ams.web.model.AmsBrokerPlatformExample;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface AmsBrokerPlatformService  extends BaseService<AmsBrokerPlatform, AmsBrokerPlatformExample>{
    List<AmsBrokerPlatform> selectAmsBrokerPlatform(AmsBrokerPlatformExample amsBrokerPlatformExample);
    Long selectCountByExample(AmsBrokerPlatformExample amsBrokerPlatformExample);
}
