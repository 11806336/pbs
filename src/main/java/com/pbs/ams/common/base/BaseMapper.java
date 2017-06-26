package com.pbs.ams.common.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TiAmo on 17/6/22.
 */
public interface BaseMapper<Record, Example>  {

    long countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer productAccountId);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(Example example);

    Record selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    int insertToSnaps();
}
