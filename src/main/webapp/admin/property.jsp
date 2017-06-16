<%--
  Created by IntelliJ IDEA.
  User: Borisovskiy.V
  Date: 16.06.2017
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>

<div class="row">
    <div class="col-sm-12">
        <div class="white-box">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/Administration/Property/Manage?mode=add">Add new</a>

            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Property</th>
                        <th>Value</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${properties}" var="prop">
                        <tr>
                            <td>${prop.id}</td>
                            <td>${prop.property}</td>
                            <td>${prop.value}</td>
                            <td>
                                <a href="<%=request.getContextPath()%>/Administration/Property/Manage?mode=edit&id=${user.id}"><i class="fa fa-pencil"></i></a>&nbsp;
                                    <%--<a href="<%=request.getContextPath()%>/Administration/UserManagement/?delete=${user.id}"><i class="fa fa-trash-o"></i></a></td>--%>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="/admin/template/footer.jsp" %>
