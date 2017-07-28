package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductAccount;
import com.pbs.ams.web.model.AmsProductUser;

import java.util.List;
import java.util.Map;

/**
* AmsProductService接口
* Created by ams on 2017/6/28.
*/
public interface AmsProductService{
    /**
     * This method by id delete data  通过id删除数据
     * @param productId
     * @return
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method by id delete data  通过id删除数据
     * @param ids
     * @return
     */
    int deleteByPrimaryKeys(List<Long> ids);

    /**
     * This method by id query data  通过id查询数据
     * @param id
     * @return
     */
    AmsProduct selectByPrimaryKey(Long id);

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectProductWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectProductWithDetailCount(Map map);

    /**
     * 修改账号状态
     * @param id 账号id
     * @param status 账号状态
     * @return
     */
    int updateProductStatusById(Long id, Integer status);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectProductCount(Map map);

    /**
     * This method is used to bind Account and Product
     * @param amsProductAccount
     * @return
     */
    int insertAmsProductAccount(AmsProductAccount amsProductAccount);

    /**
     *query product by some companys(sql:companyId in ...)
     * @param paramMaps 参数
     * @return
     */
    List<Map> selectProduct(Map<String, Object> paramMaps);

    /**
     *insert a product and product-user relation
     * @param amsProduct
     * @param amsProductUser
     * @return insert count
     */
    int insertProductAndUserRelation(AmsProduct amsProduct, AmsProductUser amsProductUser);

    /**
     * update a product and product-user relation
     * @param amsProduct
     * @param amsProductUser
     * @return update count
     */
    int updateProductAndUserRelation(AmsProduct amsProduct, AmsProductUser amsProductUser);
}