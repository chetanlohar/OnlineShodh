<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script	src="${pageContext.request.contextPath}/resources/js/commonjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Sub Category</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/admin/subcategories/save" method="post" modelAttribute="subcategory" enctype="multipart/form-data">
	<form:hidden path="subCategoryId"/>
	<form:hidden path="popularity"/>
	<form:hidden path="subCategoryLogo"/>
	<input type="hidden" name="operationType" value="update"/>
		<p>
			<label>Category Name:</label>
			<form:select path="category.categoryId" required="">
				<form:option value="0" label="--- Select ---"/>
				<c:forEach var="category1" items="${categories}">
					<form:option value="${category1.categoryId}">${category1.categoryName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="category.categoryId" cssClass="errors" />
		</p>
		<p>
			<label for="subCategoryName">Sub-Category Name*: </label>
			<form:input path="subCategoryName" title="Sub Category Name" maxlength="25" size="51"/>
			<form:errors path="subCategoryName" cssClass="errors" />
		</p>
		<p>
			<label for="subCategoryDesc" style="vertical-align: top;">Sub-Category Description*: </label>
			<form:textarea path="subCategoryDesc" title="Sub-Category Description" rows="5" cols="35"/>
			<form:errors path="subCategoryDesc" cssClass="errors" />
		</p>
		<p>
			<label for="file">Sub-Category Picture: </label>
			<input type="file" id="file" name="file" value="Browse" onchange="changeImage(this);">
			<form:errors path="subCategoryLogo" cssClass="errors" />
			<img id="categorylogo" src="${pageContext.request.contextPath}/admin/subcategories/load/logo/${subcategory.subCategoryId}" height="50" width="50" alt="*No Image"/>
		</p>
		<p>
			<input type="submit" id="saveSubCategory" name="saveSubCategory" value="Update" />
			<input type="reset" value="Reset"/>
			<a href="${pageContext.request.contextPath}/admin/subcategories" class="back">Go Back</a>
		</p>
	</form:form>
</body>
</html>