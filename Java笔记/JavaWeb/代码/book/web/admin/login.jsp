<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2021/1/18
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../pages/common/head.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="loginServlet" method="get">
    用户名<input type="text" name="username"/>
    密码<input type="text" name="password"/>
    <input type="submit"/>
</form>
</body>
</html>
