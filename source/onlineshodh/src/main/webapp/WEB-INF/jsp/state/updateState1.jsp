<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update State</title>
</head>
<body>
<center>
	<form:form action="${pageContext.request.contextPath}/states/save"
		method="POST" modelAttribute="state">
		<form:hidden path="stateId" />
		
		<p>
			<label>Country Name:</label>
		</p>
		<p>
			<form:select path="country.countryId" id="countryId">

				<form:option value="0">Select</form:option>
				<c:forEach var="country" items="${countries}">
					<form:option value="${country.countryId}">${country.countryName}</form:option>
					
				</c:forEach>
			</form:select>
	      <form:errors path="country.countryId" />		
		</p>
		<p>
			<label for="stateName">State Name:</label>
		
		</p>
		<p>
			<form:input path="stateName" title="State Name" maxlength="25"
				size="50" />
		
			<form:errors path="stateName" cssClass="errors" />
		</p>
			<input type="submit" id="saveSate" name="saveState" value="Update">
			<input type="reset" value="Reset"/>
		<a href="${pageContext.request.contextPath}/states/">Go Back</a>

	</form:form>

</center>
</body>
</html>