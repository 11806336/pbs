package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

import java.util.List;
import java.util.Map;

/**
* AmsTradeFeeTemplateService接口
* Created by ams on 2017/7/25.
*/
public interface AmsTradeFeeTemplateService{

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Integer id);

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
    int selectTradeFeeTemplateCount(Map map);

    int insertToAmsTradeFeeTemplateSnaps();

}