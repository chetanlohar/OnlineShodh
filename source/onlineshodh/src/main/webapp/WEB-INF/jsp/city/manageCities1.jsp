<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ManageCity.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<title>Manage City</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/cities/save"
		method="POST" modelAttribute="City">
		<p>
			<label>Country Name:</label>
		</p>
		<p>
			<form:select path="state.country.countryId" id="countryId"
				onchange="getState()">
				<form:option value="0" label="--- Select ---" />
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
				<form:option value="0">Select</form:option>states
				 <c:forEach var="state" items="${states}">
					<form:option value="${state.stateId}">${state.stateName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="state.stateId" />
		</p>
		<p>
		<p>
			<label for="cityName">City Name: </label>
		</p>
		<form:input path="cityName" title="City Name" maxlength="25" size="50" />
		<form:errors path="cityName" cssClass="errors" />
		<p>
		<input type="submit" id="saveCity" name="saveCity" value="Save">
        <input type="reset" value="Reset"/>
        </p>  
		<table>
			<tr>
				<th>City Id</th>
				<th>City Name</th>
				<th>Country(Id)</th>
				<th>State(Id)</th>
				<th>Action</th>
			</tr>
			<c:set var="count" value="0" scope="page" />
			<c:forEach var="city" items="${cities}">
				<tr>
					<td style="text-align: center;">${city.cityId}</td>
					<td>${city.cityName}</td>
					<td>${city.state.country.countryName}&nbsp|&nbsp(${city.state.country.countryId})</td>
					<td>${city.state.stateName}&nbsp|&nbsp(${city.state.stateId})</td>

					<td><a
						href="${pageContext.request.contextPath}/cities/edit/${city.cityId}/${city.state.country.countryId}">edit</a>&nbsp|&nbsp<a
						href="${pageContext.request.contextPath}/cities/delete/${city.cityId}"
						onclick="return confirm('Do you want to Remove City ${city.cityName}')">remove</a></td>
				</tr>
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>
		</table>






	</form:form>


</body>
</html>