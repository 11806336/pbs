package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsEntrust;

import java.util.List;
import java.util.Map;

public interface AmsEntrustMapper {

    List<Map> selectAmsEntrustWithDetail(Map map);

    int deleteByPrimaryKey(Long entrustId);

    int insert(AmsEntrust record);

    int insertSelective(AmsEntrust record);

    AmsEntrust selectByPrimaryKey(Long entrustId);

    int updateByPrimaryKeySelective(AmsEntrust record);

    int updateByPrimaryKey(AmsEntrust record);
}