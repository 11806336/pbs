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
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">
    <form id="create_form">

    <div class="control-group">
        <label for="tradeAccountPassword" class="control-label"><em class="rqd">*</em>密码：</label>
        <div class="controls">
            <input type="password" maxlength="8" id="tradeAccountPassword" name="tradeAccountPassword" value="${amsStockAccount.tradeAccountPassword}"> <span class="tipsError"
                                                                                               style="display: none; padding-left: 10px">请输入长度超过8位的字符串</span>
        </div>
    </div>

    <div class="control-group">
        <label for="passwordCheck" class="control-label">确认密码：</label>
        <div class="controls">
            <input type="password" maxlength="20" id="passwordCheck" name="passwordCheck" value="${amsStockAccount.tradeAccountPassword}"> <span
                class="tipsError" style="display: none; padding-left: 10px">请输入长度超过8位的字符串</span>
        </div>
    </div>

    <div class="radio">
        <div class="radio radio-inline radio-success" id="trade_account_status" name="trade_account_status">
            <input id="status_1" type="radio" name="status" value="1" checked>
            <label for="status_1">正常 </label>
            <input id="status_0" type="radio" name="status" value="0">
            <label for="status_0">锁定 </label>
        </div>
    </div>
    <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
    </form>
</div>
<script src="${basePath}/resources/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/plugins/select2/js/select2.min.js"></script>
<script>
    //下拉框选择
    $("select").select2({
        minimumResultsForSearch: -1
    });
    //保存产品
    $(document).on("click","#saveBrokerBtn",function () {
        $.ajax({
            type: 'POST',
            url: '${basePath}/account/save',
            data: $('#create_form').serialize(),
            success: function (data) {
                console.info(data);
                if (data.message == 'success') {
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                }
            } ,
            error: function () {
            }
        });
    });
</script>
</body>
</html>