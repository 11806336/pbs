package com.pbs.ams.common.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pbs.ams.common.util.PropertiesFileUtil;
import com.pbs.ams.web.model.UpmsUser;
import org.apache.commons.beanutils.BeanMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 控制器基类
 * Created by ams on 2017/2/4.
 */
public abstract class BaseController {

	protected Logger _log = LoggerFactory.getLogger(this.getClass());

	protected static String prefix = "/manage";

	/**
	 * 统一异常处理
	 * @param request
	 * @param response
	 * @param exception
	 */
	@ExceptionHandler
	public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		_log.error("统一异常处理：", exception);
		request.setAttribute("ex", exception);
		if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
			request.setAttribute("requestHeader", "ajax");
		}
		// shiro没有权限异常
		if (exception instanceof UnauthorizedException) {
			return "/403.jsp";
		}
		// shiro会话已过期异常
		if (exception instanceof InvalidSessionException) {
			return "/error.jsp";
		}
		return "/error.jsp";
	}

	/**
	 * 返回jsp视图
	 * @param path
	 * @return
	 */
	public static String jsp(String path) {
		return prefix+path.concat(".jsp");
	}

	/**
	 * 返回thymeleaf视图
	 * @param path
	 * @return
	 */
	public static String thymeleaf(String path) {
		String folder = PropertiesFileUtil.getInstance().get("app.name");
		return "/".concat(folder).concat(path).concat(".html");
	}


	public static Map<?, ?> objectToMap(Object obj) {
		if(obj == null){
			return null;
		}
		return new BeanMap(obj);
	}

	protected List<Map> convertMap(List lst,String child) {
		List<Map> lstMap = Lists.newArrayList();
		for (Object parent : lst) {
			Map map1 = objectToMap(parent);
			try {
				Method method = parent.getClass().getDeclaredMethod("get"+child);
				Object obj = method.invoke(parent);
				Map map2 = objectToMap(obj);
				map1.putAll(map2);
				lstMap.add(map1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lstMap;
	}

	/**
	 * this method is used to getCurrentUser By Session(Shiro).
	 * @return
	 */
	public UpmsUser getCurrentUser(){
		//获取session,取当前用户
		Session session = SecurityUtils.getSubject().getSession();
		UpmsUser upmsUser = (UpmsUser) session.getAttribute("user");
		return upmsUser;
	}
}
