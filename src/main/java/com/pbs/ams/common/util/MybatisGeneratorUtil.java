package com.pbs.ams.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pbs.ams.common.constant.GeneratorEnum;
import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Mybatis代码生成类
 * Created by ams on 2017/6/10.
 * @author TiAmo
 * 如果要生成的mapper.xml存在 内容会被新增,如果需要重写切记备份后手动删除原文件.
 * 如果要生成的service/serviceImpl存在,不会被覆盖.
 * 如果要生成的model存在,会被重写.如需原文件请注意备份.
 */
public class MybatisGeneratorUtil {

	/**
	 * 根据模板生成generatorConfig.xml文件
	 */
	private static void generator(List<Map<String, String>> lstTables) throws Exception {

		File xmlFile = new File(GeneratorEnum.XML_PATH.getValue());
		if (xmlFile.exists()){
			FileUtil.deleteDir(xmlFile);
			System.out.println("========== 删除原有generatorConfig.xml文件 ==========");
		}
		System.out.println("========== 开始生成generatorConfig.xml文件 ==========");
		try {
			VelocityContext context = new VelocityContext();
			context.put("listTables", lstTables);
			context.put("model_target_package", GeneratorEnum.PACKAGE_NAME.getValue()+".model");
			context.put("xml_target_package","mappers");
			context.put("mapper_target_package",GeneratorEnum.PACKAGE_NAME.getValue()+".mappers");
			context.put("targetProject_java", GeneratorEnum.TARGET_PROJECT_JAVA.getValue());
			context.put("targetProject_resource", GeneratorEnum.TARGET_PROJECT_RESOUCE.getValue());
			context.put("jdbc_password", GeneratorEnum.JDBC_PASSWORD.getByAESDecode());
			VelocityUtil.generate(GeneratorEnum.GENERATORCONFIG_VM.getValue(), GeneratorEnum.XML_PATH.getValue(), context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

		System.out.println("========== 开始运行MybatisGenerator ==========");
		List<String> warnings = new ArrayList<>();
		File configFile = new File(GeneratorEnum.XML_PATH.getValue());
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.println("========== 结束运行MybatisGenerator ==========");

		/*System.out.println("========== 开始生成Service ==========");
		String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = GeneratorEnum.CREATE_SERVICE_PATH.getValue();
		String serviceImplPath = GeneratorEnum.CREATE_SERVICEIMPL_PATH.getValue();
		File servicePathFile = new File(servicePath);
		File serviceImplPathFile = new File(serviceImplPath);

		if (servicePathFile.exists()) {
			servicePathFile.mkdirs();
		}
		if (!serviceImplPathFile.exists()) {
			serviceImplPathFile.mkdirs();
		}

		for (Map<String, String> lstTable : lstTables) {
			String model = StringUtil.lineToHump(ObjectUtils.toString(lstTable.get("table_name")));
			String service = servicePath + "/" + model + "Service.java";
			String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
			// 生成service
			File serviceFile = new File(service);
			if (!serviceFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", GeneratorEnum.PACKAGE_NAME.getValue());
				context.put("model", model);
				context.put("ctime", ctime);
				VelocityUtil.generate(GeneratorEnum.SERVICE_VM.getValue(), service, context);
				System.out.println(service);
			}
			// 生成serviceImpl
			File serviceImplFile = new File(serviceImpl);
			if (!serviceImplFile.exists()) {
				VelocityContext context = new VelocityContext();
				context.put("package_name", GeneratorEnum.PACKAGE_NAME.getValue());
				context.put("model", model);
				context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
				context.put("ctime", ctime);
				VelocityUtil.generate(GeneratorEnum.SERVICEIMPL_VM.getValue(), serviceImpl, context);
				System.out.println(serviceImpl);
			}
		}
		System.out.println("========== 结束生成Service ==========");*/
	}

	/**
	 * 走你
	 */
	public static void main(String[] args) throws Exception {
		List<Map<String, String>> lstTables = Lists.newArrayList();
		Map<String, String> map1 = Maps.newHashMap();
		map1.put("table_name","upms_role");
		lstTables.add(map1);
		Map<String, String> map2 = Maps.newHashMap();
		map2.put("table_name","upms_role_permission");
		lstTables.add(map2);
		MybatisGeneratorUtil.generator(lstTables);
	}

}
