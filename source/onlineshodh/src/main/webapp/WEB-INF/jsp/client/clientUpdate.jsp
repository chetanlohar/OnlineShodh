<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Client</title>

<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.css"
	rel="stylesheet" />

<!--Jancy STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jasny-bootstrap.min.css"
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
						<li><a href="#"><i class="fa fa-user-plus"></i> My
								Profile</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
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
						<img
							src="<%=request.getContextPath()%>/resources/images/user_pic.jpg"
							class="img-circle" />


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

				<li class="active"><a href="forms.html"><i
						class="fa fa-user fa-fw"></i> Client Management<span
						class="fa arrow"></a>
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
						<li><a href="#"> <i class="fa fa-list"></i> List Business
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> Upgrade
								Businesss
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
						<li><a href="#"><i class="fa fa-bullhorn "></i>List All
								Advt. Banner</a></li>
					</ul></li>

		                      <li>
                        <a href="${pageContext.request.contextPath}/prashant/pay" class="active-"><i class="fa fa-money "></i>Payment Mode <span class="fa arrow"></span></a>
                    </li>
			<li><a href="blank.html"><i class="fa fa-search "></i>Enquiry</a>
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
				<form:form
							action="${pageContext.request.contextPath}/admin/clients/update"
							modelAttribute="userDetails" enctype="multipart/form-data"
							class="form-horizontal" name="clientform" id="clientformupdate">
						
					
					<form:hidden path="userDetailsId"/>
                    <form:hidden path="regDate"/>
                    <form:hidden path="userId"/>
                    <form:hidden path="email"/>
                    <form:hidden path="photograph"/>
                    
                    
                     
                   <div class="col-lg-6">
							

							<div class="col-lg-12 space">
							    
								<label for="Name" class="col-sm-5 control-label">Name</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>

									<form:input path="name" class="form-control" id="clientname"
										name="clietname" />
									<form:errors path="name" cssClass="errors" />
								</div>
							</div>
							<div class="col-lg-12 space">
								<label for="Name" class="col-sm-5 control-label">
									Primary Contact</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span>
									<form:input path="phone1" class="form-control"
										name="clietphone" />
									<form:errors path="phone1" cssClass="errors" />

								</div>
							</div>

							<div class="col-lg-12 space">
								<label for="Name" class="col-sm-5 control-label">
									Secondary Contact</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span>

									<form:input path="phone2" class="form-control"
										name="clietphone2" />
									<form:errors path="phone2" cssClass="errors" />

								</div>
							</div>
							<div class="col-lg-6 col-lg-offset-5 space">
								<div class="fileinput fileinput-new" data-provides="fileinput">
									<div class="fileinput-preview thumbnail"
										data-trigger="fileinput" style="width: 200px; height: 150px;">
										<img
											src="${pageContext.request.contextPath}/admin/clients/load/logo/${userDetails.userDetailsId}"
											id="userDetailsLogo" height="50" width="50" />

									</div>
									<div>
										<span class="btn btn-default btn-file"><span
											class="fileinput-new">Select image</span><span
											class="fileinput-exists">Change</span> <input type="file"
											id="file" name="file" value="" onchange="changeImage(this);"> <form:errors path="photograph"
												cssClass="errors" /></span>
										<!-- <img
												src="https://s3-ap-southeast-1.amazonaws.com/tv-prod/member/photo/1186355-medium130ap.jpg"
												height="50" width="50" alt="*No Image" />  -->
										
									</div>
								</div>
							</div>
					</div>
					<div class="col-lg-5">

						<div class="col-lg-12 space">
							<label for="address" class="col-sm-5 control-label">Address</label>
							<div class="input-group">
								<span class="input-group-addon"><span class="fa fa-road"></span></span>
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
						


						<div class="col-lg-12 space">
									<label for="city" class="col-sm-5 control-label">City</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>

										<form:select path="address.city.cityId" class="form-control"
											name="clientcity" id="cityId" onchange="getTown();">
											<form:option value="0">--Select--</form:option>
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
											id="town1" name="clinettown">
											<%-- <form:option value="0">--Select--</form:option> --%>
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
					<div class="col-lg-6 col-lg-offset-5 space">
						<button type="submit" name="saveClient" class="btn btn-success"
							id="display">Update</button>
							<a href="${pageContext.request.contextPath}/admin/clients">
						<button type="button" class="btn btn-info">GO Back</button></a>
					</div>
					</form:form>
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
		src="<%=request.getContextPath()%>/resources/js/validation/formvalidation.js"></script>
		 


	<!-- JANSY BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jasny-bootstrap.js"></script>

	<!-- METIMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/metisMenu.min.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});

			$(".mobile-number").intlTelInput();

			$("#town").change(function(e) {

				if ($('#town').val() == 'Other') {
					$(".hide-div").show();
				} else {
					$(".hide-div").hide();
				}

			});
		});
	</script>
</body>
</html>