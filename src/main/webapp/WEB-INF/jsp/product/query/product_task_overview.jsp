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
    <title>任务</title>

    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div class="control-group">
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

    <table id="taskTable"></table>
</div>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#taskTable');
    var url_json = "../../../resources/data/product_task.json";
    var dataColumns =  [
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'directiveId', title: '指令ID'},
        {field: 'account', title: '账号'},
        {field: 'code', title: '代码'},
        {field: 'tradeType', title: '交易类型'},
        {field: 'progress', title: '进度'},
        {field: 'commissionTimes', title: '委托次数'},
        {field: 'startTime', title: '开始时间'},
        {field: 'endTime', title: '结束时间'},
        {field: 'status', title: '状态'}
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