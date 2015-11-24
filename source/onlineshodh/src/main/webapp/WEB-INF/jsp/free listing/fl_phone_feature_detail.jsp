<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Free Listing contact Details</title>


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
<!-- DATA TABLE STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />
<style type="text/css">
body {
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
						<h2 class="free_list_title">List your Business with India's
							popular Local Search Engine</h2>

					</div>
				</div>
			</div>
			<div class="list_form_container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="bg-info space sub_header">Free Listing Contact
							Details</h2>
						<div class="new_detail_form space">
							<%-- <form action="" id="free_list_contact" class="form form-inline"> --%>
								<div class="space"></div>
								<div class="col-md-5 space">
									<label for="address" class="col-sm-3 control-label">Phone
										Type </label>
									<div class="input-group col-md-5">
										<select class="form-control" id="phonetype">
											<option value="Landline">Landline</option>
											<option value="Mobile">Mobile</option>

										</select>
									</div>
								</div>
								<div class="col-md-4 space">
									<label for="street" class="col-sm-3 control-label">Contact
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-phone"></span></span> <input type="text"
											name="fr_list_phone" id="contact" maxlength="10"
											class="form-control">
									</div>
								</div>

								<div class="col-md-2 space">

									<button type="button" class="btn btn-info" id="phonebutton"
										onclick="addPhone()">
										<i class="fa fa-plus-circle"></i> Add
									</button>
									<input type="hidden" id="phoneurl"
										value="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/savephone" />
									<input type="hidden" id="phoneurl1"
										value="${pageContext.request.contextPath}/freelisting/updatephone/${freeListingBusiness.freelistingbusinessdetailsId}/" />



								</div>
							<%-- </form> --%>

						</div>

					</div>

				</div>

				<div class="row space">
					<div class="col-lg-12 space">
						<div class="panel panel-default">
							<div class="panel-heading text-center">Contact Management
								Table</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="phoneTable">
										<thead>
											<tr>


												<th>ID</th>
												<th>Phone</th>
												<th>Phone Type</th>
												<th>Edit</th>
												<th>Delete</th>
												<th>Verify</th>


											</tr>
										</thead>
										<tbody id="tbody">
											<c:forEach var="phones" items="${flphones}">
												<tr>
													<td>${phones.freeBuinessPhoneId}</td>
													<td>${phones.phone}</td>
													<td>${phones.phonetype}</td>
													<td><button class="upcontact btn-info btn-xs">Edit</button></td>

													<td><a
														href="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/${phones.freeBuinessPhoneId}/deletePhone">Delete</a></td>
													<td><a href="#">Verify</a></td>
												</tr>
											</c:forEach>


										</tbody>
									</table>
								</div>
								<!-- /.table-responsive -->

							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-md-12">
						<h2 class="bg-info space sub_header">Free Listing Feature
							Details</h2>
						<div class="new_detail_form">
							<%-- <form action="" id="free_list_feature" class="form form-inline"> --%>
								<div class="space"></div>
								<div class="col-md-4 space">
									<label for="feature" class="col-sm-3 control-label">Feature
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-leaf"></span></span> <input type="text"
											name="fr_list_feature" id="feature" class="form-control">
									</div>
								</div>


								<div class="col-md-2 space">

									<button type="button" class="btn btn-info"
										onclick="addFeature()">
										<i class="fa fa-plus-circle"></i> Add
									</button>
									<input type="hidden" id="featureurl"
										value="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/savefeature" />
									<input type="hidden" id="featureurl1"
										value="${pageContext.request.contextPath}/freelisting/updateFeature/${freeListingBusiness.freelistingbusinessdetailsId}/" />


								</div>
							<%-- </form> --%>

						</div>

					</div>

				</div>
				<div class="row space">

					<div class="col-lg-12 space">

						<div class="panel panel-default">
							<div class="panel-heading text-center">Feature Management
								Table</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="featureTable">
										<thead>
											<tr>


												<th>ID</th>
												<th>Feature Name</th>
												<th>Edit</th>
												<th>Delete</th>



											</tr>
										</thead>
										<tbody id="tbody">
											<c:forEach var="features" items="${flfeatures}">
												<tr>
													<td>${features.freelistingBusinessFeatureId}</td>
													<td>${features.freelistingBusinessFeature}</td>
													<td><button class="EditFeature btn-info btn-xs">Edit</button></td>
													<td>
													<a
														href="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/${features.freelistingBusinessFeatureId}/deleteFeature">Delete</a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
								<!-- /.table-responsive -->

							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row space">
					<div class="col-md-5 col-md-offset-5 space">
						<button type="button" class="btn btn-info">Countinue</button>

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
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
	<!-- DATATABLE SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>

	<script>
		$(document).ready(function() {
			/* 		$('#fl_contact').DataTable({
						  "paging":   false,
					        "ordering": false,
					        "info":     true
					});
					
					$('#fl_feature').DataTable({
						responsive : true
					});
			 */
		});
		</script>	
		<script type="text/javascript">
		var flag = false;
		var flag1 = false;

		function addPhone() {
			var phoneurl;
			if (flag == true) {

				phoneurl = $('#phoneurl1').val();
			} else {
				phoneurl = $("#phoneurl").val();
			}
			$
					.ajax({
						type : "POST",
						url : phoneurl,
						datatype : "json",
						data : {
							"phonetype" : $('#phonetype').val(),
							"contact" : $('#contact').val(),
						},
						success : function(response) {
							/* alert(response) */
							console.log(response)
							$('#phoneTable').find('#tbody').remove();
							jQuery
									.each(
											response,
											function(index, item) {

												var newRow = jQuery('<tr><td>'
														+ item.freeBuinessPhoneId
														+ '</td><td>'
														+ item.phone
														+ '</td><td>'
														+ item.phonetype
														+ '</td><td><button class="upcontact btn-info btn-xs">Edit</button></td><td><a href="${pageContext.request.contextPath}/freelisting/'+item.freeListingBusinessEntity.freelistingbusinessdetailsId+'/'+item.freeBuinessPhoneId+'/deletePhone">Delete</a></td><td>Verify</td></tr>')

												jQuery('#phoneTable')
														.append(newRow);
											});

						},
						error : function(error) {
							console.log(error)
						}

					});

		}

		function addFeature() {

			var url;
			if (flag1 == true) {
				/* alert($('#featureurl1').val())    */
				url = $('#featureurl1').val();
			} else {
				url = $('#featureurl').val();
			}

			$
					.ajax({
						type : "POST",
						url : url,
						datatype : "json",
						data : {
							"feature" : $('#feature').val()
						},
						success : function(response) {

							console.log(response)
							$('#featureTable').find('#tbody').remove();

							jQuery
									.each(
											response,
											function(index, item) {

												var newRow = jQuery('<tr><td>'
														+ item.freelistingBusinessFeatureId
														+ '</td><td>'
														+ item.freelistingBusinessFeature
														+ '</td><td><button class="EditFeature btn-info btn-xs">Edit</button></td><td><a href="${pageContext.request.contextPath}/freelisting/'+item.business.freelistingbusinessdetailsId+'/'+item.freelistingBusinessFeatureId+'/deleteFeature">Delete</a></td></tr>')
												jQuery('#featureTable').append(
														newRow);
											});
						},
						error : function(error) {
							console.log(error)
						}

					});
		}

		$(document).ready(function() {

			$(".upcontact").on('click', function(e) {

				flag = true;

				var valp = $(this).parent().siblings(":nth-child(2)").text()
				var valpid = $(this).parent().siblings(":nth-child(1)").text()
				$("#contact").val(valp);
				var url1 = $("#phoneurl1").val();
				$("#phoneurl1").val(url1 + valpid);

				$("#phonebutton").html('Update');

			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(
				function() {

					$(".EditFeature").on(
							'click',
							function(e) {

								var valfeature = $(this).parent().siblings(
										":nth-child(2)").text()
								var valfeatureid = $(this).parent().siblings(
										":nth-child(1)").text()
								var url2 = $("#featureurl1").val();
								$("#feature").val(valfeature);
								/* $("#feature").val(valfeatureid) */
								$("#featureurl1").val(url2 + valfeatureid)
								flag1 = true;
							});
				});
	</script>

		
		
	
</body>
</html>