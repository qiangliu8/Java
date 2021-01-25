<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="../common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get">
				<input type="hidden" value="${empty param.id?"add":"update"}" name="action"/>
				<input name="pageNo" type="hidden" value="${param.pageNo}"/>
				<input name="id" type="hidden" value="${book.id}"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${book.name}"/></td>
						<td><input name="price" type="text" value="${book.price}"/></td>
						<td><input name="author" type="text" value="${book.author}"/></td>
						<td><input name="sales" type="text" value="${book.sales}"/></td>
						<td><input name="stock" type="text" value="${book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="../common/footer.jsp"%>
</body>
</html>