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
    <title>手续费</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<div id="toolbar">
    <div id="searchDiv">
        <div class="btn-panel">
            <shiro:hasPermission name="upms:company:create">
                <a class="waves-effect waves-button" href="javascript:;" onclick="dialog('/feeTemplate/create','添加手续费模板','')"><i class="zmdi zmdi-plus"></i>&nbsp;添加手续费模板</a>
            </shiro:hasPermission>
        </div>
    </div>
</div>
<div id="main">
    <table id="table"></table>
</div>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns=[
        {field: 'ck', checkbox: true},
        {field: 'fee_templatete_id', title: 'ID'},
        {field: 'stock_category_name', title: '分类名称'},
        {field: 'commission_rate', title: '佣金率(%)'},
        {field: 'minimum_commission', title: '最小佣金额'},
        {field: 'transfer_fee_rate', title: '过户费率(%)'},
        {field: 'minimum_charge_count', title: '计算过户费用最小量'},
        {field: 'buy_stamp_duty_rate', title: '买入印花税率(%)'},
        {field: 'sell_stamp_duty_rate', title: '卖出印花税率(%)'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];

    //数据url
    var url_json="${basePath}/feeTemplate/list";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination='server';
    //指定主键列
    var idField='chargeId';
    //右上角刷新搜索
    var search=false;
    var showRefresh=false;
    var showColumns= false;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
        ids = new Array();
        for (var i in rows) {
            ids.push(rows[i].chargeId);
        }
        return [
            "<a class='selected' href='javascript:;' onclick=dialog('/feeTemplate/edit','编辑',"+row.fee_templatete_id+") data-toggle='tooltip' title='编辑' style='margin-right: 8px;'><i class='glyphicon glyphicon-edit'></i></a>",
            "<a class='delete' href='javascript:;' onclick=deleteAction('/manage/permission/update',"+ids+") data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>",
        ].join('');
    }
</script>
</body>
</html>