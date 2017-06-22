package com.pbs.ams.web.service.impl;

import com.pbs.ams.web.mappers.SysSequenceMapper;
import com.pbs.ams.web.model.SysSequence;
import com.pbs.ams.web.service.SysSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
@Transactional
public class SysSequenceServiceImpl implements SysSequenceService {


    @Autowired
    private SysSequenceMapper sysSequenceMapper;

    /**
     * 根据code获取序列值
     * @param sequenceCode
     * @return
     */
    @Override
    public Long selectSequeceByCode(String sequenceCode, Long startValue) throws Exception{
        Long value = sysSequenceMapper.selectSequenceByCode(sequenceCode);
        SysSequence sysSequence = new SysSequence(sequenceCode);
        if (value != null) {
            if (value >= startValue) {//说明已经有id生成，无法按照传入的来自增，不然会造成重复
                value += 1;
            } else { //当小于的时候不管之前的id从传入的id开始生成
                value = startValue;
            }
            sysSequence.setMaxValue(value);
            int updateResult = updateSequence(sysSequence);
            if (updateResult < 1) {
                return null;
            }
        } else {//说明是第一次获取此表的key，做插入动作
            sysSequence.setMaxValue(startValue);
            int insertResult = insertSequence(sysSequence);
            if (insertResult < 1) {
                return null;
            }
            value = startValue;
        }
        return value;
    }

    /**
     *插入一行新的序列
     * @param sequence
     * @return
     * @throws Exception
     */
    @Override
    public int insertSequence(SysSequence sequence) throws Exception {
        return sysSequenceMapper.insertSequence(sequence);
    }

    /**
     * 更新一行序列
     * @param sequence
     * @return
     * @throws Exception
     */
    @Override
    public int updateSequence(SysSequence sequence) throws Exception {
        return sysSequenceMapper.updateSequence(sequence);
    }
}
