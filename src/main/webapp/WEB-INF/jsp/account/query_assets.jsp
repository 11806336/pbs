<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资产</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">
    <div>
        <table id="table"></table>
    </div>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns=[
        {field: 'ck', checkbox: true},
        {field: 'trade_account_id', title: '资金账号'},
        {field: 'trade_account_type', title: '类别'},
        {field: 'trade_account_name', title: '账号名称'},
        {field: 'broker', title: '证券公司'},
        {field: 'profit_loss', title: '盈亏'},
        {field: 'available_fund', title: '可用资金'},
        {field: 'frozen_fund', title: '冻结资金'},
        {field: 'fee', title: '手续费'},
        {field: 'total_fund', title: '总资产'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];
    //数据url
    var url_json="/account/amsTradeAccountExt";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination='server';
    //指定主键列
    var idField='accountId';
    //右上角刷新搜索
    var search=false;
    var showRefresh=false;
    var showColumns= false;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick=updateAction("url","编辑","+row.accountId+") data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick=deleteAction() data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
</script>
</body>
</html>