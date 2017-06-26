package com.pbs.ams.common.Task;

import com.pbs.ams.web.model.LogTask;
import com.pbs.ams.web.model.UpmsLog;

/**
 * 任务池调用工具
 * Create by TiAmo 2017/06/26
 */
public class LogTaskHandler {


	/**
	 * 使用默认的任务池写日志
	 * @param upmsLog
	 */
	public static void AddLogByDefaultTaskPool(UpmsLog upmsLog){
		SimpleTaskHandler.getDefaultInstance().execute(new LogTask(upmsLog));
	}

	/**
	 * 使用指定任务池写日志 ex:key=ams-broker
	 * @param upmsLog
	 * @param key
	 */
	public static void AddLogByTaskPool(UpmsLog upmsLog,String key){
		SimpleTaskHandler.getOneInstance(key).execute(new LogTask(upmsLog));
	}
}
