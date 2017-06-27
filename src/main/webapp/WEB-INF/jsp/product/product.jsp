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
    <title>产品管理</title>
    <link href="${basePath}/resources/pbs-admin/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/css/admin.css" rel="stylesheet"/>
    <style>
        #searchDiv .countdown {
            display: inline-block;
            margin-left: 15px;
            color: #f00;
            border: 1px solid #f00;
            background-color: #ffeeee;
            padding: 3px 10px;
            vertical-align: middle;
        }
        #searchDiv .countdown .load {
            background: url("/images/loading.gif") no-repeat scroll 0 0 #ffeeee;
            width: 20px;
            height: 20px;
            display: inline-block;
            vertical-align: middle;
            margin: -2px -3px 0 0;
        }
        #searchDiv .countdown em {
            font-style: normal;
        }
    </style>
</head>
<body>
<div id="content">
    <div id="searchDiv">
        <div class="form-group">
            <div class="countdown">
                <span class="countText">距离前次更新</span>
                <em></em>
                <span class="load"></span>
            </div>
            <div class="btn-panel">
                <a class="btn icon-plus addstockcom btn-primary btnRefresh" href="#">立即更新</a>
                <a class="btn icon-plus addstockcom btn-primary btnCreate" href="#" onclick="create('/manage/product/edit','新建产品')">新建产品</a>
                <a class="btn icon-plus addstockcom btn-primary btnExport" href="#">导出数据</a>
            </div>
        </div>
    </div>
    <table id="table"></table>
</div>
<script src="${basePath}/resources/pbs-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/select2/js/select2.min.js"></script>
<script src="${basePath}/resources/pbs-admin/plugins/layer/js/layer.js"></script>
<script src="${basePath}/resources/pbs-admin/js/public.js"></script>
<script src="${basePath}/resources/pbs-admin/js/Timer.js"></script>
<script src="${basePath}/resources/pbs-admin/js/Loader.js"></script>
<script>

    var $table = $('#table');
    //json数据
    var url_json = "${basePath}/product/list";

    var dataColumns =  [
        {field: 'ck', checkbox: true},
        {field: 'number', title: 'No.', formatter: function (value, row, index) {return index + 1;}},
        {field: 'productId', title: '产品ID', visible: false},
        {field: 'productName', title: '产品名称'},
        {field: 'productType', title: '产品类型'},
        {field: 'productCode', title: '产品代码'},
        {field: 'productManager', title: '产品经理'},
        {field: 'productStatus', title: '产品状态'},
        {field: 'productNetValue', title: '产品净值'},
        {field: 'netAssetValue', title: '单位净值'},
        {field: 'productShares', title: '产品份额'},
        {field: 'stockTotalAssets', title: '证券总资产'},
        {field: 'securityTotalValue', title: '证券总市值'},
        {field: 'stockTotalValue', title: '股票总市值'},
        {field: 'shortTotalValue', title: '空单总市值'},
        {field: 'otherRights', title: '其他权益'},
        {field: 'operator', title: '创建人'},
        {field: 'createTime', title: '创建时间'},
        {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
    ];
    // 设置分页数据来源
    var sidePagination = 'server';

    // 指定主键列
    var idField = 'productId';
    //右上角刷新搜索
    var search=true;
    var showRefresh=true;
    var showColumns= true;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            "<a class='selected' href='javascript:;' onclick=edit('/manage/product/edit','编辑',"+row.productId+") data-toggle='tooltip' title='编辑'><i class='glyphicon glyphicon-edit'></i></a>",
            "<a class='search' href='javascript:;' onclick=query('/manage/product/query',"+row.productId+") data-toggle='tooltip' title='详情'><i class='glyphicon glyphicon-eye-open'></i></a>",
        ].join('');
    }
    // 计算合计值
    function sumFormatter(data) {
        var field = this.field;
        return data.reduce(function(sum, row) {
            return sum + (+row[field]);
        }, 0);
    }

    function create(url,title) {
        layer.open({
            type: 2,
            title:title,
            area: ['700px', '430px'],
            fixed: false, //不固定
            maxmin: true,
            content: ${basePath}+url
        });
    }

    function query(url,title,id) {
        layer.open({
            type: 2,
            title:title,
            area: ['700px', '430px'],
            fixed: false, //不固定
            maxmin: true,
            content: ${basePath}+url+"/"+id
        });
    }

    function edit(url,title,id) {
        layer.open({
            type: 2,
            title:title,
            area: ['700px', '430px'],
            fixed: false, //不固定
            maxmin: true,
            content: ${basePath}+url+"/"+id
        });
    }




    // 倒计时
    var countdown = $(".countdown");
    var countText = countdown.find("em");
    var loading = countdown.find(".load").show();
    var url = "/manage/product/product.html";
    var timer = new Timer(url, 30);

    loading.hide();
    timer.start(function(count){
        if (count >= timer.updateInterval && !Loader.loading && !Loader.localUpdate){
            loading.show();
            $(".btnRefresh").click();
            timer.count = 0;
        }
        if (count >= 3600){
            count = (Math.floor(count / 3600)) + "&nbsp;时...";
        }else if(count >= 60){
            count = (Math.floor(count / 60)) + "&nbsp;分...";
        }else{
            count += "&nbsp;秒";
        }
        countText.html(count);
    });

    //立即更新
    $(".btnRefresh").click(function(){
        var _this = this;
        if ($(_this).hasClass("disabled")) return false;
        $(_this).addClass("disabled");
        loading.show();
        timer.count = 0;
        $table.bootstrapTable('refresh',{url: url_json});
        $(_this).removeClass("disabled");
        loading.hide();
    });
</script>
</body>
</html>