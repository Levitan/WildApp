<%--
  Created by IntelliJ IDEA.
  User: vlevi
  Date: 21.05.2017
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>


<h3 style="color: #ff0000;">${error}</h3>
    <div class="white-box">
    <form action="${pageContext.request.contextPath}/Administration/UserManagement/AddUser" method="post" class="form-horizontal form-material">
        <div class="form-group">
        <label for="login" class="col-md-12">Email</label>
            <div class="col-md-12"><input class="form-control form-control-line" type="text" placeholder="UserName" name="login" id="login"></div>
        </div>
        <div class="form-group">
            <label for="pass" class="col-md-12">Email</label>
            <div class="col-md-12"><input class="form-control form-control-line" type="text" placeholder="Password" name="pass" id="pass"></div>
        </div>
        <div class="form-group">
            <label for="fname" class="col-md-12">Email</label>
            <div class="col-md-12"><input class="form-control form-control-line" type="text" placeholder="FirstName" name="fname" id="fname"></div>
        </div>
        <div class="form-group">
            <label for="lname" class="col-md-12">Email</label>
            <div class="col-md-12"><input class="form-control form-control-line" type="text" placeholder="LastName" name="lname" id="lname"></div>
        </div>
        <div class="form-group">
            <label for="age" class="col-md-12">Email</label>
            <div class="col-md-12"><input class="form-control form-control-line" type="number" placeholder="Age" name="age" id="age"></div>
        </div>
        <div class="form-group">
            <div class="col-md-12"><input class="btn btn-success" type="submit" value="create"></div>
        </div>
    </form>
    </div>
<%@include file="/admin/template/footer.jsp" %>
