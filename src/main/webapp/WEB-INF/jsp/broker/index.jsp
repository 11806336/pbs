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
    <div id="searchDiv">
        <div class="form-group">
            <label for="tradePlatformSearch">交易平台： </label>
            <select id="tradePlatformSearch" name="tradePlatformSearch" style="width:160px;">
                <option value="0"> -- 全部平台 -- </option>
                <c:forEach var="platform" items="${amsPlatforms}">
                    <option value="${platform.platformId}">${platform.platformName}</option>
                </c:forEach>
            </select>
            <div class="btn-panel" onclick="dialog('${basePath}/ams/broker/create','添加证券','')" style="display: inline-block;margin-left:20px;">
                <a class="btn icon-plus addstockcom btn-primary" style="margin-bottom: 0;" >添加证券公司</a>
            </div>
        </div>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>


    var $table = $('#table');

    function searchByPlatFormId() {
        var a = $('#tradePlatformSearch option:selected') .val();
        $('#table').bootstrapTable(
            "refresh",
            {
                url:"${basePath}/ams/broker/queryAmsBroker?platformId="+a
            }
        )
    }
    function getHeight() {
        return $(window).height() - 20;
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
            "<a class='selected' href='javascript:;' onclick=dialog('/ams/broker/edit','编辑',"+row.brokerId+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>",

            "<a class='selected' href='javascript:;' onclick=deleteAction() data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>"

        ].join('');
    }


/*
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
*/

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