<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Management</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"/>
 <script src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script> 
 <script  src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 
$("#keyword").on("keyup",function(e){
	 $( "#keyword" ).autocomplete({
			source: '${pageContext.request.contextPath}/admin/business/searchBusiness'
	});
}); 
});
</script>
<script type="text/javascript">
	$(document).ready(function(){
 	$("#keyword1").on("keyup",function(e){
	 $("#keyword1").autocomplete({
		source: '${pageContext.request.contextPath}/admin/banners/searchBanner'
	});
});
	 
}); 
</script>


<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />

<!-- DATA TABLE STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />


<!-- Datepicker STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker3.min.css"
	rel="stylesheet" />

<!--Jancy STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jasny-bootstrap.min.css"
	rel="stylesheet" />


<!-- metis STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css"
	rel="stylesheet" />


         <script src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script> 
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
        
        
        <!-- BOOTSTRAP SIDEMENU SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>
        
                <!-- BOOTSTRAP JANSY SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/assets/jasny-bootstrap.js"></script>
        
      	<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
        	<!-- Datepicker SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>
        
          <!-- CUSTOM SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>
        <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ManageTown.js"></script>
	
	 <script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script> 
		  <script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script> 
		



</head>
<body>
<form:form action="${pageContext.request.contextPath}/admin/payments/save" modelAttribute="paymentStatus" method="POST">
<p><label>Payment For :</label>
<form:select path="payment.paymentfor">
<form:option value="BusinessAdvertisement" label="BusinessAdvertisement"/>
<form:option value="BannerAdvertisement" label="BannerAdvertisement"/>
</form:select> 
</p>
<p> <label>Business Name</label><input type="text" id="keyword" name="businessName"/></p>
<p> <label>Banner Name</label><input type="text" id="keyword1" name="bannerName"/></p>
<p><label>Payment Mode :</label>
<form:select path="payment.paymentMode.paymentModeid">
<c:forEach var="paymentmode" items="${paymentmodes}">
<form:option value="${paymentmode.paymentModeid}">${paymentmode.paymentMode}</form:option>
</c:forEach>
</form:select></p>
<p><label>Amount :</label><form:input path="payment.ammount"/></p>
 <p><form:errors path="payment.ammount" cssClass="errors"/></p>     
<p><label>Status :</label><form:input path="payment.status"/><p>
 <p><form:errors path="payment.status" cssClass="errors"/></p> 
<p><label>Remark :</label><form:input path="payment.remark"/></P>
 <p><form:errors path="payment.remark" cssClass="errors"/></p> 
<p><label>payeeName:</label><form:input path="payment.payeeName"/></p>
 <p><form:errors path="payment.payeeName" cssClass="errors"/></p> 
 <p><label>Bank Name:</label><form:input path="check.bankName"/></p>
  <p><form:errors path="check.bankName" cssClass="errors"/></p> 
<p class="sandbox-container"><label>checkDate:</label><form:input path="check.checkDate" /></p>
 <p><form:errors path="check.checkDate" cssClass="errors"/></p> 
<p><label>Check No:</label><form:input path="check.checkNo"/></p>
 <p><form:errors path="check.checkNo" cssClass="errors"/></p> 
<p><label>Check Amount:</label><form:input path="check.amount"/></p>
 <p><form:errors path="check.amount" cssClass="errors"/></p> 
<p><label>Transaction No:</label><form:input path="payment.transactionid"/></p>
 <p><form:errors path="payment.transactionid" cssClass="errors"/></p> 
<input type="submit" value="save"/>
<input type="reset" value="reset"/>
</form:form>
   

</body>
</html>