<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%pageContext.setAttribute("name","刘强");%>
    ${pageScope.name}

    <%request.setAttribute("name","俞文竹");%>
    ${requestScope.name}

    <%session.setAttribute("name","老婆");%>
    ${sessionScope.name}

    <%application.setAttribute("name","我爱你");%>
    ${applicationScope.name}
<%--    <%=request.getScheme()%>它可以获取请求的协议--%>
    协议:${pageContext.request.scheme}<br>
    <%--    <%=request.getServerName()%>它可以获取请求的ip--%>
    ip:${pageContext.request.serverName}<br>
    <%--<%=request.getServerPort()%>它可以获取请求的服务器端口--%>
    服务器端口:${pageContext.request.serverPort}<br>
    <%--<%=request.getServerPath()%>它可以获取请求的工程路径--%>
    获取工程路径:${pageContext.request.contextPath}<br>

    <%--<%=request.getServerPort()%>它可以获取请求的请求方法--%>
    获取请求方法:${pageContext.request.method}<br>

    <%--<%=request.getRemoteHost()%>它可以获取请求的工程路径--%>
    获取客户端ip地址:${pageContext.request.remoteHost}<br> //0:0:0:0:0:0:0:1
    <%--<%=request.getRequestedSessionId()%>它可以获取请求的会话的id编号--%>
    获取会话的id编号:${pageContext.request.session.id}<br> //C33BB1464466FDC556C0A94564414EBA


3
</body>
</html>
