<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ManageTown.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<title>Update Town</title>
</head>
<body><center>
	<form:form action="${pageContext.request.contextPath}/towns/save"
		modelAttribute="Town" method="POST">
			<form:hidden path="townId" />
		<p>
			<label>Country Name:</label>
		</p>
		<p>
			<form:select path="city.state.country.countryId" id="countryId" onchange="getState()" >
				<form:option value="0" label="---Select-------"/>
				<c:forEach var="country" items="${countries}">
				<form:option value="${country.countryId}">${country.countryName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="city.state.country.countryId" />
		</p>

		<p>
			<label>State Name:</label>
		</p>
		<p>
			<form:select path="city.state.stateId" id="townStates" onchange="getCity()">
				
				<c:forEach var="state" items="${states}">
					<form:option value="${state.stateId}">${state.stateName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="city.state.stateId" />
		</p>

		<p>
			<label>City Name:</label>
		</p>
		<p>
			<form:select path="city.cityId" id="stateCities">
				<c:forEach var="city" items="${cities}">
					<form:option value="${city.cityId}">${city.cityName}</form:option>
			 </c:forEach>
			</form:select>
			<form:errors path="city.cityId" />
		</p>

		<p>
			<label>Town Name :</label>
		</p>
		<p>
			<form:input path="townName" maxlength="30" size="25" />
		</p>
		<input type="submit" name="updateTown" value="Update">
		<form:errors path="townName" />
		<a href="${pageContext.request.contextPath}/towns/">Go Back</a>
	</form:form>


</body>
</html>