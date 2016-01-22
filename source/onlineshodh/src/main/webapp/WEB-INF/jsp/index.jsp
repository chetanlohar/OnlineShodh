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
	<!-- HOVER ANIMATION STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/hover-min.css"
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
				<a class="navbar-brand" style="color: #FFFFFF" 
					href="${pageContext.request.contextPath}/freelisting/">Free Listing</a>
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

					<li class="dropdown"><a href="#" class="dropdown-toggle explore"
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
						<datalist id="cities">
							<c:forEach var="city" items="${cities}">
								<option value="${city}"/>
							</c:forEach>
						</datalist>
						<div class="input-group col-md-3 col-xs-12 ">
						<input id="citysearch1" list="cities" name="cityName" type="text" class="form-control" placeholder="City" />
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
				<%-- <c:forEach var="category" items="${categories}">
					<div class="col-sm-1 cat">
					<div class="row">
						<div class="col-xs-1 hvr-grow">
								<a href="${pageContext.request.contextPath}/search/business/category/${category.categoryId}"><img
									src="${pageContext.request.contextPath}/categories/load/logo/${category.categoryId}">
								</a>
								<div id="catname">${category.categoryName}</div>
							</div>
						</div>
					</div>
				</c:forEach> --%>
				<c:forEach var="category" items="${categories}">
					<div class="col-sm-1 cat">
					<div class="row">
						<div class="col-xs-1 hvr-grow">
								<a href="${pageContext.request.contextPath}/search/business/category/${category.categoryId}">
									<img src="${category.path}">
									<div id="catname">${category.categoryName}</div>
								</a>
								
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- End of Row 8 -->

		</div>
		</section>
		<!-- category Wraper End -->
		
		<!-- Footer Wrapar Start -->
		<div id="footer_wrapar">
		<div class="top-footer">
		<div class="container">
		<div class="row">
	       <div class="col-lg-6 col-xs-12">
	       <div class="useful_links">
	       <a href="#">About Us</a>
	       <a href="#">Tearm & Conditions</a>
	       <a href="#">Privacy & Policy</a>
	       
	       </div>
	       </div>
	       <div class="col-lg-6 col-xs-12">
	       <ul class="social_link">
	       <li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
	       <li><a href="#" class="google"><i class="fa fa-envelope"></i></a></li>
	       <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
	       <li><a href="#" class="youtube"><i class="fa fa-youtube"></i></a></li>
	       </ul>
	       
	       </div>
		</div>
		</div>
		</div>
		<div class="container">
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
		</div><!-- Footer Wrapar End -->
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
		<%-- <script src="${pageContext.request.contextPath}/resources/js/codejs/mainpage.js"></script> --%>
		<script src="${pageContext.request.contextPath}/resources/js/codejs/geolocation.js"></script>
		<script type="text/javascript">
  			var myip;
		</script>
		<script type="text/javascript" src="https://l2.io/ip.js?var=myip" ></script> -->
		<input id="flag" type="hidden" value="${flag}">
	<script>
			$(document).ready(function() {
				console.log(myip);
				/* getLocation(); */
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
