<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>丰缘管理系统 - 顺丰速运集团</title>
    <%@include file="../header.jsp" %>
</head>
<body>
<table id="function_tb" class="easyui-treegrid" treeField="funcName">
</table>
<div id="dlg" class="easyui-dialog"
     style="width: 500px; height: 250px; padding: 10px 30px;" title="添加功能"
     buttons="#dlg-buttons" closed="true">
    <form id="ff" action="../service/func/add" method="post">
        <table>
            <tr>
                <td>上级菜单:</td>
                <td><select class="easyui-combotree" id="add_select" url="../service/func/allTree"
                            name="parentId" style="width: 156px;"/></td>
            </tr>
            <tr>
                <td>功能名称:</td>
                <td><input type="text" name="funcName" style="width: 350px;"/></td>
            </tr>
            <tr>
                <td>功能路径:</td>
                <td><input type="text" name="url" style="width: 350px;"/></td>
            </tr>

        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok"
       onclick="addFunc()">确定</a> <a href="#" class="easyui-linkbutton"
                                     iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

<script type="text/javascript"
        src="<%=request.getContextPath()%>/js/admin/function.js">

    /**
     * 初始化界面
     */
    var dataGrid;
    var rowEditor = undefined;
    $(function () {

        hideDialog();

        dataGrid = $("#function_tb")
            .treegrid(
                {
                    url: "../service/func/all",// 加载的URL
                    idField: "id",
                    method: "GET",
                    treeField: "funcName",
                    pagination: false,// 显示分页
                    fit: true,// 自动补全
                    fitColumns: true,
                    singleSelect: true,
                    iconCls: "icon-save",// 图标
                    columns: [[ // 每个列具体内容
                        {
                            field: 'id',
                            title: '编号',
                            align: 'center',
                            width: 100,
                        },
                        {
                            field: 'funcName',
                            title: '功能名称',
                            align: 'center',
                            width: 100,
                            editor: 'text'
                        },
                        {
                            field: 'url',
                            title: '功能路径',
                            align: 'center',
                            width: 100,
                            editor: 'text'
                        },
                        {
                            field: 'createTm',
                            title: '创建时间',
                            align: 'center',
                            width: 100
                        },
                        {
                            field: 'modifiedTm',
                            title: '修改时间',
                            align: 'center',
                            width: 100
                        },
                        {
                            field: 'isDelete',
                            title: '是否禁用',
                            align: 'center',
                            width: 100,
                            editor: {
                                type: 'checkbox',
                                options: {
                                    on: '1',
                                    off: '0'
                                }
                            },
                            formatter: function (value, row, index) {
                                if (value == '0') {
                                    return '<span style="color:green">正常</span>';
                                } else {
                                    return '<span style="color:red">禁用</span>';
                                }
                            }
                        }]],
                    toolbar: [ // 工具条
                        {
                            text: "增加",
                            iconCls: "icon-add",
                            handler: function () {// 回调函数
                                openDialog();
                            }
                        },
                        {
                            text: "删除",
                            iconCls: "icon-remove",
                            handler: function () {
                                var rows = dataGrid
                                    .treegrid('getSelections');

                                if (rows.length <= 0) {
                                    $.messager.alert('警告', '您没有选择',
                                        'error');
                                } else if (rows.length > 1) {
                                    $.messager.alert('警告', '不支持批量删除',
                                        'error');
                                } else {
                                    $.messager
                                        .confirm(
                                            '确定',
                                            '您确定要删除吗',
                                            function (t) {
                                                if (t) {

                                                    $
                                                        .ajax({
                                                            url: '../service/func/del',
                                                            method: 'POST',
                                                            data: rows[0],
                                                            dataType: 'json',
                                                            success: function (r) {
                                                                if (r.code == "1") {
                                                                    dataGrid
                                                                        .treegrid('acceptChanges');
                                                                    $.messager
                                                                        .show({
                                                                            msg: r.msg,
                                                                            title: '成功'
                                                                        });
                                                                    editRow = undefined;
                                                                    dataGrid
                                                                        .treegrid('reload');
                                                                } else {
                                                                    dataGrid
                                                                        .treegrid(
                                                                            'beginEdit',
                                                                            editRow);
                                                                    $.messager
                                                                        .alert(
                                                                            '错误',
                                                                            r.msg,
                                                                            'error');
                                                                }
                                                                dataGrid
                                                                    .treegrid('unselectAll');
                                                            }
                                                        });

                                                }
                                            })
                                }

                            }
                        },
                        {
                            text: "修改",
                            iconCls: "icon-edit",
                            handler: function () {
                                var rows = dataGrid
                                    .treegrid('getSelections');
                                if (rows.length == 1) {
                                    if (rowEditor == undefined) {
                                        //var index = dataGrid.treegrid('getRowIndex', rows[0]);
                                        var index = rows[0].id;
                                        rowEditor = index;
                                        dataGrid.treegrid('unselectAll');
                                        dataGrid.treegrid('beginEdit',
                                            index);

                                    }
                                }
                            }
                        }, {
                            text: "保存",
                            iconCls: "icon-save",
                            handler: function () {
                                dataGrid.treegrid('endEdit', rowEditor);
                                rowEditor = undefined;
                            }
                        }, {
                            text: "取消编辑",
                            iconCls: "icon-redo",
                            handler: function () {
                                dataGrid.treegrid('cancelEdit', rowEditor);
                                rowEditor = undefined;
                            }
                        }],
                    onAfterEdit: function (rowIndex, rowData, changes) {
                        var inserted = dataGrid.treegrid('getChanges',
                            'inserted');
                        var updated = dataGrid.treegrid('getChanges',
                            'updated');
                        if (inserted.length < 1 && updated.length < 1) {
                            editRow = undefined;
                            dataGrid.treegrid('unselectAll');
                            return;
                        }

                        var url = '';
                        if (inserted.length > 0) {
                            url = '../service/func/add';
                        }
                        if (updated.length > 0) {
                            url = '../service/func/update';
                        }

                        $.ajax({
                            url: url,
                            method: "POST",
                            data: rowIndex,
                            dataType: 'json',
                            success: function (r) {
                                if (r.code == "1") {
                                    dataGrid
                                        .treegrid('acceptChanges');
                                    $.messager.show({
                                        msg: r.msg,
                                        title: '成功'
                                    });
                                    editRow = undefined;
                                    dataGrid.treegrid('reload');
                                } else {
                                    /* datagrid.treegrid('rejectChanges'); */
                                    dataGrid.treegrid('beginEdit',
                                        editRow);
                                    $.messager.alert('错误', r.msg,
                                        'error');
                                }
                                dataGrid.treegrid('unselectAll');
                            }
                        });

                    },
                    onDblClickCell: function (index, field, value) {
                        if (rowEditor == undefined) {
                            dataGrid.treegrid('beginEdit', field.id);
                            rowEditor = field.id;
                        }

                    }
                });
    });

    var editingId;

    function edit() {
        if (editingId != undefined) {
            dataGrid.treegrid('select', editingId);
            return;
        }
        var row = dataGrid.treegrid('getSelected');
        if (row) {
            editingId = row.id;
            dataGrid.treegrid('beginEdit', editingId);
        }
    }

    function save() {
        if (editingId != undefined) {
            var t = $("#function_tb");
            t.treegrid('endEdit', editingId);
            editingId = undefined;
            var persons = 0;
            var rows = t.treegrid('getChildren');
            for (var i = 0; i < rows.length; i++) {
                var p = parseInt(rows[i].persons);
                if (!isNaN(p)) {
                    persons += p;
                }
            }
            var frow = t.treegrid('getFooterRows')[0];
            frow.persons = persons;
            t.treegrid('reloadFooter');
        }
    }

    function cancel() {
        if (editingId != undefined) {
            dataGrid.treegrid('cancelEdit', editingId);
            editingId = undefined;
        }
    }

    function hideDialog() {
        $('#dlg').dialog('close');
    }

    function openDialog() {
        //$("#add_select").attr('url','../service/func/allTree');
        $('#add_select').combotree({
            url: '../service/func/allTree'
        });
        $('#dlg').dialog('open');
    }

    function addFunc() {
        $('#ff').form('submit', {
            url: '../service/func/add',
            success: function (data) {
                var r = JSON.parse(data);
                if (r.code == "1") {
                    $.messager.show({
                        msg: r.msg,
                        title: '成功'
                    });

                    hideDialog();
                    dataGrid
                        .treegrid('reload');
                } else {
                    $.messager.alert(
                        '错误',
                        r.msg,
                        'error');
                    hideDialog();
                    dataGrid
                        .treegrid('reload');
                }
            }
        });
    }


</script>
</body>
</html>