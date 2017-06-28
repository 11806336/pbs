<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账号</title>
    <link href="../../../resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="../../../resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="../../../resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="../../../resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="../../../resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../../../resources/css/common.css">
</head>
<body>
<div id="main">
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
        </div>
    </div>
    <div class="control-group">
        <label for="platform_add" class="control-label"><em class="rqd">*</em>证券公司：</label>
        <div class="controls">
            <select name="broker_add" id="broker_add">
                <option value="">---请选择---</option>
                <option value="1" text="测试公司1">测试公司1</option>
                <option value="2" text="测试公司2">测试公司2</option>
                <option value="3" text="测试公司3">测试公司3</option>
                <option value="4" text="测试公司4">测试公司4</option>
            </select>
        </div>
    </div>

    <div class="control-group">
        <label for="name" class="control-label"><em class="rqd">*</em>资金账号：</label>
        <div class="controls">
            <input type="text" id="name" name="name" value="" onblur="" maxlength="25"><span class="tipsError"
                                                                                             style="display: none; padding-left: 10px">请输入账号</span>
        </div>
    </div>

    <div class="control-group">
        <label for="password" class="control-label"><em class="rqd">*</em>密码：</label>
        <div class="controls">
            <input type="password" maxlength="8" id="password" name="password" value=""> <span class="tipsError"
                                                                                               style="display: none; padding-left: 10px">请输入长度超过8位的字符串</span>
        </div>
    </div>

    <div class="control-group">
        <label for="password_check" class="control-label">确认密码：</label>
        <div class="controls">
            <input type="password" maxlength="20" id="password_check" name="password_check" value=""> <span
                class="tipsError" style="display: none; padding-left: 10px">请输入长度超过8位的字符串</span>
        </div>
    </div>
    <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提 交 ">
</div>
<script src="../../../resources/plugins/jquery.1.12.4.min.js"></script>
<script src="../../../resources/plugins/select2/js/select2.min.js"></script>
<script>
    //下拉框选择
    $("select").select2({
        minimumResultsForSearch: -1
    });
</script>
</body>
</html>