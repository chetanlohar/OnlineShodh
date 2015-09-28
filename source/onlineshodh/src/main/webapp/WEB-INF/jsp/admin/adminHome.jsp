<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/categories">Category Management</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/subcategories">Sub-Category Management</a></li>
		<li><a href="${pageContext.request.contextPath}/countries">Country Management</a></li>
		<li><a href="${pageContext.request.contextPath}/states">State Management</a></li>
		<li><a href="#">City Management</a></li>
		<li><a href="#">Town Management</a></li>
	</ul>
</body>
</html>