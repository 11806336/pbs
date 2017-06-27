package com.pbs.ams.common.Task;

import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.model.AmsBroker;
import com.pbs.ams.web.model.SnapsTask;

/**
 * 任务池调用工具
 * Create by TiAmo 2017/06/26
 */
public class SnapsTaskHandler {




	/**
	 * 使用默认的任务池写日志
	 * @param classname ex:AmsBroker
	 * @param obj
	 */
	public static void AddLogByDefaultTaskPool(Object obj,String classname){
		SnapsTask logTask = new SnapsTask(obj);
		logTask.setClassname(classname);
		SimpleTaskHandler.getDefaultInstance().execute(logTask);
	}

	/**
	 * 使用指定任务池写日志 ex:key=AmsBroker
	 * @param key
	 * @param classname
	 * @param obj
	 */
	public static void AddLogByTaskPool(Object obj,String classname,String key){
		SnapsTask logTask = new SnapsTask(obj);
		logTask.setClassname(classname);
		SimpleTaskHandler.getOneInstance(key).execute(logTask);
	}

//	public static void main(String[] args) {
//		AmsBroker amsBroker = new AmsBroker();
//		amsBroker.setBrokerAbbrName("test");
//		amsBroker.setBrokerId(1L);
//		amsBroker.setBrokerName("啊啊啊啊啊");
//		SnapsTaskHandler.AddLogByDefaultTaskPool(amsBroker,"AmsBroker");
//	}
}
