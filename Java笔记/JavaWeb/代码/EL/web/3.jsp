<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2020/12/30
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${param.username}
    ${param.password}
    ${paramValues['username'][0]}

    ${header['User-Agent']}<br>
    ${header.Connection}

    ${headerValues['User-Agent'][0]}<br>
    ${headerValues.Connection[0]}

    ${cookie}

    ${cookie.JSESSIONID}
    ${cookie.JSESSIONID.name}
    ${cookie.JSESSIONID.value}

    ${initParam}
    ${initParam.username}
</body>
</html>
