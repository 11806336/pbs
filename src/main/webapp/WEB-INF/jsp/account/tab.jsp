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
    <title>Title</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    <!--二级选项卡-->
    <link href="/resources/css/tab2.css" rel="stylesheet"/>
</head>
<body>
<section style="height:100%;">
    <div class="content_tab" style="background-color: #333;">
        <div class="tab_left">
            <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
        </div>
        <div class="tab_right">
            <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
        </div>
        <ul id="tabs" class="tabs" style="overflow-x: hidden;">
            <!-- todo:li的id 和 data-index 和它对应的iframe 的值后半段一定要一样-->
            <li id="tab_setAccountInfo" data-index="setAccountInfo" class="cur">
                <a class="waves-effect waves-light">账号信息</a>
            </li>
            <li id="tab_setWhiteBlackList" data-index="setWhiteBlackList" class="">
                <a class="waves-effect waves-light">黑白名单</a>
            </li>
            <li id="tab_setCharge" data-index="setCharge" class="">
                <a class="waves-effect waves-light">手续费设置</a>
            </li>
        </ul>
    </div>
    <div class="content_main">
        <div id="iframe_setAccountInfo" class="iframe cur">
            <iframe class="tab_iframe" src="create_account_base.html" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe_setWhiteBlackList" class="iframe">
            <iframe class="tab_iframe" src="whiteBlackList.html" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe_setCharge" class="iframe">
            <iframe class="tab_iframe" src="charge.html" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
    </div>
</section>

<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
</body>
</html>