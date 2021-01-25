<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2021/1/4
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${not empty sessionScope.LoginUser}">
            <span>欢迎<span class="um_span">${sessionScope.LoginUser.username}</span>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <c:if test="${ empty sessionScope.LoginUser}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/ClientBookServlet" method="get">
                <input type="hidden" value="pageByPrice" name="action"/>
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${not empty sessionScope.cart.items}">
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: #ff0000">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
            <c:if test="${empty sessionScope.cart.items}">
                <div>
                    <span style="color: #ff0000">当前购物车为空</span>
                </div>
            </c:if>

        </div>

        <c:forEach begin="0" items="${requestScope.page.items}" var="book" >
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.img_path}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" class="addItems">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%@ include file="../common/page.jsp"%>

</div>
<%@include file="../common/footer.jsp"%>
<script type="text/javascript">
    $(".addItems").click(function (){
        bookId = $(this).attr("bookId");
        location.href = `http://localhost:8080/book/cartServlet?action=addItem&id=`+bookId;
    })
</script>
</body>
</html>