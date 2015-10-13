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
		action="${pageContext.request.contextPath}/admin/clients/update"
		modelAttribute="userDetails" enctype="multipart/form-data">
		<form:hidden path="userDetailsId"/>
		<form:hidden path="userId"/>
		<form:hidden path="regDate"/>
		<form:hidden path="email"/>
		<form:hidden path="photograph"/>
		<p>
			<label>Name</label>
			<form:input path="name" title="Name" maxlength="25" size="51" />
			<form:errors path="name" cssClass="errors" />
		</p>
		<p>
			<label>Primary Contact</label>
			<form:input path="phone1" title="Primary Contact" maxlength="25" size="51" />
			<form:errors path="phone1" cssClass="errors" />
		</p>
		<p>
			<label>Secondary Contact</label>
			<form:input path="phone2" title="Secondary Contact" maxlength="25" size="51" />
		</p>
		<p>
			<label>Photograph</label>
			<input type="file" id="file" name="file" value="Browse">
			<img src="${pageContext.request.contextPath}/admin/clients/load/logo/${userDetails.userDetailsId}" id="userDetailsLogo" height="50" width="50"/>
			<form:errors path="photograph" cssClass="errors" />
		</p>
		<p>
			<input type="submit" id="saveClient" name="saveClient" value="Save" />
			<input type="reset" value="Reset"/>
		</p>
		
	</form:form>
</body>
</html>