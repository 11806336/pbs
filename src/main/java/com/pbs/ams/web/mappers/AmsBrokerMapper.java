package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerSnaps;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AmsBrokerMapper  {

    long countByExample(AmsBroker record);

    int deleteByExample(AmsBroker record);

    int deleteByPrimaryKey(Long brokerId);

    int insert(AmsBroker record);

    int insertSelective(AmsBroker record);

    List<AmsBroker> selectByExample(Map params);

    AmsBroker selectByPrimaryKey(Long brokerId);

    int updateByExampleSelective(@Param("record") AmsBroker record);

    int updateByExample(@Param("record") AmsBroker record);

    int updateByPrimaryKeySelective(AmsBroker record);

    int updateByPrimaryKey(AmsBroker record);

    int deleteByPrimaryKeys(String ids);

    int insertSnapshotSelective(AmsBrokerSnaps amsBrokerSnaps);
}