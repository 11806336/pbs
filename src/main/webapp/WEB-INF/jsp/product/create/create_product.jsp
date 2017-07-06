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
    <title>新建产品</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/plugins/My97DatePicker/skin/WdatePicker.css">
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">
<form id="create_form">
    <div class="control-group">
        <label for="productName" class="control-label"><em class="rqd">*</em>产品名称：</label>
        <div class="controls">
            <input type="text" id="productName" name="productName" value="" onblur="funBlur(this)" maxlength="25">
            <span class="tipsError">请输入产品名称</span>
            <span class="tipsError">保存后不可更改</span>
        </div>
    </div>
    <div class="control-group">
        <label for="companyList" class="control-label"><em class="rqd">*</em>经纪公司：</label>
        <div class="controls">
            <select name="companyId" id="companyList">
                <option value="0"> ---请选择--- </option>
                <c:forEach var="comp" items="${upmsCompanies}">
                    <option value="${comp.companyId}">${comp.companyName}</option>
                </c:forEach>
            </select>
            <span class="tipsError">保存后不可更改</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="productType"><em class="rqd">*</em>产品类型：</label>
        <div class="controls">
            <label class="radio inline" style="min-width:60px;">
                <input checked="checked" type="radio" name="productType" id="productType" value="1"> 普通基金
            </label>
            <label class="radio inline" style="min-width:60px;">
                <input type="radio" name="productType" value="2"> 分级基金
            </label>
            <span class="tipsError">保存后不可更改</span>
        </div>
    </div>
    <div class="control-group">
        <label for="productCode" class="control-label"><em class="rqd">*</em>产品代码：</label>
        <div class="controls">
            <input type="text" id="productCode" name="productCode" value="" onblur="funBlur(this)">
            <span class="tipsError">请输入产品代码</span>
            <span class="tipsError">保存后不可更改</span>
        </div>
    </div>
    <div class="control-group">
        <label for="productSupervisor" class="control-label">产品管理人：</label>
        <div class="controls">
            <input type="text" id="productSupervisor" name="productSupervisor" value="" onblur="funBlur(this)" maxlength="25">
            <span class="tipsError">请输入产品管理人</span>
        </div>
    </div>
    <div class="control-group">
        <label for="productManager" class="control-label">产品经理：</label>
        <div class="controls">
            <input type="text" id="productManager" name="productManager" value="" onblur="funBlur(this)" maxlength="25">
            <span class="tipsError">请输入产品经理</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label">产品起止日期：</label>
        <input onfocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" type="text" name="startDate" value="" id="startDate" class="required">
        <span for="startDate" class="error"></span>
        <span style="display: inline-block;margin:0 10px;">至</span>
        <input onfocus="WdatePicker({dateFmt:'yyyyMMddHHmmss'})" type="text" name="endDate" id="endDate" class="required" onblur="funBlur(this)">
        <span for="endDate" class="tipsError">起始日期不能大于结束日期</span>
        <span class="tipsError">(修改需重启服务生效)</span>
    </div>
    <div class="control-group">
        <label class="control-label" for="productShareSource">产品总份额来源：</label>
        <div class="controls">
            <label class="radio inline" style="min-width:60px;">
                <input class="productShareSource" checked="checked" type="radio" name="productShareSource" id="productShareSource" value="1">自定义
            </label>
            <label class="radio inline" style="min-width:60px;">
                <input class="productShareSource" type="radio" name="productShareSource" id="productShareSource" value="2"> O32读取
            </label>
            <br>
        </div>
    </div>

    <div class="control-group radioShow" id="custom" style="display: block;">
        <label class="control-label" for="productShares">产品总份额：</label>
        <div class="controls">
            <input type="text" name="productShares" value="0.000" id="productShares" class="" maxlength="17">
            <span for="productShares" class="error">小数位数不能超过 3 位!</span>
            <span class="tipsError"></span>
        </div>
    </div>

    <div class="control-group radioShow" id="read" style="display: none;">
        <label class="control-label" for="o32_id">O32 ID：</label>
        <div class="controls">
            <input type="text" name="o32Id" id="o32_id" class="" maxlength="10">
            <span class="tipsError"></span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="productStatus"><em class="rqd">*</em>产品状态：</label>
        <div class="controls">
            <label class="radio inline" style="min-width:60px;">
                <input checked="checked" type="radio" name="productStatus" id="productStatus" value="1"> 启用
            </label>
            <label class="radio inline" style="min-width:60px;">
                <input type="radio" name="productStatus" id="productStatus" value="0"> 禁用
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="productDesc">备注：</label>
        <div class="controls">
            <textarea id="productDesc" style="width:440px;" rows="10" cols="40" name="productDesc"></textarea>
            <span class="tips-warning"></span>
            <span class="tipsError"></span>
        </div>
    </div>
    <input type="button" class="btn btn-info" onclick="submitForm()" value="提交"/>
</form>
</div>
<script src="${basePath}/resources/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/plugins/My97DatePicker/WdatePicker.js"></script>
<script>

    //提示
    function funBlur(obj) {
        if (!$(obj).val()) {
            $(obj).next().show();
        }
    }
    //实时监控input框
    $(document).on("input", "input", function () {
        if ($(this).val()) {
            $(this).next().hide();
        } else {
            $(this).next().show();
        }
    });
    //单选按钮
    $(document).on("change", ".productShareSource", function () {
        var val = $("input[name='productShareSource']:checked").val();
        $(".radioShow").hide();
        if (val == 1) {
            $("#custom").show();
        } else {
            $("#read").show();
        }
    });

    function submitForm(){
        var create_form = $("#create_form");
        $.ajax({
            type: 'POST',
            url: '${basePath}/product/create',
            data: create_form.serialize(),
            ContentType: 'application/json',
            success: function (data) {
                if (data.message == 'success') {
                    alert("保存成功！");
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                }
            } ,
            error: function () {
                alert("保存失败！");
            }

        });
    }
</script>
</body>
</html>