<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Manage City</title>

<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.css"
	rel="stylesheet" />

<!-- DATA TABLE STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />

<!-- metis STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/metisMenu.min.css"
	rel="stylesheet" />
<!--CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />
<!-- CUSTOM SCRIPTS -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/ManageCity.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>	
</head>
</head>
<body>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">City Management</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- 	/.row -->
	<div class="row">
		<div class="col-lg-9">


			<form:form action="${pageContext.request.contextPath}/cities/save"
				method="POST" modelAttribute="City" class="form-horizontal"
				id="citymanage">

				<label class="col-md-3">Country Name:<span
					style="color: red; font-size: 18px;">*</span></label>
				<div class="form-group input-group col-md-9">



					<form:select path="state.country.countryId" id="countryId"
						class="form-control" name="country" onchange="getState()">
						<form:option value="0" label="--- Select ---" />
						<c:forEach var="country" items="${countries}">
							<form:option value="${country.countryId}">${country.countryName}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="state.country.countryId" />
				</div>
				<label class="col-md-3">State Name:<span
					style="color: red; font-size: 18px;">*</span></label>
				<div class="form-group input-group col-md-9">


					<form:select path="state.stateId" class="form-control" name="state"
						id="countryStates">
						<form:option value="0">Select</form:option>states
				 <c:forEach var="state" items="${states}">
							<form:option value="${state.stateId}">${state.stateName}</form:option>
						</c:forEach>
					</form:select>
					<form:errors path="state.stateId" />

				</div>
				<label for="cityName" class="col-md-3">City Name:<span
					style="color: red; font-size: 18px;">*</span></label>
				<div class="form-group input-group col-md-9">

					<form:input path="cityName" title="City Name" class="form-control"
						name="city" maxlength="25" size="50" />
					<form:errors path="cityName" cssClass="errors" />
				</div>
				<div class="col-md-5 col-md-offset-6">
					<button type="submit" class="btn btn-success" id="saveCity"
						name="saveCity">ADD</button>
				</div>
			</form:form>
		</div>
		<!-- 	/.col-lg-12 -->
	</div>
	<!-- 			/.row -->

	<div class="row space">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">State Management Table</div>
				<!--  /.panel-heading -->
				<div class="panel-body">
					<div class="dataTable_wrapper table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>City ID</th>
									<th>City Name</th>
									<th>State Name</th>
									<th>Country/ID</th>
									<th>Edit</th>
									<th>Delete</th>

								</tr>
							</thead>
							<tbody>
								<c:set var="count" value="0" scope="page" />
								<c:forEach var="city" items="${cities}">
									<tr class="odd gradeX">
										<td>${city.cityId}</td>
										<td>${city.cityName}</td>
										<td>${city.state.country.countryName}&nbsp|&nbsp(${city.state.country.countryId})</td>
										<td>${city.state.stateName}&nbsp|&nbsp(${city.state.stateId})</td>
										<td><a
											href="${pageContext.request.contextPath}/cities/edit/${city.cityId}/${city.state.country.countryId}"
											class="edit"><button class="btn btn-info btn-xs">
													<i class="fa fa-pencil"></i> Edit
												</button></a></td>
										<td class="center"><a
											href="${pageContext.request.contextPath}/cities/delete/${city.cityId}"
											onclick="return confirm('Do you want to Remove City ${city.cityName}')"><button
													class="btn btn-danger btn-xs">
													<i class="fa fa-trash"></i> Delete
												</button></a></td>

									</tr>
									<c:set var="count" value="${count + 1}" scope="page" />
								</c:forEach>

							</tbody>
						</table>
					</div>
					<!--  /.table-responsive -->

				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!--    /.col-lg-12 -->
	</div>
	<!-- row -->


	<!-- /. PAGE INNER  -->
	<footer> &copy; 2015 OnlineShodh | By : <a
		href="www.softinfology.com" target="_blank">Softinfology</a> </footer>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- validation SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/validation/jquery.validate.min.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/bootstrap.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/validation/formvalidation.js"></script>



	<!-- METIMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/metisMenu.min.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>



	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/ManageCity.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>


	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>