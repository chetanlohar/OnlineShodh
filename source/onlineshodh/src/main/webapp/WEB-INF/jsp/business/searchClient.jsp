<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<form class="form-horizontal" name="clientsearch" id="clientsearch" >
							<div class="col-lg-10">
								<div class="col-lg-6 space">
									<label for="mailid" class="col-sm-5 control-label">Search
										By:</label>
									<div class="input-group">
										<select class="form-control" name="sortclient">
											<option value="ID">ID</option>
											<option value="Name">Name</option>
											<option value="UserName">UserName</option>
										</select>
									</div>
								</div>
								<div class="col-lg-6 space">
									<div class="input-group">
										<span class="input-group-addon"><span
											class="fa fa-user"></span></span> <input type="text"
											class="form-control" id="clientsearchbox"
											name="clientsearchbox">
									</div>
								</div>
								<div class="col-lg-6 col-lg-offset-6 space">
									<button type="submit" class="btn btn-info" id="display">
										<i class="fa fa-search"></i> Search
									</button>

								</div>
						</form>


</body>
</html>