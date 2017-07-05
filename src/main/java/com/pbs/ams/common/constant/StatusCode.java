package com.pbs.ams.common.constant;

/**
 * Created by whb on 2017/6/28.
 * 状态码
 */
public enum StatusCode {
    //
    SUCCESS("1","成功"),
    FAILED("0", "失败"),
    //1开头（系统级异常）
    SYSTEM_ERROR("Ams_10000","系统内部异常"),
    PARAM_ERROR("Ams_10001","参数异常"),
    PARAM_JSON_ERROR("Ams_10002","参数非JSON格式"),
    FILE_WRITE_ERROR("Ams_10003","文件写入异常"),

    //2开头（外部资源使用异常）
    SQL_ERROR("External_21000","sql异常"),
    SQL_LINK_ERROR("External_21001","数据库链接异常"),
    REDIS_ERROR("External_21002","redis异常"),
    REDIS_LINK_ERROR("External_21003","redis链接异常"),

    //3开头 (业务级异常)
    PWD_COUNT_ERROR("Service_30001","您的密码已连续5次输入错误,请24小时后重试"),
    INSTITUTION_STOPPED("Service_30002","机构已被停用"),
    ACCOUNT_LOCKED("Service_30003","账号被锁定"),
    USER_LOGIN_OUT_TIME("Service_30004","已离线！请重新登录"),
    INVALID_LENGTH("Service_30005", "字数超过限制"),
    EMPTY_USERNAME("Service_30006", "用户名不能为空"),
    EMPTY_PASSWORD("Service_30007", "密码不能为空"),
    INVALID_USERNAME("Service_3008", "账号不存在"),
    INVALID_PASSWORD("Service_3009", "密码错误"),
    INVALID_ACCOUNT("Service_30010", "账号无效");

    private String code;

    private String msg;

    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
