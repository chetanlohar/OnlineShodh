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
		modelAttribute="clientdetails" enctype="multipart/form-data">
		
		<p>
			<label>Email</label>
			<form:input path="user.userName" title="Email Id" maxlength="25" size="51" />
			<form:errors path="user.userName" cssClass="errors" />
		</p>
		<p>
			<label>Password</label>
			<form:password path="user.password" title="Password" maxlength="25" size="25" />
			<form:errors path="user.password" cssClass="errors" />
		</p>
		<p>
			<label>Name</label>
			<form:input path="userDetails.name" title="Name" maxlength="25" size="51" />
			<form:errors path="userDetails.name" cssClass="errors" />
		</p>
		<p>
			<label>Primary Contact</label>
			<form:input path="userDetails.phone1" title="Primary Contact" maxlength="25" size="51" />
			<form:errors path="userDetails.phone1" cssClass="errors" />
		</p>
		<p>
			<label>Secondary Contact</label>
			<form:input path="userDetails.phone2" title="Secondary Contact" maxlength="25" size="51" />
		</p>
		<p>
			<label>Photograph</label>
			<input type="file" id="file" name="file" value="Browse">
			<form:errors path="userDetails.photograph" cssClass="errors" />
		</p>
		<p>
			<input type="submit" id="saveClient" name="saveClient" value="Save" />
			<input type="reset" value="Reset"/>
		</p>
		
		<table>
			<tr>
				<th>ClientId</th>
				<th>Name</th>
				<th>Email</th>
				<th>Primary Phone</th>
				<th>Secondary Phone</th>
				<th>Registration Date</th>
				<th>Photograph</th>
				<th>Action</th>
			</tr>
			<c:forEach var="userdetail" items="${userDetails}">
				<tr>
					<td style="text-align: center;">${userdetail.userDetailsId}</td>
					<td>${userdetail.name}</td>
					<td>${userdetail.email}</td>
					<td>${userdetail.phone1}</td>
					<td>${userdetail.phone2}</td>
					<td>${userdetail.regDate}</td>
					<td><img src="${pageContext.request.contextPath}/admin/clients/load/logo/${userdetail.userDetailsId}" height="50" width="50" alt="*No Image"/></td>
					<td><a href="${pageContext.request.contextPath}/admin/clients/edit/${userdetail.userDetailsId}">edit</a>&nbsp|&nbsp<a href="${pageContext.request.contextPath}/admin/clients/delete/${userdetail.userDetailsId}" onclick="return confirm('Do you want to Remove : ${userdetail.name}')">remove</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</form:form>
</body>
</html>