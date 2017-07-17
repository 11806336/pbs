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
    <title>总览</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <table id="accountOverviewTable"></table>
</div>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    //下拉框选择
    $("#platform_add").select2({
        minimumResultsForSearch: -1
    });

    var $table = $('#accountOverviewTable');
    var url_json = "/product/overview";

    var dataColumns =  [
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'trade_account_id', title: '账号ID', visible: false},
        {field: 'accountCode', title: '账号名'},
        {field: 'trade_account_name', title: '账号名称'},
        {field: 'accountCategory', title: '账号类别'},
        {field: 'accountType', title: '类型'},
        {field: 'accountStatus', title: '状态'},
        {field: 'broker', title: '经济公司'},
        {field: 'breakEven', title: '持仓盈亏'},
        {field: 'available_fund', title: '可用资金'},
        {field: 'totalAssets', title: '总资产'}
    ];

    // 设置分页
    var sidePagination = 'server';

    // 指定主键列
    var idField = 'accountId';
    //右上角刷新搜索
    var search = false;
    var showRefresh = false;
    var showColumns = false;

</script>
</body>
</html>