<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/style.css">  
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>

<body>
<div class="container mt-3">
	
		<h1>Add a Tech Company</h1>
		<a href="/companys">Go Back</a>
		
		<form:form action="/companys/new" method="post" modelAttribute="newCompany">
			<form:hidden path="user" value="${userId}"/>
			<div class="mb-3">
				<form:label path="company" class="form-label">Company name:</form:label>
				<form:input path="company" type="text" class="form-control"/>
				<p class="form-text text-danger">
					<form:errors path="company"/>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="ceo" class="form-label">Ceo name:</form:label>
				<form:input path="ceo" type="text" class="form-control"/>
				<p class="form-text text-danger">
					<form:errors path="ceo"/>
				</p>
			</div>
			
			
			<div class="mb-3">
				<form:label path="location" class="form-label">Location</form:label>
				<form:input path="location" type="text" class="form-control"/>
				<p class="form-text text-danger">
					<form:errors path="location"/>
				</p>
			</div>
			<div class="mb-3">
				<p> Date</p>
				<form:errors path="date"></form:errors>
				<form:input path="date" type="date"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		
		</form:form>
		
	</div>
</body>
</html>