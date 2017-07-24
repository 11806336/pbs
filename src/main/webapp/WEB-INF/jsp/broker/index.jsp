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
                        <a class="waves-effect waves-button" href="javascript:;" onclick="dialog('${basePath}/broker/create','添加证券','')"><i class="zmdi zmdi-plus"></i>&nbsp;添加证券公司</a>
                    </shiro:hasPermission>
                    <%--<shiro:hasPermission name="upms:company:delete">
                        <a class="waves-effect waves-button" href="javascript:;" data-deleteTpye="批量删除" onclick="deleteAction(this,'${basePath}/broker/delete','broker_id')"><i class="zmdi zmdi-close"></i>&nbsp;删除证券公司</a>
                    </shiro:hasPermission>--%>
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
                    url:"${basePath}/broker/queryAmsBroker?platformId="+platformId
                }
            )
        }else{
            $('#table').bootstrapTable(
                "refresh",
                {
                    url:"${basePath}/broker/queryAmsBroker"
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
        {   field: 'day_begin',
            title: '日盘开始时间',
            align: 'center',
            formatter: 'day_begin',
            events: 'Events',
            clickToSelect: false
        },
        {   field: 'day_end',
            title: '日盘结束时间',
            align: 'center',
            formatter: 'day_end',
            events: 'Events',
            clickToSelect: false
        },
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
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: true}
    ];
    //数据url
    var url_json="${basePath}/broker/queryAmsBroker";//"${basePath}/resources/pbs-admin/data/broker.json";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination='server';
    //指定主键列
    var idField='broker_id';

    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    //格式化日盘开始时间
    function day_begin(value, row, index) {
        var dbegin = (row.day_begin+"").length === 5?"0"+row.day_begin:row.day_begin+"";
        var day_begin=dbegin.substr(0,2)+":"+dbegin.substr(2,2)+":"+dbegin.substr(4,2);
        return day_begin;
    }
    //格式化日盘结束时间
    function day_end(value, row, index) {
        var dend=(row.day_end+"").length === 5 ? "0"+row.day_end:row.day_end+"";
        var day_end=dend.substr(0,2)+":"+dend.substr(2,2)+":"+dend.substr(4,2);
        return day_end;
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
        return [
            "<a class='selected' href='javascript:;' onclick=dialog('/broker/edit','编辑',"+row.broker_id+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>　"/*,
            "<a class='delete' href='javascript:;' onclick=deleteAction(this,'/broker/delete','broker_id') data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>"*/
        ].join('');
    }
    //编辑修改后刷新
    function refresh() {
        $.confirm({
            title: false,
            content: '操作成功！',
            autoClose: 'cancel|3000',
            backgroundDismiss: true,
            buttons: {
                cancel: {
                    text: '确定',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
        $("#table").bootstrapTable('refresh');
    }
</script>
</body>
</html>