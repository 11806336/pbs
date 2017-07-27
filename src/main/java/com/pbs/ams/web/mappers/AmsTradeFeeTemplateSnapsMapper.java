package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeFeeTemplateSnaps;

public interface AmsTradeFeeTemplateSnapsMapper {
    int deleteByPrimaryKey(Long snapsTime);

    int insert(AmsTradeFeeTemplateSnaps record);

    int insertSelective(AmsTradeFeeTemplateSnaps record);

    AmsTradeFeeTemplateSnaps selectByPrimaryKey(Long snapsTime);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplateSnaps record);

    int updateByPrimaryKey(AmsTradeFeeTemplateSnaps record);
}