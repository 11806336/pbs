<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>产品管理</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div id="toolbar">
        <div id="searchDiv">
            <div class="form-group">
                <div class="countdown" style="float:left;">
                    <span class="countText">距离前次更新</span>
                    <em></em>
                    <span class="load"></span>
                </div>
                <div class="btn-panel" style="float:left;">
                    <shiro:hasPermission name="upms:company:refresh">
                        <a class="aves-effect waves-button btnRefresh" href="#"><i class="zmdi zmdi-refresh"></i>&nbsp;立即更新</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:create">
                        <a class="aves-effect waves-button btnCreate" href="#" onclick="dialog('${basePath}/product/createProduct','新建产品','')"><i class="zmdi zmdi-plus"></i>&nbsp;新建产品</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:close">
                        <a class="aves-effect waves-button btnCreate" href="#" data-deleteTpye = "批量删除" onclick="deleteAction(this,'${basePath}/product/delete','product_id')"><i class="zmdi zmdi-close"></i>&nbsp;删除产品</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:returned">
                        <a class="aves-effect waves-button btnExport" href="#"><i class="zmdi zmdi-assignment-returned"></i>&nbsp;导出数据</a>
                    </shiro:hasPermission>
                </div>
            </div>
        </div>
    </div>

    <table id="table"></table>
</div>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>

<script src="${basePath}/resources/js/public.js"></script>
<script src="${basePath}/resources/js/Timer.js"></script>
<script src="${basePath}/resources/js/Loader.js"></script>
<script src="${basePath}/resources/js/timer2.js"></script>
<script>
    <%--删除--%>
    //deleteAction(obj,url,idField)
    <%--编辑--%>
    //updateAction(obj,url,idField)
    <%--新增--%>
    //createAction(url,title)
    <%--调用弹出--%>
    //dialog(url,title,id)
    var $table = $('#table');
    //json数据
    var url_json = "${basePath}/product/list";
    var dataColumns =  [
        {field: 'ck', checkbox: true},
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'product_id', title: '产品ID', visible: false},
        {field: 'product_name', title: '产品名称'},
        {field: 'product_type', title: '产品类型'},
        {field: 'product_code', title: '产品代码'},
        {field: 'product_manager', title: '产品经理'},
        {field: 'product_status', title: '产品状态'},
        {field: 'product_net_value', title: '产品净值'},
        {field: 'net_asset_value', title: '单位净值'},
        {field: 'product_shares', title: '产品份额'},
        {field: 'stock_total_assets', title: '证券总资产'},
        {field: 'security_total_value', title: '证券总市值'},
        {field: 'stock_total_value', title: '股票总市值'},
        {field: 'short_total_value', title: '空单总市值'},
        {field: 'realname', title: '创建人'},
        {field: 'create_time', title: '创建时间'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];
    // 设置分页
    var sidePagination = 'server';

    // 指定主键列
    var idField = 'product_id';
    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
        var ids = [];
        for (var i in rows) {
            ids.push(rows[i].productId);
        }
        return [
            "<a class='selected' href='javascript:;' onclick=dialog('/product/edit/','编辑',"+row.product_id+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>　",
            "<a class='search' href='javascript:;' onclick=dialog('/product/query/','详情',"+row.productId+") data-toggle='tooltip' title='详情'><i class='glyphicon glyphicon-eye-open'></i></a>"
           ].join('');
    }
</script>
</body>
</html>