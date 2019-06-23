<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/5
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %></head>
<body>

<form class="layui-form" id="form-ccinfo-add" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">正文</label>
        <div class="layui-input-block">
            <input type="text" name="content" lay-verify="required" lay-reqtext="正文必须填" placeholder="请输入正文" autocomplete="off" class="layui-input">
        </div>
    </div>

</form>
<script>
    uri="/ccinfo/add";
    function submitHandler(){
            var data = $("#form-ccinfo-add").serializeArray();
        var config = {
            url:uri ,
            type: "post",
            dataType: "json",
            data: data,
            success: function(result) {
               var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                parent.$("#dg").datagrid("reload");

            }
        };
        $.ajax(config);
            //alert(data);
           // saveTab(prefix + "/add", data);
    }
</script>
</body>
</html>
