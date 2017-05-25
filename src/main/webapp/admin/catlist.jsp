<%@include file="/admin/template/header.jsp" %>
<div class="row">
    <div class="col-sm-12">
        <div class="white-box">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/Administration/Categories/Manage?mode=add">Add new</a>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${cats}" var="cat">
                            <tr>
                                <td>${cat.id}</td>
                                <td>${cat.name}</td>
                                <td>${cat.description}</td>
                                <td><a href="<%=request.getContextPath()%>/Administration/Categories/Manage?mode=edit&id=${cat.id}"><i class="fa fa-pencil"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Categories/?delete=${cat.id}"><i class="fa fa-trash-o"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            <div>
        </div>
    </div>
</div>
<%@include file="/admin/template/footer.jsp" %>