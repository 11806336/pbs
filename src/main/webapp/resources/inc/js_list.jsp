<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<script>var BASE_PATH = '${basePath}';</script>
<script src="${basePath}/resources/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/resources/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${basePath}/resources/plugins/waves-0.7.5/waves.min.js"></script
<script src="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<script src="${basePath}/resources/plugins/select2/js/select2.min.js"></script>
<script src="${basePath}/resources/plugins/layer/js/layer.js"></script>

<!--选择时间-->
<script src="${basePath}/resources/plugins/My97DatePicker/WdatePicker.js"></script>

<script src="${basePath}/resources/js/common.js"></script>
<script src="${basePath}/resources/js/public.js"></script>

