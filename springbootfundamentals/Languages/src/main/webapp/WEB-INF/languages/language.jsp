<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<br><br>
	<p><c:out value="${name}"/></p>
	<p><c:out value="${creator}"/></p>
	<p><c:out value="${currentVersion}"/></p>
	<a href="/languages/delete/${id}">Delete</a>
	<a href="/languages/edit/${id}">Edit</a>
	</body>
</html>