<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css">  
<meta charset="ISO-8859-1">
<title>All the names</title>
</head>

<body>
<div class="container mt-3">
		<nav class="d-flex justify-content-between">
			<div>
				<h1>Hello, <c:out value="${userName}"/></h1>
				<p>Here are some big companies that are popular</p>
			</div>
			<div class="text-right d-flex flex-column align-items-end">
				<a href="/logout">logout</a>
				<a class="btn btn-primary" href="/companys/new">new background</a>
			</div>
		</nav>

		<table class="table">
			<thead>
				<tr>
					<th>company</th>
					<th>ceo</th>
					<th>location</th>
					<th>date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneCompany" items="${companys }">
					<tr>
					<td>${oneCompany.id } </td>
					<td> <a href="/companys/${oneCompany.id}">${oneCompany.company }</a></td>
					<td>${oneCompany.ceo} </td>
					<td>${oneCompany.location} </td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${oneCompany.date}" /></td>
					</tr>
				</c:forEach>
				<%-- <!--  --><!--<c:forEach var="oneJoy" items="${joys}">
					<tr>

						<td><c:out value="${oneJoy.id }"/></td>
						 link to details -->
						<td><a href="/joys/${oneJoy.id}"> <c:out
									value="${oneJoy.name}" />
						</a></td>
						<!-- access data -->
						<!--  --<td><c:out value="${oneJoy.gender}" /></td>
						<td><c:out value="${oneJoy.user.origin}" /></td>-->
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>

	</div>
</body>
</html>