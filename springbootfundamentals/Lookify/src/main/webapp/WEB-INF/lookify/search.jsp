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
	<form action="/search">
		<input type='text' name="search">
		<button type='submit'>New Search</button>
	</form>
	<a href="/dashboard">Dashboard</a>
	<table>
		<tr>
			<th>Title</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="song" items="${searchSongs}">
		<tr>
			<td><a href="/songs/${song.id}">${song.title}</a></td>
			<td>${song.rating}</td>
			<td><a href="/songs/delete/${song.id}">Delete</a></td>
		</tr>
    	</c:forEach>
	</table>
</body>
</html>