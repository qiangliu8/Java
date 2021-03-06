<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2021/2/28
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第2个springmvc的项目</p>
    <p><a href="test/some.do">发起some.do请求</a></p>

    <form action="test/other.do" method="post">
        <input type="text" name="name"/>
        <input type="submit" value="发起other.do请求">
    </form>


    <form action="test/receiveproperties.do" method="post">
        <input type="text" name="name"/>
        <input type="text" name="age"/>
        <input type="submit" value="提交参数">
    </form>

    <form action="test/receiveparam.do" method="post">
        <input type="text" name="pname"/>
        <input type="text" name="page"/>
        <input type="submit" value="提交参数">
    </form>
    <p>使用java对象接受请求参数</p>
    <form action="test/receiveobject.do" method="post">
        <input type="text" name="name"/>
        <input type="text" name="age"/>
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
