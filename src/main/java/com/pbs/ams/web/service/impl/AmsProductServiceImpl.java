package com.pbs.ams.web.service.impl;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import com.pbs.ams.web.mappers.AmsProductAccountMapper;
import com.pbs.ams.web.mappers.AmsProductMapper;
import com.pbs.ams.web.mappers.AmsProductUserMapper;
import com.pbs.ams.web.model.*;
import com.pbs.ams.web.service.AmsProductService;
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

    @Autowired
    private AmsProductUserMapper amsProductUserMapper;

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
    public int deleteByPrimaryKeys(List<Long> ids) {
        if (null != ids && ids.size() >0) {
            int count = 0;
            for (long id : ids) {
                //先做查询再去删除原表数据和插入快照
                AmsProduct amsProduct = amsProductMapper.selectByPrimaryKey(id);
                if (amsProduct != null) {
                    AmsProductSnaps amsProductSnaps = new AmsProductSnaps();
                    try {
                        PropertyUtils.copyProperties(amsProductSnaps, amsProduct);
                        //向快照表插入数据
                        int snapshotResult = amsProductMapper.insertIntoAmsProductSnaps(amsProductSnaps);
                        count += amsProductMapper.deleteByPrimaryKey(id);
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
    public int selectProductCount(Map map){
        return amsProductMapper.selectProductCount(map);
    }

    @Override
    public int insertAmsProductAccount(AmsProductAccount amsProductAccount) {
        return amsProductAccountMapper.insert(amsProductAccount);
    }

    @Override
    public List<Map> selectProduct(Map<String, Object> paramMaps) {

        return amsProductMapper.selectProduct(paramMaps);
    }

    /**
     * insert a product and product-user relation
     *
     * @param amsProduct
     * @param amsProductUser
     * @return insert
     */
    @Override
    public int insertProductAndUserRelation(AmsProduct amsProduct, AmsProductUser amsProductUser) {
        if (null != amsProduct && null != amsProductUser) {
            int result;
            int count = amsProductMapper.insertSelective(amsProduct);
            if (count > 0) {
                result = amsProductUserMapper.insert(amsProductUser);
                if (result > 0) {
                    return result;
                }
            }
        }
        return 0;
    }

    /**
     * update a product and product-user relation
     *
     * @param amsProduct
     * @param amsProductUser
     * @return update count
     */
    @Override
    public int updateProductAndUserRelation(AmsProduct amsProduct, AmsProductUser amsProductUser) {
        if (null != amsProduct && null != amsProductUser) {
            //先做查询再去更新原表数据和插入快照
            AmsProduct oldamsProduct=amsProductMapper.selectByPrimaryKey(amsProduct.getProductId());
            if(null!=oldamsProduct){
                AmsProductSnaps amsProductSnaps=new AmsProductSnaps();
                try {
                    PropertyUtils.copyProperties(amsProductSnaps, oldamsProduct);
                    //向快照表插入数据
                    int snapshotResult=amsProductMapper.insertIntoAmsProductSnaps(amsProductSnaps);
                    if(snapshotResult>0){//当插入成功后再更新原数据
                        int count=amsProductMapper.updateByPrimaryKeySelective(amsProduct);
                        if(count>0){
                            return amsProductUserMapper.updateByPrimaryKeySelective(amsProductUser);
                        }
                    }
                }catch (IllegalAccessException e) {
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
    public int updateProductStatusById(Long id, Integer status) {
        if (null != id) {
            //先做查询再去更新原表数据和插入快照
            AmsProduct oldamsProduct = amsProductMapper.selectByPrimaryKey(id);
            if (null != oldamsProduct){
                AmsProductSnaps amsProductSnaps=new AmsProductSnaps();
                try {
                    PropertyUtils.copyProperties(amsProductSnaps, oldamsProduct);
                    //向快照表插入数据
                    int snapshotResult=amsProductMapper.insertIntoAmsProductSnaps(amsProductSnaps);
                    if (snapshotResult > 0) {//当插入成功后再更新原数据
                        oldamsProduct.setProductStatus(status);
                        return amsProductMapper.updateByPrimaryKeySelective(oldamsProduct);
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
}