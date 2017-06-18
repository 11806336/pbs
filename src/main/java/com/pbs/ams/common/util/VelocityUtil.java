package com.pbs.ams.common.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;

/**
 * Velocity工具类
 * Created by ams on 2017/1/10.
 */
public class VelocityUtil {

	/**
	 * 根据模板生成文件
	 * @param inputVmFilePath 模板路径
	 * @param outputFilePath 输出文件路径
	 * @param context
	 * @throws Exception
	 */
	public static void generate(String inputVmFilePath, String outputFilePath, VelocityContext context) throws Exception {
		try {
			//初始化引擎
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			velocityEngine.init();
			//获取模版
			Template template = velocityEngine.getTemplate(inputVmFilePath,"UTF-8");
			//生成file
			File outputFile = new File(outputFilePath);
			FileWriter writer = new FileWriter(outputFile);
			template.merge(context, writer);
			writer.close();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
