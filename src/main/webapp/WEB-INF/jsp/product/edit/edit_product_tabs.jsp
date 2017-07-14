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
    <title>Title</title>
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
            <li id="tab__manage_new_product" data-index="_manage_new_product" class="cur">
                <a class="waves-effect waves-light">新建产品</a>
            </li>
            <li id="tab__manage_setAccount_index" data-index="_manage_setAccount_index" class="">
                <a class="waves-effect waves-light">账号设置</a>
            </li>
        </ul>
    </div>
    <div class="content_main">
        <div id="iframe__manage_new_product" class="iframe cur">
            <iframe class="tab_iframe" src="/product/update/tab/create_product/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe__manage_setAccount_index" class="iframe">
            <iframe class="tab_iframe" src="/product/update/tab/update_product/${amsProduct.productId}" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
    </div>
</section>
</body>
</html>