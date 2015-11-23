<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<input id="lat" type="text">
	<input id="longitude" type="text">
	<input type="button" value="Convert" onclick="getAddress();">


</body>
<script src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
<script>
	function getAddress()
	{
		var lat= $("#lat").val();
		var longitude = $("#longitude").val();
		
		console.log("lat: "+lat+":"+longitude);
		
		$.ajax({
			type : "GET",
			url : "http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+longitude+"&sensor=true",
			dataType : 'json',
			success : function(response) {
				console.log(response);
			},
			error : function(e) {
				
				console.log(e)
			}
		});
		
		
	}

</script>

</html>