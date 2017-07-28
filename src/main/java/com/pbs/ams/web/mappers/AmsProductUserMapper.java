package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProductUser;

import java.util.List;

public interface AmsProductUserMapper {
    int deleteByPrimaryKey(Long productUserId);
    /**
     *insert a product and product-user relation
     * @param record
     * @return insert count
     */
    int insert(AmsProductUser record);

    int insertSelective(AmsProductUser record);

    AmsProductUser selectByPrimaryKey(Long productUserId);

    int updateByPrimaryKeySelective(AmsProductUser record);

    int updateByPrimaryKey(AmsProductUser record);

    List<AmsProductUser> select(AmsProductUser amsProductUser);
}