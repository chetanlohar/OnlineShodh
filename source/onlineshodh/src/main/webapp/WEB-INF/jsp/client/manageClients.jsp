<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/commonjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Management</title>
</head>
<body>
	<center>
		<h3>Client Management</h3>
	</center>

	<form:form
		action="${pageContext.request.contextPath}/admin/clients/save"
		modelAttribute="clientdetails">
		<p>
			<label>Email</label>
			<form:input path="user.userName" title="Email Id" maxlength="25" size="51" />
			<form:errors path="user.userName" cssClass="errors" />
		</p>
		<p>
			<label>Password</label>
			<form:password path="user.password" title="Password" maxlength="25"
				size="51" />
			<form:errors path="user.password" cssClass="errors" />
		</p>
		<p>
			<label>CountryId</label>
			<form:input path="country.countryId" title="Country Id" maxlength="25" size="51" />
			<form:errors path="country.countryId" cssClass="errors" />
		</p>
		<p>
			<label>Country Name</label>
			<form:input path="country.countryName" title="Country Name" maxlength="25"
				size="51" />
			<form:errors path="country.countryName" cssClass="errors" />
		</p>
		<p>
			<input type="submit" id="saveClient" name="saveClient" value="Save" />
			<input type="reset" value="Reset" />
		</p>
	</form:form>
</body>
</html>