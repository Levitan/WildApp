<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@include file="/admin/template/header.jsp" %>
<div class="row">
    <div class="col-sm-12">
        <div class="white-box">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/Administration/Articles/Manage?mode=add">Add new</a>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Category</th>
                            <th>Last update</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${articles}" var="article">
                            <fmt:formatDate value="${article.date}" pattern="dd MMMM yyyy HH:mm" var="displayDate"/>
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
                                <td>${displayDate}</td>
                                <td><a href="<%=request.getContextPath()%>/Administration/Articles/View/${article.id}"><i class="fa fa-eye"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Articles/Manage?mode=edit&id=${article.id}"><i class="fa fa-pencil"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Articles/Delete/${article.id}"><i class="fa fa-trash-o"></i></a></td>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="/admin/template/footer.jsp" %>