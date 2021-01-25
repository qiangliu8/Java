<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>

							<div class="msg_cont">
								<b></b>
									<span class="errorMsg">${msg}</span>
<%--									<span class="errorMsg">${pageContext.request.getAttribute("msg")}</span>--%>
<%--								<span class="errorMsg">请输入用户名和密码</span>--%>
							</div>
							<div class="form">
								<form action="UserServlet" method="POST">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
										   value="${username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"
										   value="${password}"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
									<input type="hidden" value="login" name="action"/>
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="../common/footer.jsp"%>
</body>
</html>