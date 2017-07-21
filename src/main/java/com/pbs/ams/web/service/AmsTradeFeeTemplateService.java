package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

/**
* AmsTradeFeeTemplateService接口
* Created by ams on 2017/7/21.
*/
public interface AmsTradeFeeTemplateService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    int insertToAmsTradeFeeTemplateSnaps();
}