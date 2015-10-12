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
	<form:form action="${pageContext.request.contextPath}/states/save" method="POST" modelAttribute="state">
		<p>
			<label>Country Name :</label>
			<form:select path="country.countryId">
                <form:option value="0">Select</form:option>   			
				<c:forEach var="country" items="${countries}">
					<form:option value="${country.countryId}">${country.countryName}</form:option>
				</c:forEach>
			</form:select>
		    <form:errors path="country.countryId" cssClass="errors" />  
		</p>

		<p>
			<label for="stateName">State Name:</label>
		</p>	
		<p>
			<form:input path="stateName" title="State Name" maxlength="25"
				size="50" />
		</p>		
		<p>
			<form:errors path="stateName" cssClass="errors" />
		</p>
			<input type="submit" id="saveSate" name="saveState" value="Save">
			<input type="reset" value="Reset"/>
		</form:form>	
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
					<td>${state.country.countryName}&nbsp|&nbsp(${state.country.countryId})</td>
					<td><a
						href="${pageContext.request.contextPath}/states/edit/${state.stateId}/${state.country.countryId}">edit</a>&nbsp|&nbsp<a
						href="${pageContext.request.contextPath}/states/delete/${state.stateId}"
						onclick="return confirm('Do you want to Remove State: ${state.stateName}')">remove</a></td>
				</tr>
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>
		</table>

	



</body>
</html>