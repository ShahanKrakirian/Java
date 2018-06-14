<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Relationships</title>
</head>
<body>
	<h1><c:out value="${person.firstName} ${person.lastName}"/></h1>
	<table>
		<tr>
			<td>License Number:</td>
			<td><c:out value="${license.number}"/></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><c:out value="${license.state}"/></td>
		</tr>
		<tr>
			<td>Expiration Date:</td>
			<td><c:out value="${expireDate}"/></td>
		</tr>
	</table>
</body>
</html>