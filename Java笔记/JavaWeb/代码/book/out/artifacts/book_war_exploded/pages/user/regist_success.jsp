<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<%@include file="../common/login_success_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="../../index.jsp">转到主页</a></h1>
	
		</div>

		<%@include file="../common/footer.jsp"%>
</body>
</html>