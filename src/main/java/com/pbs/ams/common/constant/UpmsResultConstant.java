package com.pbs.ams.common.constant;

/**
 * upms系统接口结果常量枚举类
 * Created by ams on 2017/2/18.
 */
public enum UpmsResultConstant {

    FAILED(0, "failed"),
    SUCCESS(1, "success"),

    INVALID_LENGTH(10001, "字数超过限制"),

    EMPTY_USERNAME(10101, "用户名不能为空"),
    EMPTY_PASSWORD(10102, "密码不能为空"),
    INVALID_USERNAME(10103, "账号不存在"),
    INVALID_PASSWORD(10104, "密码错误"),
    INVALID_ACCOUNT(10105, "账号无效");

    public int code;

    public String message;

    UpmsResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
