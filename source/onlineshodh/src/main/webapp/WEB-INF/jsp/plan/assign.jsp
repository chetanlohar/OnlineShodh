<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Assign Plan</title>

<link rel="shortcut icon" type="image/jpg"
	href="${pageContext.request.contextPath}/resources/images/logo.jpg" />
<!-- BOOTSTRAP STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />

<!--Jancy STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css"
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
<link
	href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Online Shodh </a>
		</div>

		<div class="notifications-wrapper">
			<ul class="nav">

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-tasks">
						<li><a href="#">
								<div>
									<p>
										<strong>Task 1</strong> <span class="pull-right text-muted">60%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (danger)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 2</strong> <span class="pull-right text-muted">30%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"
											style="width: 30%">
											<span class="sr-only">30% Complete</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 3</strong> <span class="pull-right text-muted">80%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100" style="width: 80%">
											<span class="sr-only">80% Complete (warning)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 4</strong> <span class="pull-right text-muted">90%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="90" aria-valuemin="0"
											aria-valuemax="100" style="width: 90%">
											<span class="sr-only">90% Complete (success)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									Tasks List + </strong>
						</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user-plus"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user-plus"></i> My
								Profile, ${pageContext.request.userPrincipal.name}</a></li>
						<li class="divider"></li>
						<li><a href="javascript:formSubmit()"><i
								class="fa fa-sign-out"></i> Logout</a></li>
					</ul></li>
			</ul>

		</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li>
					<div class="user-img-div">
						<img src="${userPhoto}" class="img-circle" />
							

					</div>

				</li>
				<li><a href="#"> <strong>OnlineShodh@mail.com </strong></a></li>

				<li><a href="${pageContext.request.contextPath}/admin/home"><i
						class="fa fa-home "></i>Home</a></li>
				<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
						Category Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/categories"><i
								class="fa fa-list"></i> Category Management</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/subcategories">
								<i class="fa fa-list"></i> Sub-Category Management
						</a></li>
					</ul> <!-- /.nav-second-level --></li>

				<li><a href="tables.html"><i class="fa fa-globe fa-fw"></i>
						Location Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/countries">Country
								Management</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/states">State
								Management</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/cities">City
								Management</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/towns">Town
								Management</a></li>
					</ul> <!-- /.nav-second-level of location management --></li>

				<li><a href="forms.html"><i class="fa fa-user fa-fw"></i>
						Client Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/clients">Manage
								Client</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-briefcase"></i>Business Management <span
						class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/clients/view/">
								<i class="fa fa-user-plus"></i> Add Business
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/business/getAllBusiness">
								<i class="fa fa-list"></i> List Business
						</a></li>
					</ul></li>

				<li class="active"><a href="add-client.html"><i
						class="fa fa-rss"></i>Plan Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/plans">
								<i class="fa fa-user-plus"></i> Create Plan

						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/plans/updatePlans">
								<i class="fa fa-list"></i> Update Plan
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/plans/getPlans">
								<i class="fa fa-list"></i> List All Plan

						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/plans/planAssign"
							class="active-menu"> <i class="fa fa-list"></i> Assign
								Business Plan
						</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-photo "></i>Advt. Banner<span
						class="fa arrow"></span></a>

					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/banners"><i
								class="fa fa-cogs "></i>Add New Advt. Banner</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/banners/showBanners"><i
								class="fa fa-bullhorn "></i>List All Advt. Banner</a></li>
					</ul></li>

				<li><a href="${pageContext.request.contextPath}/admin/payments"
					class="active-"><i class="fa fa-money "></i>Payment Mode <span
						class="fa arrow"></span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/business/Businessenqury"><i
						class="fa fa-search "></i>Enquiry <small class="label pull-middle bg-green">8</small></a></li>
				<li><a href="#"><i class="fa fa-signal "></i>Logs <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>List All Logs</a></li>
					</ul></li>
				<li><a href="#"><i class="fa fa-envelope "></i>Mails <span
						class="fa arrow"></span><small class="label pull-middle bg-yellow">3</small></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>List All Mails</a>
						</li>

					</ul></li>
				<li><a href="#"><i class="fa fa-cogs "></i>Settings <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>Second Link</a></li>
						<li><a href="#"><i class="fa fa-bullhorn "></i>Second
								Link</a></li>
						<li><a href="#">Second Level<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a href="#">Third Link</a></li>
								<li><a href="#">Third Link</a></li>

							</ul></li>
					</ul></li>


			</ul>
		</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-lg-12">
						<div class="detail-title">
							<span class="detail-titile-header font17">Business Plan
								Details </span>
						</div>
						<div class="detail-wraper">
							<table class="table">
								<tr>
									<td class="lable">Business Id</td>
									<td>${business.businessId}</td>
								</tr>
								<tr>
									<td class="lable">Business Name</td>
									<td>${business.businessName}</td>
								</tr>
								<tr>
									<td class="lable">Business Logo</td>
									<td><img
										src="${pageContext.request.contextPath}/admin/business/load/logo/${business.businessId}"
										class="plan_b_img"></td>
								</tr>

							</table>

						</div>

					</div>

				</div>
				<!-- /. row  -->
				<div class="row space">
					<form:form
						action="${pageContext.request.contextPath}/admin/plans/assignPlan/${business.businessId}"
						class="form-horizontal" id="assgin_plan_form" method="POST"
						modelAttribute="businessPlan">
						<form:hidden path="business.businessId" />
						<div class="col-lg-10 space">
							<label for="mailid" class="col-sm-3 control-label">Plan
								Name:</label>
							<div class="input-group col-md-9">
								<c:if test="${msg}">
									<c:out value="Plan SucessfullyAssigned..." />
								</c:if>
								<form:select path="plan.planId" class="form-control"
									name="plan_name">
									<form:option value="0">--Select--</form:option>
									<c:forEach var="plan" items="${plans}">
										<form:option value="${plan.planId}">${plan.planName}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="plan.planId" cssClass="error" />

							</div>

						</div>

						<div class="col-lg-10 space">
							<label for="mailid" class="col-sm-3 control-label">Start
								Date:</label>
							<div class="input-group sandbox-container">
								<span class="input-group-addon"><span
									class="fa fa-calendar"></span></span>
								<form:input path="startdate" class="form-control" id="startDate" />
								<form:errors path="startdate" cssClass="error" />
							</div>

						</div>
						<div class="col-lg-10 space ">
							<label for="mailid" class="col-sm-3 control-label">End
								Date:</label>
							<div class="input-group sandbox-container">
								<span class="input-group-addon"><span
									class="fa fa-calendar"></span></span>
								<form:input path="enddate" class="form-control" id="expiryDate" />
								<form:errors path="enddate" cssClass="error" />
							</div>

						</div>
						<div class="col-lg-10 space ">
							<label for="mailid" class="col-sm-3 control-label">Status
								:</label>
							<div class="input-group col-md-9">
								<form:select path="status" class="form-control">
									<form:option value="">---Select--</form:option>
									<form:option value="NotActive">Not Active</form:option>
									<form:option value="Active">Active</form:option>
									<form:option value="InProgress">In Progress</form:option>

								</form:select>
								<form:errors path="status" cssClass="error" />
							</div>

						</div>




						<div class="col-lg-4 col-lg-offset-5 space">
							<button class="btn btn-success assign_plan">
								<i class=" fa fa-check-circle-o"></i> Assign
							</button>

							<a
								href="${pageContext.request.contextPath}/admin/plans/planAssign">
								<button class="btn btn-info" type="button">Go Back</button>
							</a>
						</div>
					</form:form>



				</div>


			</div>
			<footer> &copy; 2015 OnlineShodh | By : <a
				href="www.softinfology.com" target="_blank">Softinfology</a> </footer>

		</div>
	</div>

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script>


	<script
		src="<%=request.getContextPath()%>/resources/js/validation/planvalidation.js"></script>



	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>


	<!-- Datepicker SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>



	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

</body>
</html>