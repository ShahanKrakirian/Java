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
			<td>Title</td>
			<td><c:out value="${song.title}"/></td>
		</tr>
		<tr>
			<td>Artist</td>
			<td><c:out value="${song.artist}"/></td>
		</tr>
		<tr>
			<td>Rating (1-10)</td>
			<td><c:out value="${song.rating}"/></td>
		</tr>
	</table>
	<br><br>
	<a href="/songs/delete/<c:out value='${song.id}'/>">Delete</a>
</body>
</html>