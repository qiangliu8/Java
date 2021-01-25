<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.qianliu8.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sc" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/30
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        table,th,td{
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <c:set
    scope="request"
    var="name"
    value="liuqiang"
    />
    ${requestScope.name}
    <c:if test="${12==12}">
        <%--test属性表示判断的条件--%>
        <h1>12==12</h1>
    </c:if>

    <%
        request.setAttribute("height",168);
    %>
    <c:choose>
        <c:when test="${height<170}">小矮子</c:when>
        <c:when test="${height<180}">标准身高</c:when>
        <c:when test="${height<190}">大巨人</c:when>
        <c:otherwise>非人类</c:otherwise>
    </c:choose>

    <c:forEach begin="0" end="10" var="i">
        ${i}
    </c:forEach>
    <%
        request.setAttribute("arr",new String[]{"186444","444455","4564655"});
    %>
    <c:forEach items="${arr}" var="item">
        <br/>${item}
    </c:forEach>
    <%
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","刘强");
        map.put("age","18");
        map.put("sex","男");
       request.setAttribute("map",map);
    %>
    ${map}
    <%
        for (Map.Entry<String,Object> entry:map.entrySet()) {
            out.println(entry);
        }
    %>
    <c:forEach items="${map.entrySet()}" var="item">
        ${item.key}:${item.value}
    </c:forEach>

    <%
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i,"刘强"+i,"Lq060528"+i,18+i,"15755337162"+i));
        }
        request.setAttribute("studentList",studentList);
    %>

    <table>
        <th>id</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>手机号</th>
        <th>操作</th>
        </th>
        <c:forEach begin="0" end="9" varStatus="status" items="${studentList}" var="item">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getUsername()}</td>
                <td>${item.getPassword()}</td>
                <td>${item.getAge()}</td>
                <td>${item.getPhone()}</td>
                <td>删除、修改</td>
                <td>${status.index}</td>
                <td>${status.count}</td>
                <td>${status.first}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
