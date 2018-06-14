<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<br><br>
	<table>
		<tr>
			<th>Rating</th>
			<th>Title</th>
			<th>Artist</th>
		</tr>
		<c:forEach var="song" items="${songs}" varStatus="idx">
		<c:if test="${idx.count <= 10}">
		<tr>
			<td>${song.rating}</td>
			<td>${song.title}</td>
			<td>${song.artist}</td>
		</tr>
		</c:if>
    	</c:forEach>
	</table>
</body>
</html>