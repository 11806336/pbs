package com.pbs.ams.web.model;

import java.io.Serializable;

import com.pbs.ams.common.base.BaseServiceImpl;
import com.pbs.ams.common.util.SpringContextUtil;
import com.pbs.ams.web.service.impl.UpmsApiServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日志任务对象
 * Create by TiAmo 2017/06/26
 */
public class SnapsTask implements Runnable, Serializable {

    private static final long serialVersionUID = 0;

    protected static Log logger = LogFactory.getLog(SnapsTask.class);

    private Object obj;

    private static final BaseServiceImpl baseService = SpringContextUtil.getBean(BaseServiceImpl.class);

    public SnapsTask(Object obj) {
        this.obj = obj;
    }

    private String classname;

    public void setClassname(String classname) {
        this.classname = classname;
    }


    public void run() {
        try {
            int flag = baseService.insertToSnaps();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        obj = null;
    }

    public Object getTask() {
        return this.obj;
    }
}
