<%@include file="/admin/template/header.jsp" %>
<div class="row">
    <div class="col-sm-12">
        <div class="white-box">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/Administration/Articles/AddArticle">Add new</a>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${articles}" var="article">
                            <tr>
                                <td>${article.id}</td>
                                <td>${article.name}</td>
                                <td>
                                    <c:forEach items="${cats}" var="cat">
                                        <c:if test="${cat.id == article.catId}">
                                            ${cat.name}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            <div>
        </div>
    </div>
</div>
<%@include file="/admin/template/footer.jsp" %>