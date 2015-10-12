<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Manage Town</title>
<!-- CUSTOM SCRIPTS -->

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/ManageTown.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

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
			<h1 class="page-header">Town Management</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-9">
			<form:form action="${pageContext.request.contextPath}/admin/towns/save"
				class="form-horizontal" id="townmanage" modelAttribute="Town"
				method="POST">

				<label class="col-md-3">Country Name:</label>
				<div class="form-group input-group col-md-9">
					<form:select path="city.state.country.countryId" id="countryId"
						onchange="getState()" class="form-control" name="tcountry">
						<form:option value="0" label="---Select-------" />
						<c:forEach var="country" items="${countries}">
							<form:option value="${country.countryId}">${country.countryName}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="city.state.country.countryId" />
				</div>

				<label class="col-md-3">State Name:</label>
				<div class="form-group input-group col-md-9">


					<form:select path="city.state.stateId" id="townStates"
						onchange="getCity()" class="form-control">
						<form:option value="0" label="---Select-------" />
						<c:forEach var="state" items="${states}">
							<form:option value="${state.stateId}">${state.stateName}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="city.state.stateId" />

				</div>
				<label class="col-md-3">City Name:</label>
				<div class="form-group input-group col-md-9">

					<form:select path="city.cityId" id="stateCities"
						class="form-control">
						<form:option value="0" label="---Select-------" />
						<c:forEach var="city" items="${cities}">
							<form:option value="${city.cityId}">${city.cityName}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="city.cityId" />

					
				</div>
				<label for="townName" class="col-md-3">Town Name:</label>
				<div class="form-group input-group col-md-9">

					<form:input path="townName" maxlength="30" size="25"
						class="form-control" name="ttowm" />
					<form:errors path="townName" />


				</div>
				<div class="col-md-5 col-md-offset-6">
					<button type="submit" class="btn btn-success" name="save">ADD</button>
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
									<th>Town Id</th>
									<th>Town Name</th>
									<th>Country(Id)</th>
									<th>State(Id)</th>
									<th>City(Id)</th>
									<th>Edit</th>
									<th>Delete</th>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="town" items="${towns}">
									<tr class="odd gradeX">
										<td style="text-align: center;">${town.townId}</td>
										<td>${town.townName}</td>
										<td>${town.city.state.country.countryName}&nbsp|&nbsp(${town.city.state.country.countryId})</td>
										<td>${town.city.state.stateName}&nbsp|&nbsp(${town.city.state.stateId})</td>
										<td>${town.city.cityName}&nbsp|&nbsp(${town.city.cityId})</td>
										<td><a
											href="${pageContext.request.contextPath}/admin/towns/edit/${town.townId}/${town.city.state.country.countryId}/${town.city.state.stateId}"
											>Edit</a></td>
										<td class="center"><a
											href="${pageContext.request.contextPath}/admin/towns/delete/${town.townId}"
											onclick="return confirm('Do you want to Remove Town ${town.townName}')"><button
													class="btn btn-danger btn-xs">
													<i class="fa fa-trash"></i> Delete
												</button></a></td>

									</tr>
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