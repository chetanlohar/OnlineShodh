<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Country</title>

<!-- BOOTSTRAP STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />
	
	<!-- DATA TABLE STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />
	
<!-- metis STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css"
	rel="stylesheet" />
<!--CUSTOM STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />

</head>
</head>
<body>
	
<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Country Management</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-9">
				<form:form action="${pageContext.request.contextPath}/admin/countries/save" method="post" modelAttribute="country" class="form-horizontal" id="countryupdate">
				<form:hidden path="countryId"/>
				<label for="countryName" class="col-md-3">Country Name:</label>
					<div class="form-group input-group col-md-9">
					<form:input path="countryName" title="Country Name" maxlength="25" size="50" class="form-control " name="cupdate"/> 
			        <form:errors path="countryName" cssClass="errors" />
					</div>
						<div class="col-lg-6 col-lg-offset-6 ">
				<button class="btn btn-success add" type="submit" id="saveCountry" name="saveCountry">UPDATE</button>
				<a href="${pageContext.request.contextPath}/admin/countries/" class="back">GoBack</a>
				
				</div>
					</form:form>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

                    <!-- /. PAGE INNER  -->
                     <footer class="space" >
            &copy; 2015 OnlineShodh | By : <a href="www.softinfology.com" target="_blank">Softinfology</a>
        </footer>
            


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	
	
<script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script>
		<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
		
				<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/formvalidation.js"></script>
		
		
		
	<!-- METIMENU SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>
		
		<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>

</body>
</html>