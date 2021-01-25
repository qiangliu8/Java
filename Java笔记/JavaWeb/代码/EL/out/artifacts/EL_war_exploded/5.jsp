<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/30
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/EL_war_exploded/upload" method="post" enctype="multipart/form-data">
        用户名<input type="text" name="username"/><br>
        头像<input type="file" name="photo" value="上传"/><br>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
