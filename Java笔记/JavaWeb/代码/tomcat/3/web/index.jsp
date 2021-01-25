<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/21
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8083/3_war_exploded/3" method="POST">
    <label for="usernames">用户名</label>
    <input type="text" value="" id = "usernames" name="username">
    <label for="passwords">密码</label>
    <input type="password" value="" id="passwords" name="password">
    <label >爱好</label>
    游戏 <input type="checkbox" name="hobby" value="game" id=""/>
    爱情<input type="checkbox" name="hobby" value="love"/>
    运动<input type="checkbox" name="hobby" value="sport"/>
    <input type="submit"/>
  </form>
  <form action="http://localhost:8083/3_war_exploded/3" method="get">
    <label for="username">用户名</label>
    <input type="text" value="" id = "username" name="username">
    <label for="password">密码</label>
    <input type="password" value="" id="password" name="password">
    <label >爱好</label>
    游戏 <input type="checkbox" name="hobby" value="game" id=""/>
    爱情<input type="checkbox" name="hobby" value="love"/>
    运动<input type="checkbox" name="hobby" value="sport"/>
    <input type="submit"/>
  </form>


  <form action="http://localhost:8083/3_war_exploded/3_Servlet1" method="get">
    <label for="username">用户名</label>
    <input type="text" value=""  name="username">
    <input type="submit"/>
  </form>
  <form action="http://localhost:8083/3_war_exploded/3_Servlet2" method="get">
    <label for="username">用户名</label>
    <input type="text" value=""  name="username">
    <label for="password">密码</label>
    <input type="password" value=""  name="password">
    <label >爱好</label>
    游戏 <input type="checkbox" name="hobby" value="game" id=""/>
    爱情<input type="checkbox" name="hobby" value="love"/>
    运动<input type="checkbox" name="hobby" value="sport"/>
    <input type="submit"/>
  </form>
  这是文件夹a/b的indexhtml
  <a href="a/b/c.html">a/b/c.html</a>
  <a href="http://localhost:8083/3_war_exploded/forword">请求转发 a/b/c.html</a>
  </body>
</html>
