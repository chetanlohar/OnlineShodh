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
				
				</div>

			</div>

		</div>



	</div>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->

</body>
</html>