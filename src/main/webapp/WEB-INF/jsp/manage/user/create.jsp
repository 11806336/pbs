﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="createDialog" class="crudDialog">
	<form id="createForm" method="post">
		<div class="control-group">
			<label for="companyId" class="control-label control-label2"><em class="rqd">*</em>所属公司：</label>
			<div class="controls">
				<select name="companyId" id="companyId">
					<option value="0">---请选择---</option>
					<c:forEach var="company" items="${upmsCompanies}">
						<option value="${company.companyId}">${company.companyName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label for="product_id" class="control-label control-label2"><em class="rqd">*</em>关联产品：</label>
			<div class="controls">
				<select name="productId" id="product_id">
					<option value="0">---请选择---</option>
					<c:forEach var="product" items="${products}">
						<option value="${product.product_id}">${product.product_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="username">帐号</label>
			<input id="username" type="text" class="form-control" name="username" onfocus="importName1(this)"
				   onblur="importName2(this)"  maxlength="20">
			<span class="tipsError">请输入账号</span>
		</div>
		<div class="form-group">
			<label for="password">密码</label>
			<input id="password" type="text" class="form-control" name="password" onfocus="importName1(this)"
				   onblur="importName3(this)"  maxlength="20">
			<span class="tipsError">密码不能小于5个字符</span>
		</div>
		<div class="form-group">
			<label for="realname">姓名</label>
			<input id="realname" type="text" class="form-control" name="realname" maxlength="20">
		</div>
		<%--<div class="form-group">--%>
			<%--<label for="avatar">头像</label>--%>
			<%--<input id="avatar" type="text" class="form-control" name="avatar" maxlength="50">--%>
		<%--</div>--%>
		<div class="form-group">
			<label for="phone">电话</label>
			<input id="phone" type="text" class="form-control" name="phone" maxlength="20">
		</div>
		<div class="form-group">
			<label for="email">邮箱</label>
			<input id="email" type="text" class="form-control" name="email" maxlength="50">
		</div>
		<div class="radio">
			<div class="radio radio-inline radio-info">
				<input id="sex_1" type="radio" name="sex" value="1" checked>
				<label for="sex_1">男 </label>
			</div>
			<div class="radio radio-inline radio-danger">
				<input id="sex_0" type="radio" name="sex" value="0">
				<label for="sex_0">女 </label>
			</div>
			<div class="radio radio-inline radio-success">
				<input id="locked_0" type="radio" name="locked" value="0" checked>
				<label for="locked_0">正常 </label>
			</div>
			<div class="radio radio-inline">
				<input id="locked_1" type="radio" name="locked" value="1">
				<label for="locked_1">锁定 </label>
			</div>
		</div>
		<div class="form-group text-right dialog-buttons">
			<a class="waves-effect waves-button" href="javascript:;" onclick="createSubmit();">保存</a>
			<a class="waves-effect waves-button" href="javascript:;" onclick="createDialog.close();">取消</a>
		</div>
	</form>
</div>
<script>
function createSubmit() {
    $.ajax({
        type: 'post',
        url: '${basePath}/manage/user/create',
        data: $('#createForm').serialize(),
        beforeSend: function() {
            if ($('#username').val() == ''
				&& $('#password').val() == '') {
                $('#username').focus();
                $('#password').focus();
                return false;
            }
            if ($('#password').val().length < 5) {
                $('#password').focus();
                return false;
            }
        },
        success: function(result) {
			if (result.code != 1) {
				if (result.data instanceof Array) {
					$.each(result.data, function(index, value) {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: value.errorMsg,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
					});
				} else {
						$.confirm({
							theme: 'dark',
							animation: 'rotateX',
							closeAnimation: 'rotateX',
							title: false,
							content: result.data,
							buttons: {
								confirm: {
									text: '确认',
									btnClass: 'waves-effect waves-button waves-light'
								}
							}
						});
				}
			} else {
				createDialog.close();
				$table.bootstrapTable('refresh');
			}
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
			$.confirm({
				theme: 'dark',
				animation: 'rotateX',
				closeAnimation: 'rotateX',
				title: false,
				content: textStatus,
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'waves-effect waves-button waves-light'
					}
				}
			});
        }
    });
}
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
function importName3(obj) {
    if ($(obj).val().length > 5) {
        $(obj).next().hide();
    }
}
</script>