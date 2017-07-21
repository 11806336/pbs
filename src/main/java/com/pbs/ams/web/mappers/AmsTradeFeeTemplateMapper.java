package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

public interface AmsTradeFeeTemplateMapper {
    int deleteByPrimaryKey(Long feeTemplateteId);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Long feeTemplateteId);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);
}