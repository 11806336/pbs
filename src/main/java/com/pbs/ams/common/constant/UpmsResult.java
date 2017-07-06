package com.pbs.ams.common.constant;

import com.pbs.ams.common.base.BaseResult;

/**
 * 返回结果集
 * Created by ams on 2017/2/18.
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(StatusCode statusCode, Object data) {
        super(statusCode.getCode(), statusCode.getMsg(), data);
    }
}
