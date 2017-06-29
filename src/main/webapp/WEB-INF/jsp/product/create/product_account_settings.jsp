<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账号设置</title>
    <jsp:include page="${basePath}/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div id="searchDiv">
        <div class="form-group">
            <label for="tradePlatformSearch" style="">账号类别：</label>
            <select id="tradePlatformSearch" style="width:160px;" name="tradePlatformSearch">
                <option value=""> -- 全部账号 -- </option>
                <option value="1">期货账号</option>
                <option value="2">证券账号</option>
                <option value="3">信用账号</option>
                <option value="4">股票期权账号</option>
                <option value="5">期货期权账号</option>
            </select>
            <div class="btn-panel" style="display: inline-block;margin-left:20px;">
                <a class="btn icon-plus addstockcom btn-primary" href="#" style="margin-bottom: 0;">添加账号</a>
            </div>
        </div>

    </div>
    <table id="accountTable"></table>
</div>

<jsp:include page="${basePath}/resources/inc/tabJS.jsp" flush="true"/>
<script>
    //下拉框选择
    $("#tradePlatformSearch").select2({
        minimumResultsForSearch: -1
    });

    var $table = $('#accountTable');
    var url_json = "${basePath}/resources/data/product_account.json";

    var dataColumns =  [
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'ck', checkbox: true},
        {field: 'accountId', title: '账号ID', visible: false},
        {field: 'accountCode', title: '账号名'},
        {field: 'accountName', title: '账号名称'},
        {field: 'accountType', title: '类型'},
        {field: 'accountStatus', title: '状态'},
        {field: 'broker', title: '经济公司'},
        {field: 'breakEven', title: '持仓盈亏'},
        {field: 'availableFunds', title: '可用资金'},
        {field: 'totalAssets', title: '总资产'}
    ];

    // 设置分页
    var sidePagination = 'client';

    // 指定主键列
    var idField = 'accountId';
    //右上角刷新搜索
    var search = false;
    var showRefresh = false;
    var showColumns = false;
</script>
</body>
</html>