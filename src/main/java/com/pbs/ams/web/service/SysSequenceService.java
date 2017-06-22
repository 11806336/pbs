package com.pbs.ams.web.service;

import com.pbs.ams.common.base.BaseService;
import com.pbs.ams.web.model.SysSequence;
import com.pbs.ams.web.model.UpmsUser;
import com.pbs.ams.web.model.UpmsUserExample;

/**
* SysSequenceService
*/

public interface SysSequenceService {

    /**
     *根据code来查询当前的最大序列值
     * @param sequenceCode
     * @param startValue
     * @return
     * @throws Exception
     */
    public Long selectSequeceByCode(String sequenceCode, Long startValue) throws Exception;

    /**
     * 插入一行新的序列
     * @param sequence
     * @return
     * @throws Exception
     */
    public int insertSequence(SysSequence sequence) throws Exception;
    /**
     * 更新一行序列
     * @param sequence
     * @return
     * @throws Exception
     */
    public int updateSequence(SysSequence sequence) throws Exception;
}