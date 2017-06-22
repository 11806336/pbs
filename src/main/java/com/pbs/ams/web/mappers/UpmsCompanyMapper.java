package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.UpmsCompany;
import com.pbs.ams.web.model.UpmsCompanyExample;
import java.util.List;

import com.pbs.ams.web.model.UpmsCompanySnaps;
import org.apache.ibatis.annotations.Param;

public interface UpmsCompanyMapper {
    long countByExample(UpmsCompanyExample example);

    int deleteByExample(UpmsCompanyExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(UpmsCompany record);

    int insertSelective(UpmsCompany record);

    List<UpmsCompany> selectByExample(UpmsCompanyExample example);

    UpmsCompany selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") UpmsCompany record, @Param("example") UpmsCompanyExample example);

    int updateByExample(@Param("record") UpmsCompany record, @Param("example") UpmsCompanyExample example);

    int updateByPrimaryKeySelective(UpmsCompany record);

    int updateByPrimaryKey(UpmsCompany record);

    int insertSnapshot(UpmsCompanySnaps upmsCompanySnaps);

    int insertSnapshotSelective(UpmsCompanySnaps upmsCompanySnaps);

}