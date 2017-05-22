<%--
  Created by IntelliJ IDEA.
  User: vlevi
  Date: 21.05.2017
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color: #ff0000;">${error}</h3>
    <form action="${pageContext.request.contextPath}/AddUser" method="post">
        <input type="text" placeholder="UserName" name="login"><br>
        <input type="text" placeholder="Password" name="pass"><br>
        <input type="text" placeholder="FirstName" name="fname"><br>
        <input type="text" placeholder="LastName" name="lname"><br>
        <input type="number" placeholder="Age" name="age"><br>
        <input type="submit" value="create">
    </form>
</body>
</html>
