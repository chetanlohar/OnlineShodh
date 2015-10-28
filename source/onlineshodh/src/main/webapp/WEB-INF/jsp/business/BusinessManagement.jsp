<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- JQUERY SCRIPTS -->
<script
	src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>


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
<!-- JQUERY SCRIPTS -->
<script
	src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>

<script type="text/javascript">
	function getClientDetails() {
		
		$.ajax({
					type : "POST",
					url : "/onlineshodh/admin/search/business/client",
					dataType : 'json',
					data : {
						"searchBy" : $('#searchBy').val(),
						"keyword" : $('#keyword').val()
					},
					success : function(response) {
						var json = response;
						console.log(response)

						$('#dataTables-example').find('option').remove().end();
						jQuery
								.each(
										response,
										function(index, item) {

											for ( var i in json) {

												alert(json[i].userDetails.userId)
												var newRow = jQuery('<tr><td>'
														+ json[i].userDetails.userId
														+ '</td><td>'
														+ json[i].userDetails.regDate
														+ '</td><td>'
														+ json[i].userDetails.name
														+ '</td><td>'
														+ json[i].email
														+ '</td><td>'
														+ json[i].userDetails.phone1
														+ '</td><td>'
														+ json[i].userDetails.phone2
														+ '</td><td>'
														+ json[i].userDetails.userId
														+ '</td><td><img src=${pageContext.request.contextPath}/admin/business/load/logo/'+json[i].userDetails.userDetailsId+'/>'

														+ '</td><td>'+'<a href="${pageContext.request.contextPath}/prashant/businessdetail/">'+'Select'+'</a></td></tr>');
												jQuery('#dataTables-example')
														.append(newRow);

											}
											
											
				
											

										});

					},
					error : function(e) {
						console.log(e)
					}
				});
	}
</script>


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

				<li ><a href="forms.html"><i
						class="fa fa-user fa-fw"></i> Client Management<span
						class="fa arrow"></a>
					<ul class="nav nav-second-level">
						<li><a 
							href="<%=request.getContextPath()%>/prashant/clientcreate">Manage
								Client</a></li>
					</ul></li>


				<li class="active"><a href="#"><i class="fa fa-"></i>Business Management <span
						class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a class="active-menu"
							href="<%=request.getContextPath()%>/prashant/businessmanage">
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
							href="${pageContext.request.contextPath}/admin/banners"><i
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
						<h1 class="page-header">Business Management</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-10">
						<form class="form-horizontal" name="clientsearch"
							id="clientsearch">
							<div class="col-lg-10">
								<div class="col-lg-6 space">
									<label for="mailid" class="col-sm-5 control-label">Search
										By:</label>
									<div class="input-group">
										<select class="form-control" id="searchBy" name="searchBy">
											<option value="ID">ID</option>
											<option value="Name">Name</option>
											<option value="UserName">UserName</option>
										</select>
									</div>
								</div>
								<div class="col-lg-6 space">
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span> <input type="text"
											class="form-control" id="keyword"
											name="keyword">
									</div>
								</div>
								<div class="col-lg-6 col-lg-offset-6 space">
									<button type="submit" class="btn btn-info" id="display" onclick="getClientDetails()" >
										<i class="fa fa-search"></i> Search
									</button>

								</div>
						</form>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12 space">
						<div class="panel panel-default">
							<div class="panel-heading">Client Table</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Client ID</th>
												<th>Registration Date</th>
												<th>Name</th>
												<th>Email Id</th>
												<th>Primary Contact</th>
												<th>Secondary Contact</th>
												<th>Address</th>
												<th>Photo</th>
												<th>Select</th>

											</tr>
										</thead>
										<tbody>
											

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

	<script>
		$(document).ready(function() {

		});
	</script>
</body>
</html>



 --%>










<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- JQUERY SCRIPTS -->
<script
	src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#searchButton')
				.click(
						function() {
							$
									.ajax({
										type : "POST",
										url : "/onlineshodh/admin/search/business/client",
										dataType : 'json',
										data : {
											"searchBy" : $('#searchBy').val(),
											"keyword" : $('#keyword').val()
										},
										success : function(response) {

											console.log(response)

											$('#dataTables-example')
													.find('.ab').remove();
											jQuery
													.each(
															response,
															function(index,
																	item) {

																var json = response;
																for ( var i in json) {
                                                                  if(i == 1){
                                                                	  break;
                                                                  }
																	/* alert(json[i].userDetailsId)
																	alert(json[i].length) */
																	var newRow = jQuery('<tr class="ab"><td>'
																			+ json[i].userDetailsId
																			+ '</td><td>'
																			+ json[i].regDate
																			+ '</td><td>'
																			+ json[i].name
																			+ '</td><td>'
																			+ json[i].email
																			+ '</td><td>'
																			+ json[i].phone1
																			+ '</td><td>'
																			+ json[i].phone2
																			+ '</td><td>'
																			+ json[i].userId
																			+ '</td><td><img src=${pageContext.request.contextPath}/admin/clients/load/logo/'+json[i].userDetailsId+'/>'

																			+ '</td><td>'
																			+ '<a href=${pageContext.request.contextPath}/admin/business/'+json[i].userDetailsId+'>'
																			+ 'Select'
																			+ '</a></td></tr>');
																	jQuery(
																			'#dataTables-example')
																			.append(
																					newRow);

																}
                                                               
															});

										},
										error : function(e) {
											console.log(e)
										}
									})

						});
	});
</script>
</head>
<body>
	<form>
		<p>
			<label>Search By</label> <select id="searchBy" name="searchBy">
				<option value="1">By Id</option>
				<option value="2">By Name</option>
				<option value="3">By Username</option>
				<option value="4">By Businessname</option>
			</select>
		</p>
		<p>
			<input id="keyword" type="text" name="keyword">
		</p>
		<p>
			<input type="button" value="Search" id="searchButton">
		</p>
	</form>

	<%-- <form:form method="POST" action="#" modelAttribute="SearchBusiness">
		<p>
			<label>Search By</label> <form:select path="searchBy" id="searchBy" name="searchBy">
                <form:option value="1" label="By Id"/>
                <form:option value="2" label="By Name"/>
                <form:option value="3" label="By Username"/>
                </form:select>
                <form:errors path="searchBy"/>
		</p>
		<p>
			<form:input path="searchText" id="keyword" name="keyword"/>
			 <form:errors path="searchText"/>
		</p>
		<p>
			<button type="button" onclick="getClientDetails();">Search</button>
		</p>
	</form:form> --%>

	<table class="table table-striped table-bordered table-hover"
		id="dataTables-example">
		<thead>
			<tr>
				<th>Client ID</th>
				<th>Registration Date</th>
				<th>Name</th>
				<th>Email Id</th>
				<th>Primary Contact</th>
				<th>Secondary Contact</th>
				<th>Address</th>
				<th>Photo</th>
				<th>Select</th>

			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>




</body>
</html>
