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
<title>SubCategory Management</title>
</head>
<body>
	<center>
		<h3>SubCategory Management</h3>
	</center>
	<form:form action="${pageContext.request.contextPath}/admin/subcategories/save" method="post" modelAttribute="subcategory" enctype="multipart/form-data">
		<p>
			<label>Category Name:</label>
			<form:select path="category.categoryId">
				<form:option value="None" label="--- Select ---" />
				<c:forEach var="category" items="${categories}">
					<form:option value="${category.categoryId}">${category.categoryName}</form:option>
					<form:errors path="category.categoryId" cssClass="errors" />
				</c:forEach>
			</form:select>
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
			<img id="categorylogo" height="50" width="50"/>
		</p>
		<p>
			<input type="submit" id="saveSubCategory" name="saveSubCategory" value="Save" />
			<input type="reset" value="Reset"/>
		</p>
		<table>
			<tr>
				<th>Sub-CatId</th>
				<th>Picture</th>
				<th>Name</th>
				<th>Description</th>
				<th>Main Category</th>
				<th>Popularity</th>
				<th>Action</th>
			</tr>
			<c:forEach var="subcategory" items="${subcategories}">
				<tr>
					<td style="text-align: center;">${subcategory.subCategoryId}</td>
					<td><img src="${pageContext.request.contextPath}/admin/subcategories/load/logo/${category.categoryId}" height="50" width="50" alt="*No Image"/></td>
					<td>${subcategory.subCategoryName}</td>
					<td>${subcategory.subCategoryDesc}</td>
					<td>${subcategory.category.categoryName}&nbsp|&nbsp(${subcategory.category.categoryId})</td>
					<td>${subcategory.popularity}</td>
					<td><a href="${pageContext.request.contextPath}/admin/subcategories/edit/${subcategory.subCategoryId}">edit</a>&nbsp|&nbsp<a href="${pageContext.request.contextPath}/admin/subcategories/delete/${subcategory.subCategoryId}" onclick="confirm('Do you want to Remove Country: ${subcategory.subCategoryName}')">remove</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</form:form>
</body>
</html>