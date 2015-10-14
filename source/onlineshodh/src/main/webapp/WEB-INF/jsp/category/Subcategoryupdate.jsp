<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Country</title>

<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.css"
	rel="stylesheet" />
	
	<!--Jancy STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/jasny-bootstrap.min.css"
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

</head>
</head>
<body>
	
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Sub-Categories Update</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-9">
				<form action="#" class="form-horizontal" id="subcategoryupdate">
				  <div class="col-lg-12 space">
                                        <label for="Name" class="col-sm-5 control-label"> Category Name</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <select class="form-control" id="categorynameup" name="categorynameup" >
                                            <option value="food">FOOD</option>
                                            <option value="travling">TRAVLE</option>
                                            </select>
                                        </div>
                                    </div>
				
				  <div class="col-lg-12 space">
                                        <label for="Name" class="col-sm-5 control-label"> Sub-Category Name</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <input type="text" class="form-control" id="subcategorynameup" name="subcategorynameup" >
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-12 space">
                                        <label for="address" class="col-sm-5 control-label">Description</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-road"></span></span> 
                                            <textarea class="form-control" rows="3" id="subcategorydescup" name="subcategorydescup" ></textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-6 col-lg-offset-5 space">
                                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                            <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 200px; height: 150px;">
                                                <img src="<%=request.getContextPath()%>/resources/images/user_pic.jpg" alt="...">

                                            </div>
                                            <div>
                                                <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="..."></span>
                                                <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    
                                    
					  <div class="col-lg-6 col-lg-offset-6 space">
                                    <button type="submit" class="btn btn-success" id="display">Update</button>
                                    <button type="reset" class="btn btn-danger">Cancel</button>
                                </div>
					</form>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			
                    <!-- /. PAGE INNER  -->
                     <footer >
            &copy; 2015 OnlineShodh | By : <a href="www.softinfology.com" target="_blank">Softinfology</a>
        </footer>
              

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
	
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
		
		<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
</body>
</html>