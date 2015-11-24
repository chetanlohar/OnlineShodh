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
var flag=false;
var flag1=false;

	function addPhone() {
		var phoneurl;
		if(flag==true){
			
			phoneurl=$('#phoneurl1').val();
		}
		else{
			phoneurl=$("#phoneurl").val();
		}
			$.ajax({
			type : "POST",
			url : phoneurl,
			datatype : "json",
			data : {
				"phonetype" : $('#phonetype').val(),
				"contact" : $('#contact').val(),
			},
			success : function(response) {
				/* alert(response) */
				console.log(response)
				 $('#phoneTable').find('#tbody').remove();
                jQuery.each(response,function(index,item){
               	
                var newRow=jQuery('<tr><td>'+item.freeBuinessPhoneId+'</td><td>'+item.phone+'</td><td>'+item.phonetype+'</td><td><button class="upcontact">Edit</button></td><td><a href="${pageContext.request.contextPath}/freelisting/'+item.freeListingBusinessEntity.freelistingbusinessdetailsId+'/'+item.freeBuinessPhoneId+'/deletePhone">Delete</a></td><td>Verify</td></tr>')
               
                jQuery('#phoneTable').append(newRow);
                });

			},
			error : function(error) {
				console.log(error)
			}

		});

	}

	function addFeature() {

		var url;
		if(flag1==true){
			/* alert($('#featureurl1').val())    */
			url=$('#featureurl1').val();
		}
		else{
			url=$('#featureurl').val();
		}
       
		
		$.ajax({
			type : "POST",
			url : url,
			datatype : "json",
			data : {
				"feature" : $('#feature').val()
			},
			success : function(response) {

				
				console.log(response)
								 $('#featureTable').find('#tbody').remove();

jQuery.each(response,function(index,item){
                	
	var newRow=jQuery('<tr><td>'+item.freelistingBusinessFeatureId+'</td><td>'+item.freelistingBusinessFeature+'</td><td><button class="EditFeature">Edit</button></td><td><a href="${pageContext.request.contextPath}/freelisting/'+item.business.freelistingbusinessdetailsId+'/'+item.freelistingBusinessFeatureId+'/deleteFeature">Delete</a></td></tr>')
    jQuery('#featureTable').append(newRow);
    });
			},
			error : function(error) {
				console.log(error)
			}

		});
	}
	
	 $(document).ready(function(){
		
		
		$(".upcontact").on('click',function(e){
			
			flag=true;
			
		var valp=$(this).parent().siblings(":nth-child(2)").text() 	
		var valpid =$(this).parent().siblings(":nth-child(1)").text()
	     $("#contact").val(valp);
         var url1=$("#phoneurl1").val();
         $("#phoneurl1").val(url1+valpid);
		
		
		
	    $("#phonebutton").html('Update');
		
		});	 
	 });	 
	
</script>
<script type="text/javascript">

$(document).ready(function(){

	$(".EditFeature").on('click',function(e){

		var valfeature=$(this).parent().siblings(":nth-child(2)").text()
		var valfeatureid=$(this).parent().siblings(":nth-child(1)").text()
		var url2=$("#featureurl1").val();
		 $("#feature").val(valfeature); 
		/* $("#feature").val(valfeatureid) */
		$("#featureurl1").val(url2+valfeatureid)
		flag1=true;
	});
});
	

</script>

<body>
	<center>
		<p>
			<label>Phone Type :</label> <select id="phonetype">
				<option value="Landline">Landline</option>
				<option value="Mobile">Mobile</option>
			</select> <label>Contact:</label> <input type="text" id="contact">
			<c:out value="${freeListingBusiness.freelistingbusinessdetailsId}" />
			<input type="button" value="Add" id="phonebutton" onclick="addPhone()"> <input
				type="hidden" id="phoneurl"
				value="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/savephone" />
			<input type="hidden" id="phoneurl1" value="${pageContext.request.contextPath}/freelisting/updatephone/${freeListingBusiness.freelistingbusinessdetailsId}/"/>	
				
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
		<td><button class="upcontact">Edit</button></td>
		
		<td><a href="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/${phones.freeBuinessPhoneId}/deletePhone">Delete</a></td>
		<td><a href="#">Verify</a></td>
		</tr>
		</c:forEach> 
		
		</tbody>
		</table>
		<p>
			<label>Feature :</label> <input type="text" id="feature"> <input
				type="button" value="Add" onclick="addFeature()"> <input
				type="hidden" id="featureurl"
				value="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/savefeature" />
	<input type="hidden" id="featureurl1" value="${pageContext.request.contextPath}/freelisting/updateFeature/${freeListingBusiness.freelistingbusinessdetailsId}/"/>	
		
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
		<td><button class="EditFeature">Edit</button></td>
		<td><a href="${pageContext.request.contextPath}/freelisting/${freeListingBusiness.freelistingbusinessdetailsId}/${features.freelistingBusinessFeatureId}/deleteFeature">Delete</a></td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		<p>
	</center>
</body>
</html>