<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Phone Details</title>
</head>
<script
	src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>

<script type="text/javascript">
	function addPhone() {
		$.ajax({
			type : "POST",
			url : $("#phoneurl").val(),
			datatype : "json",
			data : {
				"phonetype" : $('#phonetype').val(),
				"contact" : $('#contact').val(),
			},
			success : function(response) {
				 $('#phoneTable').find('#tbody').remove();
                jQuery.each(response,function(index,item){
               	
                var newRow=jQuery('<tr><td>'+item.freeBuinessPhoneId+'</td><td>'+item.phone+'</td><td>'+item.phonetype+'</td><td>Edit</td><td>Delete</td><td>Verify</td></tr>')
               
                jQuery('#phoneTable').append(newRow);
                });
            	
                

			},
			error : function(error) {
				console.log(error)
			}

		});

	}

	function addFeature() {

		$.ajax({
			type : "POST",
			url : $('#featureurl').val(),
			datatype : "json",
			data : {
				"feature" : $('#feature').val()
			},
			success : function(response) {

				
				console.log(response)
								 $('#featureTable').find('#tbody').remove();

jQuery.each(response,function(index,item){
                	
	var newRow=jQuery('<tr><td>'+item.freelistingBusinessFeatureId+'</td><td>'+item.freelistingBusinessFeature+'</td><td>Edit</td><td>Delete</td></tr>')
    jQuery('#featureTable').append(newRow);
    });
			},
			error : function(error) {
				console.log(error)
			}

		});
	}
</script>
<body>
	<center>
		<p>
			<label>Phone Type :</label> <select id="phonetype">
				<option value="Landline">Landline</option>
				<option value="Mobile">Mobile</option>
			</select> <label>Contact:</label> <input type="text" id="contact">
			<c:out value="${freeListingBusiness.freelistingbusinessdetailsId}" />
			<input type="button" value="Add" onclick="addPhone()"> <input
				type="hidden" id="phoneurl"
				value="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/savephone" />
		</p>
		<p>
		<table id="phoneTable" border="1">
		<tr>
		<th>Id</th>
		<th>Phone</th>
		<th>PhoneType</th>
		<th>Edit</th>
		<th>Delete</th>
		<th>Verify</th>
		</tr>
        <tbody id="tbody">      	
		 <c:forEach var="phones" items="${flphones}">
		<tr>
		<td>${phones.freeBuinessPhoneId}</td>
		<td>${phones.phone}</td>
		<td>${phones.phonetype}</td>
		<td>Edit</td>
		<td>Delete</td>
		<td>Verify</td>
		</tr>
		</c:forEach> 
		
		</tbody>
		</table>
		<p>
			<label>Feature :</label> <input type="text" id="feature"> <input
				type="button" value="Add" onclick="addFeature()"> <input
				type="hidden" id="featureurl"
				value="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/savefeature" />
		</p>
		<p>
		<table id="featureTable" border="1">
		<tr>
		<th>Id</th>
		<th>Feature</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>
		<tbody id="tbody"> 
				<c:forEach var="features" items="${flfeatures}">
		<tr>
		<td>${features.freelistingBusinessFeatureId}</td>
		<td>${features.freelistingBusinessFeature}</td>
		<td>Edit</td>
		<td>Delete</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		<p>
	</center>
</body>
</html>