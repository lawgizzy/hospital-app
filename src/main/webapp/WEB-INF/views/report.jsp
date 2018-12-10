<%@ include file="../views/header.jsp" %>
<div class="container-fluid">
<div class="row">
<%@ include file="../views/login-header.jsp" %>
</div>
<div class="row content">
  <div class="col-md-3 sidebar">
<%@ include file="../views/side-bar.jsp" %>
 </div>
 <div class="col-md-9">
 <div class="row">
 <div class="col-md-12" style="margin-top:1.5em;margin-bottom:1.5em;">
  <form:form method="post" action="/springhospitalsystem/login/report" modelAttribute="searchBean">
  <div class="input-group">
    <form:input path="searchCriteria" class="form-control" placeholder="Search"/>
    <div class="input-group-btn sbtn">
      <button class="btn btn-default searchBtn" type="submit">
        <i class="glyphicon glyphicon-search" style="color:#fff;"></i>
      </button>
    </div>
  </div>
</form:form> 
<p> ${ msg }</p>
 </div>
 <div class="col-md-12">
 <div class="table-responsive">
 <table class="table table-striped">
 <tr>
 <th>S/N</th>
 <th>Patient ID</th>
 <th>First Name</th>
 <th>Last Name</th>
 <th>Amount Paid (NGN)</th>
 <th></th>
 </tr>
 <c:forEach items="${ patientData }" var="data">
  <tr>
  <td>${ data.serial }</td>
 <td>${ data.patientId }</td>
 <td>${ data.patientFname }</td>
 <td>${ data.patientLname }</td>
 <td>${ data.amountPaid }</td>
 <td><a href="<%=request.getContextPath() %>/login/report/view-details/${ data.paymentId }" class="view">View</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
 </div>
 </div>
 </div>
</div>
<%@ include file="../views/footer.jsp" %>