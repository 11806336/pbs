package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsPlatform;
import com.pbs.ams.web.model.AmsPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsPlatformMapper {
    long countByExample(AmsPlatformExample example);

    int deleteByExample(AmsPlatformExample example);

    int deleteByPrimaryKey(Integer platformId);

    int insert(AmsPlatform record);

    int insertSelective(AmsPlatform record);

    List<AmsPlatform> selectByExample(AmsPlatformExample example);

    AmsPlatform selectByPrimaryKey(Integer platformId);

    int updateByExampleSelective(@Param("record") AmsPlatform record, @Param("example") AmsPlatformExample example);

    int updateByExample(@Param("record") AmsPlatform record, @Param("example") AmsPlatformExample example);

    int updateByPrimaryKeySelective(AmsPlatform record);

    int updateByPrimaryKey(AmsPlatform record);
}