<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    页脚信息<br>
    <%
        out.write(request.getParameter("username"));
        out.write(request.getParameter("password"));
    %>
    <jsp:forward page="../2.jsp"></jsp:forward>
</body>
</html>
