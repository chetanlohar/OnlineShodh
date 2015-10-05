<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Town</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ManageTown.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>
<body>
<center>
	<form:form action="${pageContext.request.contextPath}/towns/save"
		modelAttribute="Town" method="POST">
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
				<form:option value="0" label="---Select-------" />
			</form:select>
			<form:errors path="city.state.stateId" />
		</p>

		<p>
			<label>City Name:</label>
		</p>
		<p>
			<form:select path="city.cityId" id="stateCities">
				<form:option value="0" label="---Select-------" />
			</form:select>
			<form:errors path="city.cityId" />
		</p>

		<p>
			<label for="townName">Town Name :</label>
		</p>
		<p>
			<form:input path="townName" maxlength="30" size="25" />
			<form:errors path="townName" />
		</p>
		<input type="submit" name="save" value="save">
		
	</form:form>
<table>
			<tr>
				<th>Town Id</th>
				<th>Town Name</th>
				<th>Country(Id)</th>
				<th>State(Id)</th>
				<th>City(Id)</th>
				<th>Action</th>
			</tr>
			<c:forEach var="town" items="${towns}">
				<tr>
					<td style="text-align: center;">${town.townId}</td>
					<td>${town.townName}</td>
					<td>${town.city.state.country.countryName}&nbsp|&nbsp(${town.city.state.country.countryId})</td>
					<td>${town.city.state.stateName}&nbsp|&nbsp(${town.city.state.stateId})</td>
                    <td>${town.city.cityName}&nbsp|&nbsp(${town.city.cityId})</td>
                  <td><a
						href="${pageContext.request.contextPath}/towns/edit/${town.townId}/${town.city.state.country.countryId}/${town.city.state.stateId}">edit</a>&nbsp|&nbsp<a
						href="${pageContext.request.contextPath}/towns/delete/${town.townId}"
						onclick="confirm('Do you want to Remove Town ${town.townName}')">remove</a></td> 
				</tr>
				
			</c:forEach>
		</table>


</center>



</body>
</html>