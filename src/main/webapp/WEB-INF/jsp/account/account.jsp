<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>证券账号管理页</title>
    <link rel="import" href="../../../resources/inc/css_list.jsp">
</head>
<body>
<div id="main">
    <div id="searchDiv">
        <input type="text" id="query" class="form-control" style="width:220px;font-size: 12px;" placeholder="请输入主账号,按Enter查询">
        <div class="btn-panel">
            <a class="btn icon-plus addstockcom btn-primary" href="#" onclick="dialog('tab.html','添加证券账号')">添加证券账号</a>
            <a class="btn icon-plus addstockcom btn-primary" href="#" onclick="">导出全部持仓</a>
        </div>
    </div>
    <table id="table"></table>
</div>
<link rel="import" href="../../../resources/inc/js_list.jsp">
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'stockAccountId', title: '证券ID'},
        {field: 'stockAccountType', title: '账号类型'},
        {field: 'stockAccount', title: '资金账号'},
        {field: 'stockAccountName', title: '账号名称'},
        {field: 'brokerId', title: '证券公司'},
        {field: 'productId', title: '所属产品'},
        {field: 'stockAccountStatus', title: '状态'},
        {field: 'breakEven', title: '盈亏'},
        {field: 'expendableund', title: '可用资金'},
        {field: 'fee', title: '手续费'},
        {field: 'totalAssets', title: '总资产'},
        {field: 'totalMarketCapitalization', title: '总市值'},
        {field: 'operatorId', title: '创建人'},
        {field: 'createTime', title: '创建时间'},
        {
            field: 'action',
            title: '操作',
            align: 'center',
            formatter: 'actionFormatter',
            events: 'actionEvents',
            clickToSelect: true
        }
    ];

    //数据url
    var url_json = "../../../resources/data/account.json";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'client';
    //指定主键列
    var idField = 'stockId';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
        console.log( row.stockId);
        ids = new Array();
        for (var i in rows) {
            ids.push(rows[i].stockId);
        }
        return [
            "<a class='selected' href='javascript:;' onclick=updateAction('/manage/permission/update','编辑'," + row.stockId + ") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>",
            "<a class='update' style='padding:0 6px;' href='javascript:;' onclick=dialog('inquire/tab.html','账号详情') data-toggle='tooltip' title='查看账号详情'><i class='glyphicon glyphicon-eye-open'></i></a>",
            "<a class='delete' href='javascript:;' onclick=deleteAction('/manage/permission/update'," + ids + ") data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>",
        ].join('');
    }
</script>
</body>
</html>