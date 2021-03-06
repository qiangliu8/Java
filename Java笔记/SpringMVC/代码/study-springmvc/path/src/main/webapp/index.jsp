<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2021/2/28
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme()+
            "://"+request.getServerName()+":"+
            request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<base href="<%=basePath%>">
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>

    <a href="user/some.do">user/some.do</a>
    <a href="${pageContext.request.contextPath}/user/some.do">/user/some.do</a>
</body>
</html>
