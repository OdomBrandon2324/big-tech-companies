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
<title>Insert title here</title>
</head>

<body>
<div class="container">
	<h1>Change Company</h1>
		<a href="/companys">Go back</a>
		
		<form:form  action="/companys/${oneCompany.id}/edit" method="put" modelAttribute="oneCompany">
			<form:hidden path="user"/>
			<div class="mb-3">
				<form:label path="ceo" class="form-label">Ceo name:</form:label>
				<form:input path="ceo" type="text" class="form-control"/>
				<p class="form-text text-danger">
					<form:errors path="ceo"/>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="company" class="form-label">Company</form:label>
				<form:input path="company" type="text" class="form-control"/>
				<p class="form-text text-danger">
					<form:errors path="company"/>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="location" class="form-label">Company Location</form:label>
				<form:textarea path="location" class="form-control" rows="3"></form:textarea>
				<p class="form-text text-danger">
					<form:errors path="location"/>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="date" class="form-label">Date:</form:label>
				<form:errors path="date"></form:errors>
				<form:input path="date" type="date"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		
		</form:form>
		<form action="/companys/${oneCompany.id}" method="post" class="d-inline-block">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="Delete" class="btn btn-danger"/>
			</form>
		
	</div>
</body>
</html>