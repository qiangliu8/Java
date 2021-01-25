<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getAttribute("key")%>
    <%=session.getAttribute("key")%>2
    <%=application.getAttribute("key")%>

    <%
        out.write("out1");
        out.flush();
        out.write("out2");
        response.getWriter().write("response1");
        response.getWriter().write("response2");
        out.print(222);
    %>
</body>
</html>
