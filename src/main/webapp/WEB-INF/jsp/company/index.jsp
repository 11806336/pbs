<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>公司管理</title>
    <jsp:include page="/resources/inc/head.jsp"/>
    <link rel="stylesheet" href="${basePath}/resources/css/public.css">
</head>
<body>
<div id="content">
    <div style="position: absolute;top:10px;z-index: 111;">
        <shiro:hasPermission name="upms:t:t">
        <div class="btn-panel" onclick="panel('${basePath}/company/create','添加新公司')" style="display: inline-block;">
            <a class="btn icon-plus addstockcom btn-primary" href="#">添加新公司</a>
        </div>
        </shiro:hasPermission>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp"/>
<script>
    function panel(url, title) {//调用弹窗，需要传标题和url
        layer.open({
            type: 2,
            title: title,
            area: ['700px', '430px'],
            fixed: false, //不固定
            maxmin: true,
            content: url,
            shadeClose: true,
            moveOut: true
        });
    }
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
        {field: 'descriptoin', title: '备注'},
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
            '<a class="update" href="javascript:;" onclick="panel(' + "'${basePath}/company/update/" + row.companyId + "'," + "'编辑公司'" + ')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
          //  '<a class="delete" href="javascript:;" onclick="deleteAction('+"'${basePath}/company/delete/'" + "," + row.companyId + ')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
            '<a class="delete" href="javascript:;" onclick="del(' + row.companyId + ')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }

    /**
     * 通过操作列删除单个公司
     * @param id
     */
    function del(id) {
        var ids = [id];
        $.ajax({
            type: 'get',
            url: '${basePath}/company/delete' + '/' + ids.join(),
            success: function(result) {
                if (result.message == "success") {
                    alert("删除成功！");
                }
            }
         });
    }
    /**
     * 批量删除公司
     */
    function batchDelete() {
        var rows = $table.bootstrapTable('getSelections');
        if (rows) {

            var ids = new Array();
            for (var i in rows) {
                ids.push(rows[i].companyId);
            }
            $.ajax({
                type: 'get',
                url: '${basePath}/company/delete/' + ids.join("-"),
                success: function(result) {
                    console.info(JSON.parse(result));
                    if (result.message == 'success') {//说明删除成功
                        alert("删除成功！");
                    } else {
                        alert("删除失败！");
                    }
                }
            });
        } else {
            alert("请先选择要删除的行！");
        }
    }
</script>
</body>
</html>