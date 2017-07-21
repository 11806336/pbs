package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsTradeFeeTemplateMapper;
import com.pbs.ams.web.model.AmsTradeFeeTemplate;
import com.pbs.ams.web.service.AmsTradeFeeTemplateService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* AmsTradeFeeTemplateService实现
* Created by ams on 2017/7/21.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsTradeFeeTemplateServiceImpl  implements AmsTradeFeeTemplateService {

    private static Logger _log = LoggerFactory.getLogger(AmsTradeFeeTemplateServiceImpl.class);

    @Autowired
    private AmsTradeFeeTemplateMapper amsTradeFeeTemplateMapper;


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
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsTradeFeeTemplateMapper.updateByPrimaryKeySelective(amsTradeFeeTemplate);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
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
        public int insertToAmsTradeFeeTemplateSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsTradeFeeTemplateMapper.insertToAmsTradeFeeTemplateSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}