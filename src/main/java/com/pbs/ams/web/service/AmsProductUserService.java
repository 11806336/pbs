package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductUser;

import java.util.List;

/**
* AmsProductUserService接口
* Created by ams on 2017/7/11.
*/
public interface AmsProductUserService{

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsProductUser record);

    int insertSelective(AmsProductUser record);

    AmsProductUser selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsProductUser record);

    int updateByPrimaryKeySelective(AmsProductUser record);

    int insertToAmsProductUserSnaps();

    /**
     * 根据关系对象查询（productId和userId其中一个不为空即可查询结果）
     * @param amsProductUser
     * @return
     */
    List<AmsProductUser> select(AmsProductUser amsProductUser);
}