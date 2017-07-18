<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>创建公司</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/plugins/My97DatePicker/skin/WdatePicker.css">
    <link rel="stylesheet" href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css">

    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">
    <div class="control-group">
        <label for="company_name" class="control-label"><em class="rqd">*</em>公司名称：</label>
        <div class="controls">
            <input type="text" id="company_name" name="companyName" value="${company.companyName}" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
            <span class="tipsError">请输入公司名称</span>
        </div>
    </div>

    <%--<div class="control-group">
        <label for="operator_id" class="control-label"><em class="rqd">*</em>操作人ID：</label>
        <div class="controls">
            <input type="text" id="operator_id" name="operatorId" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');" value="${company.operatorId}" onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
            <span class="tipsError">请输入操作人ID</span>
        </div>
    </div>--%>

    <div class="control-group">
        <label for="manager_phone" class="control-label"><em class="rqd">*</em>负责人电话：</label>
        <div class="controls">
            <input type="text" id="manager_phone" name="managerPhone"   onfocus="importName1(this)" onblur="importName2(this)" maxlength="25">
            <span class="tipsError">请输入负责人电话</span>
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
<script src="${basePath}/resources/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/plugins/My97DatePicker/WdatePicker.js"></script>
<script src="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.js"></script>
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
    $(document).on("input","input",function () {
        if($(this).val()){
            $(this).next().hide();
        }else {
            $(this).next().show();
        }
    });
    //保存公司
    $(document).on("click","#saveBrokerBtn",function () {
        var company_name=$("#company_name").val();//公司名称
        var operator_id=$("#operator_id").val();//操作人ID
        var manager_phone=$("#manager_phone").val();//公司电话
        var company_address=$("#company_address").val();//公司地址
        var company_fax=$("#company_fax").val();//公司传真
        var description=$("#comments").val();//备注
        if(company_name == "" || /^\s*$/g.test(company_name)){
            alert("请正确输入公司名称");
            return false;
        }
        /*if(operator_id == "" || /^\s*$/g.test(operator_id)){
         alert("请正确输入操作人ID");
         return false;
         }*/
        if(!(/^1[34578]\d{9}$/.test(manager_phone))){
            alert("请正确输入负责人电话");
            return false;
        }
        if(company_fax == "" || /^\s*$/g.test(company_fax)){
            alert("请正确输入公司传真");
            return false;
        }
        $.ajax({
            type: 'POST',
            url: '${basePath}/company/create' ,
            data: {
                "companyName":company_name,
                "operatorId":operator_id,
                "managerPhone":manager_phone,
                "companyAddress":company_address,
                "companyFax":company_fax,
                "description":description
            } ,
            success: function (data) {
                if (data.code == '1') {
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                    parent.bootstrapTable('refresh');
                }
            } ,
            error: function () {
                alert("error");
            }

        });
    });
</script>
</body>
</html>