package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsTradeInstructMapper;
import com.pbs.ams.web.model.AmsTradeInstruct;
import com.pbs.ams.web.service.AmsTradeInstructService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsTradeInstructService实现
* Created by ams on 2017/7/21.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsTradeInstructServiceImpl  implements AmsTradeInstructService {

    private static Logger _log = LoggerFactory.getLogger(AmsTradeInstructServiceImpl.class);

    @Autowired
    private AmsTradeInstructMapper amsTradeInstructMapper;


        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(AmsTradeInstruct amsTradeInstruct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructMapper.insert(amsTradeInstruct);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsTradeInstruct amsTradeInstruct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructMapper.insertSelective(amsTradeInstruct);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public AmsTradeInstruct selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(AmsTradeInstruct amsTradeInstruct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructMapper.updateByPrimaryKeySelective(amsTradeInstruct);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(AmsTradeInstruct amsTradeInstruct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeInstructMapper.updateByPrimaryKey(amsTradeInstruct);
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
        public int insertToAmsTradeInstructSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsTradeInstructMapper.insertToAmsTradeInstructSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}