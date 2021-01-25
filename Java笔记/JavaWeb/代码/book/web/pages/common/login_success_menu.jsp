<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/31
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="LoginHeader.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <span class="wel_word">购物车</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.LoginUser.username}</span>光临尚硅谷书城</span>
<%--        <span>欢迎<span class="um_span">11123</span>光临尚硅谷书城</span>--%>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</body>
</html>
