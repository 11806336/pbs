<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询产品</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    <!--二级选项卡-->
    <link href="/resources/css/tab2.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    $(document).on('click', '.tabs li', function() {
        // 切换选项卡
        $('.tabs li').removeClass('cur');
        $(this).addClass('cur');
        // 切换iframe
        $('.tab_iframe').removeClass('cur');
        $('.iframe').hide();
        $('#iframe_' + $(this).data('index')).addClass('cur');
        $('#iframe_' + $(this).data('index')).show();
    });
    // iframe高度自适应
    function changeFrameHeight(ifm) {
        ifm.height = document.documentElement.clientHeight - 118;
    }
</script>
<section style="height:100%;">
    <div class="content_tab" style="background-color: #333;">
        <div class="tab_left">
            <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
        </div>
        <div class="tab_right">
            <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
        </div>
        <ul id="tabs" class="tabs">
            <!-- li的id 和 data-index 和它对应的iframe 的值后半段一定要一样-->
            <li id="tab__query_product_overview" data-index="_query_product_overview" class="cur">
                <a class="waves-effect waves-light">总览</a>
            </li>
            <li id="tab__query_product_directive" data-index="_query_product_directive" class="">
                <a class="waves-effect waves-light">指令</a>
            </li>
            <li id="tab__query_product_task" data-index="_query_product_task" class="">
                <a class="waves-effect waves-light">任务</a>
            </li>
            <li id="tab__query_product_stock_holding" data-index="_query_product_stock_holding" class="">
                <a class="waves-effect waves-light">股票持仓</a>
            </li>
            <li id="tab__query_product_other" data-index="_query_product_other" class="">
                <a class="waves-effect waves-light">其他权益</a>
            </li>
        </ul>
    </div>
    <div class="content_main">
        <div id="iframe__query_product_overview" class="iframe cur">
            <iframe class="tab_iframe" src="/product/details/tab/product_account_overview/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe__query_product_directive" class="iframe">
            <iframe class="tab_iframe" src="/product/details/tab/product_directive_overview/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe__query_product_task" class="iframe">
            <iframe class="tab_iframe" src="/product/details/tab/product_task_overview/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe__query_product_stock_holding" class="iframe">
            <iframe class="tab_iframe" src="/product/details/tab/product_stock_holding_overview/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe__query_product_other" class="iframe">
            <iframe class="tab_iframe" src="/product/details/tab/product_other_overview/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
    </div>
</section>
</body>
</html>