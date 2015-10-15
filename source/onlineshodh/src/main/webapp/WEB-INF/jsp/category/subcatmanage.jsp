<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Country</title>

<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.css"
	rel="stylesheet" />

<!--Jancy STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jasny-bootstrap.min.css"
	rel="stylesheet" />

<!-- DATA TABLE STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />

<!-- metis STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/metisMenu.min.css"
	rel="stylesheet" />
<!--CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />

</head>
</head>
<body>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Sub-Categories Management</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-9">
			<form:form
				action="${pageContext.request.contextPath}/admin/subcategories/save"
				method="post" modelAttribute="subcategory" class="form-horizontal"
				id="subcategorymanage" enctype="multipart/form-data">
				<input type="hidden" name="operationType" value="save" />
				<div class="col-lg-12 space">
					<label for="Name" class="col-sm-5 control-label">
						Sub-Category Name</label>
					<div class="input-group">
						<span class="input-group-addon"><span class="fa fa-user"></span></span>

						<form:select path="category.categoryId" required=""
							class="form-control" id="categoryname" name="categoryname">
							<form:option value="0" label="--- Select ---" />
							<c:forEach var="category" items="${categories}">
								<form:option value="${category.categoryId}">${category.categoryName}</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="category.categoryId" cssClass="errors" />
					</div>
				</div>

				<div class="col-lg-12 space">
					<label for="Name" class="col-sm-5 control-label">
						Sub-Category Name</label>
					<div class="input-group">
						<span class="input-group-addon"><span class="fa fa-user"></span></span>
						<form:input path="subCategoryName" title="Sub Category Name"
							class="form-control" id="subcategoryname" name="subcategoryname" />
						<form:errors path="subCategoryName" cssClass="errors" />
					</div>
				</div>

				<div class="col-lg-12 space">
					<label for="address" class="col-sm-5 control-label">Description</label>
					<div class="input-group">
						<span class="input-group-addon"><span class="fa fa-road"></span></span>
						<form:textarea path="subCategoryDesc" class="form-control"
							rows="3" id="subcategorydesc" name="subcategorydesc" />
						<form:errors path="subCategoryDesc" cssClass="errors" />
					</div>
				</div>

				<div class="col-lg-6 col-lg-offset-5 space">
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-preview thumbnail" data-trigger="fileinput"
							style="width: 200px; height: 150px;">
							<%-- img
							src="<%=request.getContextPath()%>/resources/images/user_pic.jpg"
							alt="..."> --%>
						</div>
						<div>
							<span class="btn btn-default btn-file"><span
								class="fileinput-new">Select image</span><span
								class="fileinput-exists">Change</span> <input type="file"
								id="file" name="file" onchange="changeImage(this);"> <form:errors
									path="subCategoryLogo" cssClass="errors" /></span> <a href="#"
								class="btn btn-default fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
				</div>



				<div class="col-lg-6 col-lg-offset-6 space">
					<button type="submit" class="btn btn-success" id="display"
						id="saveSubCategory" name="saveSubCategory">Submit</button>
					<button type="reset" class="btn btn-danger">Cancel</button>
				</div>
			</form:form>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12 space">
			<div class="panel panel-default">
				<div class="panel-heading">Country Management Table</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="dataTable_wrapper table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>Sub-Category Id</th>
									<th>Picture</th>
									<th>Sub-Category Name</th>
									<th>Description</th>
									<th>Main Category</th>
									<th>Popularity</th>
									<th>Edit</th>
									<th>Delete</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="subcategory" items="${subcategories}">
									<tr class="odd gradeX">
										<td>${subcategory.subCategoryId}</td>
										<td><img
											src="${pageContext.request.contextPath}/admin/subcategories/load/logo/${subcategory.subCategoryId}"
											class="img-responsive" width="50px " height="50px;" /></td>
										<td>${subcategory.subCategoryName}</td>
										<td>${subcategory.subCategoryDesc}</td>
										<td>${subcategory.category.categoryName}&nbsp|&nbsp(${subcategory.category.categoryId})</td>
										<td>${subcategory.popularity}</td>
										<td><a
											href="${pageContext.request.contextPath}/admin/subcategories/edit/${subcategory.subCategoryId}"
											class="edit"><button class="btn btn-info btn-xs">
													<i class="fa fa-pencil"></i> Edit
												</button></a></td>
										<td class="center"><a
											href="${pageContext.request.contextPath}/admin/subcategories/delete/${subcategory.subCategoryId}"
											onclick="return confirm('Do you want to Remove SubCategory: ${subcategory.subCategoryName}')">
												<button class="btn btn-danger btn-xs">
													<i class="fa fa-trash"></i> Delete
												</button>
										</a></td>


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

	<!-- /. PAGE INNER  -->
	<footer> &copy; 2015 OnlineShodh | By : <a
		href="www.softinfology.com" target="_blank">Softinfology</a> </footer>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/js/validation/jquery.validate.min.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/bootstrap.js"></script>

	<!-- validation SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/validation/formvalidation.js"></script>


	<!-- JANSY BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jasny-bootstrap.js"></script>

	<!-- METIMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/metisMenu.min.js"></script>

	<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>
</body>
</html>