<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>公司管理</title>
    <jsp:include page="/resources/inc/head.jsp"/>
</head>
<body>
<div id="main">
    <div id="toolbar">
        <shiro:hasPermission name="upms:company:create">
            <a class="waves-effect waves-button" href="javascript:;" onclick="dialog('${basePath}/company/create','添加公司','')"><i class="zmdi zmdi-plus"></i>&nbsp;添加公司</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="upms:company:update">
            <a class="waves-effect waves-button" href="javascript:;" data-update="表格外" onclick="dialogUpdate(this,'${basePath}/company/update/','编辑公司','companyId')"><i class="zmdi zmdi-edit"></i>&nbsp;编辑公司</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="upms:company:delete">
            <a class="waves-effect waves-button" href="javascript:;" data-deleteTpye="批量删除" onclick="deleteAction(this,'${basePath}/company/delete','companyId')"><i class="zmdi zmdi-close"></i>&nbsp;删除公司</a>
        </shiro:hasPermission>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp"/>
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
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'companyId', title: '公司ID'},
        {field: 'companyName', title: '公司名称'},
        {field: 'managerId', title: '负责人ID'},
        {field: 'companyPhone', title: '公司电话'},
        {field: 'companyAddress', title: '公司地址'},
        {field: 'companyFax', title: '公司传真'},
        {field: 'createTime', title: '创建时间'},
        {field: 'updateTime', title: '修改时间'},
        {field: 'description', title: '备注'},
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
    var url_json = "${basePath}/company/list";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'companyId';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;

    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="dialogUpdate(this,' + "'${basePath}/company/update/'," + "'编辑公司'" +",'companyId'"+')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction(this,'+"'${basePath}/company/delete'"+",'companyId'"+')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
    //编辑行的id;
    var row_id='';
    //编辑
    function dialogUpdate(obj,url,title,id) {
        //判断是表格外还是表格内
        var dataUpdate=$(obj).attr("data-update");
        var rows = $table.bootstrapTable('getSelections');
        if(dataUpdate){
            if(rows.length != 1){
                $.confirm({
                    title: false,
                    content: '请选择一条记录！',
                    autoClose: 'cancel|3000',
                    backgroundDismiss: true,
                    buttons: {
                        cancel: {
                            text: '取消',
                            btnClass: 'waves-effect waves-button'
                        }
                    }
                });
            }else{
                row_id=rows[0][id];
                layer.open({
                    type: 2,
                    title: title,
                    area: ['700px', '430px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: url+rows[0][id],
                    shadeClose: true,
                    moveOut: true
                });
            }
        }else {
            var Id=$(obj).parent().parent().find(".bs-checkbox ").find("input").val();
            row_id=Id;
            layer.open({
                type: 2,
                title: title,
                area: ['700px', '430px'],
                fixed: false, //不固定
                maxmin: true,
                content: url+Id,
                shadeClose: true,
                moveOut: true
            });
        }
    }
    //编辑后刷新
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