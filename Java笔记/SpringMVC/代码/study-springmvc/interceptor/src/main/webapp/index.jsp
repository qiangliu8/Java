<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>" />
</head>
<body>
    <p>一个拦截器</p>
    <form action="some.do" method="post">
        <input type="text" name="name" value="name">
        <input type="text" name="age" value="age">
        <input type="submit" value="提交">
    </form>
</body>
</html>
