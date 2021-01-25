<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/28
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.qiangliu8.serlvet.PringHtml" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8"
         autoFlush="false"
         buffer="8kb"
         errorPage="error.jsp"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是Html页面数据

<%--    声明类属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>
<%--申明static静态代码块--%>
    <%!
        static {
            map = new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key2","value2");
        }
    %>
<%--申明类方法--%>
    <%!
        public int abc(){
            return 12;
        }
    %>
<%--申明内部类--%>
    <%!
        public static class A{
            private Integer id = 12;
            private String abc = "abc";
        }
    %>

    <%--    输出整形--%>
    <%=
        1
    %>
    <%--    输出浮点型--%>
    <%=
    1.0
    %>
    <%--    输出字符串--%>
    <%=
        "我是字符串"
    %>
    <%--    输出对象--%>
    <%=
        map
    %>
    <%=
        request.getMethod()
    %>

<%--if语句--%>
<%
    int i = 12;
    if (i==12){
        System.out.println(i);
    }
%>

    <%--for语句--%>
    <%
        for (int j = 0; j <5 ; j++) {
            System.out.println(j);
        }
    %>

    <%
//        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    <%=request.getAttribute("key")%>
    <%=session.getAttribute("key")%>2
    <%=application.getAttribute("key")%>
</body>
</html>
