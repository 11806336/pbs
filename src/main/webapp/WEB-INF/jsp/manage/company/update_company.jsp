<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>更新公司</title>
    <link href="../../../../resources/pbs-admin/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="../../../../resources/pbs-admin/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="../../../../resources/pbs-admin/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="../../../../resources/pbs-admin/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="../../../../resources/pbs-admin/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../../../../resources/pbs-admin/plugins/My97DatePicker/skin/WdatePicker.css">

    <link rel="stylesheet" href="../../../../resources/pbs-admin/css/create_broker.css">
</head>
<body>
<div id="content">
    <div>
        <div class="control-group">
            <label for="company_name" class="control-label"><em class="rqd">*</em>公司名称：</label>
            <div class="controls">
                <input type="text" id="company_name" name="companyName" value="${company.companyName}" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入公司名称</span>
            </div>
        </div>

        <div class="control-group">
            <label for="operator_id" class="control-label"><em class="rqd">*</em>操作人ID：</label>
            <div class="controls">
                <input type="text" id="operator_id" name="operatorId" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" value="${company.operatorId}" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入操作人ID</span>
            </div>
        </div>

        <div class="control-group">
            <label for="company_phone" class="control-label"><em class="rqd">*</em>公司电话：</label>
            <div class="controls">
                <input type="text" id="company_phone" name="companyPhone" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" value="" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入公司电话</span>
            </div>
        </div>
        <div class="control-group">
            <label for="company_address" class="control-label"><em class="rqd">*</em>公司地址：</label>
            <div class="controls">
                <input type="text" id="company_address" name="companyAddress" value="${company.companyAddress}" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
                <span class="tipsError">请输入公司地址</span>
            </div>
        </div>
        <div class="control-group">
            <label for="company_fax" class="control-label">公司传真：</label>
            <div class="controls">
                <input type="text" maxlength="20" id="company_fax" name="companyFax" value="${company.companyFax}">
            </div>
        </div>
       <%-- <div class="control-group">
            <label for="create_time" class="control-label"><em class="rqd">*</em>创建时间：</label>
            <div class="controls">
                <input onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" name="createTime" value="2017-06-14" id="create_time" class="set_date">
            </div>
        </div>--%>
        <div class="control-group">
            <label class="control-label" for="comments">备注：</label>
            <div class="controls">
                <textarea id="comments" style="width:440px;" rows="10" cols="40" name="comments"></textarea>
                <span class="tips-warning"></span>
                <span class="tipsError"></span>
            </div>
        </div>
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
    </div>
</div>
<script src="../../../../resources/pbs-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="../../../../resources/pbs-admin/plugins/My97DatePicker/WdatePicker.js"></script>
<script>
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
    $(document).on("input","#company_name,#company_phone,#company_address,#operator_id",function () {
        if($(this).val()){
            $(this).next().hide();
        }else {
            $(this).next().show();
        }
    });
    //保存公司
    $(document).on("click","#saveBrokerBtn",function () {
        var company_name=$("#company_name").val(),//公司名称
            operator_id=$("#operator_id").val(),//操作人ID
            company_phone=$("#company_phone").val(),//公司电话
            company_address=$("#company_address").val(),//公司地址
            company_fax=$("#company_fax").val(),//公司传真
            comments=$("#comments").val();//备注
        if(company_name == "" || /^\s*$/g.test(company_name)){
            alert("请正确输入公司名称");
            return false;
        }
        if(operator_id == "" || /^\s*$/g.test(operator_id)){
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
        }
        $.ajax({
            type: 'POST',
            url: '${basePath}/company/update/10016' ,
            data: {
                "companyName":company_name,
                "operatorId":operator_id,
                "companyPhone":company_phone,
                "companyAddress":company_address,
                "companyFax":company_fax
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