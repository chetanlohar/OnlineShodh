<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Newbusiness</title>


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

<!--Tel Phone STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/intlTelInput.css"
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
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />


</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Add New Business</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /row -->


	<div class="row">
		<div class="col-lg-12">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">Business
						Details</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">Contact
						Details</a></li>
				<li role="presentation"><a href="#messages"
					aria-controls="messages" role="tab" data-toggle="tab">Address
						Details</a></li>
				<li role="presentation"><a href="#settings"
					aria-controls="settings" role="tab" data-toggle="tab">Business
						Map</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">
					<div class="row">
						<form class="form-horizontal space" id="add-business">

							<div class="col-lg-10 space">
								<label for="BName" class="col-sm-2 control-label">
									Business Name</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<input type="text" class="form-control" id="businessname"
										name="businessname">
								</div>
							</div>

							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label"> Person
									Name</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<input type="text" class="form-control" id="personname"
										name="personname">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="mailid" class="col-sm-2 control-label">
									Business Email Id</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-envelope"></span></span> <input type="text"
										class="form-control" id="bmailid" name="bmailid"
										placeholder="example@mail.com">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="website" class="col-sm-2 control-label">
									Business Website</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-globe"></span></span> <input type="text"
										class="form-control" id="bweb" name="bweb">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Clogo" class="col-sm-2 control-label">Company
									Logo</label>
								<div class="fileinput fileinput-new input-group col-lg-10"
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

							<div class="col-lg-10 space">
								<label for="Bcategory" class="col-sm-2 control-label">Business
									Category</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-flag"></span></span>
									<select class="form-control" name="Bcategory">
										<option value="">Select</option>
										<option value="travling">Travling</option>
									</select>
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Bscategory" class="col-sm-2 control-label">Business
									Sub-Category</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-flag"></span></span>
									<select class="form-control" name="Bscategory">
										<option value="">Select</option>
										<option value="travling">Travling</option>
									</select>
								</div>
							</div>

							<div class="col-lg-10 space">
								<label for="bdescription" class="col-sm-2 control-label">Business
									Description</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-road"></span></span>
									<textarea class="form-control" rows="3" id="bdescription"
										name="bdescription"></textarea>
								</div>
							</div>
							<div class="col-lg-7 col-lg-offset-5 space">
								<button class="btn btn-success" type="submit">Save &
									Countinue</button>
								<button class="btn btn-danger" type="submit">Cancel</button>
							</div>
						</form>
					</div>


				</div>

				<div role="tabpanel" class="tab-pane" id="profile">
					<div class="row">
						<form action=" " class="form-horizontal" name="businesscontact">
							

							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label">Contact</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span> <input type="tel"
										class="form-control mobile-number" name="clietphone">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label">Contact1</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span> <input type="tel"
										class="form-control mobile-number" name="clietphone">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label">Contact2</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span> <input type="tel"
										class="form-control mobile-number" name="clietphone">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label">Contact3</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span> <input type="tel"
										class="form-control mobile-number" name="clietphone">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label">Contact4</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-phone"></span></span> <input type="tel"
										class="form-control mobile-number" name="clietphone">
								</div>
							</div>

							<div class="col-lg-7 col-lg-offset-5 space">
								<button class="btn btn-success" type="submit">Save &
									Countinue</button>
								<button class="btn btn-danger" type="submit">Cancel</button>
							</div>
						</form>

					</div>


				</div>
				<div role="tabpanel" class="tab-pane" id="messages">
				<div class="row">
				<form action="" class="form-horizontal">
					<div class="col-lg-10 space">
								<label for="Address" class="col-sm-2 control-label">Address
								</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-road"></span></span>
									<textarea class="form-control" rows="3" id="baddress"
										name="baddress"></textarea>
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label"> 
									Street</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<input type="text" class="form-control" id="personname"
										name="personname">
								</div>
							</div>
							<div class="col-lg-10 space">
								<label for="Name" class="col-sm-2 control-label"> 
									LandMarks</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<input type="text" class="form-control" id="personname"
										name="personname">
								</div>
							</div>
							
							                                    <div class="col-lg-10 space">
                                        <label for="country" class="col-sm-2 control-label">Country</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-flag"></span></span> 
                                            <select class="form-control" name="clientcountry">
                                                <option value="">Select</option>
                                                <option value="india">India</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-10 space">
                                        <label for="state" class="col-sm-2 control-label">State</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <select class="form-control" name="clientstate">
                                            <option value="">Select</option>
                                                <option value="mharastra">maharastra</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-10 space">
                                        <label for="city" class="col-sm-2 control-label">City</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <select class="form-control" name="clientcity">
                                            <option value="">Select</option>
                                                <option value="pune">pune</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-10 space">
                                        <label for="town" class="col-sm-2 control-label">Town</label>
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
                                    
                                    <div class="col-lg-10 space">
                                        <label for="pincode" class="col-sm-2 control-label">Pincode</label>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span
                                                    class="fa fa-user"></span></span> 
                                            <input type="text" class="form-control" id="clientpin" name="clietpin" >
                                        </div>
                                    </div>
                                    <div class="col-lg-10 space">
                                        <label for="town" class="col-sm-2 control-label">Address Type</label>
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
                                    
                                    <div class="col-lg-7 col-lg-offset-5 space">
								<button class="btn btn-success" type="submit">Save &
									Countinue</button>
								<button class="btn btn-danger" type="submit">Cancel</button>
							</div>
				</form>
				
				</div>
				
				
				</div>
				<div role="tabpanel" class="tab-pane" id="settings">...</div>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /row -->
</body>
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
<!-- Input Telephone SCRIPTS -->
<script src="<%=request.getContextPath()%>/resources/js/intlTelInput.js"></script>

<!-- CUSTOM SCRIPTS -->
<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>
<script>
	$(document).ready(function() {

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
</html>