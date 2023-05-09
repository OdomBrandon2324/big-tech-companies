<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/show.css">  
<meta charset="ISO-8859-1">
<title>Create a Task</title>
</head>

<body>
<div class="container mt-3 show">

		

			
				
				<h1>	Ceo:<c:out value="${companys.ceo}" /></h1>
				
				<h5>	Company:<c:out value="${companys.company}" /></h5>
			
				
				<p>Location:<c:out value="${companys.location}" /></p>
					
				
				<p>Date:	<c:out value="${companys.date}" /></p>
				
	
		
		
		<c:if test="${userId eq companys.user.id}" >
			<a href="/companys/${companys.id}/edit" class="btn btn-success">Edit</a>
			<form action="/companys/${companys.id}" method="post" class="d-inline-block">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="Delete" class="btn btn-danger"/>
			</form>
		
		</c:if>
	</div>
</body>
</html>