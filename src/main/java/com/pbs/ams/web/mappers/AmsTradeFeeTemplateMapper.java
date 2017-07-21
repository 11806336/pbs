package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;

public interface AmsTradeFeeTemplateMapper {
    int deleteByPrimaryKey(Integer feeTemplateteId);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    AmsTradeFeeTemplate selectByPrimaryKey(Integer feeTemplateteId);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);
}