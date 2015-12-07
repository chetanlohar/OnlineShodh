<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Payment Mode</title>
<link rel="shortcut icon"  type="image/jpg" href="${pageContext.request.contextPath}/resources/images/logo.jpg" />

<!-- BOOTSTRAP STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.css"
	rel="stylesheet" />
<!-- metis STYLES-->


<link
	href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css"
	rel="stylesheet" />
<!-- Datepicker STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker3.min.css"
	rel="stylesheet" />
<!--PACE STYLES-->
<link href="${pageContext.request.contextPath}/resources/css/pace.css"
	rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"/>
<!--CUSTOM STYLES-->
<link
	href="${pageContext.request.contextPath}/resources/css/os-admin.css"
	rel="stylesheet" />
	
	
	<style type="text/css">
	.ui-autocomplete{
	
	z-index:999;
	}
	
	
	
	
	</style>

</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Online Shodh </a>
		</div>

		<div class="notifications-wrapper">
			<ul class="nav">

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-tasks">
						<li><a href="#">
								<div>
									<p>
										<strong>Task 1</strong> <span class="pull-right text-muted">60%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (danger)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 2</strong> <span class="pull-right text-muted">30%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"
											style="width: 30%">
											<span class="sr-only">30% Complete</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 3</strong> <span class="pull-right text-muted">80%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="80" aria-valuemin="0"
											aria-valuemax="100" style="width: 80%">
											<span class="sr-only">80% Complete (warning)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<p>
										<strong>Task 4</strong> <span class="pull-right text-muted">90%
											Complete</span>
									</p>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="90" aria-valuemin="0"
											aria-valuemax="100" style="width: 90%">
											<span class="sr-only">90% Complete (success)</span>
										</div>
									</div>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									Tasks List + </strong>
						</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user-plus"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
								<li><a href="#"><i class="fa fa-user-plus"></i> My Profile, ${pageContext.request.userPrincipal.name}</a></li>
						<li class="divider"></li>
						<li><a href="javascript:formSubmit()"><i class="fa fa-sign-out"></i> Logout</a></li>
					</ul></li>
			</ul>

		</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li>
					<div class="user-img-div">
						<img src="${pageContext.request.contextPath}/admin/clients/load/logo/${userDeailsId}" class="img-circle" />

					</div>

				</li>
				<li><a href="#"> <strong>OnlineShodh@mail.com </strong></a></li>

				<li><a href="${pageContext.request.contextPath}/admin/home"><i
						class="fa fa-home "></i>Home</a></li>
				<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
						Category Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/categories"><i
								class="fa fa-list"></i> Category Management</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/subcategories">
								<i class="fa fa-list"></i> Sub-Category Management
						</a></li>
					</ul> <!-- /.nav-second-level --></li>

				<li><a href="tables.html"><i class="fa fa-globe fa-fw"></i>
						Location Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/countries">Country
								Management</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/states">State
								Management</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/cities">City
								Management</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/towns">Town
								Management</a></li>
					</ul> <!-- /.nav-second-level of location management --></li>

				<li><a href="forms.html"><i class="fa fa-user fa-fw"></i>
						Client Management<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/clients">Manage
								Client</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-briefcase"></i>Business
						Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/clients/view/">
								<i class="fa fa-user-plus"></i> Add Business
						</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/business/getAllBusiness"  > <i class="fa fa-list"></i> List Business
						</a></li>

					</ul></li>

				<li><a href="add-client.html"><i class="fa fa-rss"></i>Plan
						Management <span class="fa arrow"></span></a>
					<ul class=" nav nav-second-level">
						<li><a href="${pageContext.request.contextPath}/admin/plans">
								<i class="fa fa-user-plus"></i> Create Plan

						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/plans/updatePlans">
								<i class="fa fa-list"></i> Update Plan
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/plans/getPlans">
								<i class="fa fa-list"></i> List All Plan

						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/plans/planAssign">
								<i class="fa fa-list"></i> Assign Business Plan
						</a></li>
					</ul></li>


				<li><a href="#"><i class="fa fa-photo "></i>Advt. Banner<span
						class="fa arrow"></span></a>

					<ul class="nav nav-second-level">
						<li><a
							href="${pageContext.request.contextPath}/admin/banners"><i
								class="fa fa-cogs "></i>Add New Advt. Banner</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/banners/showBanners"><i class="fa fa-bullhorn "></i>List All
								Advt. Banner</a></li>
					</ul></li>

				<li><a href="${pageContext.request.contextPath}/admin/payments"
					class="active-menu"><i class="fa fa-money "></i>Payment Mode</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/business/Businessenqury"><i class="fa fa-search "></i>Enquiry</a>
				</li>
				<li><a href="#"><i class="fa fa-signal "></i>Logs <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>List All Logs</a>
						</li>
					</ul></li>
				<li><a href="#"><i class="fa fa-envelope "></i>Mails <span class="badge bg-red">5</span><span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>List All Mails</a>
						</li>

					</ul></li>
				<li><a href="#"><i class="fa fa-cogs "></i>Settings <span
						class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="#"><i class="fa fa-cogs "></i>Second Link</a></li>
						<li><a href="#"><i class="fa fa-bullhorn "></i>Second
								Link</a></li>
						<li><a href="#">Second Level<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li><a href="#">Third Link</a></li>
								<li><a href="#">Third Link</a></li>

							</ul></li>
					</ul></li>


			</ul>
		</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">Payment Mode</h1>
					</div>
				</div>

				<div class="row">
				<div class="col-lg-12 message"></div>
					<div class=" col-md-10 col-md-offset-2 ">
						<form:form
							action="${pageContext.request.contextPath}/admin/payments/save"
							class="form-horizontal" id="payment_mode"
							modelAttribute="paymentStatus" method="POST">
							<div class="col-lg-8 space">
								<label for="payment" class="col-sm-3 control-label">Payment
									For</label>
								<div class="input-group col-lg-9">
									<form:select path="payment.paymentfor" class="form-control"
										id="payfor">
										<form:option value="BusinessAdvertisement"
											label="BusinessAdvertisement" />
										<form:option value="BannerAdvertisement"
											label="BannerAdvertisement" />
									</form:select>



								</div>
							</div>
							<div class="col-lg-8 space hide_business">
								<label for="Business_name" class="col-sm-3 control-label">Business
									Name </label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-briefcase"></span></span> <input type="text"
										class=" form-control" id="keyword" name="businessName" />


								</div>
							</div>
							<div class="col-lg-8 space hide_banner">
								<label for="Banner_name" class="col-sm-3 control-label">Banner
									Name </label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-photo"></span></span> <input type="text"
										class=" form-control" id="keyword1" name="bannerName" />
								</div>
							</div>

							<div class="col-lg-8 space">
								<label for="payment" class="col-sm-3 control-label">Payment
									Mode</label>
								<div class="input-group col-lg-9">
									<form:select path="payment.paymentMode.paymentModeid"
										class="form-control" id="pay_mode">
										<c:forEach var="paymentmode" items="${paymentmodes}">
											<form:option value="${paymentmode.paymentModeid}">${paymentmode.paymentMode}</form:option>
										</c:forEach>
									</form:select>

								</div>
							</div>
							<div class="col-lg-8 space hide_cashamount">
								<label for="Amount" class="col-sm-3 control-label">Amount
								</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-inr"></span></span>
									<form:input path="payment.ammount" class=" form-control" name="cash_amount"/>
									<form:errors path="payment.ammount" cssClass="errors"/>
								</div>
							</div>

							<div class="hide_neft">
								<div class="col-lg-8 space">
									<label for="Benif_name" class="col-sm-3 control-label">
										Beneficiary Name </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-ticket"></span></span> 
									
											<form:input path="check.checkNo" class=" form-control" name="cheque_name"/>
                                           <form:errors path="check.checkNo" cssClass="errors"/> 
									</div>
								</div>
								<div class="col-lg-8 space">
									<label for="Bank" class="col-sm-3 control-label">Bank
										Name </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-university"></span></span>
											<form:input path="check.bankName" class=" form-control" name="bank_name" />
											<form:errors path="check.bankName" cssClass="errors"/>
									</div>
								</div>
								<div class="col-lg-8 space">
									<label for="cheque_date" class="col-sm-3 control-label"> Branch
										Name </label>
									<div class="input-group sandbox-container">
										<span class="input-group-addon"><span
											class="fa fa-calendar"></span></span>
											<form:input path="check.checkDate" class=" form-control" />
											<form:errors path="check.checkDate" cssClass="errors"/>
									</div>
								</div>
								
									<div class="col-lg-8 space">
									<label for="cheque_date" class="col-sm-3 control-label">Account
										No. </label>
									<div class="input-group sandbox-container">
										<span class="input-group-addon"><span
											class="fa fa-calendar"></span></span>
											<form:input path="check.checkDate" class=" form-control" />
											<form:errors path="check.checkDate" cssClass="errors"/>
									</div>
								</div>

								<div class="col-lg-8 space">
									<label for="neft_amount" class="col-sm-3 control-label">NEFT
										Amount </label>
									<div class="input-group">
										<span class="input-group-addon"><span class="fa fa-inr"></span></span>
										
										<form:input path="check.amount"  class=" form-control" name="Cheque_amount"/>
                                       <form:errors path="check.amount" cssClass="errors"/>
									</div>
								</div>


							</div>

							<div class="col-lg-8 space">
								<label for="status" class="col-sm-3 control-label">Status
								</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="fa fa-check"></span></span> 
										<form:input path="payment.status" class=" form-control" name="status"/>
                                         <form:errors path="payment.status" cssClass="errors"/>
										
								</div>
							</div>
							<div class="col-lg-8 space">
								<label for="remark" class="col-sm-3 control-label">Remark
								</label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-flag"></span></span>
									<form:input path="payment.remark" class=" form-control" name="remark" />
                                    <form:errors path="payment.remark" cssClass="errors"/>
									
								</div>
							</div>
							<div class="col-lg-8 space">
								<label for="payuaser" class="col-sm-3 control-label">Payee
									Name </label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-user"></span></span>
									<form:input path="payment.payeeName" class=" form-control" name="payuser"/>
                                    <form:errors path="payment.payeeName" cssClass="errors"/>
								</div>
							</div>
							<div class="col-lg-8 space hide_cheque">
								<label for="transId" class="col-sm-3 control-label">Transaction
									Id </label>
								<div class="input-group">
									<span class="input-group-addon"><span class="fa fa-link"></span></span>
									<form:input path="payment.transactionid" class=" form-control" name="transId" />
									<form:errors path="payment.transactionid" cssClass="errors"/> 
								</div>
							</div>

							<div class="col-lg-5 col-lg-offset-4 space">
								<button class="btn btn-success sendinfo" type="submit">Submit</button>
							
								<button class="btn btn-danger" type="reset">Reset</button>
                                  
							</div>
						</form:form>
					</div>
				</div>

				<!-- /. PAGE INNER  -->
				<footer class="space"> &copy; 2015 OnlineShodh | By : <a
					href="www.softinfology.com" target="_blank">Softinfology</a> </footer>
			</div>
			<!-- /. PAGE WRAPPER  -->
		</div>

	</div>
	<!-- /. WRAPPER  -->


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
	<!-- Datepicker SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>

	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/assets/metisMenu.min.js"></script>

	<!-- PACE SCRIPTS -->
	<script src="${pageContext.request.contextPath}/resources/js/pace.js"></script>

		
		
		
		<!-- CUSTOM SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>
	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script>


	<script
		src="<%=request.getContextPath()%>/resources/js/validation/paymentvalidation.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script
		src="${pageContext.request.contextPath}/resources/js/os-admin.js"></script>
		<script  src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>


<script type="text/javascript">
$(document).ready(function(){

 
$("#keyword").on("keyup",function(e){
	 $( "#keyword" ).autocomplete({
			source: '${pageContext.request.contextPath}/admin/business/searchBusiness'
	});
}); 
});
</script>
<script type="text/javascript">
	$(document).ready(function(){
 	$("#keyword1").on("keyup",function(e){
	 $("#keyword1").autocomplete({
		source: '${pageContext.request.contextPath}/admin/banners/searchBanner'
	});
});
	 
}); 
</script>


	<c:url value="/j_spring_security_logout" var="logoutUrl" />
       <form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		</form>
        <script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>



</body>
</html>