<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Business</title>
</head>
<body>
<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-state">
										<thead>
											<tr>
												<th>Id</th>
												<th>Business Name</th>
												<th>Business Website</th>

											</tr>
										</thead>
										<tbody>

											<c:forEach var="business" items="${business}">
												<tr class="odd gradeX">
													<td></td>
													<td></td>
													<td></td>
												</tr>

											</c:forEach>
										</tbody>
									</table>
								</div>

</body>
</html>