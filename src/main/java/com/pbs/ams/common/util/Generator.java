package com.pbs.ams.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


import java.util.List;
import java.util.Map;

/**
 * 代码生成类
 * Created by ipb on 2017/1/10.
 */
public class Generator {

	private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("dev").get("jdbc.password");
	//包前缀
	private static String PACKAGE_NAME = "com.pbs.ams";
	//包后缀
	private static String BUSINESS = "broker";
	//表
	private static List<Map<String, String>> LIST_TABLES = Lists.newArrayList();

	static {
		Map<String, String> map1 = Maps.newHashMap();
		map1.put("table_name","ams_broker");
		map1.put("model_name","AmsBroker");
		LIST_TABLES.add(map1);
		Map<String, String> map3 = Maps.newHashMap();
		map3.put("table_name","ams_platform");
		map3.put("model_name","AmsPlatform");
		LIST_TABLES.add(map3);
	}

	/**
	 * 走你
	 */
	public static void main(String[] args) throws Exception {
		MybatisGeneratorUtil.generator(JDBC_PASSWORD, PACKAGE_NAME,LIST_TABLES,BUSINESS);
	}

}
