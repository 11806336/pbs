package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsPlatform;
import com.pbs.ams.web.model.AmsPlatformExample;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;

=======
>>>>>>> cccc120e7658fc2e74a95c493e7a2a10d6d118a8
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsPlatformMapper {
    long countByExample(AmsPlatformExample example);

    int deleteByExample(AmsPlatformExample example);

<<<<<<< HEAD
    int deleteByPrimaryKey(Long platformId);
=======
    int deleteByPrimaryKey(Integer platformId);
>>>>>>> cccc120e7658fc2e74a95c493e7a2a10d6d118a8

    int insert(AmsPlatform record);

    int insertSelective(AmsPlatform record);

    List<AmsPlatform> selectByExample(AmsPlatformExample example);

<<<<<<< HEAD
    AmsPlatform selectByPrimaryKey(Long platformId);
=======
    AmsPlatform selectByPrimaryKey(Integer platformId);
>>>>>>> cccc120e7658fc2e74a95c493e7a2a10d6d118a8

    int updateByExampleSelective(@Param("record") AmsPlatform record, @Param("example") AmsPlatformExample example);

    int updateByExample(@Param("record") AmsPlatform record, @Param("example") AmsPlatformExample example);

    int updateByPrimaryKeySelective(AmsPlatform record);

    int updateByPrimaryKey(AmsPlatform record);
}