<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>${title} :: Wildapp</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="<%=request.getContextPath()%>/resources/site/template/assets/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/site/template/assets/css/main.css" />
    <!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/resources/site/template/assets/css/ie9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/resources/site/template/assets/css/ie8.css" /><![endif]-->
</head>
<body>

<!-- Wrapper -->
<div id="wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="#">WildApp</a></h1>
        <nav class="links">
            <ul>
                <li><a href="<%=request.getContextPath()%>/">Содержание</a></li>
                <li><a href="<%=request.getContextPath()%>/tests/excel">Тест</a></li>
                <li><a href="<%=request.getContextPath()%>/articles/source">Источники</a></li>
                <li><a href="<%=request.getContextPath()%>/sluzhebnie/kontakti">Контакты</a></li>
            </ul>
        </nav>
        <%--<nav class="main">--%>
            <%--<ul>--%>
                <%--<li class="search">--%>
                    <%--<a class="fa-search" href="#search">Search</a>--%>
                    <%--<form id="search" method="get" action="#">--%>
                        <%--<input type="text" name="query" placeholder="Search" />--%>
                    <%--</form>--%>
                <%--</li>--%>
                <%--<li class="menu">--%>
                    <%--<a class="fa-bars" href="#menu">Menu</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</nav>--%>
    </header>

    <!-- Menu -->
    <section id="menu">

        <!-- Search -->
        <section>
            <form class="search" method="get" action="#">
                <input type="text" name="query" placeholder="Search" />
            </form>
        </section>

        <!-- Links -->
        <section>
            <ul class="links">
                <li>
                    <a href="#">
                        <h3>Lorem ipsum</h3>
                        <p>Feugiat tempus veroeros dolor</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <h3>Dolor sit amet</h3>
                        <p>Sed vitae justo condimentum</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <h3>Feugiat veroeros</h3>
                        <p>Phasellus sed ultricies mi congue</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <h3>Etiam sed consequat</h3>
                        <p>Porta lectus amet ultricies</p>
                    </a>
                </li>
            </ul>
        </section>

        <!-- Actions -->
        <section>
            <ul class="actions vertical">
                <li><a href="#" class="button big fit">Log In</a></li>
            </ul>
        </section>

    </section>

    <!-- Main -->
    <div id="main">
