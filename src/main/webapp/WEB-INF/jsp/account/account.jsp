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
    <title>证券账号管理页</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div id="searchDiv">
        <div class="btn-panel">
            <a class="btn icon-plus addstockcom btn-primary" href="#" onclick="dialog('/account/create','添加证券账号','')">添加证券账号</a>
            <a class="btn icon-plus addstockcom btn-primary" href="#" onclick="expot();">导出全部持仓</a>
        </div>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'trade_account_id', title: '证券ID'},
        {field: 'company_id', title: '公司ID'},
        {field: 'trade_account_type', title: '账号类型'},
        {field: 'trade_account', title: '证券资金账号'},
        {field: 'trade_account_name', title: '账号名称'},
        {field: 'broker_id', title: '证券公司ID'},
        {field: 'trade_account_status', title: '状态'},
        {field: 'create_time', title: '创建时间'},
        {field: 'update_time', title: '修改时间'},
        {field: 'operator_id', title: '创建人'},
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
    var url_json = "${basePath}/account/list";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'trade_account_id';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
        console.log( row.trade_account_id);
        ids = new Array();
        for (var i in rows) {
            ids.push(rows[i].trade_account_id);
        }
        return [
            "<a class='selected' href='javascript:;' onclick=dialog('/account/update','编辑'," + row.trade_account_id + ") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>",
            "<a class='update' style='padding:0 6px;' href='javascript:;' onclick=dialog('/account/details','详情'," + row.trade_account_id + ") data-toggle='tooltip' title='查看账号详情'><i class='glyphicon glyphicon-eye-open'></i></a>",
            "<a class='delete' href='javascript:;' onclick=deleteAction(this,'/account/delete','tradeAccountId') data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>",
        ].join('');
    }
    function expot() {
        $.ajax({
           url:"/account/export",
            type:'post',
            success : function(){
alert(1)
            }
        });
    }
</script>
</body>
</html>