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
    <title>委托</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">
    <div class="control-group form-inline">
        <div class="controls sel_time">
            <label for="build_date_bgn_start">起始日期：</label>
            <input class="form-control" type="text" id="build_date_bgn_start" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="build_date_bgn_start" readonly="readonly" style="background-color: #fff;cursor:pointer">
            <label for="build_date_bgn_end" style="margin-left: 10px;">结束日期:</label>
            <input class="form-control" type="text" id="build_date_bgn_end" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="build_date_bgn_end" readonly="readonly" style="background-color: #fff;cursor:pointer">
            <input type="button" value="查询" class="btn" id="searchBtnIdata" style="margin-left: 20px;">
            <div class="btn-panel-right" style="float:right;">
                <button type="button" data-toggle="modal" class="btn" data-target="#exportModal" id="export_data">导出数据</button>
            </div>
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
        {field: 'entrust_id', title: '证券公司'},
        {field: 'stock_id', title: '资金账号'},
        {field: 'trade_account_name', title: '账号名称'},
        {field: 'trade_account_type', title: '账号类型'},
        {field: 'exchange_name', title: '交易市场'},
//        {field: 'instrument_id', title: '证券代码'},
//        {field: 'instrument_name', title: '证券名称'},
        {field: 'entrust_price', title: '委托价格'},
        {field: 'cancel_amount', title: '委托量'},
        {field: 'contract_id', title: '合同编号'},
        {field: 'entrust_status', title: '委托状态'},
        {field: 'entrust_date', title: '委托日期'},
        {field: 'traded_price', title: '成交均价'},
        {field: 'cancel_amount', title: '已撤数量'},
        {field: 'buy_sell', title: '买卖标记'},
        {field: 'entrust_type', title: '委托类别'},
        {field: 'ip_source', title: 'ip来源'},
        {field: 'mac_address', title: 'MAC地址'},
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
    var url_json = "/account/entrust";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'accountId';
    //右上角刷新搜索
    var search = false;
    var showRefresh = false;
    var showColumns = false;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="panel(' + "''" + "," + "' '" + ')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
</script>
</body>
</html>