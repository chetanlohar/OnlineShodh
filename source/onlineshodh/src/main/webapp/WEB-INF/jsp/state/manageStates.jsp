<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Manage State</title>

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
<link href="${pageContext.request.contextPath}/resources/css/timeline.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />

</head>
</head>
<body>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">State Management</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-9">
			<form:form action="${pageContext.request.contextPath}/admin/states/save"
				method="POST" modelAttribute="state" class="form-horizontal"
				id="statemanage">
				<label class="col-md-3">Country Name:</label>
				<div class="form-group input-group col-md-9">

					<form:select path="country.countryId" class="form-control"
						name="scountry">
						<form:option value="0">Select</form:option>
						<c:forEach var="country" items="${countries}">
							<form:option value="${country.countryId}">${country.countryName}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="country.countryId" cssClass="errors" />
				</div>
				<label for="stateName" class="col-md-3">State Name:</label>
				<div class="form-group input-group col-md-9">

					<form:input path="stateName" title="State Name" maxlength="25"
						size="50" class="form-control" name="sstate" />
					<form:errors path="stateName" cssClass="errors" />
				</div>
				<div class="col-md-5 col-md-offset-6">
					<button type="submit" class="btn btn-success" id="saveSate"
						name="saveState">ADD</button>
				</div>
			</form:form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12 space">
			<div class="panel panel-default">
				<div class="panel-heading">State Management Table</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="dataTable_wrapper table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>State Id</th>
									<th>State Name</th>
									<th>Country/ID</th>
									<th>Edit</th>
									<th>Delete</th>

								</tr>
							</thead>
							<tbody>
								<c:set var="count" value="0" scope="page" />
								<c:forEach var="state" items="${states}">
									<tr class="odd gradeX">
										<td>${state.stateId}</td>
										<td>${state.stateName}</td>
										<td>${state.country.countryName}&nbsp|&nbsp(${state.country.countryId})</td>
										<td><a
											href="${pageContext.request.contextPath}/admin/states/edit/${state.stateId}/${state.country.countryId}"
											class="edit"><button class="btn btn-info btn-xs ">
													<i class="fa fa-pencil"></i> Edit
												</button></a></td>
										<td class="center"><a
											href="${pageContext.request.contextPath}/admin/states/delete/${state.stateId}"
											onclick="return confirm('Do you want to Remove State: ${state.stateName}')"
											class="edit"><button class="btn btn-danger btn-xs">
													<i class="fa fa-trash"></i> Delete
												</button></a></td>
									</tr>
									<c:set var="count" value="${count + 1}" scope="page" />
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->

				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->


	<!-- /. PAGE INNER  -->
	<footer> &copy; 2015 OnlineShodh | By : <a
		href="www.softinfology.com" target="_blank">Softinfology</a> </footer>


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
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>