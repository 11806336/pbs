package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsBrokerMapper {
    long countByExample(AmsBrokerExample example);

    int deleteByExample(AmsBrokerExample example);

    int deleteByPrimaryKey(Long brokerId);

    int insert(AmsBroker record);

    int insertSelective(AmsBroker record);

    List<AmsBroker> selectByExample(AmsBrokerExample example);

    AmsBroker selectByPrimaryKey(Long brokerId);

    int updateByExampleSelective(@Param("record") AmsBroker record, @Param("example") AmsBrokerExample example);

    int updateByExample(@Param("record") AmsBroker record, @Param("example") AmsBrokerExample example);

    int updateByPrimaryKeySelective(AmsBroker record);

    int updateByPrimaryKey(AmsBroker record);
}