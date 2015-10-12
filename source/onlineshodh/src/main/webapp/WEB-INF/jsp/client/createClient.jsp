<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link href="<%=request.getContextPath()%>/resources/css/jasny-bootstrap.min.css"
	rel="stylesheet" />
	
	
<!--CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />

</head>
</head>
<body>
<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Client Management</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
				<form class="form-horizontal" name="clientform" id="clientform">
                                <div class="col-lg-6">
                                    <div class="col-lg-12 space">
                                        <label for="mailid" class="col-sm-5 control-label">Email Id</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-envelope"></span></span> 
                                            <input type="text" class="form-control" id="clientname" name="clietmail" placeholder="example@mail.com">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 space">
                                        <label for="password" class="col-sm-5 control-label">Password</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-key"></span></span> 
                                            <input type="password" class="form-control" id="clientpass" name="clietpass" >
                                        </div>
                                    </div>
                                    <div class="col-lg-12 space">
                                        <label for="password" class="col-sm-5 control-label">Confirm Password</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-key"></span></span> 
                                            <input type="password" class="form-control" id="clientCpass" name="clietCpass" >
                                        </div>
                                    </div>

                                    <div class="col-lg-12 space">
                                        <label for="Name" class="col-sm-5 control-label">Name</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <input type="text" class="form-control" id="clientname" name="clietname" >
                                        </div>
                                    </div>
                                    <div class="col-lg-12 space">
                                        <label for="Name" class="col-sm-5 control-label">Contact</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-phone"></span></span> 
                                            <input type="tel" class="form-control mobile-number" name="clietphone" >
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-12 space">
                                        <label for="Name" class="col-sm-5 control-label"> Secondary Contact</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-phone"></span></span> 
                                            <input type="tel" class="form-control mobile-number" name="clietphone2" >
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
                                </div>
                                <div class="col-lg-6">

                                    <div class="col-lg-12 space">
                                        <label for="address" class="col-sm-5 control-label">Address</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-road"></span></span> 
                                            <textarea class="form-control" rows="3" id="clientadd" name="address" ></textarea>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 space">
                                        <label for="country" class="col-sm-5 control-label">Country</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-flag"></span></span> 
                                            <select class="form-control" name="clientcountry">
                                                <option value="">Select</option>
                                                <option value="india">India</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 space">
                                        <label for="state" class="col-sm-5 control-label">State</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <select class="form-control" name="clientstate">
                                            <option value="">Select</option>
                                                <option value="mharastra">maharastra</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 space">
                                        <label for="city" class="col-sm-5 control-label">City</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <select class="form-control" name="clientcity">
                                            <option value="">Select</option>
                                                <option value="pune">pune</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 space">
                                        <label for="town" class="col-sm-5 control-label">Town</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <select class="form-control" id="town" name="clinettown">
                                            <option value="">Select</option>
                                                <option value="kharadi">Kharadi</option>
                                                <option value="Other">Other Town</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 space hide-div ">
                                        <label for="Otown" class="col-sm-5 control-label">Town</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <input type="text" class="form-control" id="Otown" name="otown" >
                                        </div>
                                    </div>
                                    <div class="col-lg-12 space">
                                        <label for="pincode" class="col-sm-5 control-label">Pincode</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <input type="text" class="form-control" id="clientpin" name="clietpin" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-lg-offset-6 space">
                                    <button type="submit" class="btn btn-success" id="display">Submit</button>
                                    <button type="reset" class="btn btn-danger">Cancel</button>
                                </div>
                            </form>
				</div>
				<!-- /.col-lg-12 -->
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
                     <footer >
            &copy; 2015 OnlineShodh | By : <a href="www.softinfology.com" target="_blank">Softinfology</a>
        </footer>
             
      
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
        $('#dataTables-example').DataTable({
                responsive: true
        });
        
        $(".mobile-number").intlTelInput();
        
        $("#town").change(function(e){
           
           if($('#town').val()=='Other'){
           $(".hide-div").show();
       }
       else{
           $(".hide-div").hide();
       }
           
        });
    });
    </script>
</body>
</html>