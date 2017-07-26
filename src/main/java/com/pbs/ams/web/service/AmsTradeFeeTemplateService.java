package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

import java.util.List;
import java.util.Map;

/**
* AmsTradeFeeTemplateService接口
* Created by ams on 2017/7/25.
*/
public interface AmsTradeFeeTemplateService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectTradeFeeTemplate(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    long selectTradeFeeTemplateCount(Map map);

    int insertToAmsTradeFeeTemplateSnaps();

}