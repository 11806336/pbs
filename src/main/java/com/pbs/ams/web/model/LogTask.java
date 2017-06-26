package com.pbs.ams.web.model;

import java.io.Serializable;

import com.pbs.ams.common.util.SpringContextUtil;
import com.pbs.ams.web.service.impl.UpmsApiServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日志任务对象
 * Create by TiAmo 2017/06/26
 */
public class LogTask implements Runnable, Serializable {

    private static final long serialVersionUID = 0;

    protected static Log logger = LogFactory.getLog(LogTask.class);

    private UpmsLog upmsLog;

    private static final UpmsApiServiceImpl upmsApiService = SpringContextUtil.getBean(UpmsApiServiceImpl.class);

    public LogTask(UpmsLog upmsLog) {
        this.upmsLog = upmsLog;
    }

    public void run() {
        try {
            int flag = upmsApiService.insertUpmsLogSelective(upmsLog);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        upmsLog = null;
    }

    public Object getTask() {
        return this.upmsLog;
    }
}
