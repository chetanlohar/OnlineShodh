<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage States</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/states/save"
		method="POST" modelAttribute="state">

		<p>
			<label for="countryName">Country Name :</label>
			<form:select path="countryId">
				<c:forEach var="country" items="${countries}">
					<form:option value="${country.countryId}">${country.countryName}</form:option>
					<form:errors path="countryId" cssClass="errors"/>
				</c:forEach>

			</form:select>
		</p>

		<p>
			<label for="stateName">State Name:</label>
		<p>
			<form:errors path="stateName" cssClass="errors" />
		</p>
		</p>
		<p>
			<form:input path="stateName" title="State Name" maxlength="25"
				size="50" />
			<input type="submit" id="saveSate" name="saveState" value="Save">
		</p>
		<table>
			<tr>
				<th>State Id</th>
				<th>State Name</th>
				<th>Country(Id)</th>
				<th>Action</th>
			</tr>
			<c:set var="count" value="0" scope="page" />
			<c:forEach var="state" items="${states}">
				<tr>
					<td style="text-align: center;">${state.stateId}</td>
					<td>${state.stateName}</td>
					
					<c:forEach var="statecountry" items="${statesCountry}" begin="${count}" end="${count}">
					<td>${statecountry.countryName}(${state.countryId})</td>
					
				   </c:forEach>
					<td><a
						href="${pageContext.request.contextPath}/states/edit/${state.stateId}/${state.countryId}">edit</a>&nbsp|&nbsp<a
						href="${pageContext.request.contextPath}/states/delete/${state.stateId}"
						onclick="confirm('Do you want to Remove State: ${state.stateName}')">remove</a></td>
				</tr>
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>
		</table>

	</form:form>



</body>
</html>