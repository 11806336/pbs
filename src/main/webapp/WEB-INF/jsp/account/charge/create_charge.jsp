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
    <title>手续费</title>
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
    <form id="addForm">
        <div class="control-group">
            <label for="stockCategoryId" class="control-label"><em class="rqd">*</em>选择分类：</label>
            <div class="controls">
                <select name="stockCategoryId" id="stockCategoryId">
                    <option value="0">---请选择---</option>
                    <c:forEach var="amsStockCategory" items="${amsStockCategory}">
                        <option value="${amsStockCategory.stock_category_id}">${amsStockCategory.stock_category_name}</option>
                    </c:forEach>
                </select>
                <span for="platform_add" class="hint">请选择分类</span>
            </div>
        </div>

        <div class="control-group">
            <label for="commissionRate" class="control-label"><em class="rqd">*</em>佣金率：</label>
            <div class="controls">
                <input type="text" id="commissionRate" name="commissionRate" value="${amsTradeFeeTemplate.commissionRate}" onfocus="importName1(this)"
                       onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入佣金率</span>
            </div>
        </div>

        <div class="control-group">
            <label for="minimumCommission" class="control-label"><em class="rqd">*</em>最小佣金额：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="minimumCommission" name="minimumCommission" onfocus="importName1(this)"
                       onblur="importName2(this)" value="${amsTradeFeeTemplate.minimumCommission}">
                <span class="tipsError">请输入最小佣金额</span>
            </div>
        </div>

        <div class="control-group">
            <label for="transferFeeRate" class="control-label"><em class="rqd">*</em>过户费率(%)：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="transferFeeRate" name="transferFeeRate" onfocus="importName1(this)"
                       onblur="importName2(this)" value="${amsTradeFeeTemplate.transferFeeRate}">
                <span class="tipsError">请输入过户费率(%)</span>
            </div>
        </div>

        <div class="control-group">
            <label for="minimumChargeCount" class="control-label"><em class="rqd">*</em>计算过户费用最小量：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="minimumChargeCount" name="minimumChargeCount" onfocus="importName1(this)"
                       onblur="importName2(this)" value="${amsTradeFeeTemplate.minimumChargeCount}">
                <span class="tipsError">计算过户费用最小量</span>
            </div>
        </div>
        <div class="control-group">
            <label for="buyStampDutyRate" class="control-label"><em class="rqd">*</em>买入印花税率(%)：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="buyStampDutyRate" name="buyStampDutyRate" onfocus="importName1(this)"
                       onblur="importName2(this)" value="${amsTradeFeeTemplate.buyStampDutyRate}">
                <span class="tipsError">买入印花税率(%)</span>
            </div>
        </div>
        <div class="control-group">
            <label for="sellStampDutyRate" class="control-label"><em class="rqd">*</em>买入印花税率(%)：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="sellStampDutyRate" name="sellStampDutyRate" onfocus="importName1(this)"
                       onblur="importName2(this)" value="${amsTradeFeeTemplate.sellStampDutyRate}">
                <span class="tipsError">卖出印花税率(%)</span>
            </div>
        </div>
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
    </form>
</div>
<script>
    $("select").select2({
        minimumResultsForSearch: -1
    });
    //下拉框选择
    $("#platform_add").select2({
        minimumResultsForSearch: -1
    });
    //    function a(){
    //        alert(1)
    //    }
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
            url: '${basePath}/feeTemplate/save',
            data: $('#addForm').serialize(),
            success: function (data) {
                console.info(data);
                console.log(data.message);
                if (data.code == '1') {
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                    window.parent.refresh();
                }
            },
            error: function () {
                alert("error");
            }
        });
    });
</script>
</body>
</html>
