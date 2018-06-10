<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Team Roster</title>
</head>
<body>
	<p><c:out value="${team.team_name}"/></p>
	<br>
	<a href="/TeamRoster/Players?team=<%= request.getParameter("team") %>">New <c:out value="${team.team_name}"/></a>
	<br>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="player" items="${team.players}" varStatus="idx">
		<tr>
			<td>${player.first_name}<td>
  			<td>${player.last_name}</td>
  			<td>${player.age}</td>
   			<td><a href="/TeamRoster/DeletePlayer?team=<%= request.getParameter("team") %>&player=${idx.index}">Delete</a></td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>