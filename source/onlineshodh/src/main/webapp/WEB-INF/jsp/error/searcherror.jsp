<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Not Found</title>

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
	<style type="text/css">
	body {
	background: #f4f4f4;
	}
	#container .container{
	background: #fff;
	
	
}

	
	</style>
</head>
<body>
	<div id="container">
		<div class="container header_bar">
			<div class="row">
				<div class="col-md-2">
					<a href="home.jsp"> <img
						src="${pageContext.request.contextPath}/resources/images/logo.jpg"
						class="result_logo" alt="onlineshodh" /></a>
				</div>
				<div class="col-md-7">
					<div class="form_search row">
						<form action="" class="form-inline">

							<input type="text" class="search_input col-lg-8 col-xs-10 "
								placeholder="Serach For Hotels,Taxis,Movies and Much More">

							<button class="btn-lg btn btn-info search" type="submit">
								<i class="fa fa-search "></i>
							</button>


						</form>

					</div>

				</div>
				<div class="col-md-2">
					<a class="free_list_link" href="#">Free Listing</a>
				</div>

			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 image_search_wrap">
					<img
						src="${pageContext.request.contextPath}/resources/images/searcherror.jpg"
						class="img-search" alt="onlineshodh" />

				</div>
				<div class="col-md-12">
				<span class="error_msg">
				Your Search For<span> "kgfkfdhgfgjkjk" </span>Located In<span> "pune" </span>Did not match any records.
				
				</span>
				
				</div>
				<div class="col-md-12">
				<div class="serach_tip">
				<h2 class="text-center serach_tip_title">Search Tips</h2>
				<ul class="srchtip">
					       <li>Check for spelling mistakes in the search keywords.</li>
						   <li>Try using alternate terms (synonyms) for the search keywords.</li>
						   <li>Try specific product and/or service names.</li>
						   <li>Try more keywords.</li>
					  </ul>
				</div>
				<div class="srchn hidden-xs">
				       <span class="srchntor">
					          OR
					   </span>
				 </div>
				 
				</div>
				<div class="col-md-12">
				<h3 class="text-center">Fill the filed for your are looking </h3>
				<form action="" id="your_option" class="form form-horizontal">
					<div class="col-lg-4 col-lg-offset-4 space">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-map-marker"></span></span>
									<input type="text" name="location" title="Category Name"
										maxlength="25" size="51" class="form-control"
										id="location" />
					
								</div>
							</div>
							
							<div class="col-lg-4 col-lg-offset-4  space">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-search"></span></span>
									<input type="text" name="search" title="search Name"
										 size="51" class="form-control"
										id="search" />
					
								</div>
							</div>
									<div class="col-lg-4 col-lg-offset-4  space">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-road"></span></span>
									<input type="text" name="area" title="area Name"
										 size="51" class="form-control"
										id="area" />
					
								</div>
							</div>
									<div class="col-lg-4 col-lg-offset-4  space">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<input type="text" name="user" title="user Name"
										 size="51" class="form-control"
										id="user" />
					
								</div>
							</div>
									<div class="col-lg-4 col-lg-offset-4  space">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-envelope"></span></span>
									<input type="text" name="email" title="email Name"
										 size="51" class="form-control"
										id="email" />
					
								</div>
							</div>
									<div class="col-lg-4 col-lg-offset-4  space">
								
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-phone"></span></span>
									<input type="text" name="phone" title="phone Name"
										maxlength="10" size="51" class="form-control"
										id="phone" />
					
								</div>
							</div>
							<div class="col-lg-5 col-lg-offset-5">
							<button class="btn btn-info">Submit</button>
							</div>
				
				</form>
				
				</div>

			</div>

		</div>



	</div>
		<!-- Footer Wrapar Start -->
		<section id="footer_wrapar">
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
						<li><a href="#" class="facebook"><i
								class=" fa fa-facebook"></i></a></li>
						<li><a href="#" class="google"><i
								class=" fa fa-google-plus"></i></a></li>
						<li><a href="#" class="twitter"><i class=" fa fa-twitter"></i></a></li>
						<li><a href="#" class="youtube"><i class=" fa fa-youtube"></i></a></li>

					</ul>

					</p>

				</div>
			</div>
			<div class="row bottom-footer">
				<div class="col-lg-4">
					<p class="copyright footer-bottom">Copyright &copy;
						OnlineShodh.Com All Rights Reserved</p>
				</div>
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
					<p class="designer footer-bottom">
						Designed By:<a href="#" class="softinfo"> SoftInfoLogy Pvt
							Ltd.</a>
					</p>
				</div>

			</div>

		</div>
		</section>
		<!-- Footer Wrapar End -->

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->

</body>
</html>