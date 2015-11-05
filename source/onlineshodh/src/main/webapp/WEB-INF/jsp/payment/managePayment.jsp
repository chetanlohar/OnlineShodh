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




</head>
<body>
<form:form action="${pageContext.request.contextPath}/admin/payments/save" modelAttribute="payment" method="POST">
<p><label>Payment For :</label>
<form:select path="paymentfor">
<form:option value="BusinessAdvertisement" label="BusinessAdvertisement"/>
<form:option value="BannerAdvertisement" label="BannerAdvertisement"/>
</form:select> 
</p>
<p> <label>Business Name</label><form:input path="businessEntity.businessName" id="keyword"/></p>
<p> <label>Banner Name</label><form:input path="banner.bannerName" id="keyword1" /></p>
<p><label>Payment Mode :</label>
<form:select path="paymentMode.paymentModeid">
<c:forEach var="paymentmode" items="${paymentmodes}">
<form:option value="${paymentmode.paymentModeid}">${paymentmode.paymentMode}</form:option>
</c:forEach>
</form:select></p>
<p><label>Amount :</label><form:input path="ammount"/></p>
<p><label>Status :</label><form:input path="status"/><p>
<p><label>Remark :</label><form:input path="remark"/></P>
<p><label>payeeName:</label><form:input path="payeeName"/></p>



<%-- <p><label>isBusiness :</label><form:select path="">
<c:choose>
														<c:when test="${=='true'}">
															<form:option value="Y" label="YES"/>
														</c:when>
														<c:otherwise>
															<form:option value="N" label="NO"/>
														</c:otherwise>
</c:choose>	 

</form:select></p>
--%>	 												
 
<input type="submit" value="save"/>
<input type="reset" value="reset"/>
</form:form>
   

</body>
</html>