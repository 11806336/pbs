package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.mappers.AmsProductAccountMapper;
import com.pbs.ams.web.model.AmsProductAccount;
import com.pbs.ams.web.service.AmsProductAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsProductAccountService实现
* Created by ams on 2017/6/29.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsProductAccountServiceImpl implements AmsProductAccountService {

    @Autowired
    private AmsProductAccountMapper amsProductAccountMapper;


    @Override
    public AmsProductAccount getProductIdByAccountId(Long acountId) {
        return amsProductAccountMapper.getProductIdByAccountId(acountId);
    }

    @Override
    public int deleteByPrimaryKey(Long productTradeAccountId) {
        return 0;
    }

    @Override
    public int insert(AmsProductAccount record) {
        return 0;
    }

    @Override
    public int insertSelective(AmsProductAccount record) {
        return amsProductAccountMapper.insertSelective(record);
    }

    @Override
    public AmsProductAccount selectByPrimaryKey(Long productTradeAccountId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AmsProductAccount record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AmsProductAccount record) {
        return 0;
    }
}