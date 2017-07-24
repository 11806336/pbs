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
                <div class="countdown">
                    <span class="countText">距离前次更新</span>
                    <em></em>
                    <span class="load"></span>
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
    var $table = $('#table');
    //json数据
    var url_json = "${basePath}/net/list";
    var dataColumns =  [
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'product_id', title: '产品ID', visible: false},
        {field: 'company_id', title: '公司ID', visible: false},
        {field: 'product_name', title: '产品名称'},
//        {field: 'product_type', title: '产品类型'},
//        {field: 'product_code', title: '产品代码'},
//        {field: 'product_manager', title: '产品经理'},
//        {field: 'product_status', title: '产品状态'},
//        {field: 'product_share_source', title: '产品份额来源'},
//        {field: 'start_date', title: '产品开始时间'},
//        {field: 'end_date', title: '产品结束时间'},
//        {field: 'product_shares', title: '产品份额'},
        {field: 'product_supervisor', title: '产品管理人'},
        {field: 'o32_id', title: 'o32来源ID'},
        {field: 'stock_total_assets', title: '证券总资产'},
        {field: 'security_total_value', title: '证券总市值'},
        {field: 'stock_total_value', title: '股票总市值'},
        {field: 'short_total_value', title: '空单总市值'},
        {field: 'realname', title: '创建人'},
        {
            field: 'create_time',
            title: '创建时间',
            align: 'center',
            formatter: 'createTime',
            events: 'Events',
            clickToSelect: false
        },
        {
            field: 'update_time',
            title: '修改时间',
            align: 'center',
            formatter: 'updateTime',
            events: 'actionEvents',
            clickToSelect: false
        },
        {field: 'operator_id', title: '操作人ID'},
        {field: 'product_desc', title: '备注'}
    ];
    // 设置分页
    var sidePagination = 'server';

    // 指定主键列
    var idField = 'product_id';
    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    //格式化修改时间
    function createTime(value, row, index) {
        var ctime=row.create_time+"";
        var create_time=ctime.substr(0,4)+"-"+ctime.substr(4,2)+"-"+ctime.substr(6,2)+" "+ctime.substr(8,2)+":"+ctime.substr(10,2)+":"+ctime.substr(12,2);
        return create_time;
    }

    //格式化更新时间
    function updateTime(value, row, index) {
        var utime=row.update_time+"";
        var update_time=utime.substr(0,4)+"-"+utime.substr(4,2)+"-"+utime.substr(6,2)+" "+utime.substr(8,2)+":"+utime.substr(10,2)+":"+utime.substr(12,2);
        return update_time;
    }

    function refresh() {
        $.confirm({
            title: false,
            content: '操作成功！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
        $("#table").bootstrapTable('refresh');
    }
</script>
</body>
</html>