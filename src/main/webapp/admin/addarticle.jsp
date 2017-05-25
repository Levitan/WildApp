<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/admin/template/header.jsp" %>



    <div class="white-box">
    <form action="${pageContext.request.contextPath}/Administration/Articles/${method}" method="${method}" class="form-horizontal form-material">
        <input type="hidden" value="${article.id}">
        <div class="form-group">
        <label for="art_title" class="col-md-12">Name</label>
            <div class="col-md-12"><input value="${article.name}" class="form-control form-control-line" type="text" name="name" id="art_title"></div>
        </div>
        <div class="form-group">
            <label for="art_cat" class="col-md-12">Category</label>
            <div class="col-md-12">
                <select class="form-control form-control-line" name="cat" id="art_cat">
                    <option value="">Без категории</option>
                    <c:forEach items="${cats}" var="cat">
                        <option <c:if test="${article.catId == cat.id}">selected </c:if> value="${cat.id}">${cat.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

                <div class="form-group">
                    <label for="art_content" class="col-md-12">Content</label>
                    <div class="col-md-12">
                        <textarea class="form-control form-control-line" name="content" id="art_content" rows="10">${article.content}</textarea>
                    </div>
                </div>
                <div class="form-group">
                            <div class="col-md-12"><input class="btn btn-success" type="submit" value="create"></div>
                        </div>
    </form>
    </div>
<%@include file="/admin/template/footer.jsp" %>
