<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>产品管理</title>
    <link rel="stylesheet" href="${basePath}/resources/css/ace.css">
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div id="toolbar">
        <div id="searchDiv">
            <div class="form-group">
                <div class="btn-panel" style="float:left;">
                    <shiro:hasPermission name="upms:company:refresh">
                        <a class="waves-effect waves-button btnRefresh" href="#"  onclick="location=location" ><i class="zmdi zmdi-refresh"></i>&nbsp;立即更新</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:create">
                        <a class="waves-effect waves-button btnCreate" href="#" onclick="dialog('${basePath}/product/createProduct','新建产品','')"><i class="zmdi zmdi-plus"></i>&nbsp;新建产品</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:close">
                        <a class="waves-effect waves-button btnCreate" href="#" data-deleteTpye = "批量删除" onclick="deleteAction(this,'${basePath}/product/delete','product_id')"><i class="zmdi zmdi-close"></i>&nbsp;删除产品</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:returned">
                        <a class="waves-effect waves-button btnExport" href="#" onclick="expot();"><i class="zmdi zmdi-assignment-returned" ></i>&nbsp;导出全部数据</a>
                    </shiro:hasPermission>
                </div>
            </div>
        </div>
    </div>
<form name="form1">
    <table id="table"></table>
</form>
</div>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script src="${basePath}/resources/js/public.js"></script>
<script src="${basePath}/resources/js/Timer.js"></script>
<script src="${basePath}/resources/js/Loader.js"></script>
<script src="${basePath}/resources/js/timer2.js"></script>

<script language=javascript>
    function expot() {
        window.location.href="/product/export"
    }
</script>
<script>
    var $table = $('#table');
    //json数据
    var url_json = "${basePath}/product/list";
    var dataColumns =  [
        {field: 'ck', checkbox: true},
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'product_id', title: '产品ID', visible: false},
        {field: 'company_id', title: '公司ID', visible: false},
        {field: 'product_name', title: '产品名称'},
        {   field: 'product_type',
            title: '产品类型',
            align: 'center',
            formatter: 'product_type',
            events: 'Events',
            clickToSelect: false
        },
        {field: 'product_code', title: '产品代码'},
        {field: 'product_manager', title: '产品经理'},
        {   field: 'product_share_source',
            title: '产品份额来源',
            align: 'center',
            formatter: 'product_share_source',
            events: 'Events',
            clickToSelect: false
        },
        {   field: 'start_date',
            title: '产品开始时间',
            align: 'center',
            formatter: 'start_date',
            events: 'Events',
            clickToSelect: false
        },
        {   field: 'end_date',
            title: '产品结束时间',
            align: 'center',
            formatter: 'end_date',
            events: 'Events',
            clickToSelect: false
        },
        {field: 'product_shares', title: '产品份额'},
//        {field: 'product_desc', title: '备注'},
//        {field: 'operator_id', title: '操作人ID'},
        {field: 'product_supervisor', title: '产品管理人'},
        {field: 'o32_id', title: 'o32来源ID'},
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
        {
            field: 'action',
            title: '设置',
            align: 'center',
            formatter: 'set',
            events: 'actionEvents',
            clickToSelect: false
        },
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
//    格式化产品份额来源
    function product_share_source(value, row, index) {
        if(row.product_share_source == true){
            return "自定义"
        }else{
            return "O32读取"
        }
    }
    //格式化产品类型
    function product_type(value, row, index) {
        if(row.product_type == true){
            return "普通基金"
        }else{
            return "分级基金"
        }
    }
    //格式化产品开始时间
    function start_date(value, row, index) {
        var sdate=row.start_date+"";
        var start_date=sdate.substr(0,4)+"-"+sdate.substr(4,2)+"-"+sdate.substr(6,2)+" "+sdate.substr(8,2)+":"+sdate.substr(10,2)+":"+sdate.substr(12,2);
        return start_date;
    }
    //格式化产品结束时间
    function end_date(value, row, index) {
        var edate=row.end_date+"";
        var end_date=edate.substr(0,4)+"-"+edate.substr(4,2)+"-"+edate.substr(6,2)+" "+edate.substr(8,2)+":"+edate.substr(10,2)+":"+edate.substr(12,2);
        return end_date;
    }
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
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
        var ids = [];
        for (var i in rows) {
            ids.push(rows[i].productId);
        }
        return [
            "<a class='selected' href='javascript:;' onclick=dialog('/product/edit','编辑',"+row.product_id+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>　",
            "<a class='search' href='javascript:;' onclick=dialog('/product/details','详情',"+row.product_id+") data-toggle='tooltip' title='详情'><i class='glyphicon glyphicon-eye-open'></i></a>"
        ].join('');
    }
    //格式化设置开关按钮
    function set(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
        if(row.product_status == true){
            return [
                '<label> ' +
                '<input onchange="open_close(this)" name="switch-field-1"  checked="checked" class="ace ace-switch ace-switch-4" type="checkbox"> ' +
                '<span class="lbl"></span>' +
                ' </label>'
            ].join('');
        }else {
            return [
                '<label> ' +
                '<input onchange="open_close(this)" name="switch-field-1" class="ace ace-switch ace-switch-4" type="checkbox"> ' +
                '<span class="lbl"></span>' +
                ' </label>'
            ].join('');
        }
    }

    //启用、停用开关按钮的方法
    function open_close(obj) {
        //obj==this; status状态，值为ture为启用，为false就是停用
        var rows = $table.bootstrapTable('getSelections');
        if (rows.length == 0) {
            $.confirm({
                title: false,
                content: '请至少选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
            return false;
        }
        var productId=rows[0].product_id;

        var status=$(obj).context.checked;
        var productStatus=rows[0].product_status;
        $.ajax({
            type: 'POST',
            url: '${basePath}/product/updateStatus/'+productId,
            data: {status : productStatus},
            success: function (data) {
                console.info(data);
                if (data.message == '成功') {
                    if (status == true)
                        status=1;
                } else {
                    status=0;
                }
            },
            error: function () {
                alert("error")
            }
        });
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