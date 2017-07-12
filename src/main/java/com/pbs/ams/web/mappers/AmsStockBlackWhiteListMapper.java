package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockBlackWhiteList;

import java.util.List;
import java.util.Map;


public interface AmsStockBlackWhiteListMapper {

    List<Map> selectProductWithDetail(Map map);

    int deleteByPrimaryKey(Long blackWhiteId);

    int insert(AmsStockBlackWhiteList record);

    int insertSelective(AmsStockBlackWhiteList record);

    AmsStockBlackWhiteList selectByPrimaryKey(Long blackWhiteId);

    int updateByPrimaryKeySelective(AmsStockBlackWhiteList record);

    int updateByPrimaryKey(AmsStockBlackWhiteList record);
}