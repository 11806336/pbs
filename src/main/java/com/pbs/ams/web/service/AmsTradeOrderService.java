package com.pbs.ams.web.service;

import com.pbs.ams.web.model.AmsTradeOrder;

import java.util.List;
import java.util.Map;

/**
* AmsTradeOrderService接口
* Created by ams on 2017/7/21.
*/
public interface AmsTradeOrderService{
    /**
     * 查询委托列表
     * @param map
     * @return
     */
    List<Map> selectAmsTradeOrderWithDetail(Map map);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(String ids);

    int insert(AmsTradeOrder record);

    int insertSelective(AmsTradeOrder record);

    AmsTradeOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AmsTradeOrder record);

    int updateByPrimaryKeySelective(AmsTradeOrder record);

    int insertToAmsTradeOrderSnaps();
}