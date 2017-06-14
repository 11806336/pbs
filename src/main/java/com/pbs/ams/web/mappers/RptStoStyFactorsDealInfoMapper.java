package com.pbs.ams.web.mappers;


import com.pbs.ams.web.model.RptStoStyFactorsDealInfo;

import java.util.List;

public interface RptStoStyFactorsDealInfoMapper {
    int insert(RptStoStyFactorsDealInfo record);

    int insertSelective(RptStoStyFactorsDealInfo record);

    List<RptStoStyFactorsDealInfo> selectAll();

}