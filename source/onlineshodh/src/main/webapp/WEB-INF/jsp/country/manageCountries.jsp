<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Country</title>

<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.css"
	rel="stylesheet" />
	
	<!-- DATA TABLE STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/jquery.dataTables.min.css"
	rel="stylesheet" />
	
<!-- metis STYLES-->
<link
	href="<%=request.getContextPath()%>/resources/css/metisMenu.min.css"
	rel="stylesheet" />
<!--CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/resources/css/os-admin.css"
	rel="stylesheet" />

</head>
</head>
<body>
	
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Country Management</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-9">
				<form:form action="${pageContext.request.contextPath}/countries/save" method="post" modelAttribute="country" class="form-horizontal" id="countrymanage">
				<label for="countryName" class="col-md-3">Country Name:</label>
					<div class="form-group input-group col-md-9">
					
						<form:input path="countryName" title="Country Name" name="countryc"  maxlength="25" size="50" class="form-control "/> 
					    <form:errors path="countryName" cssClass="errors" />  
					</div>
					<div class="col-md-5 col-md-offset-6">
					<button type="submit" class="btn btn-success" id="saveCountry" name="saveCountry">ADD</button>
					</div>
					</form:form>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			
            <div class="row">
                <div class="col-lg-12 space">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Country Management Table
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Country Id</th>
                                            <th>Country Name</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach var="country" items="${countries}">
                                        <tr class="odd gradeX">
                                            <td>${country.countryId}</td>
                                            <td>${country.countryName}</td>
                                            <td><a href="${pageContext.request.contextPath}/countries/edit/${country.countryId}" class="edit" id="edits"><button class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>  Edit</button></a></td>
                                            <td class="center"><a href="${pageContext.request.contextPath}/countries/delete/${country.countryId}" onclick="return confirm('Do you want to Remove Country: ${country.countryName}')"> <button class="btn btn-danger btn-xs"><i class="fa fa-trash"></i>  Delete</button></a></td>
                                       </c:forEach>     
                                        </tr>
                                       </tbody>
                                   
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

                    <!-- /. PAGE INNER  -->
                     <footer >
            &copy; 2015 OnlineShodh | By : <a href="www.softinfology.com" target="_blank">Softinfology</a>
        </footer>
              

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/jquery-1.11.1.js"></script>
	
	<script
		src="<%=request.getContextPath()%>/resources/js/validation/jquery.validate.min.js"></script>
		<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/bootstrap.js"></script>
		
				<!-- validation SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/validation/formvalidation.js"></script>
		
		
		
	<!-- METIMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/assets/metisMenu.min.js"></script>
		
		<!-- DATATABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script>

	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/resources/js/os-admin.js"></script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
</body>
</html>