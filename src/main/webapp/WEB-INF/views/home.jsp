<%@ include file="../views/header.jsp" %>
<body class="home">
<div class="container-fluid">
<div class="row" style="margin-top:2.0em;padding:1.0em;">
 <div class="col-md-4 col-md-offset-4" style="background:#f2f2f2;padding:2.0em;">
 <h4 class="text-center"><i class="glyphicon glyphicon-user" style="margin-right:0.2em;font-size:1.5em;"></i>Admin Login</h4><br/>
 <form:form method="post" action="/springhospitalsystem/" modelAttribute="loginBean">
 <p class="text-danger">${ msg } </p>
 <div style="margin-bottom:1.5em;">
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <form:input path="loginId" class="form-control" placeholder="Email or Username" required="required"/>
  </div><br/>
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    <form:input path="password" type="password" class="form-control" placeholder="Password" required="required"/>
  </div>
  </div>
 <button class="btn btn-default" style="background:#ff1a1a;border:0em;color:#fff;width:100%;"><b>Login</b></button>
 </form:form>
 </div>
</div>
</div>

<script src="<c:url value="/resources/bootstrap/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
</body>
</html>
