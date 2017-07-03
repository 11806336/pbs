package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsBrokerMapper;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerSnaps;
import com.pbs.ams.web.service.AmsBrokerService;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * AmsProductService实现
 * Created by ams on 2017/6/28.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsBrokerServiceImpl implements AmsBrokerService {

    private static Logger _log = LoggerFactory.getLogger(AmsBrokerServiceImpl.class);

    @Autowired
    private AmsBrokerMapper amsBrokerMapper;

    public Object getMapper() { return amsBrokerMapper; }


    @Override
    public int deleteByPrimaryKey(Long id) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsBrokerMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


    @Override
    public int insert(AmsBroker amsBroker) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsBrokerMapper.insert(amsBroker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


    @Override
    public int insertSelective(AmsBroker amsBroker) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsBrokerMapper.insertSelective(amsBroker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


    @Override
    public AmsBroker selectByPrimaryKey(Long id) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsBrokerMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return null;
    }


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
                int insertResult = amsBrokerMapper.insertToAmsBrokerSnaps(snaps);
                if (insertResult == 0) {
                    new RuntimeException();
                }
                result = amsBrokerMapper.updateByPrimaryKeySelective(amsBroker);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


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
                    int insertResult = amsBrokerMapper.insertToAmsBrokerSnaps(snaps);
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
     * MANDATORY:该方法只能在一个已存在的事务中执行.
     *
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public int insertToAmsBrokerSnaps(AmsBrokerSnaps amsBrokerSnaps) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsBrokerMapper.insertToAmsBrokerSnaps(amsBrokerSnaps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }

    @Override
    public List<Map> selectBrokerWithDetail(Map map) {
        return amsBrokerMapper.selectBrokerWithDetail(map);
    }

    @Override
    public int selectBrokerWithDetailCount(Map map) {
        return amsBrokerMapper.selectBrokerWithDetailCount(map);
    }
}