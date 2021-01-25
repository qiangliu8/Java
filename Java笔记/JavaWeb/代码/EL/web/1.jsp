<%@ page import="com.qianliu8.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("刘强");
        person.setName("15209842010");
        List<String> cities = new ArrayList<String>();
        cities.add("合肥");
        cities.add("南昌");
        person.setCities(cities);
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>
    ${person}
    ${person.cities}
</body>
</html>
