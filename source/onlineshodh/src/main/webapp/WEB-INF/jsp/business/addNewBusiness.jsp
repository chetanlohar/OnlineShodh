<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- JQUERY SCRIPTS -->
<script
	src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function getClientDetails() {
		$.ajax({
			type : "POST",
			url : "/onlineshodh/admin/search/business/client",
			dataType : 'json',
			data : {
				"searchBy" : $('#searchBy').val(),
				"keyword" : $('#keyword').val()
			},
			success : function(response) {
				console.log(response)
			},
			error : function(e) {
				console.log(e)
			}
		});
	}
</script>
</head>
<body>
	<form method="post" action="#">
		<p>
			<label>Search By</label> <select id="searchBy" name="searchBy">
				<option value="1">By Id</option>
				<option value="2">By Name</option>
				<option value="3">By Username</option>
			</select>
		</p>
		<p>
			<input id="keyword" type="text" name="keyword">
		</p>
		<p>
			<input type="button" value="Search" onclick="getClientDetails();">
		</p>
	</form>
</body>
</html>