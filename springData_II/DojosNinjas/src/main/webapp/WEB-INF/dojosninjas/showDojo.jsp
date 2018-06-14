<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos&Ninjas</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Ninjas</h1>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="ninja" items="${ninjas}">
		<tr>
			<td>${ninja.firstName}</td>
			<td>${ninja.lastName}</td>
			<td>${ninja.age}</td>
		</tr>
    	</c:forEach>
	</table>
</body>
</html>