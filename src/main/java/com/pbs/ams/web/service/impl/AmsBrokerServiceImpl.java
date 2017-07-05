package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsBrokerMapper;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerSnaps;
import com.pbs.ams.web.service.AmsBrokerService;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
 * AmsBrokerService实现
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
        if (null != amsBroker) {
            //先做查询再去更新原表数据和插入快照
            AmsBroker amsbroker = amsBrokerMapper.selectByPrimaryKey(amsBroker.getBrokerId());
            if (null != amsbroker) {
                AmsBrokerSnaps amsBrokerSnaps = new AmsBrokerSnaps();
                try {
                    PropertyUtils.copyProperties(amsBrokerSnaps, amsbroker);
                    //向快照表插入数据
                    int snapshotResult = amsBrokerMapper.insertToAmsBrokerSnaps(amsBrokerSnaps);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        return amsBrokerMapper.updateByPrimaryKeySelective(amsbroker);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }


    @Override
    public int deleteByPrimaryKeys(List<Long> ids) {
        if (null != ids && ids.size() >0) {
            int count = 0;
            for (long id : ids) {
                //先做查询再去删除原表数据和插入快照
                AmsBroker amsbroker = amsBrokerMapper.selectByPrimaryKey(id);
                if (amsbroker != null) {
                    AmsBrokerSnaps amsBrokerSnaps = new AmsBrokerSnaps();
                    try {
                        PropertyUtils.copyProperties(amsBrokerSnaps, amsbroker);
                        //向快照表插入数据
                        int snapshotResult = amsBrokerMapper.insertToAmsBrokerSnaps(amsBrokerSnaps);
                        count += amsBrokerMapper.deleteByPrimaryKey(id);
                    } catch (IllegalAccessException e) {//checkException
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            return count;
        }
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