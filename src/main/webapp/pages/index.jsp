<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
		<div class="container pt-3 mb-3">
		  <h2 class="text-center text-dark bg-light py-2 mb-4 border rounded" style="font-size: 1.5rem;">REPORT INSURANCE APPLICATION</h2>
		
		  <form:form action="" modelAttribute="search" method="POST" class="pt-3">
		    
		    <div class="form-row mb-3">
		      <!-- Plan Name -->
		      <div class="col-md-4">
		        <label>Plan Name:</label>
		        <form:select path="planName" class="form-control">
		          <form:option value="">-SELECT-</form:option>
		          <form:options items="${names}"/>
		        </form:select>
		      </div>
		
		      <!-- Plan Status -->
		      <div class="col-md-4">
		        <label>Plan Status:</label>
		        <form:select path="planStatus" class="form-control">
		          <form:option value="">-SELECT-</form:option>
		          <form:options items="${Statuses}"/>
		        </form:select>
		      </div>
		
		      <!-- Gender -->
		      <div class="col-md-4">
		        <label class="form-label fw-bold">Gender:</label>
		        <form:select path="gender" class="form-control ">
		          <form:option value="">-SELECT-</form:option>
		          <form:option value="Male">Male</form:option>
		          <form:option value="Female">Female</form:option>
		        </form:select>
		      </div>
		    </div>
		
		    <div class="form-row mb-3">
		      <!-- Start Date -->
		      <div class="col-md-6">
		        <label>Start Date:</label>
		        <form:input path="startDate" type="date" class="form-control"/>
		      </div>
		
		      <!-- End Date -->
		      <div class="col-md-6">
		        <label  class="form-label fw-bold">End Date:</label>
		        <form:input path="endDate" type="date" class="form-control"/>
		      </div>
		    </div>
		
		    <button type="submit" class="btn btn-primary mt-2">Submit</button>
		    <button type="reset" class="btn btn-danger mt-2 ml-4">Reset</button>
		  </form:form>
	<hr>
		
		<table class="table table-bordered table-striped shadow-sm rounded" border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>PlanName</th>
         <th>Gender</th>
        <th>Status</th>
        <th>denialReason</th>
        <th>planStartDate</th>
        <th>planEndDate</th>
         <th>teminatedDate</th>
        <th>terminationReason</th>
        <th>benefitAmount</th>
    </tr>
    <c:forEach var="data" items="${filterData}">
        <tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.planName}</td>
            <td>${data.gender}</td>
            <td>${data.planStatus}</td>
            <td>${data.denialReason}</td>
            <td>${data.planStartDate}</td>
            <td>${data.planEndDate}</td>
            <td>${data.teminatedDate}</td>
            <td>${data.terminationReason}</td>
            <td>${data.benefitAmount}</td>
        </tr>
    </c:forEach>
</table>
			
	<hr>
	
	<a href="/excel" class="btn btn-success mb-3">
    <i class="bi bi-download"></i> Export to Excel
</a>
	<form action="/email" method="POST">
        <div class="form-group">
            <label for="email" class="font-weight-bold">Email Address:</label>
            <input type="email" id="email" name="email" class="form-control col-md-4" placeholder="Enter your email" required>
        </div>
        <button type="submit" class="btn btn-success mt-3">Submit</button>
    </form>	
	</div>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>