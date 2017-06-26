package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerExample;

import java.util.List;

public interface AmsBrokerMapper  {
    int insertSelective(AmsBroker amsBroker);

    List<AmsBroker> selectByExample(AmsBrokerExample amsBrokerExample);
}