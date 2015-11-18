<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Free Listing Address</title>


<!-- BOOTSTRAP STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />
<!-- PAGE STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />


</head>
<body>
	<div class="free_list_container">
		<div class="container">
			<div class="listing_header">
				<div class="row">
					<div class="col-md-3">
						<img
							src="${pageContext.request.contextPath}/resources/images/login-logo.gif"
							alt="onlineshodh" width="70px;" heigth="40px;" />
					</div>
					<div class="col-md-9">
						<h2 class="free_list_title">Free Listing</h2>

					</div>
				</div>
			</div>
			<div class="list_form_container">
				<div class="row">
					<div class="col-md-12">
						<div class="new_detail_form">
							<form action="" id="free_list_Address"
								class="form form-horizontal">
								<div class="space"></div>
								<div class="col-md-10 space">
									<label for="address" class="col-sm-3 control-label">Address
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-map-marker"></span></span>
										<textarea name="fr_list_address" id="fr_list_address"
											class="form-control"></textarea>
									</div>
								</div>
								<div class="col-md-10 space">
									<label for="street" class="col-sm-3 control-label">Street
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-road"></span></span> <input type="text"
											name="fr_list_road" id="fr_list_road" class="form-control">
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="landmark" class="col-sm-3 control-label">Landmark
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-street-view"></span></span> <input type="text"
											name="fr_list_landmark" id="fr_list_landmark"
											class="form-control">
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="city" class="col-sm-3 control-label">City </label>
									<div class="input-group col-md-9">
										<select class="form-control">
											<option value="city">city</option>
											<option value="city">city</option>
											<option value="city">city</option>
											<option value="city">city</option>
											<option value="city">city</option>
											<option value="city">city</option>
										</select>
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="town" class="col-sm-3 control-label">Town </label>
									<div class="input-group col-md-9">
										<select class="form-control">
											<option value="town">Town</option>
											<option value="town">Town</option>
											<option value="town">Town</option>
											<option value="town">Town</option>
											<option value="town">Town</option>
											<option value="town">Town</option>
										</select>
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="person" class="col-sm-3 control-label">Pincode
									</label>
									<div class="input-group col-md-9">
										<input type="text" class=" form-control"
											id="fl-list_pincode"  name="fl-list_pincode"/>

									</div>
								</div>
								<div class="col-md-5 col-md-offset-5 space">
								
								<button type="button" class="btn btn-danger">
										<i class="fa fa-arrow-circle-o-left"></i> Previous / Back
									</button>
									<button type="button" class="btn btn-info">
										<i class="fa fa-arrow-circle-o-right"></i> Save & Countinue
									</button>
								
									
								</div>
							</form>

						</div>

					</div>

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

</body>
</html>