<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"> --%>
<style type="text/css">
body {
	font-family: sans-serif;
	background-color: #e3e3e3;
}

#wrap {
	margin-left: 35%;
	width: 400px;
}

#wrap input[type="text"], [type="password"] {
	width: 200px;
}

.error {
	font-size: 14px;
	font-style: italic;
	color: red;
}

.msg {
	font-size: 14px;
	font-style: italic;
	color: blue;
}
</style>
</head>
<body>
	<div id="wrap">
		<h1>Login Screen</h1>
		<form action="<c:url value="${pageContext.request.contextPath}/j_spring_security_check" />" method="post">
			<!-- <div class="error">**Invalid Credentials</div>
			<div class="msg">**Please check the login details</div> -->
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
			<p>
				<label for="username">User Name:</label>
			</p>
			<input type="text" id="username" name="username">
			<p>
				<label for="password">Password:</label>
			</p>
			<input id="password" type="password" name="password">
			<p>
				<input id="rememberme" type="checkbox"> <label
					for="rememberme">Remember Me</label>
			</p>
			<p>
				<input type="submit" value="Login"> <input type="reset"
					value="reset">
			</p>
		</form>
	</div>
</body>
</html>