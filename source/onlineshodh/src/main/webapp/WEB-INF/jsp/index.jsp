<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Online Shodh</title>

<!-- BOOTSTRAP STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />

<!-- CUSTOME STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"/>

</head>
<body>
	<!-- page container start -->
	<div id="home_container">
		<!-- home page navbar wraper start -->
		<section id="home_nav"> <!-- navbar start --> <nav
			class="navbar navbar-inverse home_navbar">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #FFFFFF" data-toggle="modal"
					data-target=".freelisting">Free Listing</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!--<li class="active"><a href="#" data-toggle="modal" data-target=".freelisting">Free Listing <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>-->
				</ul>
				</li>
				</ul>

				<ul class="nav navbar-nav navbar-right">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Explore<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">My Account</a></li>
							<li class="divider"></li>
							<li><a href="#">Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav> <!-- navbar end tag --> </section>
		<!-- home page navbar wraper End -->

		<!-- logo wraper container -->
		<section id="logo_wrapar">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<img class="logo_img"
						src="${pageContext.request.contextPath}/resources/images/logo.jpg"
						alt="online shodh" />
				</div>

			</div>
		</div>
		</section>
		<!-- logo wraper container end -->

		<!-- serach bar wraper -->
		<section id="search_wraper">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<form action="${pageContext.request.contextPath}/search/businesses" method="GET" class="form-inline">
						
						<div class="input-group col-md-3 col-xs-12 ">
						<input id="citysearch" name="cityName" type="text" class="form-control" placeholder="City" />
						</div>
						<div class="input-group col-md-7 col-xs-12">
							<input id="searchid" name="tagName" type="text" class="form-control"
								placeholder="Search Hotels, Taxis, Movies & Much More" />
						</div>
						<div class="input-group col-md-1 col-xs-12 ">
							<button class="btn btn-info col-md-2 col-xs-12  search_btn">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		</section>
		<!-- search wrapar end -->

		<!-- category Wraper start -->
		<section id="category">
		<div class="container">
			<!-- Start of Row 1  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">

						<div class="col-xs-4">
							<a href="business_listing.html"><img
								src="${pageContext.request.contextPath}/resources/images/icons/advertising.png">
							</a>
							<div id="catname">Advertising Agencies</div>
						</div>
						<div class="col-xs-4">
							<a href="${pageContext.request.contextPath}/search/business/category/91"><img
								src="${pageContext.request.contextPath}/resources/images/icons/agriculture.png">
							</a>
							<div id="catname">Agriculture</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/apparels.png">
							</a>
							<div id="catname">Apparels</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/architect.png">
							</a>
							<div id="catname">Architect & Interior Designer</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/automobile.png">
							</a>
							<div id="catname">Automobile</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/banks.png">
							</a>
							<div id="catname">Banks</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/bakery.png">
							</a>
							<div id="catname">Bakery</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/spa.png">
							</a>
							<div id="catname">Beauty & Spa</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/books.png">
							</a>
							<div id="catname">Books Store</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 1 -->




			<!-- Start of Row 2  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/builders.png">
							</a>
							<div id="catname">Builders & Developers</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/material.png">
							</a>
							<div id="catname">Building Material Supplier</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/cardealers.png">
							</a>
							<div id="catname">Car Dealers</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/caterers.png">
							</a>
							<div id="catname">Caterers</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/classes.png">
							</a>
							<div id="catname">Classes</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/clubs.png">
							</a>
							<div id="catname">Clubs & Society</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/chemist.png">
							</a>
							<div id="catname">Chemist</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/colleges.png">
							</a>
							<div id="catname">Colleges</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/computers.png">
							</a>
							<div id="catname">Computer Services</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 3 -->



			<!-- Start of Row 3  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/cosmetics.png">
							</a>
							<div id="catname">Cosmetics</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/courier.png">
							</a>
							<div id="catname">Courier Services</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/consultant.png">
							</a>
							<div id="catname">Consultants</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/cycle.png">
							</a>
							<div id="catname">Cycle Sales & Spare Parts</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/fashion.jpg">
							</a>
							<div id="catname">Dealers & Distributors</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/doctors.png">
							</a>
							<div id="catname">Doctors</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/dth.png">
							</a>
							<div id="catname">DTH Services</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/electrical.png">
							</a>
							<div id="catname">Electrical Services</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/emergency.png">
							</a>
							<div id="catname">Emergency</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 3 -->



			<!-- Start of Row 4  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/entertainment.png">
							</a>
							<div id="catname">Entertainment</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/party.png">
							</a>
							<div id="catname">Event & Party</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/finance.png">
							</a>
							<div id="catname">Finance & Share Brokers</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/florist.png">
							</a>
							<div id="catname">Florist</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/food.png">
							</a>
							<div id="catname">Fruit & Food</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/flight.png">
							</a>
							<div id="catname">Flight</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/furniture.png">
							</a>
							<div id="catname">Furniture & Hardware</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/footware.png">
							</a>
							<div id="catname">Footware</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/gym.png">
							</a>
							<div id="catname">Gym</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 4 -->



			<!-- Start of Row 5  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/gift.png">
							</a>
							<div id="catname">Gift Shop</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/q.jpg">
							</a>
							<div id="catname">Grocery</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/government.png">
							</a>
							<div id="catname">Government Services</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/appliances.png">
							</a>
							<div id="catname">Home Appliances</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/hospitals.png">
							</a>
							<div id="catname">Hospitals & Clinics</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/hotels.png">
							</a>
							<div id="catname">Hotels & Lodge</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/housekeeping.png">
							</a>
							<div id="catname">House Keeping & Cleaning</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/industrial.png">
							</a>
							<div id="catname">Industrial Supplies</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/internet.png">
							</a>
							<div id="catname">Internet & Services</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 5-->



			<!-- Start of Row 6  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/jewellers.png">
							</a>
							<div id="catname">Jewellers</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/jobs.png">
							</a>
							<div id="catname">Jobs</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/libraries.png">
							</a>
							<div id="catname">Libraries</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/mobiles.png">
							</a>
							<div id="catname">Mobile Shops</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/driving.png">
							</a>
							<div id="catname">Motor Driving Schools</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/opticals.png">
							</a>
							<div id="catname">Opticals</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/papers.png">
							</a>
							<div id="catname">Paper Dealers</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/petrolpumps.png">
							</a>
							<div id="catname">Petrol Pumps</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/pets.png">
							</a>
							<div id="catname">Pets</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 6 -->


			<!-- Start of Row 7  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/photo.png">
							</a>
							<div id="catname">Photo Studios</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/pizza.png">
							</a>
							<div id="catname">Pizza</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/realestate.png">
							</a>
							<div id="catname">Real Estate</div>
						</div>


					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/security.png">
							</a>
							<div id="catname">Security Services</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/schools.png">
							</a>
							<div id="catname">Schools</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/sports.png">
							</a>
							<div id="catname">Sport Shops</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/tailors.png">
							</a>
							<div id="catname">Tailors</div>
						</div>

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/tele.png">
							</a>
							<div id="catname">Tele Communication</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/tiffins.png">
							</a>
							<div id="catname">Tiffin Services</div>
						</div>

					</div>

				</div>


			</div>

			<!-- End of Row 7 -->


			<!-- Start of Row 8  -->
			<div class="row">

				<div class="col-sm-4" id="cat">
					<div class="row">

						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/transport.png">
							</a>
							<div id="catname">Transport</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/travels.png">
							</a>
							<div id="catname">Tours & Travels</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/tourist.png">
							</a>
							<div id="catname">Tourist Places</div>
						</div>



					</div>
				</div>
				<div class="col-sm-4" id="cat">
					<div class="row">
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/watches.png">
							</a>
							<div id="catname">Watches</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/wedding.png">
							</a>
							<div id="catname">Wedding Halls</div>
						</div>
						<div class="col-xs-4">
							<a href="#"><img
								src="${pageContext.request.contextPath}/resources/images/icons/xerox.png">
							</a>
							<div id="catname">Xerox Centers</div>
						</div>
						<!--<div class="col-xs-4"><a href="#"><img src="images/icons/.png"> </a><div id="catname">Tailors</div></div>-->

					</div>
				</div>
				<!--<div class="col-sm-4" id="cat">
			<div class="row">
				<div class="col-xs-4"><a href="#"><img src="images/icons/.png"> </a><div id="catname">Tele Communication</div></div>
				<div class="col-xs-4"><a href="#"><img src="images/icons/.png"> </a><div id="catname">Tiffin Services</div></div>
				<div class="col-xs-4"><a href="#"><img src="images/icons/.png"> </a><div id="catname">Traders</div></div>

			</div>
		
		</div>				-->


			</div>

			<!-- End of Row 8 -->

		</div>
		</section>
		<!-- category Wraper End -->
		
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
		<!-- code for modal -->
		 
