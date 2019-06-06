<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/31
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
</head>
<body>
<table id="dg" style="width:700px;height:600px"></table>

</body>
<script>
    var prefix = "/ccinfo";

    $(function () {

        queryUserList();
    });

    function queryUserList() {
        var options = {
            url: prefix + "/list",
            sortName: "createTime",
            sortOrder: "desc",
            striped:true,
            pagination:true,
            pageSize:10,
            columns: [[
                {
                    field: 'infoId',
                    title: 'ID',
                    width:80,

                },
                {
                    field: 'title',
                    title: '标题',
                    sortable: true
                },


                {
                    field: 'createTime',
                    title: '创建时间',
                    sortable: true
                },
                {
                    field: 'viewCount',
                    title: '浏览次数',
                    sortable: true
                }]]
        };
        $.table.init(options);
    }



</script>
</html>
