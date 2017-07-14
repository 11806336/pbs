package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsKnock;

import java.util.List;
import java.util.Map;


/**
* AmsKnockService接口
* Created by ams on 2017/7/12.
*/
public interface AmsKnockService{

    long selectAmsKnockWithDetailCount(Map map);

    List<Map> selectAmsKnockWithDetail(Map map);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsKnock record);

    int insertSelective(AmsKnock record);

    AmsKnock selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsKnock record);

    int updateByPrimaryKeySelective(AmsKnock record);

    int insertToAmsKnockSnaps();
}