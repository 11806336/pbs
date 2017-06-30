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
	<title>角色管理</title>
	<jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<shiro:hasPermission name="upms:role:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction('url:${basePath}/manage/role/create','新增角色')"><i class="zmdi zmdi-plus"></i> 新增角色</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:role:update"><a class="waves-effect waves-button" href="javascript:;" data-update="表格外" onclick="updateAction(this,'url:${basePath}/manage/role/update/','roleId')"><i class="zmdi zmdi-edit"></i> 编辑角色</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:role:delete"><a class="waves-effect waves-button" href="javascript:;" data-deleteTpye="批量删除" onclick="deleteAction(this,'${basePath}/manage/role/delete/','roleId')"><i class="zmdi zmdi-close"></i> 删除角色</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:role:permission"><a class="waves-effect waves-button" href="javascript:;" onclick="permissionAction()"><i class="zmdi zmdi-key"></i> 角色权限</a></shiro:hasPermission>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
var $table = $('#table');
//列配置项
var dataColumns =  [
    {field: 'ck', checkbox: true},
    {field: 'roleId', title: '编号', sortable: true, align: 'center'},
    {field: 'name', title: '角色名称'},
    {field: 'title', title: '角色标题'},
    {field: 'description', title: '角色描述'},
    {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
];

//数据url
var url_json = '${basePath}/manage/role/list';
//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
var sidePagination = 'server';
//指定主键列
var idField = 'roleId';
//右上角刷新搜索
var search = true;
var showRefresh = true;
var showColumns = true;

// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a class="update" href="javascript:;"  data-update="表格内"  onclick="updateAction(this,'+"'url:${basePath}/manage/role/update/'"+')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a class="delete" href="javascript:;" onclick="deleteAction(this,'+"'${basePath}/manage/role/delete/'"+",'roleId'"+')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}
// 角色权限
var permissionDialog;
var roleId;
function permissionAction() {
	var rows = $table.bootstrapTable('getSelections');
	if (rows.length != 1) {
		$.confirm({
			title: false,
			content: '请选择一条记录！',
			autoClose: 'cancel|3000',
			backgroundDismiss: true,
			buttons: {
				cancel: {
					text: '取消',
					btnClass: 'waves-effect waves-button'
				}
			}
		});
	} else {
		roleId = rows[0].roleId;
		permissionDialog = $.dialog({
			animationSpeed: 300,
			title: '角色权限',
			content: 'url:${basePath}/manage/role/permission/' + roleId,
			onContentReady: function () {
				initMaterialInput();
				initTree();
			}
		});
	}
}
</script>
</body>
</html>