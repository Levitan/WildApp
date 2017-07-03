<%--
  Created by IntelliJ IDEA.
  User: Borisovskiy.V
  Date: 21.06.2017
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>

<div class="white-box">
    <form action="${pageContext.request.contextPath}/Administration/Property/${method}" method="POST" class="form-horizontal form-material">
        <input type="hidden" value="${property.id}" ${lock}>
        <div class="form-group">
            <label for="login" class="col-md-12">Property name</label>
            <div class="col-md-12"><input value="${property.login}" class="form-control form-control-line" type="text" name="name" id="login"></div>
        </div>
        <div class="form-group">
            <label for="pass" class="col-md-12">Property value</label>
            <div class="col-md-12"><input value="" class="form-control form-control-line" type="text" name="value" id="pass"></div>
        </div>
        <div class="form-group">
            <div class="col-md-12"><input class="btn btn-success" type="submit" value="Submit"></div>
        </div>
    </form>
</div>
<%@include file="/admin/template/footer.jsp" %>
