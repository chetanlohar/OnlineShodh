<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Country</title>

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

</head>
</head>
<body>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Banner Management</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-10 space">
			<label for="category" class="col-sm-2 control-label">Category</label>
			<div class="input-group">
				<span class="input-group-addon"><span class="fa fa-flag"></span></span>
				<select class="form-control" name="bannercategory">
					<option value="">Select</option>
					<option value="Food">Food</option>
				</select>
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="Country" class="col-sm-2 control-label">Country</label>
			<div class="input-group">
				<span class="input-group-addon"><span class="fa fa-flag"></span></span>
				<select class="form-control" name="bannerCountry">
					<option value="">Select</option>
					<option value="india">India</option>
				</select>
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="state" class="col-sm-2 control-label">state</label>
			<div class="input-group">
				<span class="input-group-addon"><span class="fa fa-flag"></span></span>
				<select class="form-control" name="bannerstate">
					<option value="">Select</option>
					<option value="maharastra">Maharastra</option>
				</select>
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="city" class="col-sm-2 control-label">city</label>
			<div class="input-group">
				<span class="input-group-addon"><span class="fa fa-flag"></span></span>
				<select class="form-control" name="bannercity">
					<option value="">Select</option>
					<option value="pune">pune</option>
				</select>
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
						alt="...">

				</div>
				<div>
					<span class="btn btn-default btn-file"><span
						class="fileinput-new">Select image</span><span
						class="fileinput-exists">Change</span><input type="file"
						name="..."></span> <a href="#"
						class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
				</div>
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="url" class="col-sm-2 control-label">UrlLink</label>
			<div class="input-group">
				<span class="input-group-addon"><span class="fa fa-globe"></span></span>
				<input type="text" class="form-control" id="bannerurl"
					name="bannerurl">
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="date" class="col-sm-2 control-label">Start Date</label>
			<div class="input-group sandbox-container">
				<span class="input-group-addon"><span class="fa fa-calendar"></span></span>
				<input type="text" class="form-control" id="startdate"
					name="startdate">
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="date" class="col-sm-2 control-label">Expiry Date</label>
			<div class="input-group sandbox-container">
				<span class="input-group-addon"><span class="fa fa-calendar"></span></span>
				<input type="text" class="form-control" id="Expirydate"
					name="Expirydate">
			</div>
		</div>
		<div class="col-lg-10 space">
			<label for="date" class="col-sm-2 control-label">Registration
				Date</label>
			<div class="input-group sandbox-container">
				<span class="input-group-addon"><span class="fa fa-calendar"></span></span>
				<input type="text" class="form-control" id="rgdate" name="rgdate">
			</div>
		</div>
		<div class="col-lg-6 col-lg-offset-5 space">
			<button type="submit" class="btn btn-success" id="display">Submit</button>
			<button type="reset" class="btn btn-danger">Cancel</button>
		</div>
	</div>
	<!-- /.row -->
	
            <div class="row">
                <div class="col-lg-12 space">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Client Management Table
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Banner ID</th>
                                            <th>category ID</th>
                                            <th>City ID</th>
                                            <th>Banner Picture</th>
                                            <th>Registerd Date</th>
                                            <th>Start Date</th>
                                            <th>Expiry Date</th>
                                            <th>Url</th>
                                            <th>Total Hits</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td>1</td>
                                            <td>Pune</td>
                                            <td>Maharastra</td>
                                            <td>India</td>
                                            <td>Pune</td>
                                            <td>Maharastra</td>
                                            <td class="text-center"> <img src="<%=request.getContextPath()%>/resources/images/user_pic.jpg" class="img-responsive"  width="50px " height="50px;"/>
                                            </td>
                                            
                                            <td><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>  Edit</button></td>
                                            <td class="center"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i>  Delete</button></td>
                                            
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>2</td>
                                            <td>Kept Home</td>
                                            <td>New York</td>
                                            <td>America</td>
                                            <td>Pune</td>
                                            <td>Maharastra</td>
                                            <td> <img src="<%=request.getContextPath()%>/resources/images/user_pic.jpg" class="img-responsive"  width="50px " height="50px;"/>
                                            </td>
                                            <td><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>  Edit</button></td>
                                            <td class="center"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i>  Delete</button></td>
                                            
                                        </tr>
                                         <tr class="even gradeC">
                                            <td>2</td>
                                            <td>Kept Home</td>
                                            <td>New York</td>
                                            <td>America</td>
                                            <td>Pune</td>
                                            <td>Maharastra</td>
                                            <td> <img src="<%=request.getContextPath()%>/resources/images/user_pic.jpg" class="img-responsive"  width="50px " height="50px;"/>
                                            </td>
                                            <td><a href="<%=request.getContextPath()%>/prashant/clientupdate" class="edit"><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>  Edit</button></a></td>
                                            <td class="center"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i>  Delete</button></td>
                                            
                                        </tr>
                                         <tr class="even gradeC">
                                            <td>2</td>
                                            <td>Kept Home</td>
                                            <td>New York</td>
                                            <td>America</td>
                                            <td>Pune</td>
                                            <td>Maharastra</td>
                                            <td> <img src="<%=request.getContextPath()%>/resources/images/user_pic.jpg" class="img-responsive"  width="50px " height="50px;"/>
                                            </td>
                                            <td><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>  Edit</button></td>
                                            <td class="center"><button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i>  Delete</button></td>
                                            
                                        </tr>
            
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



	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>


	<script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/formvalidation.js"></script>

	<!-- Datepicker SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>

	<!-- JANSY BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jasny-bootstrap.js"></script>


	<!-- METIMENU SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
		        <!-- CUSTOM SCRIPTS -->
        <script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>
        
       

</body>
</html>