package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeAccount;
import com.pbs.ams.web.model.AmsTradeAccountSnaps;

import java.util.List;
import java.util.Map;

/**
* AmsTradeAccountService接口
* Created by ams on 2017/6/29.
*/
public interface AmsTradeAccountService{

    int deleteByPrimaryKey(Long id);

    /**
     * 根据id删除账号
     * @param ids 券商id
     * @return
     */
    int deleteByPrimaryKeys(List<Long> ids);

    int insert(AmsTradeAccount record);

    /**
     * 新增账号
     * @param record 账号实体
     * @return
     */
    int insertSelective(AmsTradeAccount record);

    /**
     * 根据id查询单条记录
     * @param id 券商id
     * @return
     */
    AmsTradeAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeAccount record);

    /**
     *编辑券商
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AmsTradeAccount record);

    /**
     * 修改账号状态
     * @param id 账号id
     * @param status 账号状态
     * @return
     */
    int updateAccountStatusById(Long id, Integer status);
    /**
     * 向快照表中插入数据
     * @return
     */

    int insertToAmsTradeAccountSnaps(AmsTradeAccountSnaps amsTradeAccountSnaps);

    /**
     * This method is used to get PageList data.
     * @param map
     * @return
     */
    List<Map> selectTradeAccoutWithDetail(Map map);

    /**
     * This method is used to get PageListTotalSize
     * @param map
     * @return
     */
    int selectTradeAccoutWithDetailCount(Map map);
}