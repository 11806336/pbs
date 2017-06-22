package com.pbs.ams.web.mappers;


import com.pbs.ams.web.model.SysSequence;
import com.pbs.ams.web.model.UpmsPermission;
import com.pbs.ams.web.model.UpmsRole;

import java.util.List;

/**
 *
 */
public interface SysSequenceMapper {

	/**
	 * 根据sequenceCode查询下序列
	 * @param sequenceCode
	 * @return
	 */
	public Long selectSequenceByCode(String sequenceCode) throws Exception;

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