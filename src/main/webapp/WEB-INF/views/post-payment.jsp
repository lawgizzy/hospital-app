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
 <h4><i class="glyphicon glyphicon-briefcase" style="margin-right:2.0em;"></i>Post Payments</h4><br/>
 <p>All Collected payments should be posted here. Kindly ensure every detail provided is accurate.</p>
 <div class="row">
 <form:form action="/springhospitalsystem/login/post-payment" method="post" modelAttribute="postPaymentBean">
   <div class="row" style="padding-left:1.0em;">
  <div class="col-md-12">
    <p class="text-danger">${ msg } </p>
  </div>
  </div>
 <div class="form-group col-md-8">
 <form:input path="patientId" class="form-control" Placeholder="Patient Username or Id" required="required"/>
 </div>
   <div class="form-group col-md-8">
 <form:input path="amountPaid" type="number" class="form-control" Placeholder="Amount (e.g 5000)" required="required"/>
 </div>
 <div class="form-group col-md-8">
 <form:textarea path="description" class="form-control" cols="7" placeholder="Description of payment" required="required"/>
 </div>
 <div class="col-md-12">
 <button type="submit" class="btn btn-default" style="background:#ff1a1a;border:0em;color:#fff;width:66%;">Post Payment</button>
 </div>
 </form:form>
 </div>
 </div>
</div>
<%@ include file="../views/footer.jsp" %>
