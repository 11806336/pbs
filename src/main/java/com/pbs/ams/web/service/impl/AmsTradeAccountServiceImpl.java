package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsTradeAccountMapper;
import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.AmsTradeAccountSnaps;
import com.pbs.ams.web.service.AmsTradeAccountService;
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
* AmsTradeAccountService实现
* Created by ams on 2017/6/29.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsTradeAccountServiceImpl  implements AmsTradeAccountService {

    private static Logger _log = LoggerFactory.getLogger(AmsTradeAccountServiceImpl.class);

    @Autowired
    private AmsTradeAccountMapper amsTradeAccountMapper;

        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeAccountMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insert(AmsTradeAccount amsTradeAccount) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeAccountMapper.insert(amsTradeAccount);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsTradeAccount amsTradeAccount) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeAccountMapper.insertSelective(amsTradeAccount);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public AmsTradeAccount selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeAccountMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }

        @Override
        public int updateByPrimaryKeySelective(AmsTradeAccount amsTradeAccount) {
            if (null != amsTradeAccount) {
                //先做查询再去更新原表数据和插入快照
                AmsTradeAccount oldamsTradeAccount = amsTradeAccountMapper.selectByPrimaryKey(amsTradeAccount.getTradeAccountId());
                if (null != oldamsTradeAccount) {
                    AmsTradeAccountSnaps amsTradeAccountSnaps = new AmsTradeAccountSnaps();
                    try {
                        PropertyUtils.copyProperties(amsTradeAccountSnaps, oldamsTradeAccount);
                        //向快照表插入数据
                        int snapshotResult = amsTradeAccountMapper.insertIntoAmsTradeAccountSnaps(amsTradeAccountSnaps);
                        if (snapshotResult > 0) {//当插入成功后再更新原数据
                            return amsTradeAccountMapper.updateByPrimaryKeySelective(amsTradeAccount);
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
    public int updateAccountStatusById(Long id, Integer status) {
        if (null != id) {
            //先做查询再去更新原表数据和插入快照
            AmsTradeAccount oldamsTradeAccount = amsTradeAccountMapper.selectByPrimaryKey(id);
            if (null != oldamsTradeAccount){
                AmsTradeAccountSnaps amsTradeAccountSnaps = new AmsTradeAccountSnaps();
                try {
                    PropertyUtils.copyProperties(amsTradeAccountSnaps, oldamsTradeAccount);
                    //向快照表插入数据
                    int snapshotResult = amsTradeAccountMapper.insertIntoAmsTradeAccountSnaps(amsTradeAccountSnaps);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        oldamsTradeAccount.setTradeAccountStatus(String.valueOf(status));
                        return amsTradeAccountMapper.updateByPrimaryKeySelective(oldamsTradeAccount);
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
        public int updateByPrimaryKey(AmsTradeAccount amsTradeAccount) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeAccountMapper.updateByPrimaryKey(amsTradeAccount);
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
                    AmsTradeAccount amsTradeAccount = amsTradeAccountMapper.selectByPrimaryKey(id);
                    if (amsTradeAccount != null) {
                        AmsTradeAccountSnaps amsTradeAccountSnaps = new AmsTradeAccountSnaps();
                        try {
                            PropertyUtils.copyProperties(amsTradeAccountSnaps, amsTradeAccount);
                            //向快照表插入数据
                            int snapshotResult = amsTradeAccountMapper.insertIntoAmsTradeAccountSnaps(amsTradeAccountSnaps);
                            count += amsTradeAccountMapper.deleteByPrimaryKey(id);
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
        * @return
        */
        @Override
        @Transactional(propagation = Propagation.MANDATORY)
        public int insertToAmsTradeAccountSnaps(AmsTradeAccountSnaps amsTradeAccountSnaps) {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

    @Override
    public List<Map> selectTradeAccoutWithDetail(Map map) {
        return amsTradeAccountMapper.selectTradeAccoutWithDetail(map);
    }

    @Override
    public int selectTradeAccoutWithDetailCount(Map map) {
        return amsTradeAccountMapper.selectTradeAccoutWithDetailCount(map);
    }
}