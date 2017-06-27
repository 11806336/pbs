package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.UpmsCompanySnaps;
import com.pbs.ams.web.model.UpmsCompanySnapsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsCompanySnapsMapper {
    long countByExample(UpmsCompanySnapsExample example);

    int deleteByExample(UpmsCompanySnapsExample example);

    int insert(UpmsCompanySnaps record);

    int insertSelective(UpmsCompanySnaps record);

    List<UpmsCompanySnaps> selectByExample(UpmsCompanySnapsExample example);

    int updateByExampleSelective(@Param("record") UpmsCompanySnaps record, @Param("example") UpmsCompanySnapsExample example);

    int updateByExample(@Param("record") UpmsCompanySnaps record, @Param("example") UpmsCompanySnapsExample example);
}