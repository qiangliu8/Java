<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% for (int i = 1; i <=9 ; i++) {%>
    <tr>
        <%   for (int j = 1; j <=i ; j++) { %>
        <td>
            <%=  i+"*"+j+"="+i*j %>
        </td>
    </tr>
    <%    }    %>
    <br/>
    <%  }   %>
</body>
</html>
