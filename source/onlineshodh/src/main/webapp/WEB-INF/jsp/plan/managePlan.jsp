<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plan Management</title>
</head>
<body>
	<center>
		<form:form
			action="${pageContext.request.contextPath}/admin/plans/save"
			method="POST" modelAttribute="plan">
			<p>
				<label for="planName">Plan Name :</label>
				<form:input path="planName" />
				<form:errors path="planName" />
			</p>
			<p>
				<label for="planDescription">Plan Description :</label>
				<form:input path="planDescription" />
				<form:errors path="planDescription" />
			</p>
			<p>
				<label for="businessName">View BusinessName :</label>
				<form:radiobutton path="businessName" label="Yes" value="true" />
				<form:radiobutton path="businessName" label="No" value="false" />
				<form:errors path="businessName" />
			</p>
			<p>
				<label for="businessAddress">Business Address :</label>
				<form:radiobutton path="businessAddress" label="Yes" value="true" />
				<form:radiobutton path="businessAddress" label="No" value="false" />
				<form:errors path="businessAddress" />
			</p>

			<p>
				<label for="personName">PersonName :</label>
				<form:radiobutton path="personName" label="Yes" value="true" />
				<form:radiobutton path="personName" label="No" value="false" />
				<form:errors path="personName" />
			</p>
			<p>
				<label for="noOfImages">No of Images:</label>
				<form:input path="noOfImages" />
				<form:errors path="noOfImages" />
			</p>
			<p>
				<label for="businessDescription">Business Description :</label>
				<form:radiobutton path="businessDescription" label="Yes"
					value="true" />
				<form:radiobutton path="businessDescription" label="No"
					value="false" />
				<form:errors path="businessDescription" />
			</p>
			<p>
				<label for="email">Email :</label>
				<form:radiobutton path="email" label="Yes" value="true" />
				<form:radiobutton path="email" label="No" value="false" />
				<form:errors path="email" />
			</p>
			<p>
				<label for="noOfContacts">No of Contacts:</label>
				<form:input path="noOfContacts" />
				<form:errors path="noOfContacts" />
			</p>
			<p>
				<label for="enquiryForm">Enquiry Form :</label>
				<form:radiobutton path="enquiryForm" label="Yes" value="true" />
				<form:radiobutton path="enquiryForm" label="No" value="false" />
				<form:errors path="enquiryForm" />
			</p>
			<p>
				<label for="generalInfo">Features/General Info :</label>
				<form:radiobutton path="generalInfo" label="Yes" value="true" />
				<form:radiobutton path="generalInfo" label="No" value="false" />
				<form:errors path="generalInfo" />
			</p>
			<p>
				<label for="website">Website :</label>
				<form:radiobutton path="website" label="Yes" value="true" />
				<form:radiobutton path="website" label="No" value="false" />
				<form:errors path="website" />
			</p>
			<p>
				<label for="priority">Priority:</label>
				<form:input path="priority" />
				<form:errors path="priority" />
			</p>
			<p>
				<label for="validityInMonths">Validity In Months:</label>
				<form:input path="validityInMonths" />
				<form:errors path="validityInMonths" />
			</p>
			<p>
				<label for="amount">Amount:</label>
				<form:input path="amount" />
				<form:errors path="amount" />
			</p>
			<p>
				<label for="map">Map :</label>
				<form:radiobutton path="map" label="Yes" value="true" />
				<form:radiobutton path="map" label="No" value="false" />
				<form:errors path="map" />
			</p>
			<input type="submit" value="Add" name="addPlan">
			<input type="reset" value="Reset">
		</form:form>
	</center>

	<table border="1">
		<tr>
			<th>Plan Id</th>
			<th>Plan Name</th>
			<th>Plan Description</th>
			<th>Business Name</th>
			<th>Business Address</th>
			<th>Person Name</th>
			<th>No Of Images</th>
			<th>Business Description</th>
			<th>Email</th>
			<th>No Of Contacts</th>
			<th>Enquiry Form</th>
			<th>Features/General Info</th>
			<th>Website</th>
			<th>Priority</th>
			<th>Validity In Months</th>
			<th>Amount</th>
			<th>Map</th>
			<th>Action</th>
		</tr>

		<br />
		<c:forEach var="plan" items="${plans}">
			<tr>
				<td style="text-align: center;">${plan.planId}</td>
				<td style="text-align: center;">${plan.planName}</td>
				<td style="text-align: center;">${plan.planDescription}</td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.businessName=='true'}">
				 Y 
				</c:when>
						<c:otherwise>
				 N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.businessAddress=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.personName=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;">${plan.noOfImages}</td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.businessDescription=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.email=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;">${plan.noOfContacts}</td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.enquiryForm=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.generalInfo=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.website=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td style="text-align: center;">${plan.priority}</td>
				<td style="text-align: center;">${plan.validityInMonths}</td>
				<td style="text-align: center;">${plan.amount}</td>
				<td style="text-align: center;"><c:choose>
						<c:when test="${plan.map=='true'}">
				Y
				</c:when>
						<c:otherwise>
				N
				</c:otherwise>
					</c:choose></td>
				<td><a
					href="${pageContext.request.contextPath}/admin/plans/edit/${plan.planId}">edit</a>&nbsp|&nbsp<a
					href="${pageContext.request.contextPath}/admin/plans/delete/${plan.planId}"
					onclick="return confirm('Do you want to Remove Plan ${plan.planName}')">remove</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>