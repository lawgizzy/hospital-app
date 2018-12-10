<%@ include file="../views/header.jsp" %>
<body>
<div class="container-fluid">
<div class="row">
<%@ include file="../views/login-header.jsp" %>
</div>
<div class="row content">
 <div class="col-md-3 sidebar">
<%@ include file="../views/side-bar.jsp" %>
 </div>
 <div class="col-md-9">
 <h4><i class="glyphicon glyphicon-user" style="margin-right:2.0em;"></i>Register Patients</h4><br/>
 <div class="row">
 <form:form method="post" action="/springhospitalsystem/login/register" modelAttribute="registerPatientBean">
  <div class="row" style="padding-left:1.0em;">
  <div class="col-md-12">
    <p class="text-danger">${ msg } </p>
  </div>
  </div>
 <div class="form-group col-md-6">
 <form:input path="firstName" type="text" class="form-control" Placeholder="First Name" required="required"/>
 </div>
  <div class="form-group col-md-6">
 <form:input path="middleName" class="form-control" Placeholder="Middle Name" required="required"/>
 </div>
 <div class="form-group col-md-6">
 <form:input path="lastName" class="form-control" Placeholder="Last Name" required="required"/>
 </div>
  <div class="form-group col-md-6">
 <form:input path="phoneOffice" class="form-control" Placeholder="Phone Number(Office)" maxlength="15" required="required"/>
 </div>
 <div class="form-group col-md-6">
 <form:input path="email" type="Email" class="form-control" Placeholder="Email Address" required="required"/>
 </div>
    <div class="form-group col-md-6">
 <form:input path="phoneHome" class="form-control" Placeholder="Phone Number(Home)" maxlength="15" required="required"/>
 </div>
  <div class="form-group col-md-6">
 <form:textarea path="address" class="form-control" cols="7" placeholder="Home Address" required="required"/>
 </div>
   <div class="form-group col-md-6">
 <form:input path="username" class="form-control" Placeholder="Username" required="required"/>
 </div> 
 <div class="col-md-12">
 <button type="submit" class="btn btn-default" style="background:#ff1a1a;border:0em;color:#fff;width:100%;">Register</button>
 </div>
 </form:form>
 </div>
 </div>
</div>
<%@ include file="../views/footer.jsp" %>