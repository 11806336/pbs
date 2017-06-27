package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsStockAccount;
import com.pbs.ams.web.model.AmsStockAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmsStockAccountMapper {
    long countByExample(AmsStockAccountExample example);

    int deleteByExample(AmsStockAccountExample example);

    int deleteByPrimaryKey(Long stockAccountId);

    int insert(AmsStockAccount record);

    int insertSelective(AmsStockAccount record);

    List<AmsStockAccount> selectByExample(AmsStockAccountExample example);

    AmsStockAccount selectByPrimaryKey(Long stockAccountId);

    int updateByExampleSelective(@Param("record") AmsStockAccount record, @Param("example") AmsStockAccountExample example);

    int updateByExample(@Param("record") AmsStockAccount record, @Param("example") AmsStockAccountExample example);

    int updateByPrimaryKeySelective(AmsStockAccount record);

    int updateByPrimaryKey(AmsStockAccount record);
}