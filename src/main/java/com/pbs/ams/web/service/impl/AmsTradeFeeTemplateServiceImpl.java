package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsTradeAccountFeeMapper;
import com.pbs.ams.web.mappers.AmsTradeFeeTemplateMapper;
import com.pbs.ams.web.model.*;
import com.pbs.ams.web.service.AmsTradeFeeTemplateService;
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
 * AmsTradeFeeTemplateService实现
 * Created by ams on 2017/7/25.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsTradeFeeTemplateServiceImpl  implements AmsTradeFeeTemplateService {

    private static Logger _log = LoggerFactory.getLogger(AmsTradeFeeTemplateServiceImpl.class);

    @Autowired
    private AmsTradeFeeTemplateMapper amsTradeFeeTemplateMapper;

    @Autowired
    private AmsTradeAccountFeeMapper amsTradeAccountFeeMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsTradeFeeTemplateMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


    @Override
    public int insert(AmsTradeFeeTemplate amsTradeFeeTemplate) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsTradeFeeTemplateMapper.insert(amsTradeFeeTemplate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }

    @Override
    public int insertSelective(AmsTradeFeeTemplate amsTradeFeeTemplate) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsTradeFeeTemplateMapper.insertSelective(amsTradeFeeTemplate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }


    @Override
    public AmsTradeFeeTemplate selectByPrimaryKey(Long id) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsTradeFeeTemplateMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AmsTradeFeeTemplate amsTradeFeeTemplate) {
        if (null != amsTradeFeeTemplate) {
            //先做查询再去更新原表数据和插入快照
            AmsTradeFeeTemplate oldAmsTradeFeeTemplate = amsTradeFeeTemplateMapper.selectByPrimaryKey(amsTradeFeeTemplate.getFeeTemplateteId());
            if (null != oldAmsTradeFeeTemplate) {
                AmsTradeFeeTemplateSnaps snapshot = new AmsTradeFeeTemplateSnaps();
                try {
                    PropertyUtils.copyProperties(snapshot, oldAmsTradeFeeTemplate);
                    //向快照表插入数据
                    int snapshotResult = amsTradeFeeTemplateMapper.insertIntoAmsTradeFeeTemplateSnaps(snapshot);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        return amsTradeFeeTemplateMapper.updateByPrimaryKeySelective(amsTradeFeeTemplate);
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
    public int updateByPrimaryKey(AmsTradeFeeTemplate amsTradeFeeTemplate) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            return amsTradeFeeTemplateMapper.updateByPrimaryKey(amsTradeFeeTemplate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(List<Long> ids) {

        if (null != ids && ids.size() >0) {
            int count = 0;
            for (long id : ids) {
                //先做查询再去删除原表数据和插入快照
                AmsTradeFeeTemplate amsTradeFeeTemplate = amsTradeFeeTemplateMapper.selectByPrimaryKey(id);
                if (amsTradeFeeTemplate != null) {
                    AmsTradeFeeTemplateSnaps snapshot = new AmsTradeFeeTemplateSnaps();
                    try {
                        PropertyUtils.copyProperties(snapshot, amsTradeFeeTemplate);
                        //向快照表插入数据
                        int snapshotResult = amsTradeFeeTemplateMapper.insertIntoAmsTradeFeeTemplateSnaps(snapshot);
                        count += amsTradeFeeTemplateMapper.deleteByPrimaryKey(id);
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

    @Override
    public List<Map<String,Object>> selectTradeFeeTemplate(Map map){
        return amsTradeFeeTemplateMapper.selectTradeFeeTemplate(map);
    }
    @Override
    public long selectTradeFeeTemplateCount(Map map) {
        return amsTradeFeeTemplateMapper.selectTradeFeeTemplateCount(map);
    }
    /**
     * MANDATORY:该方法只能在一个已存在的事务中执行.
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public int insertIntoAmsTradeFeeTemplateSnaps(AmsTradeFeeTemplateSnaps amsTradeFeeTemplateSnaps){
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsTradeFeeTemplateMapper.insertToAmsTradeFeeTemplateSnaps();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DynamicDataSource.clearDataSource();
        return 0;
    }
    @Override
    public int insertTemplateAndTradeAccount(AmsTradeFeeTemplate amsTradeFeeTemplate, AmsTradeAccountFee amsTradeAccountFee) {

        if (null != amsTradeFeeTemplate && null != amsTradeAccountFee) {
            int result = 0;
            int count = amsTradeFeeTemplateMapper.insertSelective(amsTradeFeeTemplate);
            if (count > 0) {//手续费插入成功的再向关系表中插入信息
                result = amsTradeAccountFeeMapper.insertSelective(amsTradeAccountFee);
            }
            return result;
        }
        return 0;
    }

}