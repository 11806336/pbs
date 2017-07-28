package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.SysGlobalConstData;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysGlobalConstDataMapper {

    List<SysGlobalConstData> selectDataByCode(Map<String, Object> params);

}