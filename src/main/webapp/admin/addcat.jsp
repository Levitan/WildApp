<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>
<div class="white-box">
    <form action="${pageContext.request.contextPath}/Administration/Categories/${method}" method="POST" class="form-horizontal form-material">
        <input type="hidden" value="${cat.id}" name="id">
        <div class="form-group">
        <label for="login" class="col-md-12">Name</label>
            <div class="col-md-12"><input value="${cat.name}" class="form-control form-control-line" type="text" placeholder="" name="name" id="login"></div>
        </div>
        <div class="form-group">
            <label for="pass" class="col-md-12">Description</label>
            <div class="col-md-12"><input value="${cat.description}" class="form-control form-control-line" type="text" placeholder="" name="desc" id="pass"></div>
        </div>
        <div class="form-group">
            <div class="col-md-12"><input class="btn btn-success" type="submit" value="create"></div>
        </div>
    </form>
    </div>
<%@include file="/admin/template/footer.jsp" %>