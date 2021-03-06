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
    <p>当出来方法返回ModelAndView返回forward</p>
    <form action="doForward.do" method="post">
        <input type="text" name="name" value="name">
        <input type="text" name="age" value="age">
        <input type="submit" value="提交">
    </form>
    <form action="doRedirect.do" method="post">
        <input type="text" name="name" value="name">
        <input type="text" name="age" value="age">
        <input type="submit" value="提交">
    </form>
</body>
</html>
