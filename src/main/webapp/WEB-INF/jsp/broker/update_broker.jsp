<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>经纪公司</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/plugins/My97DatePicker/skin/WdatePicker.css">

    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
    <script src="${basePath}/resources/plugins/jquery.1.12.4.min.js"></script>
    <script src="${basePath}/resources/plugins/select2/js/select2.min.js"></script>
    <script src="${basePath}/resources/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="main">
    <form id="updateForm">
        <div class="control-group">
            <label for="platformId" class="control-label"><em class="rqd">*</em>交易平台：</label>
            <div class="controls">
                <select name="platformId" id="platformId">
                    <c:forEach var="platform" items="${amsPlatforms}">
                        <option value="${platform.platform_id}" <c:if
                                test='${amsBrokers.platformId == platform.platform_id}'> selected='selected' </c:if>>
                                ${platform.platform_name}
                        </option>
                    </c:forEach>
                </select>
                <span for="platform_add" class="hint">请选择平台</span>
            </div>
        </div>

        <div class="control-group">
            <label for="brokerName" class="control-label"><em class="rqd">*</em>期货公司：</label>
            <div class="controls">
                <input type="text" id="brokerName" name="brokerName" value="${amsBrokers.brokerName}" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入名称</span>
            </div>
        </div>

        <div class="control-group">
            <label for="brokerAbbrName" class="control-label"><em class="rqd">*</em>缩写名称：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="brokerAbbrName" name="brokerAbbrName" onfocus="importName1(this)" onblur="importName2(this)" value="${amsBrokers.brokerAbbrName}">
                <span class="tipsError">请输入缩写名称</span>
            </div>
        </div>

        <%--<div class="control-group">
            <label for="verificationCode" class="control-label">客户端认证码：</label>
            <div class="controls">
                <input type="text" maxlength="20" id="verificationCode" name="verification" value="">
                <span class="tipsError" style="display: none; padding-left: 10px">请输入长度不超过20位的数字串</span>
            </div>
        </div>--%>

        <div class="control-group ">
            <label  class="control-label">日盘启动时间：</label>
            <input type="text" name="day_begin" id="day_begin" readonly="readonly" onfocus="WdatePicker({dateFmt:'H:mm:ss', maxDate:'%y-%M-%d'});" value="08:30:00" style="background-color: #fff;cursor:pointer;">
            <span style="display: inline-block;margin:0 10px;">至</span>
            <input type="text" name="day_end" id="day_end" readonly="readonly" onfocus="WdatePicker({dateFmt:'H:mm:ss', maxDate:'%y-%M-%d'});" value="15:30:00" style="background-color: #fff;cursor:pointer">
            <span for="day_endDate" class="error" style="display: none;"></span>
        </div>

        <input type="hidden" name="brokerId" value="${amsBrokers.brokerId}">
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
    </form>
</div>
<script>
    //下拉框选择
    $("#platformId").select2({
        minimumResultsForSearch: -1
    });

    //选择交易平台，提示
    $(document).on("change", "#platform_add", function () {
        if ($(this).val()) {
            $(".hint").hide();
        } else {
            $(".hint").show();
        }
    });
    $(document).on("click", "#select2-platform_add-container", function () {
        if (!$("#platform_add").val()) {
            $(".hint").show();
        }
    });
    function importName1(obj) {
        if (!$(obj).val()) {
            $(obj).next().show();
        }
    }
    function importName2(obj) {
        if ($(obj).val()) {
            $(obj).next().hide();
        }
    }
    //实时监控input框
    $(document).on("input", "#brokerName,#brokerId", function () {
        if ($(this).val()) {
            $(this).next().hide();
        } else {
            $(this).next().show();
        }
    });

    //保存公司
    $(document).on("click", "#saveBrokerBtn", function () {
        $.ajax({
            type: 'POST',
            url: '${basePath}/ams/broker/update/${amsBrokers.brokerId}',
            data: $('#updateForm').serialize(),
            success: function (data) {
                if (data.code == '1') {
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                    window.parent.refresh();
                }
            },
            error: function () {
            }
        });
    });
</script>
</body>
</html>
