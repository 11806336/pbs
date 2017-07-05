package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerSnaps;

import java.util.List;
import java.util.Map;

public interface AmsBrokerMapper {
    int deleteByPrimaryKey(Long brokerId);

    int deleteByPrimaryKeys(List<Long> ids);

    int insertSelective(AmsBroker record);

    AmsBroker selectByPrimaryKey(Long brokerId);

    int updateByPrimaryKeySelective(AmsBroker record);

    List<Map> selectBrokerWithDetail(Map map);

    int selectBrokerWithDetailCount(Map map);

    int insertToAmsBrokerSnaps(AmsBrokerSnaps snaps);
}