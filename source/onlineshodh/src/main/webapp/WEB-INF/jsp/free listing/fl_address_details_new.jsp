<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<style type="text/css">
body {
	background: #FFF;
}
#footer_wrapar{
margin-top: 16%;

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
						<h2 class="free_list_title">List your Business with India's
							popular Local Search Engine</h2>

					</div>
				</div>
			</div>
			<div class="list_form_container">
				<div class="row">
					<div class="col-md-12">
						<div class="new_detail_form">

							<form:form modelAttribute="FreeListing_Address"
								id="free_list_Address" class="form form-horizontal"
								action="${pageContext.request.contextPath}/freelisting/address/save"
								method="POST">
								<form:hidden path="businessEntity.freelistingbusinessdetailsId" />

								<div class="space"></div>
								<div class="col-md-10 space">
									<label for="address" class="col-sm-3 control-label">Address
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-map-marker"></span></span>
										<form:textarea path="fl_Address" class="form-control"
											id="clientadd" name="address" />
										<form:errors path="fl_Address" cssClass="errors" />

									</div>
								</div>
								<div class="col-md-10 space">
									<label for="street" class="col-sm-3 control-label">Street
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-road"></span></span>
										<form:textarea path="fl_Street" class="form-control"
											id="clientStreet" name="Street" />
										<form:errors path="fl_Street" cssClass="errors" />
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="landmark" class="col-sm-3 control-label">Landmark
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-street-view"></span></span>
										<form:textarea path="fl_LandMark" class="form-control"
											id="clientLandM" name="LandMark" />
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="city" class="col-sm-3 control-label">City </label>
									<div class="input-group col-md-9 col-xs-12">

										<form:select path="city.cityId" class="form-control"
											name="clientcity" id="cityId" onchange="getTown('${pageContext.request.contextPath}');">
											<form:option value="0">--Select--</form:option>
											<c:forEach var="city" items="${cities}">
												<form:option value="${city.cityId}">${city.cityName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="city.cityId" cssClass="errors" />
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="town" class="col-sm-3 control-label">Town </label>
									<div class="input-group col-md-9 col-xs-12">
										<form:select path="town.townId" class="form-control" id="town"
											name="clinettown">
											<form:option value="0">--Select--</form:option>
											<c:forEach var="town" items="${towns}">
												<form:option value="${town.townId}">${town.townName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="town.townId" cssClass="errors" />


									</div>
								</div>

								<div class="col-md-10 space">
									<label for="person" class="col-sm-3 control-label">Pincode
									</label>
									<div class="input-group col-md-9 col-xs-12">


										<form:input path="pincode" class=" form-control"
											id="clientpin" name="clietpin" />
										<form:errors path="pincode" cssClass="errors" />


									</div>
								</div>
								<div class="col-md-5 col-md-offset-5 space">
									<a href="${pageContext.request.contextPath}/freelisting/"
										id="goBack" class="back">
										<button type="button" class="btn btn-danger space">
											<i class="fa fa-arrow-circle-o-left"></i> Previous / Back

										</button>
									</a>
									<button type="submit" class="btn btn-info space">
										<i class="fa fa-arrow-circle-o-right"></i> Save & Countinue
									</button>


								</div>
							</form:form>

						</div>

					</div>

				</div>

			</div>
		</div>
	</div>
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
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/free_listing.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/freeListingBusinessAddres.js"></script>


</body>
</html>