<!-- /.container-fluid -->
</div>
<footer class="footer text-center"> 2017 &copy; WildApp</footer>
</div>
<!-- ============================================================== -->
<!-- End Page Content -->
<!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- End Wrapper -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath()%>/resources/admin/template/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="<%=request.getContextPath()%>/resources/admin/template/js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="<%=request.getContextPath()%>/resources/admin/template/js/waves.js"></script>
<!--Counter js -->
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/counterup/jquery.counterup.min.js"></script>
<!-- chartist chart -->
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/chartist-js/dist/chartist.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
<!-- Sparkline chart JavaScript -->
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<%=request.getContextPath()%>/resources/admin/template/js/custom.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/admin/template/js/dashboard1.js"></script>
<script src="<%=request.getContextPath()%>/resources/admin/plugins/bower_components/toast-master/js/jquery.toast.js"></script>


<script type="text/javascript">
    jQuery(document).ready(function (e) {
        <c:if test="${toast.enable}">
        // toat popup js
        jQuery.toast({
            heading: '${toast.title}',
            text: '${toast.description}',
            position: 'top-center',
            loaderBg: '#fff',
            icon: '${toast.type}',
            hideAfter: 3500,
            stack: 6
        })
        </c:if>
        $("#imageUpload").on("submit", function (e) {
            e.preventDefault();
            $("#loading").html("loading...");
            $.ajax({
                url: "<%=request.getContextPath()%>/Administration/Articles/Upload",
                type: "POST",
                data: new FormData(this),
                contentType: false,
                cache: false,
                processData: false,
                success: function (data) {
                    $("#loading").html("");
                    $("#outCode").val(data);
                }
            });
        });

        jQuery("#typeSelect").on("change", function () {
            var content = $.getJSON("<%=request.getContextPath()%>/Administration/Menu/Type?contentT=" + jQuery("#typeSelect").val(), function (data) {
                var contentSel = jQuery("#contentSelect");
                contentSel.find("option").remove();
                contentSel.css("display", "block");
                jQuery.each(data, function (i, item) {
                    contentSel.append(jQuery("<option/>")
                        .attr("value", item.id)
                        .text(item.name));
                });
            });
        });

    });
</script>

</body>

</html>
