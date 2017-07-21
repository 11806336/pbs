package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsTradeInstructStockMapper;
import com.pbs.ams.web.model.AmsTradeInstructStock;
import com.pbs.ams.web.service.AmsTradeInstructStockService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsTradeInstructStockService实现
* Created by ams on 2017/7/21.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsTradeInstructStockServiceImpl  implements AmsTradeInstructStockService {

    private static Logger _log = LoggerFactory.getLogger(AmsTradeInstructStockServiceImpl.class);

    @Autowired
    private AmsTradeInstructStockMapper amsTradeInstructStockMapper;


        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructStockMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(AmsTradeInstructStock amsTradeInstructStock) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructStockMapper.insert(amsTradeInstructStock);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsTradeInstructStock amsTradeInstructStock) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructStockMapper.insertSelective(amsTradeInstructStock);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public AmsTradeInstructStock selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructStockMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(AmsTradeInstructStock amsTradeInstructStock) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructStockMapper.updateByPrimaryKeySelective(amsTradeInstructStock);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(AmsTradeInstructStock amsTradeInstructStock) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructStockMapper.updateByPrimaryKey(amsTradeInstructStock);
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
                    //count += amsStockAccountMapper.deleteByPrimaryKey(id);
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
        * @return
        */
        @Override
        @Transactional(propagation = Propagation.MANDATORY)
        public int insertToAmsTradeInstructStockSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsTradeInstructStockMapper.insertToAmsTradeInstructStockSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}