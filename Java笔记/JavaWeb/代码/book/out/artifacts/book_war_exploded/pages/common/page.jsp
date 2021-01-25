<%--
  Created by IntelliJ IDEA.
  User: 11026
  Date: 2021/1/4
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="${page.url}&pageNo=${1}">首页</a>
    <c:if test="${page.pageNo!=1}">
        <a href="${page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <c:if test="${page.pageNo!=1}">
        <a href="${page.url}&pageNo=${requestScope.page.pageNo-1}">${page.pageNo-1}</a>
    </c:if>

    【${requestScope.page.pageNo}】

    <c:if test="${page.pageNo!=page.pageToal}">
        <a href="${page.url}&pageNo=${requestScope.page.pageNo+1}">${page.pageNo+1}</a>
    </c:if>

    <c:if test="${page.pageNo<=page.pageToal-1}">
        <a href="${page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>
    <c:if test="${page.pageNo!=page.pageToal}">
        <a href="${page.url}&pageNo=${requestScope.page.pageToal}">末页</a>
    </c:if>
    共${page.pageToal}页，${page.pageTotalCount}条记录到 第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
    <input type="button" id="searchPageBtn" value="确定"/>
</div>
