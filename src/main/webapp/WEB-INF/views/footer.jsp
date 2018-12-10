<div class="row footer">
<div class="col-md-12 text-center">
<p style="color:#fff;margin-top:2.0em;">&copy;2018. Hospital Management System.<br/>Developed by Vincent </p>
</div>
</div>
</div>
<script src="<c:url value="/resources/bootstrap/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
<script>
$(function(){
$("#print").on("click",function(e){
e.preventDefault();
var pageTitle = 'Hospital Management System',
            stylesheet = '//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css',
            win = window.open('', 'Print', 'width=900,height=400');
        win.document.write('<html><head><title>' + pageTitle + '</title>' +
            '<link rel="stylesheet" href="' + stylesheet + '">' +
            '</head><body>' + $('.table, .table2')[0].outerHTML + '</body></html>');
        win.document.close();
        win.print();
        win.close();
        return false;
 });
});
</script>
</body>
</html>