<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>
<div class="white-box">
    <form action="${pageContext.request.contextPath}/Administration/Menu/${method}" method="POST" class="form-horizontal form-material">
        <input type="hidden" value="${menu.id}" name="id">
        <div class="form-group">
        <label for="menuName" class="col-md-12">Name</label>
            <div class="col-md-12"><input required value="${menu.name}" class="form-control form-control-line" type="text" placeholder="" name="name" id="menuName"></div>
        </div>
        <div class="form-group">
            <div class="col-md-12">
                <input class="form-control-line" type="checkbox" name="enabled" id="menuEnable">
                <label for="menuEnable" class="">Enabled</label>
            </div>
        </div>
        <hr>
        <div class="form-group">
            <label for="typeSelect" class="col-md-12">Type</label>
            <div class="col-md-12">
                <select class="form-control form-control-line" name="type" id="typeSelect" required>
                    <option>--</option>
                    <c:forEach items="${TYPES}" var="type" varStatus="status">
                        <option <c:if test="${status.index == menu.type}">selected </c:if> value="${status.index}">${type}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="contentSelect" class="col-md-12">Type</label>
            <div class="col-md-12">
                <select class="form-control form-control-line" name="contentId" id="contentSelect" required style="display: none;">
                </select>
            </div>
        </div>




        <div class="form-group">
            <div class="col-md-12"><input class="btn btn-success" type="submit" value="create"></div>
        </div>
    </form>
    </div>

<%@include file="/admin/template/footer.jsp" %>