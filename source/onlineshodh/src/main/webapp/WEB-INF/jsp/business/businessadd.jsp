<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Business</title>


<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />
<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.css"
	rel="stylesheet" />

<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/intlTelInput.css"
	rel="stylesheet" />

<!-- DATA TABLE STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />

<!-- metis STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/metisMenu.min.css"
	rel="stylesheet" />

<!--Jancy STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jasny-bootstrap.min.css"
	rel="stylesheet" />


<!--CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/codejs/viewSubCategory.js"></script>

</head>
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
						<li><a href="#"><i class="fa fa-user-plus"></i> My Profile, ${pageContext.request.userPrincipal.name}</a></li>
						<li class="divider"></li>
						<li><a href="javascript:formSubmit()"><i class="fa fa-sign-out"></i> Logout</a></li>
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
					<img src="${pageContext.request.contextPath}/admin/clients/load/logo/${userDeailsId}" class="img-circle" />


					</div>

				</li>
				<li><a href="#"> <strong>OnlineShodh@mail.com </strong></a></li>

				<li><a href="<%=request.getContextPath()%>/admin/home"><i
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


				<li class="active"><a href="#"><i class="fa fa-"></i>Business
						Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a class="active-menu"
							href="${pageContext.request.contextPath}/admin/clients/view/">
								<i class="fa fa-user-plus"></i> Add Business
						</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/business/getAllBusiness"  class="active-menu"> <i class="fa fa-list"></i> List Business
						</a></li>

					</ul></li>

				<li><a href="add-client.html"><i class="fa fa-rss"></i>Plan
						Management <span class="fa arrow"></span></a>
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
							href="${pageContext.request.contextPath}/admin/plans/planAssign">
								<i class="fa fa-list"></i> Assign Business Plan
						</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-photo "></i>Advt. Banner<span
						class="fa arrow"></span></a>

					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/banners"><i
								class="fa fa-cogs "></i>Add New Advt. Banner</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/banners/showBanners"><i class="fa fa-bullhorn "></i>List All
								Advt. Banner</a></li>
					</ul></li>

	                      <li>
                        <a href="${pageContext.request.contextPath}/admin/payments" class="active-"><i class="fa fa-money "></i>Payment Mode <span class="fa arrow"></span></a>
                    </li>
			<li><a href="${pageContext.request.contextPath}/admin/business/Businessenqury"><i class="fa fa-search "></i>Enquiry</a>
			</li>
			<li><a href="#"><i class="fa fa-signal "></i>Logs <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#"><i class="fa fa-cogs "></i>List All Logs</a></li>
				</ul></li>
			<li><a href="#"><i class="fa fa-envelope "></i>Mails <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#"><i class="fa fa-cogs "></i>List All Mails</a>
					</li>

				</ul></li>
			<li><a href="#"><i class="fa fa-cogs "></i>Settings <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#"><i class="fa fa-cogs "></i>Second Link</a></li>
					<li><a href="#"><i class="fa fa-bullhorn "></i>Second Link</a>
					</li>
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
						<h3 class="page-header">Add Business Details</h3>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<form:form
							action="${pageContext.request.contextPath}/admin/business/new/save"
							method="POST" class="form-horizontal" name="bclientupdate"
							id="bclientupdate" modelAttribute="businessdetail"
							enctype="multipart/form-data">
							<form:hidden path="businessId" />
							<form:hidden path="businessLogo" />
							<form:hidden path="address.addressId" />
							<form:hidden path="userDetails.userDetailsId"
								value="${userDetailsId}" />
							<div class="col-lg-8">
								<%-- <div class="col-lg-12 space">
									<label for="businessid" class="col-sm-5 control-label">Business
										Id</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-chain"></span></span> 
											<form:input path="" class="form-control" id="businessid" name="businessid"	placeholder="" />
									</div>
								</div> --%>
								<div class="col-lg-12 space">
									<label for="businame" class="col-sm-5 control-label">Business
										Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-calendar"></span></span>
										<form:input path="businessName" class="form-control"
											id="businame" name="businame" />
										<form:errors path="businessName" cssClass="errors" />
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="pname" class="col-sm-5 control-label">Business
										Description </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-align-justify"></span></span>
										<form:textarea path="businessDesc" class="form-control" />
										<form:errors path="businessDesc" cssClass="errors" />
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="pname" class="col-sm-5 control-label">Person
										Name </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:input path="personName" class="form-control"
											id="personname" name="personname" />
										<form:errors path="personName" cssClass="errors" />
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="busiEmail" class="col-sm-5 control-label">Email
										Id</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-envelope"></span></span>
										<form:input path="email" class="form-control" id="busimail"
											name="busimail" />
										<form:errors path="email" cssClass="errors" />
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="web" class="col-sm-5 control-label">
										WebSite</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-globe"></span></span>
										<form:input path="website" class="form-control" name="Website" />
										<form:errors path="website" cssClass="errors" />
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="busicategory" class="col-sm-5 control-label">
										Category</label>
									<div class="input-group col-lg-7">
										<!-- <select class="form-control">
										<option value="FOOD">FOOD</option>
										</select> -->
										

										<form:select path="subCategory.category.categoryId"
											required="" class="form-control" id="categoryname"
											name="categoryname" onchange="getSubCategories()">
											<form:option value="0" label="--- Select ---" />
											<c:forEach var="category" items="${categories}">
												<form:option value="${category.categoryId}">${category.categoryName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="subCategory.category.categoryId"
											cssClass="errors" />
									</div>
								</div>


								<div class="col-lg-12 space">
									<label for="busisubcategory" class="col-sm-5 control-label">
										Sub-Category</label>
									<div class="input-group col-lg-7">
										<!-- <select class="form-control">
										<option value="Non-Veg">Non-Veg</option>
										</select> -->

										<form:select path="subCategory.subCategoryId" required=""
											class="form-control" id="subcategoryname"
											name="subcategoryname">
											<form:option value="0" label="--- Select ---" />
											<c:forEach var="subcategory" items="${subcategories}">
												<form:option value="${subcategory.subCategoryId}">${subcategory.subCategoryName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="subCategory.subCategoryId"
											cssClass="errors" />

									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="web" class="col-sm-5 control-label">Rank</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-globe"></span></span>
										<form:input path="rank" class="form-control" />
										<form:errors path="rank" cssClass="errors" />
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="web" class="col-sm-5 control-label">
										Keywords</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-globe"></span></span>
										<form:input path="keywords" class="form-control" />
										<form:errors path="keywords" cssClass="errors" />
									</div>
								</div>
								<label for="web" class="col-sm-5 control-label">
										Business Logo</label>
								<div class="col-lg-6 col-lg-offset-5 space">								
									<div class="fileinput fileinput-new" data-provides="fileinput">
										<div class="fileinput-preview thumbnail"
											data-trigger="fileinput" style="width: 200px; height: 150px;">
											<img
												src="${pageContext.request.contextPath}/admin/business/load/logo/${businessdetail.businessId}"
												alt="...">

										</div>
										<div>
											<span class="btn btn-default btn-file"><span
												class="fileinput-new">Select image</span><span
												class="fileinput-exists">Change</span> <input type="file"
												id="file" name="file"> <form:errors
													path="businessLogo" cssClass="errors" /></span>
											<!-- <img
												src="https://s3-ap-southeast-1.amazonaws.com/tv-prod/member/photo/1186355-medium130ap.jpg"
												height="50" width="50" alt="*No Image" />  -->
											
										</div>
									</div>
								</div>

							</div>
							<div class="col-lg-6 col-lg-offset-4 space">
								<button type="submit" class="btn btn-success" id="update">Add</button>

							</div>
						</form:form>
					</div>
					<!-- /.row -->

				</div>
				<!-- /. PAGE INNER  -->




				<footer class="space"> &copy; 2015 OnlineShodh | By : <a
					href="www.softinfology.com" target="_blank">Softinfology</a> </footer>
			</div>

			<!-- /. PAGE WRAPPER  -->
		</div>

	</div>
	<!-- /. WRAPPER  -->

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/validation/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script>


	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/bootstrap.js"></script>

	<!-- validation SCRIPTS -->

	<script
		src="<%=request.getContextPath()%>/resources/js/validation/businessvalidation.js"></script>



	<!-- JANSY BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jasny-bootstrap.js"></script>

	<!-- METIMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/metisMenu.min.js"></script>



	<!-- Input Telephone SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/intlTelInput.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

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