<div class="modal fade freelisting" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" data-backdrop="static">
 <div class="modal-backdrop fade in"  ></div>
  <div class="modal-dialog modal-md">
    <div class="modal-content">
			<div class="modal-header" style="background-color:#F7D417">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">Free Listing - Register Your Business for Free & Get Searched on Internet</h4>
			</div>
			
			
			<div class="modal-body">
				<div class="row">
					<div class="col-lg-1 col-lg-offset-1"></div>
					<div class="col-lg-6 col-sm-5">
					<form>
						  <div class="form-group">
							<label for="companyname">Company Name</label>
							<input type="text" class="form-control" id="companyname" placeholder="Enter Company Name" style="border-radius:0" required>
						  </div>
						  
						  <div class="form-group">
						  	<label for="description">Description</label>
							<textarea class="form-control" id="description" placeholder="Enter Company Description" style="border-radius:0"></textarea>
						  </div>
						  
						  
						  <div class="form-group">
							<label for="contactperson">Contact Person</label>
							<input type="text" class="form-control" id="contactperson" placeholder="Enter your Name" style="border-radius:0" required>
						  </div>
						  
						  <div class="form-group">
						  	<label for="address">Address</label>
							<textarea class="form-control" id="address" placeholder="Enter Company Address" style="border-radius:0"></textarea>
						  </div>
						  <div class="form-group">
							<label for="city">City</label>
							<input type="text" class="form-control" id="city" placeholder="Enter your City Name" style="border-radius:0" required>
						  </div>
						  
						  <div class="form-group">
							<label for="pincode">Pincode</label>
							<input type="text" class="form-control" id="pincode" placeholder="Enter Pincode" style="border-radius:0" required>
						  </div>
						  
						  <div class="form-group">
							<label for="email">Email Id</label>
							<input type="email" class="form-control" id="email" placeholder="Enter your Email Id" style="border-radius:0" required>
						  </div>
						  
						  <div class="form-group">
							<label for="mobile">Mobile Number</label>
							<input type="text" class="form-control" id="mobile" placeholder="Enter 10 Digit Mobile Number" style="border-radius:0" required>
						  </div>
						  
						  <hr>
						  
						  
						  <button type="submit" class="btn btn-primary">Submit</button>
					</form>
					</div>
				</div>
			
			</div>
			
			
			<div class="modal-footer" style="background-color:#0F1F7A;color:#FFFFFF" id="center">India's Best Local Search Engine</div>
    </div>
  </div>
</div>

	</div>
	<!-- page container end -->

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/codejs/mainpage.js"></script>
	<script>
			$(document).ready(function() {
				console.log("in auto_complete..path: ${pageContext.request.contextPath}");
				$("#searchid").on("keyup",function(){
					 $( "#searchid" ).autocomplete({
							source: '${pageContext.request.contextPath}/search/dosearch?cityName='+$( "#citysearch" ).val()
					});
				});
				
				$("#citysearch").on("keyup",function(){
					 $( "#citysearch" ).autocomplete({
							source: '${pageContext.request.contextPath}/search/doCitySearch'
					});
				});
			});
</script>
		
</body>
</html>
