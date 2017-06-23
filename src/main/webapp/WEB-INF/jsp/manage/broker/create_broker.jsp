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
    <title>经纪公司</title>
    <link href="${basePath}/resources/pbs-admin/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/pbs-admin/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/pbs-admin/plugins/My97DatePicker/skin/WdatePicker.css">

    <link rel="stylesheet" href="${basePath}/resources/pbs-admin/css/create_broker.css">
    <script src="${basePath}/resources/pbs-admin/plugins/jquery.1.12.4.min.js"></script>
    <script src="${basePath}/resources/pbs-admin/plugins/select2/js/select2.min.js"></script>
    <script src="${basePath}/resources/pbs-admin/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="content">
    <div>
        <div class="control-group">
            <label for="platform_add" class="control-label"><em class="rqd">*</em>交易平台：</label>
            <div class="controls">
                <select name="platform_add" id="platform_add">
                    <option value="">---请选择---</option>
                    <option value="20001" text="CTP实盘">CTP实盘</option>
                    <option value="20002" text="恒生期货实盘">恒生期货实盘</option>
                    <option value="21001" text="CTP模拟">CTP模拟</option>
                    <option value="21002" text="恒生期货模拟">恒生期货模拟</option>
                </select>
                <span for="platform_add" class="hint">请选择平台</span>
            </div>
        </div>

        <div class="control-group">
            <label for="brokerName" class="control-label"><em class="rqd">*</em>期货公司：</label>
            <div class="controls">
                <input type="text" id="brokerName" name="brokerName" value="" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入名称</span>
            </div>
        </div>

        <div class="control-group">
            <label for="brokerId" class="control-label"><em class="rqd">*</em>公司代码：</label>
            <div class="controls">
                <input type="text" maxlength="8" id="brokerId" name="brokerId" onfocus="importName1(this)" onblur="importName2(this)"  value="">
                <span class="tipsError">请输入代码</span>
            </div>
        </div>

        <div class="control-group">
            <label for="verificationCode" class="control-label">客户端认证码：</label>
            <div class="controls">
                <input type="text" maxlength="20" id="verificationCode" name="verification" value="">
                <span class="tipsError" style="display: none; padding-left: 10px">请输入长度不超过20位的数字串</span>
            </div>
        </div>

        <div class="control-group ">
            <label  class="control-label">日盘启动时间：</label>
            <input type="text" name="day_startDate" id="day_startDate" readonly="readonly" onfocus="WdatePicker({dateFmt:'H:mm:ss', maxDate:'%y-%M-%d'});" value="08:30:00" style="background-color: #fff;cursor:pointer;margin-left: 20px">
            <span style="display: inline-block;margin:0 10px;">至</span>
            <input type="text" name="day_endDate" id="day_endDate" readonly="readonly" onfocus="WdatePicker({dateFmt:'H:mm:ss', maxDate:'%y-%M-%d'});" value="15:30:00" style="background-color: #fff;cursor:pointer">
            <span for="day_endDate" class="error" style="display: none;"></span>
        </div>

        <div class="control-group">
            <label  class="control-label">夜盘启动时间：</label>
            <input type="text" name="night_startDate" id="night_startDate" readonly="readonly" onfocus="WdatePicker({dateFmt:'H:mm:ss', maxDate:'%y-%M-%d'});" value="20:00:00" style="background-color: #fff;cursor:pointer;margin-left: 20px">
            <span style="display: inline-block;margin:0 10px;">至</span>
            <input type="text" name="night_endDate" id="night_endDate" readonly="readonly" onfocus="WdatePicker({dateFmt:'H:mm:ss', maxDate:'%y-%M-%d'});" value="01:00:00" style="background-color: #fff;cursor:pointer">
            <span for="night_endDate" class="error" style="display: none;"></span>
        </div>
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
    </div>
</div>

<script>
    //下拉框选择
    $("#platform_add").select2({
        minimumResultsForSearch: -1
    });
    //选择交易平台，提示
    $(document).on("change","#platform_add",function () {
        if($(this).val()){
            $(".hint").hide();
        }else{
            $(".hint").show();
        }
    });
    $(document).on("click","#select2-platform_add-container",function () {
        if(!$("#platform_add").val()) {
            $(".hint").show();
        }
    });
    function importName1(obj) {
        if(!$(obj).val()){
            $(obj).next().show();
        }
    }
    function importName2(obj) {
        if($(obj).val()){
            $(obj).next().hide();
        }
    }
    //实时监控input框
    $(document).on("input","#brokerName,#brokerId",function () {
        if($(this).val()){
            $(this).next().hide();
        }else {
            $(this).next().show();
        }
    });

    //保存公司
    $(document).on("click","#saveBrokerBtn",function () {
        var platform_add=$("#platform_add").val(),//平台ID
            brokerName=$("#brokerName").val(),//期货公司
            brokerId=$("#brokerId").val(),//公司代码
            verification=$("#verification").val(),//客户端认证码
            day_startDate=$("#day_startDate").val(),//日盘启动时间
            night_startDate=$("#night_startDate").val();//夜盘启动时间
        /*if(platform_add == ""){
            alert("请正确输入公司名称");
            return false;
        }
        if(broker_name == ""){
            alert("请正确输入操作人ID");
            return false;
        }
        if(!/^\d{3,4}\-\d{7,8}$/.test(company_phone)){
            alert("请正确输入公司电话");
            return false;
        }
        if(company_fax == "" || /^\s*$/g.test(company_fax)){
            alert("请正确输入公司传真");
            return false;
        }*/
        $.ajax({
            type: 'POST',
            url: '${basePath}/ams/broker/create' ,
            data: {
                "brokerName":brokerName,
                "brokerId":brokerId,
                "dayStartDate":day_startDate,
                "nightStartDate":night_startDate
            } ,
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
