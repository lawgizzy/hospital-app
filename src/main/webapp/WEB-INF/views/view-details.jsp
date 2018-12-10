<%@ include file="../views/header.jsp" %>
<body style="background:#f1f1f3;">
<div class="container-fluid">
<div class="row">
<%@ include file="../views/login-header.jsp" %>
</div>
<div class="row">
  <div class="col-md-3 sidebar">
<%@ include file="../views/side-bar.jsp" %>
 </div>
 <div class="col-md-9">
 <c:choose>
 <c:when test="${msg2==false}">
 <p>${ msg }</p>
 </c:when>
 <c:when test="${ msg2==true }">
 <div class="table-responsive" style="margin-top:1.5em;margin-bottom:1.5em;">
 <table class="table table-condensed" id="report" style="width:80%;">
 <caption><h4>Generated Report for Posted Payment (PATIENT ID: ${ patientData.patientId }) </h4></caption>
 <td>Patient ID:</td>
 <td>${ patientData.patientId }</td>
 </tr>
 <tr>
 <td>Full Name:</td>
 <td>${ patientData.patientFullName } </td>
 </tr>
  <tr>
 <td>Email Address:</td>
 <td>${ patientData.patientEmail }</td>
 </tr>
  <tr>
 <td>Phone Number (Office):</td>
 <td>${ patientData.patientPhoneOffice }</td>
 </tr>
  <tr>
 <td>Phone Number (Home):</td>
 <td>${ patientData.patientPhoneHome }</td>
 </tr>
  <tr>
 <td>Home Address</td>
 <td>${ patientData.patientAddress }</td>
 </tr>
 
  <tr>
 <td>Created Date:</td>
 <td>${ patientData.paymentDate }</td>
 </tr>
  <tr>
 <td><b>Total Amount:</b></td>
 <td><b>&#8358;${ patientData.amountPaid }.00</b></td>
 </tr>
 <tr>
 <td>Description of payment:</td>
 <td>${ patientData.paymentDescription }</td>
 </tr>
 </table>
 <div>
 </div>
 <div style="margin-left:30%;">
 <button href="" class="btn btn-default" id="print" style="background:#ff1a1a;color:#fff;border:0em;text-decoration:none;width:20%;"><b>Print</b></button>
 </div>
 </div>
 </c:when>
 </c:choose>
</div>
</div>
<%@ include file="../views/footer.jsp" %>