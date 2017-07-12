package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsKnock;

import java.util.List;
import java.util.Map;

public interface AmsKnockMapper {
    List<Map> selectAmsKnockWithDetail(Map map);

    int deleteByPrimaryKey(Long knockId);

    int insert(AmsKnock record);

    int insertSelective(AmsKnock record);

    AmsKnock selectByPrimaryKey(Long knockId);

    int updateByPrimaryKeySelective(AmsKnock record);

    int updateByPrimaryKey(AmsKnock record);
}