package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

import java.util.List;
import java.util.Map;

public interface AmsTradeFeeTemplateMapper {
    int deleteByPrimaryKey(Integer feeTemplateteId);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Integer feeTemplateteId);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);

    List<Map> selectTradeFeeTemplate(Map map);

    int selectTradeFeeTemplateCount(Map map);
}