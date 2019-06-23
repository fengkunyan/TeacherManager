<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>教工出差管理系统</title>
    <%@ include file="/commons/basejs.jsp" %>
    <script type="text/javascript">
        function openTab(text, url, iconCls) {
            if($("#tabs").tabs("exists", text)) {
                //如果已经存在，则使之处于选中的状态
                $("#tabs").tabs("select", text);
            } else {
                //如果不存在则新增加一个
                var content = "<iframe id='iframe' frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
                $("#tabs").tabs("add", {
                    title: text, //标题
                    iconCls: iconCls, //图标
                    closable: true, //可以关闭
                    content: content //内容，内嵌一个 iframe！
                });
            }
        }
    </script>

</head>
<body class="easyui-layout">

<div region="north" style="height: 107px;overflow: hidden;background-color: #FFFFFF">
    <table style="padding: 5px" width="100%">
        <tr>
            <td width="50%">
                <img alt="logo" src="/images/logo.jpg" />
            </td>

        </tr>
    </table>
</div>

<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-help'">
            <iframe id="iframe" frameborder="0" scrolling="auto" style="width:100%;height:100%" src="${staticPath}/ccinfo/">

            </iframe>

        </div>
    </div>
</div>

<div region="west" style="width: 200px" title="教工出差管理系统-菜单" split="true">
    <div style="padding-top: 10px;padding-left: 10px;">
        <a href="javascript:openTab('用户管理','https://www.baidu.com','icon-useredit')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-useredit'" style="width: 150px;">用户管理</a>
        <a href="javascript:openTab('出差申请','https://www.360.cn','icon-ccsq')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ccsq'" style="width: 150px;">出差申请</a>
        <a href="javascript:openTab('出差结算','https://www.csdn.net','icon-ccjs')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ccjs'" style="width: 150px;">出差结算</a>
        <a href="javascript:openTab('出差信息','http://edu.51cto.com','icon-ccinfo')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ccinfo'" style="width: 150px;">出差信息</a>
        <a href="javascript:openTab('出差审批','http://www.people.com.cn/','icon-ccsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ccsp'" style="width: 150px;">出差审批</a>
        <a href="javascript:openTab('结算审批','http://www.people.com.cn/','icon-jssp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-jssp'" style="width: 150px;">结算审批</a>
        <a href="javascript:openTab('预算管理','http://www.people.com.cn/','icon-ysgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ysgl'" style="width: 150px;">预算管理</a>
        <a href="javascript:openTab('出差统计','http://www.people.com.cn/','icon-cctj')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cctj'" style="width: 150px;">出差统计</a>
    </div>
</div>

<div region="south" style="height: 30px;padding: 5px" align="center">
    Copyright © 2019-2022 wowx
</div>

</body>

</html>