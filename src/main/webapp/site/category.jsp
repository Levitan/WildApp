<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="/site/template/header.jsp" %>

<c:forEach items="${articles}" var="article">
    <article class="post">
        <%--<header>--%>
            <div class="title">
                <h2><a href="<%=request.getContextPath()%>/${category.alias}/${article.alias}">${article.name}</a></h2>
            </div>
        <%--</header>--%>
        ${fn:substring(article.content, 0, fn:indexOf(article.content, "<!--more-->"))}
        <footer>
            <ul class="actions">
                <li><a href="<%=request.getContextPath()%>/${category.alias}/${article.alias}"" class="button big">Читать далее</a></li>
            </ul>
        </footer>
    </article>
</c:forEach>

<c:forEach var="pPage" begin="1" end="${pageCount}">

    <c:choose>
        <c:when test="${pPage == currentPage}">
            <a class="button big active">${pPage}</a>
        </c:when>
        <c:when test="${pPage != currentPage}">
            <a href="<%=request.getContextPath()%>/${category.alias}/page_${pPage}" class="button big">${pPage}</a>
        </c:when>
    </c:choose>

</c:forEach>


<%@include file="/site/template/footer.jsp" %>