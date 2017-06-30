<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <shiro:hasPermission name="upms:company:create">
            <a class="waves-effect waves-button" href="javascript:;" onclick="createOrEditCompany('/company/create','添加公司')"><i class="zmdi zmdi-edit"></i>添加公司</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="upms:company:update">
            <a class="waves-effect waves-button" href="javascript:;" onclick="createOrEditCompany('/company/update','编辑公司',1)"><i class="zmdi zmdi-edit"></i>编辑公司</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="upms:company:delete">
            <a class="waves-effect waves-button" href="javascript:;" onclick="batchDelete()"><i class="zmdi zmdi-edit"></i>删除公司</a>
        </shiro:hasPermission>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp"/>
<script>
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
            '<a class="update" href="javascript:;" onclick="createOrEditCompany(' + "'${basePath}/company/update'," + "'编辑公司'" + ',1)" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="del(' + row.companyId + ')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
    /**
     * 新建/编辑公司
     * url:请求地址
     * title：窗口title
     * flag:用来区分是新增还是编辑，方便判断
     */
    function createOrEditCompany(url, title, flag) {
        if (flag) {//如果是编辑判断是否只选择了一条
            var rows = $table.bootstrapTable('getSelections');
            if (rows.length > 1) {
                alert("请只选择一行！");
                return;
            } else if (rows.length == 0) {
                alert("请先选择要编辑的行！");
                return;
            }
            url = url + "/" + rows[0].companyId;
        }
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
        if (rows.length > 0) {
            var ids = new Array();
            for (var i in rows) {
                ids.push(rows[i].companyId);
            }
            $.ajax({
                type: 'get',
                url: '${basePath}/company/delete/' + ids.join(),
                success: function(result) {
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