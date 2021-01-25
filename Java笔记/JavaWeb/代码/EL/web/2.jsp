<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1、值为null值的时候，为空--%>
<%--2，值为空串的时候，为空--%>
<%--3，值是object类型数组，长度为零的时候--%>
<%--4，List集合，元素个数为零--%>
<%--5,map集合，元素个数为零--%>

    <%
        request.setAttribute("key1",null);
        request.setAttribute("key2","");
        request.setAttribute("key3",new Object[]{});
        List<String> list = new ArrayList<>();
        request.setAttribute("key4", list);
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("key5",map);
    %>
    ${empty key1}
    ${empty key2}
    ${empty key3}
    ${empty key4}
    ${empty key5}
</body>
</html>
