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
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
</head>
<body>
<div id="main">
    <div id="toolbar">
        <shiro:hasPermission name="upms:company:create">
            <div id="searchDiv">
                <div class="form-group">
                    <label for="tradePlatformSearch">交易平台： </label>
                    <select id="tradePlatformSearch" name="tradePlatformSearch" onchange="selectByPlatformId()" style="width:160px;">
                        <option value=""> -- 全部平台 -- </option>
                        <c:forEach var="platform" items="${amsPlatforms}">
                            <option value="${platform.platform_id}">${platform.platform_name}</option>
                        </c:forEach>
                    </select>
                    <shiro:hasPermission name="upms:company:create">
                        <a class="waves-effect waves-button" href="javascript:;" onclick="dialog('${basePath}/ams/broker/create','添加证券','')"><i class="zmdi zmdi-plus"></i>&nbsp;添加证券公司</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="upms:company:delete">
                        <a class="waves-effect waves-button" href="javascript:;" data-deleteTpye="批量删除" onclick="deleteAction(this,'${basePath}/ams/broker/delete','broker_id')"><i class="zmdi zmdi-close"></i>&nbsp;删除证券公司</a>
                    </shiro:hasPermission>
                </div>
            </div>
        </shiro:hasPermission>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    function selectByPlatformId () {
        var platformId = $('#tradePlatformSearch option:selected') .val();
        if(platformId){
            $('#table').bootstrapTable(
                "refresh",
                {
                    url:"${basePath}/ams/broker/queryAmsBroker?platformId="+platformId
                }
            )
        }else{
            $('#table').bootstrapTable(
                "refresh",
                {
                    url:"${basePath}/ams/broker/queryAmsBroker"
                }
            )
        }
    }
    function getHeight() {
        return $(window).height() - 20;
    }
    //列配置项
    var dataColumns=[
        {field: 'ck', checkbox: true},
        {field: 'broker_id', title: '券商ID'},
        {field: 'broker_name', title: '券商名称'},
        {field: 'platform_name', title: '交易平台'},
        {field: 'broker_abbr_name', title: '缩写名称'},
        {field: 'day_begin', title: '日盘开始时间'},
        {field: 'day_end', title: '日盘结束时间'},
        {field: 'create_time', title: '创建时间'},
        {field: 'update_time', title: '修改时间'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];
    //数据url
    var url_json="${basePath}/ams/broker/queryAmsBroker";//"${basePath}/resources/pbs-admin/data/broker.json";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination='server';
    //指定主键列
    var idField='broker_id';

    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    // 格式化操作按钮

    function actionFormatter(value, row, index) {
        return [
            "<a class='update' href='javascript:;' onclick=dialog('/ams/broker/edit','编辑',"+row.broker_id+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a> ",
            " <a class='delete' href='javascript:;' onclick=deleteAction(this,'/ams/broker/delete','broker_id') data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>"
        ].join('');
    }
    

</script>
</body>
</html>