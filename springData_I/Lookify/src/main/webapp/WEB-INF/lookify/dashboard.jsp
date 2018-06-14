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
	<a href="/songs/new">Add New</a>
	<a href="/search/topTen">Top Songs</a>
	<form action="/search">
		<input type='text' name="search">
		<button type='submit'>Search Artists</button>
	</form>
	<br><br>
	<table>
		<tr>
			<th>Title</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="song" items="${songs}">
		<tr>
			<td><a href="/songs/${song.id}">${song.title}</a></td>
			<td>${song.rating}</td>
			<td><a href="/songs/delete/${song.id}">Delete</a></td>
		</tr>
    	</c:forEach>
	</table>
</body>
</html>