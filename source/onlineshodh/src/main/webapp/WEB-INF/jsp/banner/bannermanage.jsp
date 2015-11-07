<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Banner</title>
<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />
<!-- BOOTSTRAP STYLES-->
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
<!--CUSTOM STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />


<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/commonjs.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"> --%>
<!-- <script>
	$(function() {
		$("#datepicker").datepicker();
	});
	$(function() {
		$("#datepicker2").datepicker();
	});
	$(function() {
		$("#datepicker3").datepicker();
	});
</script> -->



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
		<nav  class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li>
                        <div class="user-img-div">
                            <img src="${pageContext.request.contextPath}/resources/images/user_pic.jpg" class="img-circle" />

                           
                        </div>

                    </li>
                        <li>
                            <a  href="#"> <strong>OnlineShodh@mail.com </strong></a>
                        </li>

                        <li>
                            <a   href="${pageContext.request.contextPath}/admin/home"><i class="fa fa-home "></i>Home</a>
                        </li>
                             <li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
							Category Management<span class="fa arrow"></span></a>
						     <ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath}/admin/categories"><i class="fa fa-list"></i> Category Management</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/subcategories"> <i class="fa fa-list"></i> Sub-Category Management</a></li>
						</ul> <!-- /.nav-second-level --></li>
						
						<li><a href="tables.html"><i class="fa fa-globe fa-fw"></i>
							Location Management<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/countries">Country Management</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/states">State Management</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/cities">City Management</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/towns">Town Management</a>
                                </li>
                            </ul>
						 <!-- /.nav-second-level of location management --></li>
                           
                           <li><a href="forms.html"><i class="fa fa-user fa-fw"></i>
							Client Management<span class="fa arrow"></a>
						<ul class="nav nav-second-level">
							<li><a href="${pageContext.request.contextPath}/admin/clients">Manage Client</a></li>
						</ul></li>
						
						
                        <li>
                            <a href="#"><i class="fa fa-briefcase"></i>Business Management  <span class="fa arrow"></span></a>
                            <ul class=" nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/clients/view/">
                                        <i class="fa fa-user-plus"></i>
                                       Add Business
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-list"></i>
                                        List Business
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-list"></i>
                                        Upgrade Businesss
                                    </a>
                                </li>
                                
                            </ul>
                        </li>

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


                        <li class="active">
                            <a href="#"><i class="fa fa-photo "></i>Advt. Banner<span class="fa arrow"></span></a>

                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/banners" class="active-menu"><i class="fa fa-cogs "></i>Add New Advt. Banner</a>
                              
                              
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-bullhorn "></i>List All Advt. Banner</a>
                                </li>
                            </ul>
                        </li>


                    <li>
                        <a href="blank.html"><i class="fa fa-search "></i>Enquiry</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-signal "></i>Logs <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-cogs "></i>List All Logs</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-envelope "></i>Mails <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-cogs "></i>List All Mails</a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-cogs "></i>Settings <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-cogs "></i>Second  Link</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-bullhorn "></i>Second Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third  Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>


                    </ul>
                </div>

            </nav>
            <!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Banner Management</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
				<form:form
							action="${pageContext.request.contextPath}/admin/banners/save"
							modelAttribute="banner" method="POST"
							enctype="multipart/form-data" id="managebanner">
							<form:hidden path="bannerId" />
							<form:hidden path="bannerLogo" />
					<div class="col-lg-10 space">
						

							<label for="category" class="col-sm-2 control-label">Category</label>
							<div class="input-group">
								<span class="input-group-addon"><span class="fa fa-flag"></span></span>
								<form:select path="category.categoryId" id="categoryId"
									class="form-control" name="bannercategory">
									<form:option value="0" label="---Select-------" />
									<c:forEach var="category" items="${categories}">
										<form:option value="${category.categoryId}">${category.categoryName}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="category.categoryId" />

							</div>
					</div>
					<div class="col-lg-10 space">
						<label for="Country" class="col-sm-2 control-label">Country</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="fa fa-flag"></span></span>

							<form:select path="city.state.country.countryId" id="countryId"
								onchange="getState()" class="form-control" >
								<form:option value="0" label="---Select-------" />
								<c:forEach var="country" items="${countries}">
									<form:option value="${country.countryId}">${country.countryName}</form:option>
								</c:forEach>
							</form:select>
							<form:errors path="city.state.country.countryId" />
						</div>
					</div>
					<div class="col-lg-10 space">
						<label for="state" class="col-sm-2 control-label">state</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="fa fa-flag"></span></span>
							<form:select path="city.state.stateId" id="townStates"
								onchange="getCity()" class="form-control" >
								<form:option value="0" label="---Select-------" />
								 <c:forEach var="state" items="${states}">
									<form:option value="${state.stateId}">${state.stateName}</form:option>
								</c:forEach> 
							</form:select>
							<form:errors path="city.state.stateId" />

						</div>
					</div>
					<div class="col-lg-10 space">
						<label for="city" class="col-sm-2 control-label">city</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="fa fa-flag"></span></span>
							<form:select path="city.cityId" id="stateCities"
								class="form-control" >
								<form:option value="0" label="---Select-------" />
								 <c:forEach var="city" items="${cities}">
									<form:option value="${city.cityId}">${city.cityName}</form:option>
								</c:forEach> 
							</form:select>
							<form:errors path="city.cityId" />

						</div>
					</div>
					<div class="col-lg-7  space">
						<label for="banner" class="col-sm-2 control-label">Banner</label>
						<div class="fileinput fileinput-new col-lg-offset-1"
							data-provides="fileinput">
							<div class="fileinput-preview thumbnail" data-trigger="fileinput"
								style="width: 200px; height: 150px;">
									<img
							src="<%=request.getContextPath()%>/resources/images/user_pic.jpg"
							class="img-responsive" />
									
					</div>
							<div>
								<span class="btn btn-default btn-file"><span
									class="fileinput-new">Select image</span><span
									class="fileinput-exists">Change Image</span> <input type="file"
									id="file" name="file" onchange="changeImage(this);">
									<form:errors path="bannerLogo" cssClass="errors" />
									<!-- <img id="bannerLogo" height="50" width="50" /> </span> --> 
								
							</div>
						</div>
					</div>
					<div class="col-lg-10 space">
						<label for="url" class="col-sm-2 control-label">Banner Name</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="fa fa-photo"></span></span>
							<form:input path="bannerName" class="form-control" id="bannerurl" />
						</div>
						<form:errors path="bannerName" cssClass="errors" />
					</div>
					
					<div class="col-lg-10 space">
						<label for="url" class="col-sm-2 control-label">Url Link</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="fa fa-globe"></span></span>
							<form:input path="urlLink" class="form-control" id="bannerur" />
						</div>
						<form:errors path="urlLink" cssClass="errors" />
					</div>
					<div class="col-lg-10 space">
						<label for="date" class="col-sm-2 control-label">Start
							Date</label>
						<div class="input-group sandbox-container">
							<span class="input-group-addon"><span
								class="fa fa-calendar"></span></span>

							<form:input path="startDate" class="form-control" id="startDate"
								/>
							<form:errors path="startDate" cssClass="errors" />

						</div>
					</div>
					<div class="col-lg-10 space">
						<label for="date" class="col-sm-2 control-label">Expiry
							Date</label>
						<div class="input-group sandbox-container">
							<span class="input-group-addon"><span
								class="fa fa-calendar"></span></span>

							<form:input path="expiryDate" class="form-control" id="expiryDate"
								/>
							<form:errors path="expiryDate" cssClass="error" />
						</div>
					</div>
					<div class="col-lg-10 space">
						<label for="date" class="col-sm-2 control-label">Registration
							Date</label>
						<div class="input-group sandbox-container">
							<span class="input-group-addon"><span
								class="fa fa-calendar"></span></span>

							<form:input path="regDate" class="form-control" />
							
						</div>
						<form:errors path="regDate" cssClass="error" />
					</div>
						<div class="col-lg-10 space">
						<label for="status" class="col-sm-2 control-label">Status</label>
						<div class="input-group">
							<span class="input-group-addon"><span class="fa fa-globe"></span></span>
							<form:input path="status" class="form-control" id="status" />
							
						</div>
						<form:errors path="status" cssClass="errors" />
					</div>
					
					
					<div class="col-lg-6 col-lg-offset-5 space">
						<button type="submit" class="btn btn-success" id="display"
							name="save" value="Save ">Submit</button>
						<button type="reset" class="btn btn-danger">Cancel</button>
						</form:form>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12 space">
						<div class="panel panel-default">
							<div class="panel-heading">Banner Management Table</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-banner">
										<thead>
											<tr>


												<th>Banner ID</th>
												<th>Category ID</th>
												<th>City ID</th>
												<th>Banner Picture</th>
												<th>Register Date</th>
												<th>Start Date</th>
												<th>Expiry Date</th>
												<th>URL Link</th>
												<th>Total Hits</th>
												<th>Status</th>
												<th>Edit</th>
												<th>Delete</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="banner" items="${banners}">
											<tr class="odd gradeX">
											
													<td>${banner.bannerId}</td>
													<td>${banner.category.categoryId}</td>
													<td>${banner.city.cityId}</td>
													<td class="text-center"><img
														src="${pageContext.request.contextPath}/admin/banners/load/logo/${banner.bannerId}"
														class="img-responsive" width="50px " height="50px;" /></td>

													<td>${banner.regDate}</td>
													<td>${banner.startDate}</td>
													<td>${banner.expiryDate}</td>
													<td>${banner.urlLink}</td>
													<td>${banner.totalHit}</td>
													<td>${banner.status}</td>


													<td><a
														href="${pageContext.request.contextPath}/admin/banners/edit/${banner.bannerId}"
														class="edit"><button class="btn btn-info btn-xs">
																<i class="fa fa-pencil"></i> Edit
															</button></a></td>
													<td class="center"><a
														href="${pageContext.request.contextPath}/admin/banners/delete/${banner.bannerId}"
														onclick="return confirm('Do you want to Remove Banner: ${banner.bannerId}')"><button
																class="btn btn-danger btn-xs">
																<i class="fa fa-trash"></i> Delete
															</button> </a></td>
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

	
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
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
	  <script
		src="${pageContext.request.contextPath}/resources/js/validation/bannervalidation.js"></script> 
	
        	<script>
		$(document).ready(function() {
		 	$('#dataTables-banner').DataTable({
				responsive : true
			});

		

		
		});
	</script>
</body>
</html>