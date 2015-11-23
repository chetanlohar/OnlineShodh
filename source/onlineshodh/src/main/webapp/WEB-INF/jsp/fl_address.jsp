<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
 <script src="${pageContext.request.contextPath}/resources/js/assets/jquery-1.11.1.js"></script> 
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/assets/bootstrap.js"></script>
        
          
                 <script
		src="${pageContext.request.contextPath}/resources/js/validation/jquery.validate.min.js"></script> 
		 
			  <script
		src="${pageContext.request.contextPath}/resources/js/validation/additional-methods.min.js"></script> 
		
	  <script
		src="${pageContext.request.contextPath}/resources/js/validation/formvalidation.js"></script> 
        
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/freeListingBusinessAddres.js"></script>
</head>
<body>
<form:form modelAttribute="FreeListing_Address" action="${pageContext.request.contextPath}/freelisting/address/save" method="POST">
 <form:hidden path="businessEntity.freelistingbusinessdetailsId"/>

 
                                   <P>  
									<label for="address" class="col-sm-5 control-label">Address</label>
									
										<form:textarea path="fl_Address" class="form-control"
											rows="3" id="clientadd" name="address" />
										<form:errors path="fl_Address" cssClass="errors" />
									</P>
                                      <P>    
									<label for="address" class="col-sm-5 control-label">Street</label>
									
										<form:textarea path="fl_Street" class="form-control"
											rows="2" id="clientStreet" name="Street" />
										<form:errors path="fl_Street" cssClass="errors" />
					
								</P>
								 <P>
									<label for="address" class="col-sm-5 control-label">LandMark</label>
									
										<form:textarea path="fl_LandMark" class="form-control"
											rows="2" id="clientLandM" name="LandMark" />


                                    </P>
                                     <P>
									<label for="city" class="col-sm-5 control-label">City</label>
									
										<form:select path="city.cityId" class="form-control"
											name="clientcity" id="cityId" onchange="getTown();">
											<form:option value="">--Select--</form:option>
											<c:forEach var="city" items="${cities}">
												<form:option value="${city.cityId}">${city.cityName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="city.cityId" cssClass="errors" />

						               </P>
						                <P>
									<label for="town" class="col-sm-5 control-label">Town</label>
										<form:select path="town.townId" class="form-control"
											id="town" name="clinettown">
											<form:option value="0">--Select--</form:option> 
											<c:forEach var="town" items="${towns}">
												<form:option value="${town.townId}">${town.townName}</form:option>
											</c:forEach>
										</form:select>
										<form:errors path="town.townId" cssClass="errors" />

                                     </P>
								 <P>
									<label for="pincode" class="col-sm-5 control-label">Pincode</label>
									
										<form:input path="pincode" class="form-control"
											id="clientpin" name="clietpin" />
										<form:errors path="pincode" cssClass="errors" />
                                       </P>
                                    <a href="${pageContext.request.contextPath}/freelisting/"
									id="goBack" class="back">GoBack</a>                                   
                                    <input type="submit" value="save & continue">
                                       
							
</form:form>
</body>
</html>