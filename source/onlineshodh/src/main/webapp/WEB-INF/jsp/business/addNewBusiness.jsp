<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

<!-- JQUERY SCRIPTS -->
<script
	src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script> 
	<script async src="//code.jquery.com/ui/1.10.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#searchButton')
				.click(
						function() {
							$
									.ajax({
										type : "POST",
										url : "/onlineshodh/admin/clients/getClient",
										dataType : 'json',
										data : {
											"searchBy" : $('#searchBy').val(),
											"keyword" : $('#keyword').val()
										},
										success : function(response) {

											console.log(response)

											$('#dataTables-example')
													.find('.ab').remove(); 
											 jQuery
													.each(
															response,
															function(index,
																	item) {
																	var newRow = jQuery('<tr class="ab"><td>'
																			+ item.userDetailsId
																			+ '</td><td>'
																			+ item.regDate
																			+ '</td><td>'
																			+ item.name
																			+ '</td><td>'
																			+ item.email
																			+ '</td><td>'
																			+ item.phone1
																			+ '</td><td>'
																			+ item.phone2
																			+ '</td><td>'
																			+ item.userId
																			+ '</td><td><img src=${pageContext.request.contextPath}/admin/clients/load/logo/'+item.userDetailsId+'/>'

																			+ '</td><td>'
																			+ '<a href=${pageContext.request.contextPath}/admin/business/'+item.userDetailsId+'>'
																			+ 'Select'
																			+ '</a></td></tr>');
																	jQuery(
																			'#dataTables-example')
																			.append(
																					newRow);
																	
                                                               
															});

										},
										error : function(e) {
											console.log(e)
											alert("Please Enter Valid keywords")
											/* jQuery('#error')
											.append(e); */
										}
									})

						});
	});
</script>

<script type="text/javascript">
$(document).ready(function(){
$("#searchBy").click(function(e){
	 
	 $( "#keyword" ).autocomplete({

		source: '${pageContext.request.contextPath}/admin/clients/searchClient?searchBy='+$("#searchBy").val(),
});
	 
}); 
});
</script>

</head>
<body>
	<form method="post" action="#">
		<p>
			<label>Search By</label> <select id="searchBy" name="searchBy">
				<option value="1">By Id</option>
				<option value="2">By Name</option>
				<option value="3">By Username</option>
				<option value="4">By BusinessName</option>
			</select>
		</p>
		<p>
			<input id="keyword" type="text">
		</p>
		<p>
			<input type="button" value="Search" id="searchButton">
			
		</p>
	</form>
	
	
	
	
	
	
<table class="table table-striped table-bordered table-hover"
		id="dataTables-example">
		<thead>
			<tr>
				<th>Client ID</th>
				<th>Registration Date</th>
				<th>Name</th>
				<th>Email Id</th>
				<th>Primary Contact</th>
				<th>Secondary Contact</th>
				<th>Address</th>
				<th>Photo</th>
				<th>Select</th>

			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>	
	
</body>
</html>