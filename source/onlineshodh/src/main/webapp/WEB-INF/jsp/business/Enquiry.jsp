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
<title>Enquiry Table</title>
<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />

<!-- BOOTSTRAP STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />
<!-- metis STYLES-->
<!-- DATA TABLE STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />

<link
	href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css"
	rel="stylesheet" />
<!-- Datepicker STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker3.min.css"
	rel="stylesheet" />

<!--CUSTOM STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />
	
	
	<style type="text/css">
	.ui-autocomplete{
	
	z-index:999;
	}
	
	
	
	
	</style>

</head>
<body>

	<div id="wrapper">
<%-- 
	 <%@ include file="../header.jsp" %> --%> 
	 	
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
							href="<%=request.getContextPath()%>/prashant/clientcreate">Manage
								Client</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-briefcase"></i>Business
						Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a 
							href="${pageContext.request.contextPath}/admin/clients"> <i
								class="fa fa-user-plus"></i> Add Business
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
							href="${pageContext.request.contextPath}/admin/clients/view/"><i
								class="fa fa-cogs "></i>Add New Advt. Banner</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/banners/showBanners"><i class="fa fa-bullhorn "></i>List All
								Advt. Banner</a></li>
					</ul></li>

	   <li>
                        <a href="${pageContext.request.contextPath}/admin/payments" class="active-"><i class="fa fa-money "></i>Payment Mode <span class="fa arrow"></span></a>
                    </li>
			<li><a href="${pageContext.request.contextPath}/admin/business/Businessenqury"  class="active-menu"><i class="fa fa-search "></i>Enquiry</a>
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
					<div class="col-md-12">
						<h1 class="page-head-line">Enquiry Management</h1>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-lg-12 space">
						<div class="panel panel-default">
							<div class="panel-heading">Enquiry Management Table</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-enquiry">
										<thead>
											<tr>


												<th>Id</th>
												<th>Enquiry Name</th>
												<th>Business Name</th>
												<th>Phone</th>
												<th>Email Id</th>
												<th>Select</th>
												<th>Delete</th>
												

											</tr>
										</thead>
										<tbody>
											<c:forEach var="enquiry" items="${enquiries}">
											
												<tr>
													<td>${enquiry.businessEnquiryDetailsId}</td>
													<td>${enquiry.enquiryname}</td>
													<td>${enquiry.business.businessName}</td>
													<td>${enquiry.phone}</td>
													<td>${enquiry.email}</td>
													<td><a
														href="#"
														class="edit"><button class="btn btn-info btn-xs">
																<i class="fa fa-pencil"></i> Select
															</button></a></td>
													<td class="center"><a
														data-href="#"
														data-toggle="modal" data-target="#confirm-delete"><button
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
				<footer class="space"> &copy; 2015 OnlineShodh | By : <a
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
	<!-- Datepicker SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>

	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>


		      	<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
		
		<!-- CUSTOM SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>
		<script  src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>

	
		<script>
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));

					$('.debug-url').html(' Are you confirm to Delete Enquiry ?');
				});
	</script>



<script type="text/javascript">
$(document).ready(function() {
 	$('#dataTables-enquiry').DataTable({
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