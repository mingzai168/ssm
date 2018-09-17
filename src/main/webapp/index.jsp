<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;  charset=UTF-8" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>组织机构</title>
    <%--   ⑴ 引入EasyUI相关的js和css文件：--%>
    <script type="text/javascript" src="/scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">

</head>
<body>

<table id="tgTab" title="组织机构" class="easyui-treegrid" style="width:1080px;height:600px" ,
       data-options="url:'',idField:'id',treeField:'name',toolbar:'#tb',border:true">
    <%--  treeField：是指定那列要展示成树形  idField一般是指主键    --%>

    <thead>
    <tr>
        <th data-options="field:'name',width:160">机构名称</th>
        <th data-options="field:'type',width:100">机构类型</th>
        <th data-options="field:'code',width:100">机构编码</th>
        <th data-options="field:'principalId',width:100, align:'center' ">负责人</th>
        <th data-options="field:'path',width:100, align:'center' ">业务覆盖范围</th>
        <th data-options="field:'address',width:50, align:'center' ">地址</th>
        <th data-options="field:'phone',width:200, align:'center' ">电话号码</th>
        <th data-options="field:'postCode',width:200, align:'center' ">邮政编码</th>
        <th data-options="field:'fax',width:200, align:'center' ">传真号</th>
        <th field='createTime' align="center"
            data-options="formatter:function(value,row,index){return dateFormatter(value);}">创建时间
        </th>
        <%--  <th field='modifyTime'align="center" data-options="formatter:function(value,row,index){var unixTimestamp = new Date(value);
          commonTime = unixTimestamp.toLocaleString();return commonTime;  }">最后修改时间</th>--%>
        <th field='modifyTime' align="center"
            data-options="formatter:function(value,row,index){ return dateFormatter(value);}">最后修改时间
        </th>
    </tr>
    </thead>

<%--    <tbody>
    <c:forEach items="${pager.datas }" var="data">
        <tr>
            <td>${data.id }</td>
            <td>${data.name }</td>
            <td>${data.loginName }</td>
            <td>${data.password }</td>
            <td>${data.gender }</td>
            <td>${data.phoneNumber }</td>
            <td>${data.email }</td>
            <td>${data.description }</td>
        </tr>
    </c:forEach>
    </tbody>--%>
</table>

<span style="white-space:pre">	</span>
<div id="tb">
    <span style="white-space:pre">	</span><a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"
                                                plain="true" onclick="onAdd()">增加</a>
    <span style="white-space:pre">	</span><a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"
                                                plain="true" onclick="onUpdate()">编辑</a>
    <span style="white-space:pre">	</span><a href="javascript:void(0)" class="easyui-linkbutton"
                                                iconCls="icon-remove" plain="true" onclick="onDelete()">删除</a>
    <span style="white-space:pre">	</span>

    <div id="dd" style="display: none" align="center">

        <select id="cc" class="easyui-combobox" label="上级机构" style="width:300px; " align="center">
            <option>请选择...</option>
            <option>bitem2</option>
            <option>bitem3</option>
        </select></br>

        <select id="cc1" class="easyui-combobox" label="机构类型" style="width:300px; " align="center">
            <option></option>
            <option>bitem2</option>
            <option>bitem3</option>
        </select></br>

        <select id="cc2" class="easyui-combobox" label="负责人" style="width:300px; " align="center">
            <option></option>
            <option>bitem2</option>
            <option>bitem3</option>
        </select></br>

        <input class="easyui-textbox" data-options="" label="机构名称" style="width:300px"/></br>
        <input class="easyui-textbox" data-options="" label="地址" style="width:300px"/></br>
        <input class="easyui-textbox" data-options="" label="电话号码" style="width:300px"/></br>
        <input class="easyui-textbox" data-options="" label="邮政编码" style="width:300px"/></br>
        <input class="easyui-textbox" data-options="" label="传真号" style="width:300px"/></br>

        <input id="ss" class="easyui-numberspinner" label="排序" style="width:300px;"
               required="required" data-options="min:10,max:100,editable:false"/></br>


    </div>

</div>


<script type="text/javascript">

    var editingId;

    function onAdd() {
        // var selections = $("#tgTab").datagrid("getSelected");
        // alert(selections);
        $('#dd').dialog({
            title: '机构详细信息',
            width: 680,
            height: 420.24,
            closed: false,
            cache: false,
            closable: true,
            resizable: true,
            maximizable: true,

            buttons: [{
                text: '保存',
                handler: function () {
                    alert("怎么保存！");
                    $("#dd").dialog("close");
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#dd").dialog("close");
                }
            }],
            //href: 'get_content.php',
            modal: true
        });
        //$('#dd').dialog('refresh', 'new_content.php');
    }

    function onDelete() {
        //修改默认按钮的文本值
        $.messager.defaults = {ok: "确认", cancel: "取消"};
        //获取单行数据
        var row = $('#tgTab').treegrid('getSelected');

        //title, msg, fn
        if (row != null) {
            $.messager.confirm('确认提示！', '您确认删除该机构吗？删除后其子机构将被一起删除。', function (r) {
                if (r) {
                    //删除部门信息
                    alert(row);
                    $('#tgTab').treegrid('reload');
                } else {
                    alert("能不能给我一首歌的时间去思考？");
                }
            });
        } else {
            alert("请选中要删除的机构");
        }
    }


    function onUpdate() {
        alert("准备保存更新，烦请等待！");
    }


    $(function () {
        $('#tgTab').treegrid({
            iconCls: 'icon-ok',
            rownumbers: true,   //可自动在表格前面添加序号
            animate: true,  //  定义在展开和折叠的时候是否显示动画效果。
            minimizable: true,
            maximizable: true,
            //collapsible: true, 如果设置为true将显示折叠按钮。
            closable: true,
            striped: true,       //隔行变色,修改easyi.css中.datagrid-row-alt样式
            fitColumns: true,  //设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
            loadMsg: "Loading...",
            url: 'List',
            idField: 'id',      //定义关键字段来标识树节点
            treeField: 'name',   //treeField属性定义哪个字段显示为树形菜单
            pageSize: 5,
            pageList: [5, 10, 20],
            pagination: true
        });
        /*.treegrid('clientPaging');    进度条 */
    });

    /**
     * 方法一
     * 时间格式化
     * @param value
     * @returns {string}
     */
    function dateFormatter(value) {
        var date = new Date(value);
        var year = date.getFullYear().toString();
        var month = (date.getMonth() + 1);
        var day = date.getDate().toString();
        var hour = date.getHours().toString();
        var minutes = date.getMinutes().toString();
        var seconds = date.getSeconds().toString();
        if (month < 10) {
            month = "0" + month;
        }
        if (day < 10) {
            day = "0" + day;
        }
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        if (seconds < 10) {
            seconds = "0" + seconds;
        }
        return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    }




</script>


</body>
</html>