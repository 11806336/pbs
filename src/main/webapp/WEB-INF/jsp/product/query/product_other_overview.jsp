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
    <title>其他权益</title>

    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div class="control-group">
        <label for="build_date_bgn_start">起始日期：</label>
        <input class="form-control" type="text" id="build_date_bgn_start" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="build_date_bgn_start" readonly="readonly" style="background-color: #fff;cursor:pointer">
        <label for="build_date_bgn_end" style="margin-left: 10px;">结束日期:</label>
        <input class="form-control" type="text" id="build_date_bgn_end" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="build_date_bgn_end" readonly="readonly" style="background-color: #fff;cursor:pointer">
        <input type="button" value="查询" class="btn" id="searchBtnIdata" style="margin-left: 20px;">
    </div>

    <table id="otherRightTable"></table>
</div>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#otherRightTable');
    var url_json = "${basePath}/resources/data/product_other.json";
    var dataColumns =  [
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'otherId', title: '其他权益ID', visible: false},
        {field: 'rightsName', title: '权益名称'},
        {field: 'rightsValue', title: '权益值'},
        {field: 'operation', title: '操作'},
        {field: 'operator', title: '操作人'},
        {field: 'updateTime', title: '操作时间'}
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