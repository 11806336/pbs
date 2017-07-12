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
<div id="main" style="padding:10px 20px;">
    <div class="block" id="tradeServerBlack" style="width: 500px;float: left;">
        <a href="javascript:void(0);" class="block-heading">黑名单</a>
        <div class="block-body">
            <div class="container" style="float:left;width:100px;">
                <div id="code1" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加</h3>
                    </div>
                    <div class="modal-body">
                        <input type="text" id="" name="" placeholder="请输入市场">
                        <input type="text" id="" name="" placeholder="请输入证券代码">
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success">提交</a>
                        <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#code" class="btn">添加代码</a></p>
            </div>

            <div class="container" style="float:left;width:100px;">
                <div id="cat" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加</h3>
                    </div>
                    <div class="modal-body">
                        <select id="tradePlatformSearch" name="tradePlatformSearch">
                            <option value=""> -- 所有证券 --</option>
                            <option value="1">沪深A股</option>
                            <option value="2">上海A</option>
                            <option value="6">深圳A</option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success">提交</a>
                        <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#cat" class="btn">添加分类</a></p>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add"> 全部删除</a>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add"> 批量上传</a>
            </div>
            <table class="table font12 table-bordered alignCenter table-condensed" id="tradeServerTable">
                <thead class="table-heading">
                <tr>
                    <th width="80">序号</th>
                    <th width="80">类别</th>
                    <th width="80">代码/名称</th>
                    <th width="80">是否全局</th>
                    <th width="80">操作</th>
                </tr>
                <tr>
                   <c:forEach items="amsStockBlackWhiteList" var="amsStockBlackWhite">
                       <td>${amsStockBlackWhite.blackWhiteId}</td>
                   </c:forEach>
                </tr>

                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <div style="clear: both;"></div>
    <div class="block" id="tradeServerDiv" style="width: 500px;float: left;">
        <a href="javascript:void(0);" class="block-heading">白名单</a>
        <div class="block-body">
            <!--添加代码dialog-->
            <div class="container" style="float:left;width:100px;">
                <div id="code" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加代码</h3>
                    </div>
                    <div class="modal-body">
                        <input type="text" id="" name="" placeholder="请输入市场">
                        <input type="text" id="" name="" placeholder="请输入证券代码">
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success">提交</a>
                        <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#code" class="btn">添加代码</a></p>
            </div>
            <!--添加分类dialog-->
            <div class="container" style="float:left;width:100px;">
                <div id="cat" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加分类</h3>
                    </div>
                    <div class="modal-body">
                        <select id="tradePlatformSearch" name="tradePlatformSearch">
                            <option value=""> -- 所有证券 --</option>
                            <option value="1">沪深A股</option>
                            <option value="2">上海A</option>
                            <option value="6">深圳A</option>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success">提交</a>
                        <a href="#" class="btn" data-dismiss="modal">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#cat" class="btn">添加分类</a></p>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add"> 全部删除</a>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add"> 批量上传</a>
            </div>
            <table class="table font12 table-bordered alignCenter table-condensed" id="tradeServerTable">
                <thead class="table-heading">
                <tr>
                    <th width="80">序号</th>
                    <th width="80">类别</th>
                    <th width="80">代码/名称</th>
                    <th width="80">是否全局</th>
                    <th width="80">操作</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <div style="clear: both;">
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提交 ">
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 导出黑白名单 ">
    </div>
</div>
</body>
</html>