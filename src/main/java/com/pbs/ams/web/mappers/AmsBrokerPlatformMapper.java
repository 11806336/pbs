package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsBrokerPlatform;
import com.pbs.ams.web.model.AmsBrokerPlatformExample;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface AmsBrokerPlatformMapper {

    List<AmsBrokerPlatform> selectBrokerPlatform(AmsBrokerPlatformExample amsBrokerPlatformExample);

    Long selectCountByExample(AmsBrokerPlatformExample amsBrokerPlatformExample);
}
