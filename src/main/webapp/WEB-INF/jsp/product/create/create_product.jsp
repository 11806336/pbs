<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新建产品</title>
    <jsp:include page="${basePath}/resources/inc/head.jsp" flush="true"/>

</head>
<body>
<div id="main">
<form>
    <div class="control-group">
        <label for="productName" class="control-label"><em class="rqd">*</em>产品名称：</label>
        <div class="controls">
            <input type="text" id="productName" name="productName" value="" onblur="funBlur(this)" maxlength="25">
            <span class="tipsError">请输入产品名称</span>
            <span class="tipsError" style="display: inline-block;">保存后不可更改</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="productType"><em class="rqd">*</em>产品类型：</label>
        <input type="hidden" id="productType" name="productType" value="1">
        <div class="controls">
            <label class="radio inline" style="min-width:60px;">
                <input checked="checked" type="radio" name="types" value="1"> 普通基金
            </label>
            <label class="radio inline" style="min-width:60px;">
                <input type="radio" name="types" value="2"> 分级基金
            </label>
            <span class="tipsError" style="display: inline-block;top:4px;">保存后不可更改</span>
        </div>
    </div>
    <div class="control-group">
        <label for="productCode" class="control-label"><em class="rqd">*</em>产品代码：</label>
        <div class="controls">
            <input type="text" id="productCode" name="productCode" value="" onblur="funBlur(this)">
            <span class="tipsError">请输入产品代码</span>
            <span class="tipsError" style="display: inline-block;">保存后不可更改</span>
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
        <input onfocus="WdatePicker({dateFmt:'yyyyMMddHHmmssSSS'})" type="text" name="startDate" value="" id="startDate" class="required">
        <span for="startDate" class="error" style="display: none;"></span>
        <span style="display: inline-block;margin:0 10px;">至</span>
        <input onfocus="WdatePicker({dateFmt:'yyyyMMddHHmmssSSS'})" type="text" name="endDate" id="endDate" class="required" onblur="funBlur(this)">
        <span for="endDate" class="tipsError">起始日期不能大于结束日期</span>
        <span class="tipsError" style="display: inline-block;">(修改需重启服务生效)</span>
    </div>
    <div class="control-group">
        <label class="control-label" for="productSharesSource">产品总份额来源：</label>
        <input type="hidden" id="productSharesSource" name="productSharesSource" value="1">
        <div class="controls">
            <label class="radio inline" style="min-width:60px;">
                <input class="productSharesSource" checked="checked" type="radio" name="productSharesSource" value="1">自定义
            </label>
            <label class="radio inline" style="min-width:60px;">
                <input class="productSharesSource" type="radio" name="productSharesSource" value="2"> O32读取
            </label>
            <br>
        </div>
    </div>

    <div class="control-group radioShow" id="custom" style="display: block;">
        <label class="control-label" for="productShares">产品总份额：</label>
        <div class="controls">
            <input type="text" name="productShares" value="0.000" id="productShares" class="" maxlength="17">
            <span for="productShares" class="error" style="display: none;">小数位数不能超过 3 位!</span>
            <span class="tipsError"></span>
        </div>
    </div>

    <div class="control-group radioShow" id="read" style="display: none;">
        <label class="control-label" for="o32_id">O32 ID：</label>
        <div class="controls">
            <input type="text" name="o32_id" id="o32_id" class="" maxlength="10">
            <span class="tipsError"></span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="desc">备注：</label>
        <div class="controls">
            <textarea id="desc" style="width:440px;" rows="10" cols="40" name="desc"></textarea>
            <span class="tips-warning"></span>
            <span class="tipsError"></span>
        </div>
    </div>
    <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
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
    $(document).on("change", ".productSharesSource", function () {
        var val = $("input[name='productSharesSource']:checked").val();
        $(".radioShow").hide();
        if (val == 1) {
            $("#custom").show();
        } else {
            $("#read").show();
        }
    });
</script>
</body>
</html>