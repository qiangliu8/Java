<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      request.setAttribute("key1","value1");
    %>
    <%=request.getAttribute("key1")%>
    ${key2}
  </body>
</html>
