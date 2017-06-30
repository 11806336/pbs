$(function() {
    // bootstrap table初始化
    $table.bootstrapTable({
        url:url_json,
        datatype:'json',
        height: getHeight(),
        striped: true,
        search: search,
        showRefresh: showRefresh,
        showColumns: showColumns,
        minimumCountColumns: 2,
        clickToSelect: true,
        detailView: true,
        detailFormatter: 'detailFormatter',
        pagination: true,
        paginationLoop: false,
        sidePagination: sidePagination,
        silentSort: false,
        smartDisplay: false,
        escape: true,
        searchOnEnterKey: true,
        idField: idField,
        maintainSelected: true,
        toolbar: '#toolbar',
        columns:dataColumns
    });
});

function getHeight() {
    return $(window).height() - 20;
}

// 格式化图标
function iconFormatter(value, row, index) {
    return '<i class="' + value + '"></i>';
}
// 格式化类型
function typeFormatter(value, row, index) {
    if (value == 1) {
        return '目录';
    }
    if (value == 2) {
        return '菜单';
    }
    if (value == 3) {
        return '按钮';
    }
    return '-';
}
// 格式化状态
function statusFormatter(value, row, index) {
    if (value == 1) {
        return '<span class="label label-success">正常</span>';
    } else {
        return '<span class="label label-default">锁定</span>';
    }
}
// 新增
var createDialog;
function createAction(url,title) {
    createDialog = $.dialog({
        animationSpeed: 300,
        title: title,
        content:url, /*/manage/permission/create'*/
        onContentReady: function () {
            initMaterialInput();
            $('select').select2();
        }
    });
}

// 编辑
var updateDialog;
function updateAction(obj,url) {
    var rows = $table.bootstrapTable('getSelections');
    //找到主键Id
    var Id=$(obj).parent().parent().find(".bs-checkbox ").find("input").val();
    var dataUpdate=$(obj).attr("data-update");
    //判断是表格内行后面的按钮还是右上角的编辑文字
    if(dataUpdate === "表格外"){
        if (rows.length != 1) {
            $.confirm({
                title: false,
                content: '请选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        } else {
            updateDialog = $.dialog({
                animationSpeed: 300,
                title: '编辑组织',
                content: url + rows[0].organizationId,
                onContentReady: function () {
                    initMaterialInput();
                    $('select').select2();
                    initType();
                    initSelect2();
                }
            });
        }
    }else{
        updateDialog = $.dialog({
            animationSpeed: 300,
            title: '编辑组织',
            content: url + Id,
            onContentReady: function () {
                initMaterialInput();
                $('select').select2();
                initType();
                initSelect2();
            }
        });
    }
}
// 删除
var deleteDialog;
function deleteAction(obj,url,dField) {
    // console.log(url);
    // console.log(dField);
    var rows = $table.bootstrapTable('getSelections');
    var Id = $(obj).parent().parent().find(".bs-checkbox ").find("input").val();
    // console.log(Id);
    var ids = new Array();//删除的数组
    //"判断单个删除还是批量删除
    var delete_type = $(obj).attr("data-deleteTpye");
    console.log(delete_type);
    if(delete_type === "批量删除"){
        if (rows.length == 0) {
            $.confirm({
                title: false,
                content: '请至少选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
            return false;
        }
        for (var i in rows) {
            ids.push(rows[i][dField]);
        }
    } else {
        ids.push(Id);
    }
    deleteDialog = $.confirm({
        type: 'red',
        animationSpeed: 300,
        title: false,
        content: '确认删除该系统吗？',
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    $.ajax({
                        type: 'get',
                        url:'${basePath}'+url+"/" + ids.join("-"),
                        success: function (result) {
                            if (result.code != 1) {
                                if (result.data instanceof Array) {
                                    $.each(result.data, function (index, value) {
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
                                        content: result.data.errorMsg,
                                        buttons: {
                                            confirm: {
                                                text: '确认',
                                                btnClass: 'waves-effect waves-button waves-light'
                                            }
                                        }
                                    });
                                }
                            } else {
                                deleteDialog.close();
                                $table.bootstrapTable('refresh');
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
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
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}

function dialog(url,title,id) {//调用弹窗，需要传标题和url
    layer.open({
        type: 2,
        title:title,
        area: ['700px', '430px'],
        fixed: false, //不固定
        maxmin: true,
        content: url+"/"+id
    });
}
/**共有的js文件
 * Created by Administrator on 2017/5/27.
 */
/*function new_deleteAction(obj) {
    var rows = $table.bootstrapTable('getSelections');
    var Id = $(obj).parent().parent().find(".bs-checkbox ").find("input").val();
    var ids = new Array();//删除的数组
    //"判断单个删除还是批量删除
    var delete_type = $(obj).attr("data-deleteType");
    if(delete_type === "batch"){
        for (var i in rows) {
            ids.push(rows[i].systemId);
        }
    } else {
        ids.push(Id);
    }
    deleteDialog = $.confirm({
        type: 'red',
        animationSpeed: 300,
        title: false,
        content: '确认删除该系统吗？',
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    $.ajax({
                        type: 'get',
                        url: '${basePath}/manage/system/delete/' + ids.join("-"),
                        success: function (result) {
                            if (result.code != 1) {
                                if (result.data instanceof Array) {
                                    $.each(result.data, function (index, value) {
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
                                        content: result.data.errorMsg,
                                        buttons: {
                                            confirm: {
                                                text: '确认',
                                                btnClass: 'waves-effect waves-button waves-light'
                                            }
                                        }
                                    });
                                }
                            } else {
                                deleteDialog.close();
                                $table.bootstrapTable('refresh');
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
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
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}*/
