<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ManageCity.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<title>Update City</title>
</head>
<body>
<center>
	<form:form action="${pageContext.request.contextPath}/cities/save"
		method="POST" modelAttribute="city">
		<form:hidden path="cityId" />
		<p>
			<label>Country Name:</label>
		</p>
		<p>
			<form:select path="state.country.countryId" id="countryId"
				onchange="getState()">
				<form:option value="0">Select</form:option>
				<c:forEach var="country" items="${countries}">
					<form:option value="${country.countryId}">${country.countryName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="state.country.countryId" />
		</p>

		<p>
			<label>State Name: </label>
		</p>
		<p>
			<form:select path="state.stateId" id="countryStates">

				<c:forEach var="state" items="${states}">
					<form:option value="${state.stateId}">${state.stateName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="state.stateId" />
		</p>
		<p>
			<label for="cityName">City Name:</label>
		<p>
			<form:input path="cityName" title="City Name" maxlength="25"
				size="50" />

			<form:errors path="cityName" cssClass="errors" />
		</p>
		<input type="submit" id="updateCity" name="updateCity" value="Update">
         <input type="reset" value="Reset"/>      

		<a href="${pageContext.request.contextPath}/cities/">Go Back</a>

	</form:form>
</center>

</body>
</html>