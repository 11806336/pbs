<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>经纪公司</title>
    <link href="${basePath}/resources/pbs-admin/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/layer/css/layer.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/pbs-admin/css/public.css">
</head>
<body>
<div id="content">
    <div id="searchDiv">
        <div class="form-group">
            <label for="tradePlatformSearch">交易平台： </label>
            <select id="tradePlatformSearch" name="tradePlatformSearch">
                <option value="0"> -- 全部平台 -- </option>
                <c:forEach var="platform" items="${amsPlatforms}">
                    <option value="${platform.platformId}">${platform.platformName}</option>
                </c:forEach>
            </select>
            <div class="btn-panel" onclick="createAction('${basePath}/ams/broker/create','添加证券')">
                <a class="btn icon-plus addstockcom btn-primary" >添加证券公司</a>
            </div>
        </div>
        <div id="toolbar">
            <shiro:hasPermission name="upms:organization:create"><a class="waves-effect waves-button" href="javascript:;" onclick="createAction('${basePath}/ams/broker/create','添加证券')"><i class="zmdi zmdi-plus"></i> 新增公司</a></shiro:hasPermission>
            <shiro:hasPermission name="upms:organization:update"><a class="waves-effect waves-button" href="javascript:;" onclick="")><i class="zmdi zmdi-edit"></i> 编辑公司</a></shiro:hasPermission>
            <shiro:hasPermission name="upms:organization:delete"><a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除公司</a></shiro:hasPermission>
        </div>
    </div>
    <table id="table"></table>
</div>
<!--<div id="iframe">
    <iframe src="" frameborder="0"></iframe>
</div>-->
<script src="${basePath}/resources/pbs-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/select2/js/select2.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/layer/js/layer.js"></script>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script>

    $("#tradePlatformSearch").select2();
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/ams/broker/queryAmsBroker',
            height: getHeight(),
            striped: true,
            search: true,
            showRefresh: true,
            showColumns: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            detailView: true,
            detailFormatter: 'detailFormatter',
            pagination: true,
            paginationLoop: false,
            sidePagination: 'server',
            silentSort: false,
            smartDisplay: false,
            escape: true,
            searchOnEnterKey: true,
            idField: 'brokerId',
            maintainSelected: true,
            toolbar: '#toolbar',
            columns:dataColumns,
        });
    });
    function getHeight() {
        return $(window).height() - 20;
    }

    // 格式化图标
    function iconFormatter(value, row, index) {
        return '<i class="' + value + '"></i>';
    }
    // 格式化类型
    function typeFormatter(value, row, index) {
        if (value == 1) {
            return '目录';
        }
        if (value == 2) {
            return '菜单';
        }
        if (value == 3) {
            return '按钮';
        }
        return '-';
    }
    // 格式化状态
    function statusFormatter(value, row, index) {
        if (value == 1) {
            return '<span class="label label-success">正常</span>';
        } else {
            return '<span class="label label-default">锁定</span>';
        }
    }
    //列配置项
    var dataColumns=[
        {field: 'ck', checkbox: true},
        {field: 'brokerName', title: '券商名称'},
        {field: 'amsPlatform.platformName', title: '交易平台'},
        {field: 'brokerAbbrName', title: '缩写名称'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];
    //数据url
    var url_json="${basePath}/ams/broker/queryAmsBroker";//"${basePath}/resources/pbs-admin/data/broker.json";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination='server';
    //指定主键列
    var idField='brokerName';



    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    // 格式化操作按钮

    function actionFormatter(value, row, index) {
        return [
            "<a class='selected' href='javascript:;' onclick=updateAction('/ams/broker/edit','编辑',"+row.brokerId+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>",

            "<a class='selected' href='javascript:;' onclick=deleteAction() data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>"

        ].join('');
    }
    // 新增
    var createAction;
    function createAction(url,title) {//调用弹窗，需要传标题和url
        layer.open({
            type: 2,
            title:title,
            area: ['700px', '430px'],
            fixed: false, //不固定
            maxmin: true,
            content: url,
            shadeClose:true,
            moveOut:true
        });
    }

    var rows = $table.bootstrapTable('getSelections');
    // 编辑
    var updateAction;
    function updateAction(url,title,id){
        var updateurl = "${basePath}/ams/broker/edit/"+id;
        layer.open({
            type: 2,
            title:title,
            area: ['700px', '430px'],
            fixed: false, //不固定
            maxmin: true,
            content: updateurl,
            shadeClose:true,
            moveOut:true
        });

    }

    // 删除
    var deleteDialog;
    function deleteAction() {
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
        } else {
            deleteDialog = $.confirm({
                type: 'red',
                animationSpeed: 300,
                title: false,
                content: '确认删除吗？',
                buttons: {
                    confirm: {
                        text: '确认',
                        btnClass: 'waves-effect waves-button',
                        action: function () {
                            var ids = new Array();
                            for (var i in rows) {
                                ids.push(rows[i].brokerId);
                            }
                            $.ajax({
                                type: 'GET',
                                url: '${basePath}/ams/broker/delete/' + ids.join("-"), /*/manage/permission/delete*/
                                success: function(result) {
                                    if (result.code != 1) {
                                        if (result.data instanceof Array) {
                                            $.each(result.data, function(index, value) {
                                                $.confirm({
                                                    theme: 'dark',
                                                    animation: 'rotateX',
                                                    closeAnimation: 'rotateX',
                                                    title: false,
                                                    content: value.errorMsg,
                                                    buttons: {
                                                        confirm: {
                                                            text: '确认',
                                                            btnClass: 'waves-effect waves-button waves-light'
                                                        }
                                                    }
                                                });
                                            });
                                        } else {
                                            $.confirm({
                                                theme: 'dark',
                                                animation: 'rotateX',
                                                closeAnimation: 'rotateX',
                                                title: false,
                                                content: result.data.errorMsg,
                                                buttons: {
                                                    confirm: {
                                                        text: '确认',
                                                        btnClass: 'waves-effect waves-button waves-light'
                                                    }
                                                }
                                            });
                                        }
                                    } else {
                                        deleteDialog.close();
                                        $table.bootstrapTable('refresh');
                                    }
                                },
                                error: function(XMLHttpRequest, textStatus, errorThrown) {
                                    $.confirm({
                                        theme: 'dark',
                                        animation: 'rotateX',
                                        closeAnimation: 'rotateX',
                                        title: false,
                                        content: textStatus,
                                        buttons: {
                                            confirm: {
                                                text: '确认',
                                                btnClass: 'waves-effect waves-button waves-light'
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    },
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        }
    }

</script>
</body>
</html>