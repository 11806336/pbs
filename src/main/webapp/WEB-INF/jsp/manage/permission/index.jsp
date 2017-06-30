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
	<title>权限管理</title>
	<jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
	<div id="toolbar">
		<shiro:hasPermission name="upms:permission:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction('url:${basePath}/manage/permission/create','新增权限')"><i class="zmdi zmdi-plus"></i> 新增权限</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:permission:update"><a class="waves-effect waves-button" href="javascript:;" data-update="表格外" onclick="updateAction(this)"><i class="zmdi zmdi-edit"></i> 编辑权限</a></shiro:hasPermission>
		<shiro:hasPermission name="upms:permission:delete"><a class="waves-effect waves-button" href="javascript:;" data-deleteTpye="批量删除" onclick="deleteAction(this,'/manage/permission/delete','permissionId')"><i class="zmdi zmdi-close"></i> 删除权限</a></shiro:hasPermission>
	</div>
	<table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
var $table = $('#table');
//列配置项
var dataColumns = [
    {field: 'ck', checkbox: true},
    {field: 'permissionId', title: '编号', sortable: true, align: 'center'},
    {field: 'systemId', title: '所属系统'},
    {field: 'pid', title: '所属上级'},
    {field: 'name', title: '权限名称'},
    {field: 'type', title: '类型', formatter: 'typeFormatter'},
    {field: 'permissionValue', title: '权限值'},
    {field: 'uri', title: '路径'},
    {field: 'icon', title: '图标', align: 'center', formatter: 'iconFormatter'},
    {field: 'status', title: '状态', sortable: true, align: 'center', formatter: 'statusFormatter'},
    {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
];

//数据url
var url_json = '${basePath}/manage/permission/list';
//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
var sidePagination = 'server';
//指定主键列
var idField = 'permissionId';
//右上角刷新搜索
var search = true;
var showRefresh = true;
var showColumns = true;
// 格式化操作按钮
function actionFormatter(value, row, index) {
    return [
		'<a class="update" href="javascript:;" data-update="表格内" onclick="updateAction(this)" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
		'<a class="delete" href="javascript:;" onclick="deleteAction(this,'+"'/manage/permission/delete'"+')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
    ].join('');
}

// 编辑
var updateDialog;
function updateAction(obj) {
	var rows = $table.bootstrapTable('getSelections');
    //找到主键Id
    var Id=$(obj).parent().parent().find(".bs-checkbox ").find("input").val();
    var dataUpdate=$(obj).attr("data-update");
    //判断是表格内行后面的按钮还是右上角的编辑文字
    if(dataUpdate === "表格外"){
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
            updateDialog = $.dialog({
                animationSpeed: 300,
                title: '编辑权限',
                content: 'url:${basePath}/manage/permission/update/' + rows[0].permissionId,
                onContentReady: function () {
                    initMaterialInput();
                    $('select').select2();
                    initType();
                    initSelect2();
                }
            });
        }
	}else {
        updateDialog = $.dialog({
            animationSpeed: 300,
            title: '编辑权限',
            content: 'url:${basePath}/manage/permission/update/' + Id,
            onContentReady: function () {
                initMaterialInput();
                $('select').select2();
                initType();
                initSelect2();
            }
        });
	}

}
</script>
</body>
</html>