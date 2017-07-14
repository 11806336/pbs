<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>股票持仓</title>

    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div class="control-group form-inline mt10 mb10">
        <div class="controls">
            <label for="build_date_bgn_start">查询日期：</label>
            <input class="form-control" type="text" id="build_date_bgn_start" name="build_date_bgn_start"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  readonly="readonly" style="background-color: #fff;cursor:pointer">
            <input type="button" value="查询" class="btn" id="searchBtnIdata" style="margin-left: 20px;">
            <input type="button" value="上一日" class="btn" id="prev_day" style="margin-left: 10px;">
            <input type="button" value="下一日" class="btn" id="next_day" style="margin-left: 10px;">
            <div class="btn-panel-right" style="float:right;">
                <button type="button" data-toggle="modal" class="btn" data-target="#exportModal" id="export_data">导出数据</button>
            </div>
        </div>
    </div>
    <table id="stockHoldingTable"></table>
</div>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#stockHoldingTable');
    var url_json = "../../../resources/data/product_stock_holding.json";
    var dataColumns =  [
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'broker', title: '证券公司'},
        {field: 'account', title: '资金账号'},
        {field: 'accountName', title: '账号名称'},
        {field: 'accountType', title: '账号类型'},
        {field: 'marketCode', title: '市场代码'},
        {field: 'marketName', title: '市场名称'},
        {field: 'stockCode', title: '证券代码'},
        {field: 'stockName', title: '证券名称'},
        {field: 'currentStockHolding', title: '当前拥股'},
        {field: 'positionDate', title: '持仓日期'},
        {field: 'positionCost', title: '持仓成本'},
        {field: 'costValue', title: '成本价'},
        {field: 'breakEven', title: '盈亏'},
        {field: 'marketValue', title: '市值'},
        {field: 'stockholderAccount', title: '股东账号'},
        {field: 'frozenAmount', title: '冻结数量'},
        {field: 'remaining', title: '可用余额'},
        {field: 'transitShares', title: '在途股份'},
        {field: 'shareRemaining', title: '股份余额'},
        {field: 'latestPrice', title: '最新价'},
        {field: 'profitRate', title: '盈亏比例'},
        {field: 'operator', title: '操作'}
    ];

    // 设置分页
    var sidePagination = 'client';

    // 指定主键列
    var idField = 'otherId';
    //右上角刷新搜索
    var search = false;
    var showRefresh = false;
    var showColumns = false;
</script>
</body>
</html>