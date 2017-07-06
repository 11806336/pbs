package com.pbs.ams.common.base;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 统一返回结果类
 * Created by whb on 2017/6/27.
 */
public class BaseResult implements Serializable{

    Logger logger = LoggerFactory.getLogger(getClass());
    // 状态码：1成功，其他为失败
    public String code = "1";
    // 成功为success，其他为失败原因
    public String message = "success";
    //token
    public String token;
    // 数据结果集
    public Object data;

    public BaseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public BaseResult(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        if(!code.equals("1")){
            logger.error(message);
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                ", data=" + data +
                '}';
    }

    public String toJsonStr(){
        return JSONObject.fromObject(this).toString();
    }
}
