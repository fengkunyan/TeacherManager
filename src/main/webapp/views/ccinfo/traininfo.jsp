<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/31
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
</head>
<body>


<table id="dg" class="easyui-datagrid" title="出差信息"  style="..."
       data-options="nowrap:true,striped:true,singleSelect:true,url:'/ccinfo/list',method:'post',toolbar:'#tb',pagination:true,
				pageSize:10" >
    <thead>
    <tr>
        <th data-options="field:'infoId',width:80">ID</th>
        <th data-options="field:'title',width:100 ,align:'center'">标题</th>
        <th data-options="field:'createTime',width:250,align:'center',formatter:formatDate">创建日期</th>
        <th data-options="field:'action',formatter:operateFormatter,width:180">操作</th>
    </tr>
    </thead>
</table>
<div id="tb" style="font-size: large">
    开始日期: <input class="easyui-datebox" style="font-size: large">
    结束日期: <input class="easyui-datebox" style="font-size: large">
    <button type="button" class="layui-btn layui-btn-primar layui-btn-sm layui-btn-normal"  onclick="opedAddDialog()"><i class="layui-icon layui-icon-search">查询</i></button>


    <p>
        <button type="button" class="layui-btn layui-btn-primar layui-btn-sm"  onclick="openAdd()"><i class="layui-icon layui-icon-add-1">增加</i></button>
        <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" onclick="deleteRows()"><i class="layui-icon layui-icon-delete">删除</i></button>
    </p>
</div>

<div id="win"></div>
</body>
<script type="text/javascript">


    var option={
        createUrl:"/ccinfo/add",
        updateUrl:"/ccinfo/edit/{id}",
        remove:"/ccinfo/delete/{id}",
        modalTitle:"信息",
    }

    function operateFormatter(value, row, index) {
        var htmlstr = '<button class="layui-btn layui-btn-xs" onclick="openEditDiag(\'' + row.userId + '\')">编辑</button>';
        htmlstr += '<button class="layui-btn layui-btn-xs layui-btn-danger" onclick="deleteRow(\'' + row.userId + '\')">删除</button>';
        return htmlstr;

    }

    function formatDate(value,row,index){
        return $.common.formatDate(value);
    }

   function  del() {
       var row=$("#dg").datagrid('getSelected');

       var uri="/ccinfo/del/"+row.infoId;

       $.ajax(
           {url:uri,
            type:"delete",
            success:function (result) {
               alert("删除成功");
               $("#dg").datagrid("reload");

            }
           }
       )
   }

</script>
<script type="text/javascript" src="${staticPath }/js/train/main.js"></script>
</html>
