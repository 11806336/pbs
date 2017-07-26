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
    <title>账号</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>

</head>
<body>
<div id="main" style="padding:10px 20px;">
    <div class="block" id="tradeServerBlack" style="width: 500px;float: left;">
        <a href="javascript:void(0);" class="block-heading">黑名单</a>
        <table id="black"></table>

        <%--<div class="block-body">
            <div class="container" style="float:left;width:100px;">
                <div id="code1" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加</h3>
                    </div>
                    <div class="modal-body">
                        <input type="text" id="" name="" placeholder="请输入市场">
                        <input type="text" id="" name="" placeholder="请输入证券代码">
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success">提交</a>
                        <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#code" class="btn" onclick="createAction('url:create.jsp','添加代码')">添加代码</a></p>
            </div>

            <div class="container" style="float:left;width:100px;">
                <div id="cat" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加</h3>
                    </div>
                    <div class="modal-body">
                        <select id="tradePlatformSearch1" name="tradePlatformSearch1">
                            <option value=""> -- 所有证券 --</option>
                            <option value="1">沪深A股</option>
                            <option value="2">上海A</option>
                            <option value="6">深圳A</option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success">提交</a>
                        <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#cat" class="btn">添加分类</a></p>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add"> 全部删除</a>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add1"> 批量上传</a>
            </div>
            <form id="blackTable" action="/blackWhite/list" method="post">
                <table class="table font12 table-bordered alignCenter table-condensed" id="tradeServerTable">
                    <thead class="table-heading">
                    <tr>
                        <th width="80">序号</th>
                        <th width="80">类别</th>
                        <th width="80">代码/名称</th>
                        <th width="80">是否全局</th>
                        <th width="80">操作</th>
                    </tr>
                    <tr>
                       &lt;%&ndash;<c:forEach items="rows" var="rows">&ndash;%&gt;
                           &lt;%&ndash;<td>${rows.black_white_id}</td>&ndash;%&gt;
                           &lt;%&ndash;<td>${rows.stock_id}</td>&ndash;%&gt;
                       &lt;%&ndash;</c:forEach>&ndash;%&gt;
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </form>
        </div>--%>
    </div>
    <div style="clear: both;"></div>
    <div class="block" id="tradeServerDiv" style="width: 500px;float: left;">
        <a href="javascript:void(0);" class="block-heading">白名单</a>
        <table id="white"></table>
        <%--<div class="block-body">--%>
            <%--<!--添加代码dialog-->--%>
            <%--<div class="container" style="float:left;width:100px;">--%>
                <%--<div id="code" class="modal hide fade in" style="display: none; ">--%>
                    <%--<div class="modal-header">--%>
                        <%--<a class="close" data-dismiss="modal">×</a>--%>
                        <%--<h3>添加代码</h3>--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<input type="text" id="" name="" placeholder="请输入市场">--%>
                        <%--<input type="text" id="" name="" placeholder="请输入证券代码">--%>
                    <%--</div>--%>
                    <%--<div class="modal-footer">--%>
                        <%--<a href="#" class="btn btn-success">提交</a>--%>
                        <%--<a href="#" class="btn" data-dismiss="modal">关闭</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<p><a data-toggle="modal" href="#code" class="btn">添加代码</a></p>--%>
            <%--</div>--%>
            <%--<!--添加分类dialog-->--%>
            <%--<div class="container" style="float:left;width:100px;">--%>
                <%--<div id="cat" class="modal hide fade in" style="display: none; ">--%>
                    <%--<div class="modal-header">--%>
                        <%--<a class="close" data-dismiss="modal">×</a>--%>
                        <%--<h3>添加分类</h3>--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<select id="tradePlatformSearch" name="tradePlatformSearch">--%>
                            <%--<option value=""> -- 所有证券 --</option>--%>
                            <%--<option value="1">沪深A股</option>--%>
                            <%--<option value="2">上海A</option>--%>
                            <%--<option value="6">深圳A</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div class="modal-footer">--%>
                        <%--<a href="#" class="btn btn-success">提交</a>--%>
                        <%--<a href="#" class="btn" data-dismiss="modal">关闭</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<p><a data-toggle="modal" href="#cat" class="btn">添加分类</a></p>--%>
            <%--</div>--%>
            <%--<div class="container" style="float:left;width:100px;">--%>
                <%--<a class="btn" href="javascript:void(0);" id="add"> 全部删除</a>--%>
            <%--</div>--%>
            <%--<div class="container" style="float:left;width:100px;">--%>
                <%--<a class="btn" href="javascript:void(0);" id="add"> 批量上传</a>--%>
            <%--</div>--%>
            <%--<table class="table font12 table-bordered alignCenter table-condensed" id="tradeServerTable">--%>
                <%--<thead class="table-heading">--%>
                <%--<tr>--%>
                    <%--<th width="80">序号</th>--%>
                    <%--<th width="80">类别</th>--%>
                    <%--<th width="80">代码/名称</th>--%>
                    <%--<th width="80">是否全局</th>--%>
                    <%--<th width="80">操作</th>--%>
                <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
    </div>
    <div style="clear: both;">
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提交 ">
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 导出黑白名单 ">
    </div>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#black');
    //列配置项
    var dataColumns = [
        {field: 'black_white_id', title: '序号'},
        {field: 'stock_id', title: '类别'},
        {field: 'stock_code', title: '代码名称'},
        {field: 'is_global', title: '是否全局'},
        {field: 'operator_id', title: '创建人'},
        {
            field: 'action',
            title: '操作',
            align: 'center',
            formatter: 'actionFormatter',
            events: 'actionEvents',
            clickToSelect: true
        }
    ];

    var $white = $('#white');
    //列配置项
    var whiteDataColumns = [
        {field: 'black_white_id', title: '序号'},
        {field: 'stock_id', title: '类别'},
        {field: 'stock_code', title: '代码名称'},
        {field: 'is_global', title: '是否全局'},
        {field: 'operator_id', title: '创建人'},
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
    var url_json = "${basePath}/blackWhite/list";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'black_white_id';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;

    $white.bootstrapTable({
        url:url_json,
        datatype:'json',
        height: getHeight(),
        striped: true,
        search: search,
        showRefresh: showRefresh,
        showColumns: showColumns,
        minimumCountColumns: 2,
        clickToSelect: true,
        // detailView: true,
        detailFormatter: 'detailFormatter',
        pagination: true,
        paginationLoop: false,
        sidePagination: sidePagination,
        silentSort: false,
        smartDisplay: false,
        escape: true,
        searchOnEnterKey: true,
        idField: idField,
        maintainSelected: true,
        toolbar: '#toolbar',
        columns:whiteDataColumns
    });
</script>
</body>
</html>