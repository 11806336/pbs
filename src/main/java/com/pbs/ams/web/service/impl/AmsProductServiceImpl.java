package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.common.exception.AmsException;
import com.pbs.ams.web.mappers.AmsProductAccountMapper;
import com.pbs.ams.web.mappers.AmsProductMapper;
import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductAccount;
import com.pbs.ams.web.service.AmsProductService;
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
* AmsProductService实现
* Created by ams on 2017/6/28.
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class AmsProductServiceImpl  implements AmsProductService {

    private static Logger _log = LoggerFactory.getLogger(AmsProductServiceImpl.class);

    @Autowired
    private AmsProductMapper amsProductMapper;

    @Autowired
    private AmsProductAccountMapper amsProductAccountMapper;

        @Override
        public int deleteByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductMapper.deleteByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int insert(AmsProduct amsProduct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductMapper.insert(amsProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

        @Override
        public int insertSelective(AmsProduct amsProduct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductMapper.insertSelective(amsProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public AmsProduct selectByPrimaryKey(Long id) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductMapper.selectByPrimaryKey(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return null;
        }


        @Override
        public int updateByPrimaryKeySelective(AmsProduct amsProduct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductMapper.updateByPrimaryKeySelective(amsProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }


        @Override
        public int updateByPrimaryKey(AmsProduct amsProduct) {
            try {
                DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
                return amsProductMapper.updateByPrimaryKey(amsProduct);
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
                    count += amsProductMapper.deleteByPrimaryKey(id);
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
        public int insertToAmsProductSnaps() {
        try {
            DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
//            return amsProductMapper.insertToAmsProductSnaps();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DynamicDataSource.clearDataSource();
            return 0;
        }

    @Override
    public List<Map> selectProductWithDetail(Map map){
        return amsProductMapper.selectProductWithDetail(map);
    }

    @Override
    public int selectProductWithDetailCount(Map map){
        return amsProductMapper.selectProductWithDetailCount(map);
    }

    @Override
    public int insertAmsProductAccount(AmsProductAccount amsProductAccount) {
        return amsProductAccountMapper.insert(amsProductAccount);
    }

}