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
        content: 'url:${basePath}'+url, /*/manage/permission/create'*/
        onContentReady: function () {
            initMaterialInput();
            $('select').select2();
        }
    });
}
// 编辑
var updateDialog;
function updateAction(url,title,id) {
    updateDialog = $.dialog({
        animationSpeed: 300,
        title: title,
        content: 'url:${basePath}'+url +"/"+ id,
        onContentReady: function () {
            initMaterialInput();
            $('select').select2();
            initType();
            initSelect2();
        }
    });
}
// 删除
var deleteDialog;
function deleteAction(url,ids) {
    var rows = $table.bootstrapTable('getSelections');
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
    } else {
        deleteDialog = $.confirm({
            type: 'red',
            animationSpeed: 300,
            title: false,
            content: '确认删除吗？',
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'waves-effect waves-button',
                    action: function () {
                        $.ajax({
                            type: 'get',
                            url: '${basePath}'+url+"/"+ ids.join("-"),  /*/manage/permission/delete*/
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
                },
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    }
}

/**共有的js文件
 * Created by Administrator on 2017/5/27.
 */
