<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Business Details</title>
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




<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
</head>
<body>
	<div class="container" id="topbar_line"></div>

	<!-- search bar and logo -->
	<div class="container">
		<div class="row" id="result_head">
			<div class="col-lg-3 col-md-3">
				<a href="home.jsp"> <img
					src="${pageContext.request.contextPath}/resources/images/logo.jpg"
					class="result_logo" />
				</a>
			</div>
			<div class="col-lg-9 col-md-9">
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
		</div>

	</div>


	<!-- code for advertisement -->
	<div class="container" id="businessname">
		<div class="row">
			<h1 class="col-lg-12 col-sm-12 col-xs-12">${business.businessName}</h1>
		</div>
	</div>



	<!-- code for business listing -->
	<div class="container space">



		<div class="row">
			<div class="col-lg-8 col-md-8 col-sm-8">

				<div class="row">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/prashant/business_list">Hotels</a></li>
						<li class="active">${business.businessName}</li>
					</ol>
				</div>


				<!-- code for image slider -->
				<div class="row">
					<div class="col-lg-12" id="imageslider">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel" data-interval="3000">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<img
										src="${pageContext.request.contextPath}/resources/images/ad.jpg"
										alt="tp1">
									<div class="carousel-caption">timepass</div>
								</div>
								<div class="item">
									<img
										src="${pageContext.request.contextPath}/resources/images/ad.jpg"
										alt="tp2">
									<div class="carousel-caption">timepass2</div>
								</div>

								<div class="item">
									<img
										src="${pageContext.request.contextPath}/resources/images/ad.jpg"
										alt="tp3">
									<div class="carousel-caption">timepass3</div>
								</div>

							</div>

							<!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic"
								role="button" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" role="button" data-slide="next">
								<span class="glyphicon glyphicon-chevron-right"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>






				<!-- code for description & contact info -->
				<h2 id="myh2">
					CONTACT INFO
					</h1>
					<div class="row" id="contactinfo">
						<div class="col-lg-7 col-md-7 col-sm-7 " id="description">${business.businessDesc}</div>

						<div class="col-lg-5 col-md-5 col-sm-5 " id="contacts">
							<div class="row">
								<div class="col-lg-12" id="personname">
									<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
									&nbsp;${business.personName}
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12" id="addr">
									<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
									&nbsp;${business.address.address} , ${business.address.street}, ${business.address.town.city.cityName}, ${business.address.town.townName}
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12" id="addr">
									<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
									&nbsp;${business.email}
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12" id="addr">
									<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
									&nbsp;${business.website}
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12" id="addr">
									<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
									&nbsp;
									<c:forEach var="phone" items="${phones}">
										${phone.phone} ,
									</c:forEach>
								</div>
							</div>
						</div>

					</div>


					<!-- code for general information -->

					<h2 id="myh2">GENERAL INFO</h2>
					<div class="row" id="generalinformation">
						<div class="col-lg-12">
							<div class="row">
								<c:forEach var="info" items="${generalinfo}">
									<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6" id="gi">
										<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;3
											${info.generalInfoName}
									</div>
								</c:forEach>
								
							</div>
						</div>
					</div>
					<!-- code for map -->

					<h2 id="myh2">MAP</h2>
					<div class="row">

						<!-- <iframe
							src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15204.872945889128!2d74.0304022402588!3d17.687147754495733!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0000000000000000%3A0xcf6deb4348cd2bc2!2sCloudcom+Technologies+%26+Software+Solutions+Pvt+Ltd!5e0!3m2!1sen!2sin!4v1431337276619"
							height="300" frameborder="0" style="border: 0" class="col-lg-12"></iframe> -->

						<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3782.5932998417798!2d73.93377931489313!3d18.547271987393472!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc2c3db00000001%3A0x570779d477cae3c8!2sSoftinfology+Solutions+And+Cunsultancy+Pvt.+Ltd.!5e0!3m2!1sen!2sin!4v1446812088810" height="300" frameborder="0" style="border:0" allowfullscreen class="col-lg-12"></iframe>

					</div>



					<!-- code for enquiry -->

					<h2 id="myh2">ENQUIRY</h2>

					
					<div class="form-group">
						<form:form action="${pageContext.request.contextPath}/search/business/enquiry/save/${business.businessId}" method="post" modelAttribute="businessEnquiry">
							<div class="row">
								<div class="col-lg-6">
									<div class="row">
										
										<div class="col-lg-12 space">
											<form:input path="enquiryname" class="form-control" placeholder="FULL NAME *" required />
										</div>
										
										<div class="col-lg-12 space">
											<form:input path="phone" class="form-control" placeholder="MOBILE NUMBER *" required />
										</div>
										<div class="col-lg-12 space">
											<form:input path="email" class="form-control" placeholder="EMAIL ID*" required />
										</div>
									</div>
								</div>

								<div class="col-lg-6">
									<div class="row">
										<div class="col-lg-12 space">
											<form:textarea path="message" class="form-control" rows="6" name="message"
												placeholder="MESSAGE *" required />
										</div>

									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-lg-12" style="text-align: right">
									<input type="submit" name="sendenquiry" class="btn btn-primary" />
								</div>
							</div>
						</form:form>
					</div>
					
			</div>


			<!-- code for keywords -->

			<div class="col-lg-3 col-md-3 col-sm-3">
				<div class="rel_category">
					<ul class="list_rel_cat">
						<li class="rel_head">Related Category</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
						<li>5 Star Hotel</li>
					</ul>


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
					Designed By:<a href="#" class="softinfo"> SoftInfoLogy Pvt Ltd.</a>
				</p>
			</div>

		</div>

	</div>
	</section>
	<!-- Footer Wrapar End -->


</body>
</html>