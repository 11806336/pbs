package com.pbs.ams.common.constant;

import com.pbs.ams.common.util.AESUtil;
import com.pbs.ams.common.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Generator自动代码生成参数枚举
 * @author TiAmo
 */
public enum GeneratorEnum {

    //项
    TARGET_PROJECT_JAVA("src/main/java"),
    //项目名称
    TARGET_PROJECT_RESOUCE("src/main/resources"),
    //生成xml路径
    XML_PATH("src/main/resources/generatorConfig.xml"),
    // generatorConfig模板路径
    GENERATORCONFIG_VM("template/generatorConfig.vm"),
    // Service模板路径
    SERVICE_VM("template/Service.vm"),
    // ServiceImpl模板路径
    SERVICEIMPL_VM("template/ServiceImpl.vm"),
    //生成service路径
    CREATE_SERVICE_PATH("src/main/java/com/pbs/ams/web/service"),
    //生成serviceimpl路径
    CREATE_SERVICEIMPL_PATH("src/main/java/com/pbs/ams/web/service/impl"),
    //包名
    PACKAGE_NAME("com.pbs.ams.web"),
    //jdbc密码
    JDBC_PASSWORD("");

	private final String value;

    private  String jdbc_password = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.password");

	GeneratorEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	// Implementing a fromString method on an enum type
    private static final Map<String, GeneratorEnum> stringToEnum = new HashMap<>();
    static {
        // Initialize map from constant name to enum constant
        for(GeneratorEnum enumObj : values()) {
            stringToEnum.put(enumObj.toString(), enumObj);
        }
    }
    // Returns GeneratorEnum for string, or null if string is invalid
    public static GeneratorEnum parse(String id) {
        return stringToEnum.get(id);
    }

    @Override
    public String toString() {
        return value;
    }

    public String getByAESDecode(){
        if (this == GeneratorEnum.JDBC_PASSWORD){
            return AESUtil.AESDecode(jdbc_password);
        }
        return null;
    }
}