<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
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
<link
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/css/tokenfield-typeahead.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.min.css"
	rel="stylesheet" />


<style type="text/css">
body {
	background: #FFF;
}

#footer_wrapar{
margin-top: 14%;

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

							<form:form method="post" id="free_list_first"
								class="form form-horizontal"
								action="${pageContext.request.contextPath}/freelisting/business/save"
								modelAttribute="flDetails">
								<div class="space"></div>
								<div class="col-md-10 space">
									<label for="company" class="col-sm-3 control-label">Company/business
										Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:input path="businessName" name="fr_list_company"
											id="fr_list_company" class="form-control" />
										<form:errors path="businessName" cssClass="errors"/>	
									</div>
								</div>
								<div class="col-md-10 space">
									<label for="person" class="col-sm-3 control-label">Person
										Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span>
										<form:input path="personName" name="fr_list_person"
											id="fr_list_person" class="form-control" />
										<form:errors path="personName" cssClass="errors"/>	
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="email" class="col-sm-3 control-label">Email
										Id </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-envelope"></span></span>

										<form:input path="email" name="fr_list_email"
											id="fr_list_email" class="form-control" />
										<form:errors path="email" cssClass="errors"/>
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="web" class="col-sm-3 control-label">Website
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-globe"></span></span>
										<form:input path="website" name="fr_list_web" id="fr_list_web"
											class="form-control" />
										<form:errors path="website" cssClass="errors"/>	
									</div>
								</div>
								<div class="col-md-10 space">
									<label for="category" class="col-sm-3 control-label">Category
									</label>
									<div class="input-group col-md-9">

										<form:select path="subCategory.category.categoryId"
											required="" id="categoryname" name="categoryname"
											onchange="getSubCategoriesForFreeListing()"
											class="form-control">
											<form:option value="0" label="--- Select ---" />
											<c:forEach var="category" items="${categories}">
												<form:option value="${category.categoryId}">${category.categoryName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="subCategory.category.categoryId" cssClass="errors"/>
									</div>
								</div>


								<div class="col-md-10 space">
									<label for="sub-category" class="col-sm-3 control-label">Sub-Category
									</label>
									<div class="input-group col-md-9">
										<form:select path="subCategory.subCategoryId"
											class="form-control" required="" 
											id="subcategoryname" name="subcategoryname">
											<form:option value="0" label="--- Select ---" />
											<c:forEach var="subcategory" items="${subcategories}">
												<form:option value="${subcategory.subCategoryId}">${subcategory.subCategoryName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="subCategory.subCategoryId" cssClass="errors"/>
									</div>
								</div>

								<div class="col-md-10 space">
									<label for="person" class="col-sm-3 control-label">Keywords
									</label>
									<div class="input-group col-md-9">
										<form:textarea path="keywords" class="keyword form-control"
											id="keyword" name="keyword" />
										<form:errors path="keywords" cssClass="errors"/>	

									</div>
								</div>
								<div class="col-md-5 col-md-offset-5 space">
									<button type="submit" class="btn btn-info">
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

	<!-- keyword SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.min.js"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$('#keyword').tokenfield(
							{
								autocomplete : {
									source : [ 'computer', 'travelling',
											'hotel', 'bus', 'flight', 'cargo',
											'hospital', 'bank', 'dj' ],
									delay : 100
								},
								showAutocompleteOnFocus : true
							})
				});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/codejs/viewSubCategory.js"></script>
</body>
</html>