package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductSnaps;

public interface AmsProductSnapsMapper {
    int deleteByPrimaryKey(Long snapsTime);

    int insert(AmsProductSnaps record);

    int insertSelective(AmsProductSnaps record);

    AmsProductSnaps selectByPrimaryKey(Long snapsTime);

    int updateByPrimaryKeySelective(AmsProductSnaps record);

    int updateByPrimaryKey(AmsProductSnaps record);
}