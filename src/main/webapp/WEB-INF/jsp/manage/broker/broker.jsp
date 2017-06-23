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
                <option value=""> -- 全部平台 -- </option>
                <option value="1">期货平台</option>
                <option value="2">股票平台</option>
                <option value="6">股票期权平台</option>
                <option value="8">期货期权平台</option>
            </select>
            <div class="btn-panel" onclick="panel('${basePath}/manage/broker/create','添加证券')">
                <a class="btn icon-plus addstockcom btn-primary" >添加证券公司</a>
            </div>
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
<script src="${basePath}/resources/pbs-admin/js/public.js"></script>
<script>
    $("#tradePlatformSearch").select2();
    function panel(url,title) {//调用弹窗，需要传标题和url
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

    var $table = $('#table');
    $(function() {
     // bootstrap table初始化
     $table.bootstrapTable({
     url: '${basePath}/manage/broker/list',
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
     columns: [
             {field: 'ck', checkbox: true},
             {field: 'brokerId', title: '经纪公司ID'},
             {field: 'platformName', title: '交易平台'},
             {field: 'brokerAbbrName', title: '经纪公司'},
             {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
     ]
     });
     });
    //列配置项
   var dataColumns=[
        {field: 'ck', checkbox: true},
        {field: 'brokerId', title: '经纪公司ID2'},
        {field: 'platformName', title: '交易平台'},
        {field: 'brokerAbbrName', title: '经纪公司'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];
    //数据url
    var url_json="${basePath}/manage/broker/list";//"${basePath}/resources/pbs-admin/data/broker.json";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination='server';
    //指定主键列
    var idField='brokerId';
    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    // 格式化操作按钮

    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="panel('+"'create_broker.jsp'"+","+"'管理经纪公司'"+')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }

</script>
</body>
</html>