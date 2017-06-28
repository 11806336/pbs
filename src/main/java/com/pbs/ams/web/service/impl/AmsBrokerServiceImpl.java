package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.annotation.BaseService;
import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsBrokerMapper;
import com.pbs.ams.web.model.*;
import com.pbs.ams.web.service.AmsBrokerService;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * AmsBrokerService实现
 * Created by ams on 2017/6/22.
 */
@Service
@Transactional
@BaseService
public class AmsBrokerServiceImpl extends BaseServiceImpl<AmsBroker, AmsBrokerExample> implements AmsBrokerService {

    private static Logger _log = LoggerFactory.getLogger(AmsBrokerServiceImpl.class);

    @Autowired
    private AmsBrokerMapper amsBrokerMapper;

    @Override
    public Object getMapper() { return amsBrokerMapper; }


    @Override
    public int insertToSnaps(){
        return 1;
    }

   /* *//**
     * 添加经纪公司
     *//*
    @Override
    public int insertSelective(AmsBroker amsBroker){
        return amsBrokerMapper.insertSelective(amsBroker);
    }

    *//**
     * 查询列表
     *//*
    @Override
    public List<AmsBroker> selectByExample(AmsBrokerExample amsBrokerExample){
        return amsBrokerMapper.selectByExample(amsBrokerExample);
    }

    *//**
     * 查询数量
     *//*
    @Override
    public long countByExample(AmsBrokerExample amsBrokerExample){
        return amsBrokerMapper.countByExample(amsBrokerExample);
    }

    *//**
     * 修改
     *//*
    public int updateByPrimaryKeySelective(AmsBroker amsBroker){
        return amsBrokerMapper.updateByPrimaryKeySelective(amsBroker);
    }

    public AmsBroker selectByPrimaryKey(Long id){
        return amsBrokerMapper.selectByPrimaryKey(id);
    }*/

    /**
     * 删除操作
     * @param ids 主键id
     * @return
     */
    @Override
    public int deleteByPrimaryKeys(String ids) {
        try {
            if (StringUtils.isBlank(ids)) {
                return 0;
            }
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            String[] idArray = ids.split("-");
            int count = 0;
            for (String idStr : idArray) {
                if (StringUtils.isBlank(idStr)) {
                    continue;
                }
                Long id = Long.parseLong(idStr);
                //先查询本条记录
                Method selectByPrimaryKey =  getMapper().getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
                AmsBroker amsBroker = (AmsBroker) selectByPrimaryKey.invoke( getMapper(), id);
                //将本条记录放在快照表中
                if (amsBroker != null) {//查到数据后再做新增和删除操作
                    AmsBrokerSnaps snaps = new AmsBrokerSnaps();
                    PropertyUtils.copyProperties(snaps, amsBroker);
                    snaps.setSnapsTime(System.currentTimeMillis());
//                    Method insertSelective =  getMapper().getClass().getDeclaredMethod("insertSelective", snaps.getClass());
//                    Object t = insertSelective.invoke( getMapper(), snaps);
                    int insertResult = amsBrokerMapper.insertSnapshotSelective(snaps);
                    if (insertResult == 0) {
                        new RuntimeException();
                    }
                    Method deleteByPrimaryKey =  getMapper().getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
                    Object result = deleteByPrimaryKey.invoke( getMapper(), id);
                    count += Integer.parseInt(String.valueOf(result));
                }
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }

    /**
     * 修改
     * @param
     * @return
     */

    @Override
    public int updateByPrimaryKeySelective(AmsBroker amsBroker) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            int result = 0;
            //先查询本条记录
            Long id = amsBroker.getBrokerId();
            Method selectByPrimaryKey =  getMapper().getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
            AmsBroker ams = (AmsBroker) selectByPrimaryKey.invoke( getMapper(), id);
            //将本条记录放在快照表中
            if (ams != null) {//查到数据后再做新增和删除操作
                AmsBrokerSnaps snaps = new AmsBrokerSnaps();
                PropertyUtils.copyProperties(snaps, ams);
                snaps.setSnapsTime(System.currentTimeMillis());
                int insertResult = amsBrokerMapper.insertSnapshotSelective(snaps);
                if (insertResult == 0) {
                    new RuntimeException();
                }
//                Method updateByPrimaryKeySelective =  getMapper().getClass().getDeclaredMethod("updateByPrimaryKeySelective", upmsCompany.getClass());
//                result = Integer.parseInt(String.valueOf(updateByPrimaryKeySelective.invoke( getMapper(), upmsCompany)));
                result = amsBrokerMapper.updateByPrimaryKeySelective(amsBroker);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


}