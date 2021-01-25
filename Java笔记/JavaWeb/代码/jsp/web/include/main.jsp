<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主体内容<br>

<%--
    <%@include file=""%>就是静态包含
        file属性指定要包含的jsp页面路径
        地址中第一个斜杠/ 表示http://ip:port/工程路径/ 映射到代码的web目录
--%>
    <jsp:include page="footer.jsp">
        <jsp:param name="username" value="lq"/>
        <jsp:param name="password" value="Lq060528"/>
    </jsp:include>

</body>
</html>
