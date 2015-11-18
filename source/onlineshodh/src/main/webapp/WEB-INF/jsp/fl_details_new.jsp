<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Free Listing</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/codejs/viewSubCategory.js"></script>
<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
</head>
<body>

	<form:form method="post" action="${pageContext.request.contextPath}/freelisting/business/save" modelAttribute="flDetails">
		<p>
			<label>Company/Business Name:</label>
			<form:input path="businessName" />
		</p>
		<p>
			<label>Person Name:</label>
			<form:input path="personName" />
		</p>
		<p>
			<label>Email:</label>
			<form:input path="email" />
		</p>
		<p>
			<label>Web Site:</label>
			<form:input path="website" />
		</p>
		<p>
			<label>Keywords:</label>
			<form:textarea path="keywords" />
		</p>
		<p>
			<label>Category:</label>
			<form:select path="subCategory.category.categoryId" required=""
				id="categoryname" name="categoryname" onchange="getSubCategoriesForFreeListing()">
				<form:option value="0" label="--- Select ---" />
				<c:forEach var="category" items="${categories}">
					<form:option value="${category.categoryId}">${category.categoryName}</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<label>Sub-Category:</label>
			<form:select path="subCategory.subCategoryId" required=""
				class="form-control" id="subcategoryname" name="subcategoryname">
				<form:option value="0" label="--- Select ---" />
				<c:forEach var="subcategory" items="${subcategories}">
					<form:option value="${subcategory.subCategoryId}">${subcategory.subCategoryName}</form:option>
				</c:forEach>
			</form:select>
		</p>
		
		<p>
			<input type="submit" value="Save & Continue">
		</p>
		
	</form:form>




</body>
</html>