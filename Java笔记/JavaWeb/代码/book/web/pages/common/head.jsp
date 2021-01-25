<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/31
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String besePath = request.getScheme()
            +"://"+request.getServerName()
            +":"+request.getServerPort()
            +request.getContextPath()
            +"/";
    request.setAttribute("basePath",besePath);
%>
<base href="http://localhost:8080/book/">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>