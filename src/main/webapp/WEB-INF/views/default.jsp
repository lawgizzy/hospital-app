<%@ include file="../views/header.jsp" %>
<body>
<div class="container-fluid">
<div class="row" style="margin-bottom:1.5em;">
<jsp:include page="../views/login-header.jsp"></jsp:include>
</div>
<div class="container-fluid content">
<div class="row">
<h4>This Application helps administrators in Patients' registration, posting of payments and generating report of all payments received.</h4><br/>
 <div class="col-md-4 text-center text-info" style="background-color:#0073e6;padding:2.0em;">
 <a class="homeNavLinks" href="<%=request.getContextPath() %>/login/register" style="text-decoration:none;">
 <h3 class="info"><i class="glyphicon glyphicon-user icons"></i><br/><span>Patients Registration</span></h3>
 <p class="info">Ensure Patient details provided are entered accurately.</p>
 </a>
 </div>
 <div class="col-md-4 text-center text-info" style="background-color:#66ccff;padding:2.0em;">
  <a class="homeNavLinks" href="<%=request.getContextPath() %>/login/post-payment" style="text-decoration:none;">
 <h3 class="info"><i class="glyphicon glyphicon-briefcase icons"></i><br/><span>Post Payments</span></h3>
 <p class="info">Post all payments here.</p>
 </a>
 </div>
  <div class="col-md-4 text-info text-center" style="background-color:#cc0000;padding:2.0em;">
   <a class="homeNavLinks" href="<%=request.getContextPath() %>/login/report" style="text-decoration:none;">
 <h3 class="info"><i class="glyphicon glyphicon-user icons"></i><br/><span>Generate Report</span></h3>
 <p class="info">Find all registered payments using the search functionality.</p>
  </a>
 </div>
</div>
</div>

<%@ include file="../views/footer.jsp" %>