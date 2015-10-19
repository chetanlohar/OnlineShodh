<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/ManageTown.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/commonjs.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
	$(function() {
		$("#datepicker2").datepicker();
	});
	$(function() {
		$("#datepicker3").datepicker();
	});
</script>

<title>Banner Management</title>
</head>
<body>
	<center>
		<form:form
			action="${pageContext.request.contextPath}/admin/banners/save"
			modelAttribute="banner" method="POST" enctype="multipart/form-data">
			<p>
				<label>Category Name:</label>
			</p>
			<p>
				<form:select path="category.categoryId" id="categoryId">
					<form:option value="0" label="---Select-------" />
					<c:forEach var="category" items="${categories}">
						<form:option value="${category.categoryId}">${category.categoryName}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="category.categoryId" />
			</p>


			<p>
				<label>Country Name:</label>
			</p>
			<p>
				<form:select path="city.state.country.countryId" id="countryId"
					onchange="getState()">
					<form:option value="0" label="---Select-------" />
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
				<form:select path="city.state.stateId" id="townStates"
					onchange="getCity()">
					<form:option value="0" label="---Select-------" />
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
					<form:option value="0" label="---Select-------" />
					<c:forEach var="city" items="${cities}">
						<form:option value="${city.cityId}">${city.cityName}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="city.cityId" />
			</p>

			<p>
				<label>Banner : </label> <input type="file" id="file" name="file"
					value="Browse" onchange="changeImage(this);"> <img
					id="categorylogo" height="50" width="50" />
					
			</p>

			<p>
				<label>UrlLink :</label>
				<form:input path="urlLink" size="35px" maxlength="25px" />
				<form:errors path="urlLink" cssClass="errors" />
			</p>
			<p>
				<label for="startDate">Start Date :</label>
				<form:input path="startDate" size="35px" maxlength="25px"
					id="datepicker" />
				<form:errors path="startDate" cssClass="errors" />
			</p>
			<p>
				<label for="expiryDate">Expiry Date:</label>
				<form:input path="expiryDate" size="35px" maxlength="25px"
					id="datepicker2" />
				<form:errors path="expiryDate" cssClass="errors" />
			</p>
			<p>
				<label for="regDate">Registration Date :</label>
				<form:input path="regDate" size="35px" maxlength="25px"
					id="datepicker3" />
				<form:errors path="regDate" cssClass="errors" />
			</p>

			<p>
				<input type="submit" name="save" value="Save" /> <input
					type="reset" value="Reset" />
			</p>
		</form:form>
		<table>
			<tr>
				<th>BannerId</th>
				<th>CategoryId</th>
				<th>CityId</th>
				<th>BannerPicture</th>
				<th>RegisterDate</th>
				<th>StartDate</th>
				<th>ExpiryDate</th>
				<th>URLLink</th>
				<th>TotalHits</th>
				<th>Status</th>

			</tr>
			<c:forEach var="banner" items="${banners}">
				<tr>
					<td style="text-align: center;">${banner.bannerId}</td>
					<td style="text-align: center;">${banner.category.categoryId}</td>
					<td style="text-align: center;">${banner.city.cityId}</td>
					<td><img
						src="${pageContext.request.contextPath}/admin/banners/load/logo/${banner.bannerId}"
						height="50" width="50" alt="*No Image" /></td>
					<td>${banner.regDate}</td>
					<td>${banner.startDate}</td>
					<td>${banner.expiryDate}</td>
					<td style="text-align: center;">${banner.urlLink}</td>
					<td style="text-align: center;">${banner.totalHit}</td>
					<td style="text-align: center;">${banner.status}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/banners/edit/${banner.bannerId}">edit</a>&nbsp|&nbsp<a
						href="${pageContext.request.contextPath}/admin/banners/delete/${banner.bannerId}"
						onclick="return confirm('Do you want to Remove Banner: ${banner.bannerId}')">remove</a></td>
				</tr>
			</c:forEach>
		</table>

	</center>

</body>
</html>