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
												<th>Business Logo</th>
												<th>Business Website</th>

											</tr>
										</thead>
										<tbody>

											<c:forEach var="business" items="${businessList}">
												<tr class="odd gradeX">
													<td>${business.businessId}</td>
													<td>${business.businessName}</td>
													<td class="text-center"><img
														src="${pageContext.request.contextPath}/admin/business/load/logo/${business.businessId}"
														height="50" width="50" alt="*No Image" /></td>
													<td>${business.website}</td>
												</tr>

											</c:forEach>
										</tbody>
									</table>
								</div>
								
								
								<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="dataTable_wrapper table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-client">
										<thead>
											<tr>
												<th>Client ID</th>
												<th>Client Name</th>
												<th>Email</th>
												<th>Contact</th>
												<th>Address</th>
												<th>Reg. Date</th>
												<th>Photograph</th>
												<th>Edit</th>
												<th>Delete</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="userdetail" items="${userDetails}">
												<tr class="odd gradeX">
													<td style="text-align: center;">${userdetail.userDetailsId}</td>
													<td>${userdetail.name}</td>
													<td>${userdetail.email}</td>
													<td>${userdetail.phone1}<br>${userdetail.phone2}</td>
													<td>${userdetail.address.address} ${userdetail.address.street}
														${userdetail.address.landMark} ${userdetail.address.city.cityName} ${userdetail.address.town.townName} ${userdetail.address.townOther} ${userdetail.address.pincode}
													</td>
													<td>${userdetail.regDate}</td>
													<td class="text-center"><img
														src="${pageContext.request.contextPath}/admin/clients/load/logo/${userdetail.userDetailsId}"
														height="50" width="50" alt="*No Image" /></td>
													<td><a
														href="${pageContext.request.contextPath}/admin/clients/edit/${userdetail.userDetailsId}"
														class="edit"><button class="btn btn-info btn-xs">
																<i class="fa fa-pencil"></i> Edit
															</button></a></td>
													<td class="center"><a
														href="${pageContext.request.contextPath}/admin/clients/delete/${userdetail.userDetailsId}"
														onclick="return confirm('Do you want to Remove : ${userdetail.name}">Delete</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>
								<!-- /.table-responsive -->

							</div>
							<!-- /.panel-body -->
								
								
								

</body>
</html>