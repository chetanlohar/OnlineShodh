<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Business Details</title>
<!-- BOOTSTRAP STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />

<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/intlTelInput.css"
	rel="stylesheet" />

<!-- DATA TABLE STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />

<!-- metis STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css"
	rel="stylesheet" />

<!--Jancy STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jasny-bootstrap.min.css"
	rel="stylesheet" />


<!--CUSTOM STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />

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
							src="${pageContext.request.contextPath}/resources/images/user_pic.jpg"
							class="img-circle" />


					</div>

				</li>
				<li><a href="#"> <strong>OnlineShodh@mail.com </strong></a></li>

				<li><a href="${pageContext.request.contextPath}/admin/home"><i
						class="fa fa-home "></i>Home</a></li>
				<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
						Category Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/prashant/categorymanage"><i
								class="fa fa-list"></i> Category Management</a></li>
						<li><a
							href="${pageContext.request.contextPath}/prashant/subcategorymanage">
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
						Client Management<span class="fa arrow"></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/prashant/clientcreate">Manage
								Client</a></li>
					</ul></li>


				<li class="active"><a href="#"><i class="fa fa-"></i>Business
						Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a class="active-menu"
							href="${pageContext.request.contextPath}/prashant/businessmanage">
								<i class="fa fa-user-plus"></i> Add Business
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> List Business
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> Upgrade
								Businesss
						</a></li>

					</ul></li>

				<li><a href="add-client.html"><i class="fa fa-rss"></i>Advt.
						Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a href="#"> <i class="fa fa-user-plus"></i> Add New
								Add
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> List All Add
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> Add New Advt.
								payment
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> List All
								Advt. Payment
						</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-photo "></i>Advt. Banner<span
						class="fa arrow"></span></a>

					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/prashant/bannermanage"><i
								class="fa fa-cogs "></i>Add New Advt. Banner</a></li>
						<li><a href="#"><i class="fa fa-bullhorn "></i>List All
								Advt. Banner</a></li>
					</ul></li>

				<li><a href="#"><i class="fa fa-sitemap "></i>Category
						Management <span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>List All
								Category</a></li>
						<li><a href="#"><i class="fa fa-bullhorn "></i>New Sub
								Category</a></li>
						<li><a href="#">List Sub Category</a></li></li>
			</ul>
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
							<li><a href="#">Third Link</a></li>s
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
						<h3 class="page-header">Edit Business Details</h3>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
					
											<div class="detail-title">
							<span class="detail-titile-header font17">Business
								Information</span><a href="${pageContext.request.contextPath}/admin/business/update/businessinfo/${business.businessId}">&nbsp;<i class="fa fa-pencil"></i>
								Edit
							</a>
						</div>
						<div class="detail-wraper">
							<table class="table">
								<tr>
									<td>Business Id</td>
									<td>${business.businessId}</td>
								
								</tr>
								<tr>
									<td>Business Name</td>
									<td>${business.businessName}</td>
									
								</tr>
								<tr>
									<td>Business Logo</td>
									<td><img
										src="${pageContext.request.contextPath}/admin/business/load/logo/${business.businessId}"
										class="img-responsive" width="50px " height="50px;" /></td>
									
								</tr>
								<tr>
									<td>Person Name</td>
									<td>${business.personName}</td>
									
								</tr>
								<tr>
									<td>Email Id</td>
									<td>${business.email}</td>
									
								</tr>
								<tr>
									<td>Website</td>
									<td>${business.website}</td>
									
								</tr>
								<tr>
									<td>Category</td>
									<td>${business.subCategory.category.categoryName}</td>
									
								</tr>
								<tr>
									<td>Sub-Category	</td>
									<td>${business.subCategory.subCategoryName}</td>
								</tr>
							</table>
						</div>
					</div>
						<!-- <form class="form-horizontal" name="bclientupdate"
							id="bclientupdate">
							<div class="col-lg-8">
								<div class="col-lg-12 space">
									<label for="businessid" class="col-sm-5 control-label">Business
										Id</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-chain"></span></span> <input type="text"
											class="form-control" id="businessid" name="businessid"
											placeholder="">
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="businame" class="col-sm-5 control-label">Business
										Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-calendar"></span></span> <input type="text"
											class="form-control" id="businame" name="businame">
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="Logo" class="col-sm-5 control-label">Business
										Logo</label>
									<div class="fileinput fileinput-new input-group"
										data-provides="fileinput">
										<div class="form-control" data-trigger="fileinput">
											<i class="glyphicon glyphicon-file fileinput-exists"></i> <span
												class="fileinput-filename"></span>
										</div>
										<span class="input-group-addon btn btn-default btn-file"><span
											class="fileinput-new">Select file</span><span
											class="fileinput-exists">Change</span><input type="file"
											name="..."></span> <a href="#"
											class="input-group-addon btn btn-default fileinput-exists"
											data-dismiss="fileinput">Remove</a>
									</div>
								</div>
                                 <div class="col-lg-12 space">
									<label for="pname" class="col-sm-5 control-label">Person Name
										</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span> <input type="text"
											class="form-control" id="personname" name="personname">
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="busiEmail" class="col-sm-5 control-label">Email
										Id</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-envelope"></span></span> <input type="text"
											class="form-control" id="busimail" name="busimail">
									</div>
								</div>
								<div class="col-lg-12 space">
									<label for="web" class="col-sm-5 control-label">
									WebSite</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-globe"></span></span> <input type="text"
											class="form-control" name="Website">
									</div>
								</div>

								<div class="col-lg-12 space">
									<label for="busicategory" class="col-sm-5 control-label">
										Category</label>
									<div class="input-group col-lg-7">
										<select class="form-control">
										<option value="FOOD">FOOD</option>
										</select>
									</div>
								</div>
								
								
								<div class="col-lg-12 space">
									<label for="busisubcategory" class="col-sm-5 control-label">
										Sub-Category</label>
									<div class="input-group col-lg-7">
										<select class="form-control">
										<option value="Non-Veg">Non-Veg</option>
										</select>
									</div>
								</div>
								

								</div>
							</div>

							<div class="col-lg-6 col-lg-offset-4 space">
								<button type="submit" class="btn btn-success" id="update">Update</button>

							</div>
						</form>
 -->					</div><!-- /.row -->
					
					<div class="row space ">
					<div class="col-lg-12">
						<div class="detail-title">
							<span class="detail-titile-header font17">Business Address
								Information</span><a href="${pageContext.request.contextPath}/admin/business/${business.businessId}/update/address">&nbsp;<i class="fa fa-pencil"></i>
								Edit
							</a>
						</div>
						<div class="detail-wraper">
							<table class="table">
								<tr>
									<td>Address</td>
									<td>${businessDetails.address.address}</td>
								
								</tr>
								<tr>
									<td>Street</td>
									<td>${businessDetails.address.street}</td>
									
								</tr>
								<tr>
									<td>Landmark</td>
									<td>${businessDetails.address.landMark}</td>
									
								</tr>
								<tr>
									<td>Country</td>
									<td>${businessDetails.address.city.state.country.countryName}</td>
									
								</tr>
								<tr>
									<td>State</td>
									<td>${businessDetails.address.city.state.stateName}</td>
									
								</tr>
								<tr>
									<td>City</td>
									<td>${businessDetails.address.city.cityName}</td>
									
								</tr>
								<tr>
									<td>Town</td>
									<td>${businessDetails.address.town.townName}</td>
									
								</tr>
								<tr>
									<td>Pincode</td>
									<td>${businessDetails.address.pincode}</td>
								</tr>

							</table>

						</div>
						
					</div>

				</div>
				<!-- /. row  -->
				<div class="row space">
					<div class="col-lg-12">
						<div class="detail-title">
							<span class="detail-titile-header font17">Contact
								Information</span>
						</div>
							<div class="add_business_contact space">
							<form class="form-inline" id="busd_contact" method="post">
								<div class="form-group">
									<label for="contact">Add Contact:</label> <input
										type="text" class="form-control" id="bdetail_contact"
										placeholder="Contact" name="businessd_contact">
								</div>
								<input type="hidden" id="phoneurl" value="${pageContext.request.contextPath}/admin/business/${business.businessId}/phone/save"/>
								<%-- <a href="${pageContext.request.contextPath}/admin/business/${business.businessId}/phone/save" class="bd_contact"> --%>
								<button type="button" id="phonebutton" class="btn btn-success b_contact">Add</button></a>
							</form>

						</div>
						<div class="detail-wraper space">
							<table class="table busi_contact">
								<tbody>
									<c:forEach var="businessphone" items="${businessPhones}" >
										<tr>
											<td>${businessphone.buinessPhoneId}</td>
											<td>${businessphone.phone}</td>
											<td><a href="#"><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit</button></a></td>
											<td><a href="#"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					
					</div>

				</div>
				<!-- /. row  -->
				
				
					<div class="row space">
					<div class="col-lg-12">
						<div class="detail-title">
							<span class="detail-titile-header font17">Business Features/facilities</span>
						</div>
							<div class="add_features space">
							
							<%-- <form action="#" class="form-inline" id="busd_feature" method="post"> --%>
							<form action="#" class="form-inline" method="POST" id="busd_feature">
								<div class="form-group">
									<label for="Features">Add Features:</label> <input
										type="text" class="form-control" id="bus_Features"
										placeholder="Features">
								</div>
								<input type="hidden" id="featureurl" value="${pageContext.request.contextPath}/admin/business/${business.businessId}/feature/save"/>
								<!-- <a href="" class="bd_features"> -->
								<button type="button" id="featurebutton" class="btn btn-success">Add</button></a>
							</form>
						</div>
						<div class="detail-wraper space">
							<table class="table busi_feature">
								<tbody>
									<c:forEach var="info" items="${businessGeneralInfo}">
										<tr>
											<td>${info.businessGenInfoId}</td>
											<td>${info.generalInfoName}</td>
											<td><a href="#"><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Modify</button></a></td>
											<td><a href="#"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Delete</button></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /. row  -->
				</div><!-- /. PAGE INNER  -->
				
				


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
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/formvalidation.js"></script>



	<!-- JANSY BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jasny-bootstrap.js"></script>

	<!-- METIMENU SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>



	<!-- Input Telephone SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/intlTelInput.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>

</body>
</html>