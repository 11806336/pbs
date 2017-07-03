<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>日志管理</title>
	<jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<shiro:hasPermission name="upms:log:delete"><a class="waves-effect waves-button" href="javascript:;" data-deleteTpye="批量删除" onclick="deleteAction(this,'/manage/log/delete','logId')"><i class="zmdi zmdi-close"></i> 删除日志</a></shiro:hasPermission>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'logId', title: '编号', sortable: true, align: 'center'},
        {field: 'description', title: '操作'},
        {field: 'username', title: '操作用户'},
        {field: 'startTime', title: '操作时间'},
        {field: 'spendTime', title: '耗时'},
        {field: 'url', title: '请求路径'},
        {field: 'method', title: '请求类型'},
        {field: 'parameter', title: '请求参数'},
        {field: 'userAgent', title: '用户标识'},
        {field: 'ip', title: 'IP地址'},
        {field: 'permissions', title: '权限值'}
    ];

    //数据url
    var url_json = '${basePath}/manage/log/list';
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'logId';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;
</script>
</body>
</html>