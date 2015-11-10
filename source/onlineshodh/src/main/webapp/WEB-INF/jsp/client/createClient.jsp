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
<title>Client</title>

<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />

<!-- BOOTSTRAP STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
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
<link href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />
<!--CUSTOM SCRIPT-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/clientAddress.js"></script>
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

				<li class="active"><a href="forms.html"><i
						class="fa fa-user fa-fw"></i> Client Management<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="active-menu"
							href="${pageContext.request.contextPath}/admin/clients">Manage
								Client</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-"></i>Business Management <span
						class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/clients/view/">
								<i class="fa fa-user-plus"></i> Add Business
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/business/getAllBusiness"  > <i class="fa fa-list"></i> List Business
						</a></li>
					</ul></li>

		<li>
                            <a href="add-client.html"><i class="fa fa-rss"></i>Plan Management  <span class="fa arrow"></span></a>
                           	<ul class=" nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/plans"> <i class="fa fa-user-plus"></i> Create Plan
								
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/plans/updatePlans"> <i class="fa fa-list"></i> Update Plan
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/plans/getPlans"> <i class="fa fa-list"></i> List All Plan
							
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/plans/planAssign"> <i class="fa fa-list"></i> 
								Assign Business Plan
						</a></li>
					</ul>
                        </li>

				<li><a href="#"><i class="fa fa-photo "></i>Advt. Banner<span
						class="fa arrow"></span></a>

					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/banners"><i
								class="fa fa-cogs "></i>Add New Advt. Banner</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/banners/getAllBanners"><i class="fa fa-bullhorn "></i>List All
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
						<h1 class="page-header">Client Management</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<form:form
							action="${pageContext.request.contextPath}/admin/clients/save"
							modelAttribute="clientdetails" enctype="multipart/form-data"
							class="form-horizontal" name="clientform" id="clientform">

							<div class="col-lg-6">
								<div class="col-lg-12 space">
									<label for="mailid" class="col-sm-5 control-label">Email
										Id</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-envelope"></span></span>
										<form:input path="user.userName" class="form-control"
											id="clientname" name="clietmail"
											placeholder="example@mail.com" />
										<form:errors path="user.userName" cssClass="errors" />
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="password" class="col-sm-5 control-label">Password</label>
									<div class="input-group">
										<span class="input-group-addon"><span class="fa fa-key"></span></span>
										<form:password path="user.password" class="form-control"
											id="clientpass" name="clietpass" />
										<form:errors path="user.password" cssClass="errors" />

									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="password" class="col-sm-5 control-label">Confirm
										Password</label>
									<div class="input-group">
										<span class="input-group-addon"><span class="fa fa-key"></span></span>
										<input type="password" class="form-control"
											id="confpass" name="clietpass" />
										<form:errors path="user.password" cssClass="errors" />
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="Name" class="col-sm-5 control-label">Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>

										<form:input path="userDetails.name" class="form-control"
											id="uclientname" name="clietname" />
										<form:errors path="userDetails.name" cssClass="errors" />
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="Name" class="col-sm-5 control-label">Primary
										Contact</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-phone"></span></span>
										<form:input path="userDetails.phone1"
											class="form-control mobile-number" name="clietphone" />
										<form:errors path="userDetails.phone1" cssClass="errors" />

									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="Name" class="col-sm-5 control-label">
										Secondary Contact</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-phone"></span></span>

										<form:input path="userDetails.phone2"
											class="form-control mobile-number" name="clietphone2" />
										<form:errors path="userDetails.phone2" cssClass="errors" />

									</div>
								</div>
								<div class="col-lg-6 col-lg-offset-5 space">
									<div class="fileinput fileinput-new" data-provides="fileinput">
										<div class="fileinput-preview thumbnail"
											data-trigger="fileinput" style="width: 200px; height: 150px;">
											<img
												src="${pageContext.request.contextPath}/resources/images/user_pic.jpg"
												alt="...">

										</div>
										<div>
											<span class="btn btn-default btn-file"><span
												class="fileinput-new">Select image</span><span
												class="fileinput-exists">Change</span> <input type="file"
												id="file" name="file"> <form:errors
													path="userDetails.photograph" cssClass="errors" /></span>
											<!-- <img
												src="https://s3-ap-southeast-1.amazonaws.com/tv-prod/member/photo/1186355-medium130ap.jpg"
												height="50" width="50" alt="*No Image" />  -->
											
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">

								<div class="col-lg-12 space">
									<label for="address" class="col-sm-5 control-label">Address</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-road"></span></span>
										<form:textarea path="address.address" class="form-control"
											rows="3" id="clientadd" name="address" />
										<form:errors path="address.address" cssClass="errors" />
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="address" class="col-sm-5 control-label">Street</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-road"></span></span>
										<form:textarea path="address.street" class="form-control"
											rows="2" id="clientStreet" name="Street" />
										<form:errors path="address.street" cssClass="errors" />
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="address" class="col-sm-5 control-label">LandMark</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-road"></span></span>
										<form:textarea path="address.landMark" class="form-control"
											rows="2" id="clientLandM" name="LandMark" />

									</div>
								</div>


								<%-- <div class="col-lg-12 space">
									<label for="country" class="col-sm-5 control-label">Country</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-flag"></span></span>

										
											<form:select path="address.city.state.country.countryId" class="form-control"
												name="clientcountry">
												<c:forEach var="country" items="${countries}">
												<form:option value="${country.countryName}" />
												</c:forEach>
      											</form:select>
										
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="state" class="col-sm-5 control-label">State</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:select path="address.city.state.stateId" class="form-control"
											name="clientstate">
											<form:option value="Select" />
										</form:select>

									</div>
								</div> --%>

										<div class="col-lg-12 space">
									<label for="city" class="col-sm-5 control-label">City</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>

										<form:select path="address.city.cityId" class="form-control"
											name="clientcity" id="cityId" onchange="getTown();">
											<form:option value="">--Select--</form:option>
											<c:forEach var="city" items="${cities}">
												<form:option value="${city.cityId}">${city.cityName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="address.city.cityId" cssClass="errors" />

									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="town" class="col-sm-5 control-label">Town</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:select path="address.town.townId" class="form-control"
											id="town" name="clinettown">
											<form:option value="0">--Select--</form:option> 
											<c:forEach var="town" items="${towns}">
												<form:option value="${town.townId}">${town.townName}</form:option>
											</c:forEach>
											<form:option value="25">--OtherTown--</form:option>
										</form:select>
										<form:errors path="address.town.townId" cssClass="errors" />

									</div>

								</div>
								<!-- temp other -->
								<div class="col-lg-12 space hide-div">
								<label for="Otown" class="col-sm-5 control-label">OtherTown</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<form:input path="address.townOther" class="form-control"
										id="Otown" name="otown" />
									<form:errors path="address.townOther"
										cssClass="errors" />
								</div>
</div>


								<%-- <div class="col-lg-12 space hide-div ">
									<label for="Otown" class="col-sm-5 control-label">OtherTown</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span> 
											<form:input path="address.townOther" class="form-control" id="Otown" name="otown"/>
									</div>
								</div> --%>
								<div class="col-lg-12 space">
									<label for="pincode" class="col-sm-5 control-label">Pincode</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:input path="address.pincode" class="form-control"
											id="clientpin" name="clietpin" />
										<form:errors path="address.pincode" cssClass="errors" />

									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="pincode" class="col-sm-5 control-label">Map</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:input path="address.map" class="form-control"
											id="clientmap" name="clietmap" />
									</div>
								</div>

							</div>
							<div class="col-lg-6 col-lg-offset-6 space">
								<button type="submit" name="saveClient" class="btn btn-success"
									id="display">Submit</button>
								<button type="reset" class="btn btn-danger">Cancel</button>
							</div>
						</form:form>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12 space">
						<div class="panel panel-default">
							<div class="panel-heading text-center">Client Management Table</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-client">
										<thead>
											<tr>
												<th>Client ID</th>
												<th>Client Name</th>
												<th>Email</th>
												<th>Contact</th>
												<th>Address</th>
												<th>Reg. Date</th>
												<th>Photograph</th>
												<th>Edit</th>
												<th>Delete</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="userdetail" items="${userDetails}">
												<tr class="odd gradeX">
													<td style="text-align: center;">${userdetail.userDetailsId}</td>
													<td>${userdetail.name}</td>
													<td>${userdetail.email}</td>
													<td>${userdetail.phone1}<br>${userdetail.phone2}</td>
													<td>${userdetail.address.address} ${userdetail.address.street}
														${userdetail.address.landMark} ${userdetail.address.city.cityName} ${userdetail.address.town.townName} ${userdetail.address.townOther} ${userdetail.address.pincode}
													</td>
													<td>${userdetail.regDate}</td>
													<td class="text-center"><img
														src="${pageContext.request.contextPath}/admin/clients/load/logo/${userdetail.userDetailsId}"
														height="50" width="50" alt="*No Image" /></td>
													<td><a
														href="${pageContext.request.contextPath}/admin/clients/edit/${userdetail.userDetailsId}"
														class="edit"><button class="btn btn-info btn-xs">
																<i class="fa fa-pencil"></i> Edit
															</button></a></td>
													<td class="center"><a
														href="${pageContext.request.contextPath}/admin/clients/delete/${userdetail.userDetailsId}"
														onclick="return confirm('Do you want to Remove : ${userdetail.name}"><button class="btn btn-danger btn-xs">Delete</button></a>
													</td>
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
			</div>
			<!-- /. PAGE WRAPPER  -->
		</div>

	</div>
	<!-- /. WRAPPER  -->

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
         <script src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script> 
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
        
          
                 <script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script> 
		 
			  <script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script> 
		
	  <script
		src="${pageContext.request.contextPath}/resources/js/validation/formvalidation.js"></script> 
        
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

	<script>
		$(document).ready(function() {
		 	$('#dataTables-client').DataTable({
				responsive : true
			});

		

		
		});
	</script>
		<script>
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