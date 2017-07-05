package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.AmsBrokerSnaps;

import java.util.List;
import java.util.Map;

/**
* AmsBrokerService接口
* Created by ams on 2017/6/29.
*/
public interface AmsBrokerService{

    /**
     * 根据id删除券商
     * @param ids 券商id
     * @return
     */
    int deleteByPrimaryKeys(List<Long> ids);/**/

    /**
     * 新增券商
     * @param record 券商实体
     * @return
     */
    int insertSelective(AmsBroker record);/**/

    /**
     * 根据id查询单条记录
     * @param id 券商id
     * @return
     */
    AmsBroker selectByPrimaryKey(Long id);/**/

    /**
     *编辑券商
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AmsBroker record);/**/

    /**
     * 向快照表中插入数据
     * @return
     */
    int insertToAmsBrokerSnaps(AmsBrokerSnaps amsBrokerSnaps);/**/

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectBrokerWithDetail(Map map);/**/

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectBrokerWithDetailCount(Map map);/**/


}