<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Countries</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/countries/save" method="post" modelAttribute="country">
		<p>
			<label for="countryName">Country Name: </label>
		</p>
		<p>
			<form:input path="countryName" title="Country Name" maxlength="25" size="50"/> 
			<form:errors path="countryName" cssClass="errors" />
			<input type="submit" id="saveCountry" name="saveCountry" value="Save">
		</p>
		<table>
			<tr>
				<th>Country Id</th>
				<th>Country Name</th>
				<th>Action</th>
			</tr>
			<c:forEach var="country" items="${countries}">
				<tr>
					<td style="text-align: center;">${country.countryId}</td>
					<td>${country.countryName}</td>
					<td><a href="#">edit</a>&nbsp|&nbsp<a href="#">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>