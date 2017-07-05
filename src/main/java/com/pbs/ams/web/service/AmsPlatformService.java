package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsPlatform;

import java.util.List;
import java.util.Map;

/**
* AmsBrokerService接口
* Created by ams on 2017/6/29.
*/
public interface AmsPlatformService {

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsPlatform record);

    int insertSelective(AmsPlatform record);

    AmsPlatform selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsPlatform record);

    int updateByPrimaryKeySelective(AmsPlatform record);

    int insertToAmsPlatformSnaps();

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectPlatformWithDetail(Map map);/**/

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectPlatformWithDetailCount(Map map);

    /**
     * This method is used to bind AmsPlatform and AmsBroker
     * @param amsPlatform
     * @return
     */
    //int insertAmsBroker(AmsPlatform amsPlatform);
}