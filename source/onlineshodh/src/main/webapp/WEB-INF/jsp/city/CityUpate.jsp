<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="<%=request.getContextPath()%>/resources/css/timeline.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />

</head>
</head>
<body>
	<div id="wrapper">

            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a  class="navbar-brand" href="index.html">Online Shodh

                    </a>
                </div>

                <div class="notifications-wrapper">
                    <ul class="nav">

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                                <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-tasks">
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 1</strong>
                                                <span class="pull-right text-muted">60% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                                    <span class="sr-only">60% Complete (danger)</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 2</strong>
                                                <span class="pull-right text-muted">30% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                                    <span class="sr-only">30% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 3</strong>
                                                <span class="pull-right text-muted">80% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                    <span class="sr-only">80% Complete (warning)</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 4</strong>
                                                <span class="pull-right text-muted">90% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                                    <span class="sr-only">90% Complete (success)</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a class="text-center" href="#">
                                        <strong>See Tasks List + </strong>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-user-plus"></i>  <i class="fa fa-caret-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="#"><i class="fa fa-user-plus"></i> My Profile</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="#"><i class="fa fa-sign-out"></i> Logout</a>
                                </li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </nav>
            <!-- /. NAV TOP  -->
            <nav  class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li>
                        <div class="user-img-div">
                            <img src="<%=request.getContextPath()%>/resources/images/logo.jpg" class="img-circle" />

                           
                        </div>

                    </li>
                        <li>
                            <a  href="#"> <strong>OnlineShodh@mail.com </strong></a>
                        </li>

                        <li>
                            <a  href="<%=request.getContextPath()%>/admin/home"><i class="fa fa-home "></i>Home</a>
                        </li>
                             <li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
							Category Management<span class="fa arrow"></span></a>
						     <ul class="nav nav-second-level">
							<li><a href="flot.html"><i class="fa fa-list"></i> Category Management</a></li>
							<li><a href="morris.html"> <i class="fa fa-list"></i> Sub-Category Management</a></li>
						</ul> <!-- /.nav-second-level --></li>
						
						<li class="active"><a href="tables.html"><i class="fa fa-globe fa-fw"></i>
							Location Management<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/prashant/countymanage">Country Management</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/prashant/statemanage">State Management</a>
                                </li>
                                <li class="active-menu">
                                    <a href="<%=request.getContextPath()%>/prashant/citymanage">City Management</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/prashant/Townmanage">Town Management</a>
                                </li>
                            </ul>
						 <!-- /.nav-second-level of location management --></li>
                           
                           <li><a href="forms.html"><i class="fa fa-user fa-fw"></i>
							Client Management<span class="fa arrow"></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath()%>/prashant/clientcreate">Manage Client</a></li>
						</ul></li>

                        <li>
                            <a href="add-client.html"><i class="fa fa-rss"></i>Advt. Management  <span class="fa arrow"></span></a>
                            <ul class=" nav nav-second-level">
                                <li>
                                    <a href="#">
                                        <i class="fa fa-user-plus"></i>
                                        Add New Add
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-list"></i>
                                        List All Add
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-list"></i>
                                        Add New Advt. payment
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-list"></i>
                                        List All Advt. Payment
                                    </a>
                                </li>
                            </ul>
                        </li>


                        <li>
                            <a href="forms.html"><i class="fa fa-photo "></i>Advt. Banner<span class="fa arrow"></span></a>

                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#"><i class="fa fa-cogs "></i>Add New Advt. Banner</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-bullhorn "></i>List All Advt. Banner</a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#"><i class="fa fa-sitemap "></i>Category Management <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#"><i class="fa fa-cogs "></i>List All Category</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-bullhorn "></i>New Sub Category</a>
                                </li>
                                <li>
                                    <a href="#">List Sub Category</a>
                                </li>


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
					<h1 class="page-header">City Update</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-9">
				<form action="#" class="form-horizontal">
				<label for="country" class="col-md-3">Country Name:</label>
				<div class="form-group input-group col-md-9">
					
						<select class="form-control">
						<option value="india">India</option>
						<option value="US">US</option>
						<option value="UK">UK</option>
						</select>
					</div>
					<label for="country" class="col-md-3">State Name:</label>
				<div class="form-group input-group col-md-9">
					
						<select class="form-control">
						<option value="Maharastra">Maharastra</option>
						<option value="Gujrat">Gujrat</option>
						<option value="UK">UK</option>
						</select>
					</div>
				<label for="country" class="col-md-3">City Name:</label>
					<div class="form-group input-group">
					
						<input type="text" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Add</button>
						</span>
					</div>
					
					</form>
				</div>
				<!-- /.col-lg-9 -->
				<div class="col-lg-3 col-lg-offset-5">
				<a href="<%=request.getContextPath()%>/prashant/citymanage"><button class="btn btn-info ">Go Back</button></a>"
				
				</div>
			</div>
			<!-- /.row -->
			

                       

                    <!-- /. PAGE INNER  -->
                     <footer class="space" >
            &copy; 2015 OnlineShodh | By : <a href="www.softinfology.com" target="_blank">Softinfology</a>
        </footer>
                </div>
                <!-- /. PAGE WRAPPER  -->
            </div>
	</div>
	<!-- /#wrapper -->

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/bootstrap.js"></script>
		
	<!-- METIMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/metisMenu.min.js"></script>
		
		<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

</body>
</html>