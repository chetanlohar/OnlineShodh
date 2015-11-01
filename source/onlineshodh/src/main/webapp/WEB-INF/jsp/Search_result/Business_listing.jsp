<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Business Listing</title>
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
	<div id="result_container">
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
		<!-- search bar and logo End -->

		<!-- add banner -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12 banner_img">

					<img
						src="${pageContext.request.contextPath}/resources/images/ad.jpg" />

				</div>

			</div>

		</div>
		<!--  End add banner -->

		<!-- search result display -->
		<div class="container">
			<div class="row">
				<div class="col-lg-9 col-md-9">
					<div class="row">
						<ol class="breadcrumb">
							<li><a href="#">Home</a></li>
							<li><a href="#">Hotels</a></li>
							<li class="active">3 Star Hotels</li>
						</ol>
					</div>
					<div id="pageStuff" class="nav nav-tabs nav-stacked">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/hotel.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a
													href="${pageContext.request.contextPath}/prashant/businessd"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/bike.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a href="#"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>

							</div>

						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/bike.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a href="#"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>

							</div>

						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/bike.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a href="#"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>

							</div>

						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/bike.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a href="#"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>

							</div>

						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/bike.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a href="#"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>

							</div>

						</div>
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="search_cnter">
									<div class="row">
										<div class="col-lg-4 col-md-4">
											<img class="product_img"
												src="${pageContext.request.contextPath}/resources/images/bike.jpg" />
										</div>
										<div class="col-lg-8 col-md-8">
											<h4 class="product_name">
												<span class="product_brand"><i
													class="fa fa-thumbs-up "></i></span> <a href="#"
													class="product_title"> <strong>Softinfology
														solutions and Counsultancy</strong>
												</a>

											</h4>
											<p class="product_location">
												<i class="fa fa-map-marker fa-2x"></i><span>Pride
													Icon Hadpsar-Bypass Road Pune 401222</span>
											</p>
											<p class="product_contact">
												<i class="fa fa-phone-square fa-2x"></i><span>+91
													8600249455</span><span>+91 8600249455</span>
											</p>

										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="span6">
						<div class="pagination">
							<ul class="pager"></ul>
						</div>
					</div>
				</div>
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
						Designed By:<a href="#" class="softinfo"> SoftInfoLogy Pvt
							Ltd.</a>
					</p>
				</div>

			</div>

		</div>
		</section>
		<!-- Footer Wrapar End -->
	</div>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var listElement = $('#pageStuff');
							var perPage = 10;
							var numItems = listElement.children().size();
							var numPages = Math.ceil(numItems / perPage);

							$('.pager').data("curr", 0);

							var curr = 0;
							while (numPages > curr) {
								$(
										'<li><a href="#" class="page_link">'
												+ (curr + 1) + '</a></li>')
										.appendTo('.pager');
								curr++;
							}

							$('.pager .page_link:first').addClass('active');

							listElement.children().css('display', 'none');
							listElement.children().slice(0, perPage).css(
									'display', 'block');

							$('.pager li a').click(function() {
								var clickedPage = $(this).html().valueOf() - 1;
								goTo(clickedPage, perPage);
							});

							function previous() {
								var goToPage = parseInt($('.pager')
										.data("curr")) - 1;
								if ($('.active').prev('.page_link').length == true) {
									goTo(goToPage);
								}
							}

							function next() {
								goToPage = parseInt($('.pager').data("curr")) + 1;
								if ($('.active_page').next('.page_link').length == true) {
									goTo(goToPage);
								}
							}

							function goTo(page) {
								var startAt = page * perPage, endOn = startAt
										+ perPage;

								listElement.children().css('display', 'none')
										.slice(startAt, endOn).css('display',
												'block');
								$('.pager').attr("curr", page);
							}
						});
	</script>

</body>
</html>