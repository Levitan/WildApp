<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
</div>

<!-- Sidebar -->
<section id="sidebar">

    <!-- Intro -->
    <section id="intro">
        <a href="#" class="logo"><img src="<%=request.getContextPath()%>/resources/site/template/images/logo.jpg" alt="" /></a>
        <header>
            <h2>WildApp</h2>
            <p>Дипломный проект</p>
        </header>
    </section>
    <%--<c:choose>--%>
        <%--<c:when test="${isCat}">--%>
            <section>
                <h2>Содержание</h2>
                <ul class="posts">
                    <c:forEach items="${articles}" var="art">
                        <li>
                            <article>
                                <header>
                                    <h3><a href="<%=request.getContextPath()%>/${category.alias}/${art.alias}">${art.name}</a></h3>
                                        <%--<time class="published" datetime="2015-10-20">October 20, 2015</time>--%>
                                </header>
                                    <%--<a href="#" class="image"><img src="<%=request.getContextPath()%>/resources/site/template/images/pic08.jpg" alt="" /></a>--%>
                            </article>
                        </li>
                    </c:forEach>
                </ul>
            </section>
        <%--</c:when>--%>
    <%--</c:choose>--%>




    <%--<!-- About -->--%>
    <%--<section class="blurb">--%>
        <%--<h2>About</h2>--%>
        <%--<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod amet placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at phasellus sed ultricies.</p>--%>
        <%--<ul class="actions">--%>
            <%--<li><a href="#" class="button">Learn More</a></li>--%>
        <%--</ul>--%>
    <%--</section>--%>

    <%--<!-- Footer -->--%>
    <%--<section id="footer">--%>
        <%--<ul class="icons">--%>
            <%--<li><a href="#" class="fa-twitter"><span class="label">Twitter</span></a></li>--%>
            <%--<li><a href="#" class="fa-facebook"><span class="label">Facebook</span></a></li>--%>
            <%--<li><a href="#" class="fa-instagram"><span class="label">Instagram</span></a></li>--%>
            <%--<li><a href="#" class="fa-rss"><span class="label">RSS</span></a></li>--%>
            <%--<li><a href="#" class="fa-envelope"><span class="label">Email</span></a></li>--%>
        <%--</ul>--%>
        <%--<p class="copyright">&copy; Untitled. Design: <a href="http://html5up.net">HTML5 UP</a>. Images: <a href="http://unsplash.com">Unsplash</a>.</p>--%>
    <%--</section>--%>

</section>

</div>

<!-- Scripts -->
<script src="<%=request.getContextPath()%>/resources/site/template/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/site/template/assets/js/skel.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/site/template/assets/js/util.js"></script>
<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/resources/site/template/assets/js/ie/respond.min.js"></script><![endif]-->
<script src="<%=request.getContextPath()%>/resources/site/template/assets/js/main.js"></script>

</body>
</html>