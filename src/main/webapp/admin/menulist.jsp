<%@include file="/admin/template/header.jsp" %>
<div class="row">
    <div class="col-sm-12">
        <div class="white-box">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/Administration/Menu/Manage?mode=add">Add new</a>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Content</th>
                            <th>Enabled</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${menus}" var="menu">
                            <tr>
                                <td>${menu.id}</td>
                                <td>${menu.name}</td>
                                <td>${menu.type}</td>
                                <td>${menu.contentId}</td>
                                <td>${menu.isEnable}</td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/Administration/Categories/Manage?mode=enable&id=${menu.id}"><i class="fa fa-check"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Categories/Manage?mode=edit&id=${menu.id}"><i class="fa fa-pencil"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Categories/?delete=${menu.id}"><i class="fa fa-trash-o"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            <div>
        </div>
    </div>
</div>
<%@include file="/admin/template/footer.jsp" %>