<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>

<div class="row">
    <div class="col-sm-12">
        <div class="white-box">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/Administration/UserManagement/Manage?mode=add">Add new</a>

            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Login</th>
                            <th>Age</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${identity}" var="user">
                            <tr>
                                <td>${user.firstName}</td>
                                <td>${user.secondName}</td>
                                <td>${user.login}</td>
                                <td>${user.age}</td>
                                <td><a href="<%=request.getContextPath()%>/Administration/UserManagement/Manage?mode=edit&id=${user.id}"><i class="fa fa-pencil"></i></a>&nbsp;<a href="<%=request.getContextPath()%>/Administration/UserManagement/?delete=${user.id}"><i class="fa fa-trash-o"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="/admin/template/footer.jsp" %>