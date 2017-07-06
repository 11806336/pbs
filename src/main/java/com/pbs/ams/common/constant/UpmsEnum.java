package com.pbs.ams.common.constant;

import com.pbs.ams.common.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统级常量枚举
 * @author TiAmo
 */
public enum UpmsEnum {

    // 会话key
    AMS_UPMS_SHIRO_SESSION_ID ("pbs-ams-management-shiro-session-id"),
    // 全局会话key
    AMS_UPMS_SERVER_SESSION_ID ("pbs-ams-management-server-session-id"),
    // 全局会话列表key
    AMS_UPMS_SERVER_SESSION_IDS ("pbs-ams-management-server-session-ids"),
    // code key
    AMS_UPMS_SERVER_CODE ("pbs-ams-management-server-code"),
    // 局部会话key
    AMS_UPMS_CLIENT_SESSION_ID("pbs-ams-management-client-session-id"),
    // 单点同一个code所有局部会话key
    AMS_UPMS_CLIENT_SESSION_IDS ("pbs-ams-management-client-session-ids"),
    //退出标识
    FORCE_LOGOUT("FORCE_LOGOUT"),
	//访问类型
    UPMSTYPE(PropertiesFileUtil.getInstance("pbs-ams-management-client").get("upms.type")),

    SSO_SERVER_URL(PropertiesFileUtil.getInstance("pbs-ams-management-client").get("sso.server.url")),

    APPID(PropertiesFileUtil.getInstance("pbs-ams-management-client").get("appID"));

	private final Object value;

	UpmsEnum(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	// Implementing a fromString method on an enum type
    private static final Map<String, UpmsEnum> stringToEnum = new HashMap<>();
    static {
        // Initialize map from constant name to enum constant
        for(UpmsEnum enumObj : values()) {
            stringToEnum.put(enumObj.toString(), enumObj);
        }
    }
    // Returns GeneratorEnum for string, or null if string is invalid
    public static UpmsEnum parse(String id) {
        return stringToEnum.get(id);
    }

    public String getString() {
        return  String.valueOf(this.getValue());
    }

    public StringBuilder getStringBuilder() {
        return  new StringBuilder(this.getString());
    }
}