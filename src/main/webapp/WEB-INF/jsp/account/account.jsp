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
    <title>证券账号管理页</title>
    <link rel="stylesheet" href="${basePath}/resources/css/ace.css">
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div id="main">
    <div id="toolbar">
        <div id="searchDiv">
            <div class="btn-panel">
                <shiro:hasPermission name="upms:company:create">
                    <a class="waves-effect waves-button" href="javascript:;" onclick="dialog('/account/create','添加证券账号','')"><i class="zmdi zmdi-plus"></i>&nbsp;添加证券账号</a>
                </shiro:hasPermission>
                <shiro:hasPermission name="upms:company:delete">
                    <a class="waves-effect waves-button" href="javascript:;" onclick="expot();"><i class="zmdi zmdi-assignment-returned"></i>&nbsp;导出全部持仓</a>
                </shiro:hasPermission>
            </div>
        </div>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'trade_account_id', title: '证券ID'},
        {field: 'company_id', title: '公司ID'},
        {field: 'trade_account', title: '证券资金账号'},
        {field: 'trade_account_name', title: '账号名称'},
        {field: 'broker_id', title: '证券公司ID'},
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
        {field: 'operator_id', title: '创建人'},
        {
            field: 'action',
            title: '设置',
            align: 'center',
            formatter: 'set',
            events: 'actionEvents',
            clickToSelect: false
        },
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
    var url_json = "${basePath}/account/list";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'trade_account_id';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;
    //格式化修改时间
    function createTime(value, row, index) {
        var ctime=row.update_time+"";
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
        console.log( row.trade_account_id);
        ids = new Array();
        for (var i in rows) {
            ids.push(rows[i].trade_account_id);
        }
        return [
            "<a class='selected' href='javascript:;' onclick=dialog('/account/edit','编辑'," + row.trade_account_id + ") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>",
            "<a class='update' style='padding:0 6px;' href='javascript:;' onclick=dialog('/account/details','详情'," + row.trade_account_id + ") data-toggle='tooltip' title='查看账号详情'><i class='glyphicon glyphicon-eye-open'></i></a>",
            "<a class='delete' href='javascript:;' onclick=deleteAction(this,'/account/delete','tradeAccountId') data-toggle='tooltip' title='删除'><i class='glyphicon glyphicon-remove'></i></a>",
        ].join('');
    }
    function expot() {
        if(confirm("确定导出？")){
            $.ajax({
                url:"/account/export",
                type:'post',
                success : function(){
                    alert("导出成功")
                }
            });
        }
        else
        {
            alert("取消成功");
        }
    }
    //格式化设置开关按钮
    function set(value, row, index) {
        var rows = $table.bootstrapTable('getSelections');
      if(row.trade_account_status === "1"){
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
        if(rows.length==0){
            alert("请选择一条记录")
        }
        var tradeAccoundId=rows[0].trade_account_id;

        var status=$(obj).context.checked;
        var accountStatus=rows[0].trade_account_status;
        $.ajax({
            type: 'POST',
            url: '${basePath}/account/updateStatus/'+tradeAccoundId,
            data: {status : accountStatus},
            success: function (data) {
                console.info(data);
                if (data.message == '成功') {
                    if (status == true)
                        status=false;
                    } else {
                        status=true;
                }
            },
            error: function () {
                alert("error")
            }
        });
    }
</script>
</body>
</html>