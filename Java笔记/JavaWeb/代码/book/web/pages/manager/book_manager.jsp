<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@include file="../common/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>图书管理</title>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
	<span class="wel_word">图书管理系统</span>
	<%@include file="../common/manager_menu.jsp"%>
</div>

<div id="main">
	<table>
		<tr>
			<td>名称</td>
			<td>价格</td>
			<td>作者</td>
			<td>销量</td>
			<td>库存</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach begin="0" var="item" items="${requestScope.page.items}">
			<tr>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.author}</td>
				<td>${item.sales}</td>
				<td>${item.stock}</td>
				<td><a href="manager/bookServlet?action=getBook&id=${item.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
				<td><a class="deleteClass"
					   href="manager/bookServlet?action=delete&id=${item.id}&pageNo=${requestScope.page.pageToal}"
				>删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageToal}">添加图书</a></td>
		</tr>
	</table>
	<%@ include file="../common/page.jsp"%>
</div>
<script type="text/javascript">
	$(".deleteClass").click(function (e){
		return confirm("确定要删除么"+$(this).parent().parent().find("td:first").text());
	})
	$("#searchPageBtn").click(function (e){
		let pageNo = $("#pn_input").val();
		location.href="${besePath}manager/bookServlet?action=page&pageNo="+pageNo;
	})
</script>
<%@include file="../common/footer.jsp"%>
</body>
</html>