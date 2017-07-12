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
    <title>持仓</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">
    <div class="control-group form-inline mt10 mb10">
        <div class="controls">
            <label for="positionDate">查询日期：</label>
            <input class="form-control" type="text" id="positionDate" name="positionDate"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  readonly="readonly" style="background-color: #fff;cursor:pointer">
            <input type="button" value="查询" class="btn" id="searchBtnIdata" style="margin-left: 20px;">
            <input type="button" value="上一日" class="btn" id="prev_day" style="margin-left: 10px;">
            <input type="button" value="下一日" class="btn" id="next_day" style="margin-left: 10px;">
            <div class="btn-panel-right" style="float:right;">
                <button type="button" data-toggle="modal" class="btn" data-target="#exportModal" id="export_data">导出数据</button>
                <button type="button" data-toggle="modal" class="btn" data-target="#importModal" id="import_data" style="margin-left: 10px;">估值修正成本</button>
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
        {field: 'stock_holding_id', title: '证券持仓ID'},
        {field: 'company_id', title: '公司ID'},
        {field: 'broker_id', title: '证券公司ID'},
        {field: 'stock_account_id', title: '证券账号ID'},
        {field: 'market_id', title: '市场ID'},
        {field: 'position', title: '当前拥股'},
        {field: 'position_date', title: '持仓日期'},
        {field: 'positionCost', title: '持仓成本'},
        {field: 'avgPrice', title: '成本价'},
        {field: 'positionProfit', title: '盈亏'},
        {field: 'instrumentValue', title: '市值'},
        {field: 'frozenVolume', title: '冻结数量'},
        {field: 'canUseVolume', title: '可用余额'},
        {field: 'onRoadVolume', title: '在途股份'},
        {field: 'yesterDayVolume', title: '股份余额'},
        {field: 'settlementPrice', title: '最新价'},
        {field: 'profitRate', title: '盈亏比例'},
        {field: 'totalCost', title: '累计总成本'},
        {field: 'singleCost', title: '单股成本价'},
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
    var url_json = "/account/position";
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
            '<a class="update" href="javascript:;" onclick="updateAction("url","编辑","row.accountId")" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
</script>
</body>
</html>