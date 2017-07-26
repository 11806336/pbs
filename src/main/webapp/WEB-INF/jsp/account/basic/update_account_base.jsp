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
            <label for="productId" class="control-label"><em class="rqd">*</em>产品列表：</label>
            <div class="controls">
                <select  name="productId" id="productId">
                    <c:forEach var="amsProduct" items="${amsProducts}">
                        <option value="${amsProduct.product_id}" <c:if
                                test='${amsProduct.product_id == amsProductAccount.productId}'> selected='selected' </c:if>>
                                ${amsProduct.product_name}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="control-group">
            <label for="brokerId" class="control-label"><em class="rqd">*</em>证券公司：</label>
            <div class="controls">
                <select name="brokerId" id="brokerId" disabled="disabled">
                    <c:forEach var="amsBrokers" items="${amsBrokers}">
                        <option value="${amsBrokers.broker_id}" <c:if
                                test='${amsBrokers.broker_id == amsTradeAccount.brokerId}'> selected='selected' </c:if>>${amsBrokers.broker_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="control-group">
            <label for="companyId" class="control-label"><em class="rqd">*</em>公司列表：</label>
            <div class="controls">
                <select  name="companyId" id="companyId" disabled="disabled">
                    <c:forEach var="upmsCompany" items="${upmsCompany}">
                        <option value="${upmsCompany.companyId}" <c:if test="${upmsCompany.companyId==amsTradeAccount.companyId}"> selected='selected' </c:if>>${upmsCompany.companyName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="control-group">
            <label for="tradeAccountName" class="control-label"><em class="rqd">*</em>证券账号名称：</label>
            <div class="controls">
                <input type="text" id="tradeAccountName" name="tradeAccountName" readonly="readonly" value="${amsTradeAccount.tradeAccountName}" onblur="" maxlength="25"><span class="tipsError"
                                                                                                                                                            style="display: none; padding-left: 10px">请输入名称</span>
            </div>
        </div>
    <div class="control-group">
        <label for="tradeAccountPassword" class="control-label"><em class="rqd">*</em>密码：</label>
        <div class="controls">
            <input type="password" maxlength="8" id="tradeAccountPassword" name="tradeAccountPassword" value="${amsTradeAccount.tradeAccountPassword}"> <span class="tipsError"
                                                                                               style="display: none; padding-left: 10px">请输入长度超过8位的字符串</span>
        </div>
    </div>

    <div class="control-group">
        <label for="passwordCheck" class="control-label">确认密码：</label>
        <div class="controls">
            <input type="password" maxlength="20" id="passwordCheck" name="passwordCheck" value="${amsTradeAccount.tradeAccountPassword}"> <span
                class="tipsError" style="display: none; padding-left: 10px">请输入长度超过8位的字符串</span>
        </div>
    </div>

    <div class="radio">
        <div class="radio radio-inline radio-success" >
            <input id="status_1" type="radio" name="tradeAccountStatus" value="1"
                   <c:if test="${amsTradeAccount.tradeAccountStatus=='1'}">checked
            </c:if>>
            <label for="status_1">正常 </label>
            <input id="status_0" type="radio" name="tradeAccountStatus" value="0"
                   <c:if test="${amsTradeAccount.tradeAccountStatus=='0'}">checked
            </c:if>>
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
            url: '${basePath}/account/update/${amsTradeAccount.tradeAccountId}',
            data: $('#create_form').serialize(),
            success: function (data) {
                console.info(data);
                if (data.code == '1') {
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                    window.parent.refresh();
                }
            } ,
            error: function () {
            }
        });
    });
</script>
</body>
</html>