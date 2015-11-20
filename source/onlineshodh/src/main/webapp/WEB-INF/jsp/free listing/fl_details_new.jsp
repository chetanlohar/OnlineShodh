<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Free Listing onlineshodh</title>

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

<!-- tags STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"  rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/resources/css/tokenfield-typeahead.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.min.css" rel="stylesheet" />


<style type="text/css">
body{
background: #FFB203;
}

</style>

</head>
<body>
	<div class="free_list_container">
		<div class="container">
			<div class="listing_header">
				<div class="row">
					<div class="col-md-2">
						<img
							src="${pageContext.request.contextPath}/resources/images/login-logo.gif"
							alt="onlineshodh" width="70px;" height="40px;" />
					</div>
					<div class="col-md-9">
						<h2 class="free_list_title">List your Business with India's popular Local Search Engine</h2>

					</div>
				</div>
			</div>
			<div class="list_form_container">
				<div class="row">
					<div class="col-md-12">
						<div class="new_detail_form">
							<form action="" id="free_list_first" class="form form-horizontal">
								<div class="space"></div>
								<div class="col-md-10 space">
									<label for="company" class="col-sm-3 control-label">Company/business
										Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span> <input type="text"
											name="fr_list_company" id="fr_list_company"
											class="form-control">
									</div>
								</div>
								<div class="col-md-10 space">
									<label for="person" class="col-sm-3 control-label">Person
										Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span> <input type="text"
											name="fr_list_person" id="fr_list_person"
											class="form-control">
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="email" class="col-sm-3 control-label">Email
										Id </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-envelope"></span></span> <input type="text"
											name="fr_list_email" id="fr_list_email" class="form-control">
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="web" class="col-sm-3 control-label">Website
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-globe"></span></span> <input type="text"
											name="fr_list_web" id="fr_list_web" class="form-control">
									</div>
								</div>
								<div class="col-md-10 space">
									<label for="category" class="col-sm-3 control-label">Category
									</label>
									<div class="input-group col-md-9">
										<select class="form-control" name="category">
											<option value="">category</option>
											<option value="category">category</option>
											<option value="category">category</option>
											<option value="category">category</option>
											<option value="category">category</option>
											<option value="category">category</option>
										</select>
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="sub-category" class="col-sm-3 control-label">Sub-Category
									</label>
									<div class="input-group col-md-9">
										<select class="form-control" name="subcategory">
											<option value="">sub-category</option>
											<option value="category">sub-category</option>
											<option value="category">sub-category</option>
											<option value="category">sub-category</option>
											<option value="category">sub-category</option>
											<option value="category">sub-category</option>
										</select>
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="person" class="col-sm-3 control-label">Keywords
									</label>
									<div class="input-group col-md-9">
										<input type="text" 
											class="keyword form-control" id="keyword" name="keyword" />

									</div>
								</div>
								<div class="col-md-5 col-md-offset-5 space">
									<button type="submit" class="btn btn-info">
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
	<!-- Footer Wrapar Start -->
		<section id="footer_wrapar" style="margin-top:20%;">
		<div class="container">
		<div class="row">
		<div class="col-lg-6 ">
		<p class="term">
		<ul>
		<li><a href="#">About Us</a></li>
		<li><a href="#">Terms & Conditions</a></li>
		<li><a href="#">Privacy Policy</a></li>
		</ul>
		</p>
		</div>
		<div class="col-lg-6">
		<p class="right_social">
		<ul>
		<li><a href="#" class="facebook"><i class=" fa fa-facebook"></i></a></li>
		<li><a href="#" class="google"><i class=" fa fa-google-plus"></i></a></li>
		<li><a href="#" class="twitter"><i class=" fa fa-twitter"></i></a></li>
		<li><a href="#" class="youtube"><i class=" fa fa-youtube"></i></a></li>
	
		</ul>
		
		</p>
		
		</div>
		</div>
		<div class="row bottom-footer">
		<div class="col-lg-4">
		<p class="copyright footer-bottom">Copyright &copy; OnlineShodh.Com All Rights Reserved</p>
		</div>
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
		<p class="designer footer-bottom">Designed By:<a href="#" class="softinfo">  SoftInfoLogy Pvt Ltd.</a></p>
		</div>
		
		</div>
		
		</div>
		</section><!-- Footer Wrapar End -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
	<!-- FORM VALIDATION SCRIPTS -->
		 <script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script> 
		  <script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script>
		 <script src="${pageContext.request.contextPath}/resources/js/validation/free_listing.js"></script> 
	
	<!-- keyword SCRIPTS -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#keyword').tokenfield({
				  autocomplete: {
				    source: ['computer','travelling','hotel','bus','flight','cargo','hospital','bank','dj'],
				    delay: 100
				  },
				  showAutocompleteOnFocus: true
				})
		});
	</script>
</body>
</html>