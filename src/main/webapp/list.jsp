<%--
  Created by IntelliJ IDEA.
  User: jsc
  Date: 2019/4/26
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div>
        <form class="form-inline">
            <div>
                <div style="float: left;margin-bottom: 20px">
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <input type="text" class="form-control" id="name" placeholder="姓名">
                    </div>
                    <div class="form-group">
                        <label for="address">籍贯</label>
                        <input type="text" class="form-control" id="address" placeholder="籍贯">
                    </div>
                    <div class="form-group">
                        <label for="email">邮箱</label>
                        <input type="email" class="form-control" id="email" placeholder="邮箱">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </div>
                <div style="float: right">
                    <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
                    <button type="button" class="btn btn-primary" onclick="add();">添加联系人</button>
                    <button type="button" class="btn btn-primary" onclick="deleteSlectUser();">删除选中</button>
                </div>
            </div>


            <table border="1" class="table table-bordered table-hover">
                <tr class="success">
                    <th><input type="checkbox" id="checkboxTotal"></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${userList}" var="user" varStatus="ct">
                    <tr>
                        <td>
                            <input type="checkbox" name="checkbox" value="${user.id}">
                            <input type="hidden" name="id" value="${user.id}">
                        </td>
                        <td>${ct.count}</td>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/user/updateShow/${user.id}">修改</a>&nbsp;
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/user/deleteUser/${user.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                <%-- <tr>
                     <td colspan="8" align="center">
                         <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
                     </td>
                 </tr>--%>
            </table>
        </form>
    </div>
</div>
<script>
    function add() {
        location.href = "${pageContext.request.contextPath}/add.jsp";
    }

    function deleteSlectUser() {
        var checkEles = document.getElementsByName("checkbox");
        var loca = "";
        for (var i = 0; i < checkEles.length; i++) {
            if (checkEles[i].checked) {
                var value = checkEles[i].value;
                loca += ("checkbox=" + value + "&");
            }
        }

        if (loca.endsWith("&")) {
            loca = loca.substring(0, loca.length - 1);
        }
        var xx = "${pageContext.request.contextPath}/user/deleteSlectUser?" + loca;
        location.href = "${pageContext.request.contextPath}/user/deleteSlectUser?" + loca;
    }

    window.onload = function () {
        var checkboxEle = document.getElementById("checkboxTotal");
        checkboxEle.onclick = function () {
            var flag = checkboxEle.checked;
            var checkboxEles = document.getElementsByName("checkbox");
            for (var i = 0; i < checkboxEles.length; i++) {
                checkboxEles[i].checked = flag;
            }
        }
    }
</script>
</body>
</html>