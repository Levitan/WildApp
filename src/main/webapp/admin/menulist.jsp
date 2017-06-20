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
                            <th>Order</th>
                            <th>Enabled</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${menus}" var="menu" varStatus="menuCount">
                            <tr>
                                <td>${menu.id}</td>
                                <td>${menu.name}</td>
                                <td>
                                    <c:forEach items="${TYPES}" var="type" varStatus="status">
                                        <c:if test="${status.index == menu.type}">
                                            ${type}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>
                                    ${names.get(menuCount.index)}
                                </td>
                                <td>${menu.nOrder}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${menu.isEnable()}">
                                            <span class="green"><b>Enabled</b></span>
                                        </c:when>
                                        <c:when test="${!menu.isEnable()}">
                                            <span class="red"><b>Disabled</b></span>
                                        </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="<%=request.getContextPath()%>/Administration/Menu/Manage?mode=enable&id=${menu.id}"><i class="fa fa-check"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Menu/Manage?mode=edit&id=${menu.id}"><i class="fa fa-pencil"></i></a>&nbsp;
                                    <a href="<%=request.getContextPath()%>/Administration/Menu/?delete=${menu.id}"><i class="fa fa-trash-o"></i></a>
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