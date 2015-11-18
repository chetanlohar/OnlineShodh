<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

</head>
<body>
	<div class="free_list_container">
		<div class="container">
			<div class="listing_header">
				<div class="row">
					<div class="col-md-3">
						<img
							src="${pageContext.request.contextPath}/resources/images/login-logo.gif"
							alt="onlineshodh" width="70px;" heigth="40px;" />
					</div>
					<div class="col-md-9">
						<h2 class="free_list_title">Free Listing</h2>

					</div>
				</div>
			</div>
			<div class="list_form_container">
				<div class="row">
					<div class="col-md-12">
					<h2 class="bg-info space">Free Listing Contact Details</h2>
						<div class="new_detail_form space">
							<form action="" id="free_list_contact" class="form form-inline">
								<div class="space"></div>
								<div class="col-md-5 space">
									<label for="address" class="col-sm-3 control-label">Phone
										Type </label>
									<div class="input-group col-md-5">
										<select class="form-control">
											<option value="Landline">Landline</option>

										</select>
									</div>
								</div>
								<div class="col-md-5 space">
									<label for="street" class="col-sm-3 control-label">Contact
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-phone"></span></span> <input type="text"
											name="fr_list_phone" id="fr_list_phone" class="form-control">
									</div>
								</div>

								<div class="col-md-2 space">

									<button type="button" class="btn btn-info">
										<i class="fa fa-plus-circle"></i> Add
									</button>


								</div>
							</form>

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
										id="fl_contact">
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
										<tbody>

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
					<h2 class="bg-info space">Free Listing Feature Details</h2>
						<div class="new_detail_form">
							<form action="" id="free_list_feature" class="form form-inline">
								<div class="space"></div>
								<div class="col-md-5 space">
									<label for="feature" class="col-sm-3 control-label">Feature
									</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-phone"></span></span> <input type="text"
											name="fr_list_feature" id="fr_list_feature"
											class="form-control">
									</div>
								</div>


								<div class="col-md-2 space">

									<button type="button" class="btn btn-info">
										<i class="fa fa-plus-circle"></i> Add
									</button>


								</div>
							</form>

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
										id="fl_feature">
										<thead>
											<tr>


												<th>ID</th>
												<th>Feature Name</th>
												<th>Edit</th>
												<th>Delete</th>



											</tr>
										</thead>
										<tbody>

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
			</div>
		</div>
	</div>
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
			$('#fl_contact').DataTable({
				responsive : true
			});
			
			$('#fl_feature').DataTable({
				responsive : true
			});

		});
	</script>
</body>
</html>