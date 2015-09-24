<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Management</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/categories/save" method="post" modelAttribute="category" enctype="multipart/form-data">
		<p>
			<label for="categoryName">Category Name*: </label>
			<form:input path="categoryName" title="Category Name" maxlength="25" size="51"/>
			<form:errors path="categoryName" cssClass="errors" />
		</p>
		<p>
			<label for="categoryDesc" style="vertical-align: top;">Category Description*: </label>
			<form:textarea path="categoryDesc" title="Category Description" rows="5" cols="35"/>
			<form:errors path="categoryDesc" cssClass="errors" />
		</p>
		<p>
			<label for="categoryLogo">Category Picture: </label>
			<input type="file" id="file" name="file" value="Browse">
		</p>
		<p>
			<input type="submit" id="saveCategory" name="saveCategory" value="Save" />
			<input type="reset" value="Reset"/>
		</p>
		<table>
			<tr>
				<th>Id</th>
				<th>Picture</th>
				<th>Name</th>
				<th>Description</th>
				<th>Popularity</th>
				<th>Action</th>
			</tr>
			<c:forEach var="category" items="${categories}">
				<tr>
					<td style="text-align: center;">${category.categoryId}</td>
					<td><img src="${pageContext.request.contextPath}/resources/images/automobile.png" height="50" width="50"/></td>
					<td>${category.categoryName}</td>
					<td>${category.categoryDesc}</td>
					<td>${category.popularity}</td>
					<td><a href="${pageContext.request.contextPath}/countries/edit/${category.categoryId}">edit</a>&nbsp|&nbsp<a href="${pageContext.request.contextPath}/countries/delete/${category.categoryId}" onclick="confirm('Do you want to Remove Country: ${category.categoryName}')">remove</a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>