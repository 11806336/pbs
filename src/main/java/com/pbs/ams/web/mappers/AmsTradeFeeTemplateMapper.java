package com.pbs.ams.web.mappers;

import com.pbs.ams.web.model.AmsTradeFeeTemplate;
import com.pbs.ams.web.model.AmsTradeFeeTemplateSnaps;

import java.util.List;
import java.util.Map;

public interface AmsTradeFeeTemplateMapper {
    int deleteByPrimaryKey(Long feeTemplateteId);

    int insert(AmsTradeFeeTemplate record);

    int insertSelective(AmsTradeFeeTemplate record);

    /**
     * 根据ID查询单个记录
     * @param feeTemplateteId
     * @return
     */
    AmsTradeFeeTemplate selectByPrimaryKey(Long feeTemplateteId);

    int updateByPrimaryKeySelective(AmsTradeFeeTemplate record);

    int updateByPrimaryKey(AmsTradeFeeTemplate record);

    List<Map<String, Object>> selectTradeFeeTemplate(Map map);

    long selectTradeFeeTemplateCount(Map map);

    /**
     * 向快照表中插入数据
     * @return
     */

    int insertIntoAmsTradeFeeTemplateSnaps(AmsTradeFeeTemplateSnaps amsTradeFeeTemplateSnaps);
}