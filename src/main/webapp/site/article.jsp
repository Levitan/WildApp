<%--
  Created by IntelliJ IDEA.
  User: Borisovskiy.V
  Date: 04.06.2017
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/site/template/header.jsp"%>


<article class="post">
    <header>
        <div class="title"> <h2>${art.name}</h2></div>
        <div class="meta">
            <fmt:formatDate value="${art.date}" pattern="dd MMMM yyyy" var="displayDate"/>
            <fmt:formatDate value="${art.date}" pattern="HH:mm" var="displayTime"/>
            <fmt:formatDate value="${art.date}" pattern="yyyy-MM-dd" var="valDate"/>
            <time class="published" datetime="${valDate}">${displayDate}<br>${displayTime}</time>
            ${newDate}
        </div>
    </header>
${art.content}
</article>

<%@include file="/site/template/footer.jsp"%>