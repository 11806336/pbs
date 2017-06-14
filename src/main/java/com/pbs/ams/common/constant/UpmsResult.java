package com.pbs.ams.common.constant;

import com.pbs.ams.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * Created by ipb on 2017/2/18.
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

}
