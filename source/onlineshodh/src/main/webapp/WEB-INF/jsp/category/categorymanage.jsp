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
<title>Category</title>

<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />
<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />
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
				<img src="${userPhoto}" class="img-circle" />


					</div>

				</li>
				<li><a href="#"> <strong>OnlineShodh@mail.com </strong></a></li>

				<li><a href="${pageContext.request.contextPath}/admin/home"><i
						class="fa fa-home "></i>Home</a></li>
				<li class="active"><a href="#"><i
						class="fa fa-sitemap fa-fw"></i> Category Management<span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="active-menu"
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


				<li><a href="#"><i class="fa fa-"></i>Business Management <span
						class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/clients/view/">
								<i class="fa fa-user-plus"></i> Add Business
						</a></li>
						<li><a href="#"> <i class="fa fa-list"></i> List Business
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/business/getAllBusiness" > <i class="fa fa-list"></i> List Business
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
						<h1 class="page-header">Categories Management</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-9">
						<form:form
							action="${pageContext.request.contextPath}/admin/categories/save"
							method="post" modelAttribute="category"
							enctype="multipart/form-data" class="form-horizontal"
							id="categorymanage">

							<div class="col-lg-12 space">
								<label for="categoryName" class="col-sm-5 control-label">
									Category Name</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<form:input path="categoryName" title="Category Name"
										maxlength="25" size="51" class="form-control"
										id="categoryname" />
									<form:errors path="categoryName" cssClass="error" />




								</div>
							</div>

							<div class="col-lg-12 space">
								<label for="categoryDesc" class="col-sm-5 control-label">Description</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-road"></span></span>
									<form:textarea path="categoryDesc" title="Category Description"
										class="form-control" rows="3" id="categorydesc"
										name="categorydesc" style="resize:none;" />
									<form:errors path="categoryDesc" cssClass="error" />

								</div>
							</div>

							<div class="col-lg-6 col-lg-offset-5 space">
								<div class="fileinput fileinput-new" data-provides="fileinput">
									<div class="fileinput-preview thumbnail"
										data-trigger="fileinput" style="width: 200px; height: 150px;">
										<img id="categorylogo"
											src="${pageContext.request.contextPath}/resources/images/user_pic.jpg"
											alt="...">

									</div>
									<div>
										<span class="btn btn-default btn-file"><span
											class="fileinput-new">Select image</span><span
											class="fileinput-exists">Change Image</span><input
											type="file" id="file" name="file"> <form:errors
												path="categoryLogo" cssClass="errors" /> </span>
										<!-- <img id="categorylogo" height="50" width="50"/> -->

									</div>
								</div>
							</div>



							<div class="col-lg-6 col-lg-offset-6 space">
								<!-- <button type="submit" class="btn btn-success" id="display"
						id="saveCategory" name="saveCategory">Submit</button> -->

								<button type="submit" class="btn btn-success" id="display"
									name="saveCategory">Submit</button>

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
							<div class="panel-heading text-center">Category Management Table</div>
							<!-- /.panel-heading -->
														<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-cat">
										<thead>
											<tr>
												<th>Category Id</th>
												<th>Picture</th>
												<th>Category Name</th>
												<th>Description</th>
												<th>Popularity</th>
												<th>Edit</th>
												<th>Delete</th>

											</tr>
										</thead>
										<tbody>
												<c:forEach var="category" items="${categories}">
												<tr class="odd gradeX">
													<td>${category.categoryId}</td>
													<%-- <td><img
														src="${pageContext.request.contextPath}/admin/categories/load/logo/${category.categoryId}"
														class="img-responsive" width="50px " height="50px;" /></td> --%>
													<td><img
														src="${pageContext.request.contextPath}/resources/images/icons/${category.imageFileName}"
														class="img-responsive" width="50px " height="50px;" /></td>
													<td>${category.categoryName}</td>
													<td>${category.categoryDesc}</td>
													<td>${category.popularity}</td>
													<td><a
														href="${pageContext.request.contextPath}/admin/categories/edit/${category.categoryId}"
														class="edit"><button class="btn btn-info btn-xs">
																<i class="fa fa-pencil"></i> Edit
															</button></a></td>

													<td class="center"><a
														data-href="${pageContext.request.contextPath}/admin/categories/delete/${category.categoryId}"
														data-toggle="modal" data-target="#confirm-delete"><button
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
			</div>
			<!-- /. PAGE WRAPPER  -->
		</div>

	</div>
	<!-- /. WRAPPER  -->
	
	
		 <div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
            
                <div class="modal-body">
                    <p>You are about to delete one track, this procedure is irreversible.</p>
                    <p>Do you want to proceed?</p>
                    <p class="debug-url"></p>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-danger btn-ok">Delete</a>
                </div>
            </div>
        </div>
    </div>
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>


	<!-- BOOTSTRAP SIDEMENU SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>

	<!-- BOOTSTRAP JANSY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jasny-bootstrap.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
	<!-- Datepicker SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/formvalidation.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>
	
		<script>
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {

					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));

					$('.debug-url').html(
							'Delete URL: <strong>'
									+ $(this).find('.btn-ok').attr('href')
									+ '</strong>');
				});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#dataTables-cat').DataTable({
				responsive : true
			});

		});
	</script>
		
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