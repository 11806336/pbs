package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

import java.util.List;
import java.util.Map;

public interface AmsTradeFeeTemplateMapper {
    int deleteByPrimaryKey(Long feeTemplateteId);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Long feeTemplateteId);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);

    List<Map> selectTradeFeeTemplate(Map map);

    long selectTradeFeeTemplateCount(Map map);
}