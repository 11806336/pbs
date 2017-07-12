package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsStockBlackWhiteListMapper;
import com.pbs.ams.web.model.AmsStockBlackWhiteList;
import com.pbs.ams.web.service.AmsStockBlackWhiteListService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
* AmsStockBlackWhiteListService实现
* Created by ams on 2017/7/11.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsStockBlackWhiteListServiceImpl  implements AmsStockBlackWhiteListService {

    private static Logger _log = LoggerFactory.getLogger(AmsStockBlackWhiteListServiceImpl.class);

    @Autowired
    private AmsStockBlackWhiteListMapper amsStockBlackWhiteListMapper;

        @Override
        public List<Map> selectProductWithDetail(Map map){
            return amsStockBlackWhiteListMapper.selectProductWithDetail(map);
        }
        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockBlackWhiteListMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(AmsStockBlackWhiteList amsStockBlackWhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockBlackWhiteListMapper.insert(amsStockBlackWhiteList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsStockBlackWhiteList amsStockBlackWhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockBlackWhiteListMapper.insertSelective(amsStockBlackWhiteList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public AmsStockBlackWhiteList selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockBlackWhiteListMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(AmsStockBlackWhiteList amsStockBlackWhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockBlackWhiteListMapper.updateByPrimaryKeySelective(amsStockBlackWhiteList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(AmsStockBlackWhiteList amsStockBlackWhiteList) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsStockBlackWhiteListMapper.updateByPrimaryKey(amsStockBlackWhiteList);
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
        public int insertToAmsStockBlackWhiteListSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
            //return amsStockBlackWhiteListMapper.insertToAmsStockBlackWhiteListSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

}