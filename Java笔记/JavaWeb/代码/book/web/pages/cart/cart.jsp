<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<%@include file="../common/login_success_menu.jsp"%>
	</div>

	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="item">
				<tr>
					<td>${item.value.name}</td>
					<td>
						<input class="updateCount" bookId="${item.value.id}" type="text" value="${item.value.count}" name="count" style="width: 50px;"/>
					</td>
					<td>${item.value.price}</td>
					<td>${item.value.totalPrice}</td>
					<td><a class="isDelete" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="cart_info">
			<c:if test="${ not empty sessionScope.cart.items}">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="isClear" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</c:if>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5">亲，当前购物车为空<a href="index.jsp">去浏览商品吧</a></td>
			</c:if>

		</div>
	
	</div>

	<%@include file="../common/footer.jsp"%>
<script>
	$(".isDelete").click(function (){
		return confirm("是否删除"+$(this).parent().parent().find("td:first").text()+"？");
	})
	$(".isClear").click(function (){
		return confirm("是否清空购物车？");
	})
	$(".updateCount").change(function (){
		let count = $(this).val();
		let id = $(this).attr("bookId");
		if(confirm("是否修改商品数据?")){
			location.href = "http://localhost:8080/book/cartServlet?action=updateCount&id="+id+"&count="+count;
		}else{
			this.value = this.defaultValue;
		}
	})
</script>
</body>
</html>