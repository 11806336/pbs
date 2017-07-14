package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsEntrust;

import java.util.List;
import java.util.Map;

/**
* AmsEntrustService接口
* Created by ams on 2017/7/11.
*/
public interface AmsEntrustService{

    List<Map> selectAmsEntrustWithDetail(Map map);

    long selectAmsEntrustWithDetailCount(Map map);

    int deleteByPrimaryKey(Long entrustId);

    int insert(AmsEntrust record);

    int insertSelective(AmsEntrust record);

    AmsEntrust selectByPrimaryKey(Long entrustId);

    int updateByPrimaryKeySelective(AmsEntrust record);

    int updateByPrimaryKey(AmsEntrust record);

    int deleteByPrimaryKeys(String ids);

    int insertToAmsEntrustSnaps();
}