<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="${basePath}/resources/inc/head.jsp" flush="true"/>
    <!--二级选项卡-->
    <link href="${basePath}/resources/css/tab2.css" rel="stylesheet"/>
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
            <iframe class="tab_iframe" src="${basePath}/product/create/createProduct" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
        <div id="iframe__manage_setAccount_index" class="iframe">
            <iframe class="tab_iframe" src="${basePath}/account/create/accountSettings" width="100%" frameborder="0" scrolling="auto" onload="changeFrameHeight(this)"></iframe>
        </div>
    </div>
</section>
<jsp:include page="${basePath}/resources/inc/tabJS.jsp" flush="true"/>
</body>
</html>