<%@ page import="java.util.List" %>
<%@ page import="com.qiangliu8.serlvet.student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/29
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,tr,td{
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <%
//        List<student> studentList = new ArrayList<student>();
//        for (int i = 0; i <10 ; i++) {
//            studentList.add(new student(i+1,"刘强"+i,18+i,"1877"+i));
//        }
        List<student> studentList = (List<student>) request.getAttribute("stulist");
    %>
    <table>
    <% for (student student:studentList){%>
        <tr>
            <td>
                <%= student.getId() %>
            </td>
            <td>
                <%= student.getName() %>
            </td>
            <td>
                <%= student.getAge() %>
            </td>
            <td>
                <%= student.getPhone() %>
            </td>
        </tr>

        <%
        }
    %>
    </table>
</body>
</html>
