package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.RskBlackwhiteListMapper;
import com.pbs.ams.web.model.RskBlackwhiteList;
import com.pbs.ams.web.service.RskBlackwhiteListService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* RskBlackwhiteListService实现
* Created by ams on 2017/7/28.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RskBlackwhiteListServiceImpl  implements RskBlackwhiteListService {

    private static Logger _log = LoggerFactory.getLogger(RskBlackwhiteListServiceImpl.class);

    @Autowired
    private RskBlackwhiteListMapper rskBlackwhiteListMapper;


        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return rskBlackwhiteListMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(RskBlackwhiteList rskBlackwhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return rskBlackwhiteListMapper.insert(rskBlackwhiteList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(RskBlackwhiteList rskBlackwhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return rskBlackwhiteListMapper.insertSelective(rskBlackwhiteList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public RskBlackwhiteList selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return rskBlackwhiteListMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(RskBlackwhiteList rskBlackwhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return rskBlackwhiteListMapper.updateByPrimaryKeySelective(rskBlackwhiteList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(RskBlackwhiteList rskBlackwhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return rskBlackwhiteListMapper.updateByPrimaryKey(rskBlackwhiteList);
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
        public int insertToRskBlackwhiteListSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return rskBlackwhiteListMapper.insertToRskBlackwhiteListSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}