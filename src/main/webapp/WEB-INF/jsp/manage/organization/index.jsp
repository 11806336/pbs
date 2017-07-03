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
	<title>组织管理</title>
	<jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<shiro:hasPermission name="upms:organization:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction('url:${basePath}/manage/organization/create','新增组织')"><i class="zmdi zmdi-plus"></i> 新增组织</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:organization:update"><a class="waves-effect waves-button" href="javascript:;" data-update="表格外" onclick="updateAction(this,'url:${basePath}/manage/organization/update/','organizationId')"><i class="zmdi zmdi-edit"></i> 编辑组织</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:organization:delete"><a class="waves-effect waves-button" data-deleteTpye="批量删除" href="javascript:;" onclick="deleteAction(this,'${basePath}/manage/organization/delete/','organizationId')"><i class="zmdi zmdi-close"></i> 删除组织</a></shiro:hasPermission>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'organizationId', title: '编号', sortable: true, align: 'center'},
        {field: 'name', title: '组织名称'},
        {field: 'description', title: '组织描述'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
    ];
    //数据url
    var url_json = '${basePath}/manage/organization/list';
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'organizationId';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" data-update="表格内" onclick="updateAction(this,'+"'url:${basePath}/manage/organization/update/',"+"''"+')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction(this,'+"'${basePath}/manage/organization/delete/',"+"'organizationId'"+')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
</script>
</body>
</html>