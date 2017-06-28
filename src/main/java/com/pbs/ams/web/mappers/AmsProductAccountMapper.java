package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductAccount;
<<<<<<< HEAD
import com.pbs.ams.web.model.AmsProductAccountExample;
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> cccc120e7658fc2e74a95c493e7a2a10d6d118a8

import java.util.List;

public interface AmsProductAccountMapper {
    int deleteByPrimaryKey(Long productAccountId);

    int insert(AmsProductAccount record);

    int insertSelective(AmsProductAccount record);

    AmsProductAccount selectByPrimaryKey(Long productAccountId);

    int updateByPrimaryKeySelective(AmsProductAccount record);

    int updateByPrimaryKey(AmsProductAccount record);
}