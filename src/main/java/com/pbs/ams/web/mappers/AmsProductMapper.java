package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsProduct;
import com.pbs.ams.web.model.AmsProductSnaps;

import java.util.List;
import java.util.Map;

public interface AmsProductMapper {
    /**
     * This method by id delete data  通过id删除数据
     * @param productId
     * @return
     */
    int deleteByPrimaryKey(Long productId);

    /**
     * This method by id query data  通过id查询数据
     * @param productId
     * @return
     */
    AmsProduct selectByPrimaryKey(Long productId);

    /**
     * This method is used to get Net PageList data.产品净值查询列表
     * @param map
     * @return
     */
    List<Map> selectProductWithDetail(Map map);

    /**
     * This method is used to get Net PageListTotalSize.产品净值查询数量
     * @param map
     * @return
     */
    int selectProductWithDetailCount(Map map);

    /**
     *This method is used to get basic PageList data.产品基本信息查询列表
     * @param paramMaps 参数
     * @return
     */
    List<Map> selectProduct(Map<String, Object> paramMaps);

    /**
     * This method is used to get basic PageListTotalSize.产品基本信息查询数量
     * @param map
     * @return
     */
    int selectProductCount(Map map);

    /**
     *insert a product
     * @param record
     * @return insert count
     */
    int insertSelective(AmsProduct record);

    /**
     *Modify Existing Product Configurations
     * @param record
     * @return
     */
    int updateAmsProduct(AmsProduct record);

    /**
     * The snapshot to add data in the table
     * @param snaps
     * @return
     */
    int insertIntoAmsProductSnaps(AmsProductSnaps snaps);
}