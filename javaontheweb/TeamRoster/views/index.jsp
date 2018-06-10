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
	<h4>Teams Roster</h4>
	<a href="/TeamRoster/Teams">New Team</a>
	<br>
	<table>
		<tr>
			<th>Name</th>
			<th># Players</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="team" items="${teamlist}" varStatus="idx">
		<tr>
			<td>${team.team_name}<td>
  			<td>${team.players.size()}</td>
   			<td><a href="/TeamRoster/TeamDetail?team=${idx.index}">Details</a>&nbsp;<a href="/TeamRoster/DeleteTeam?teamIndex=${idx.index}">Delete</a></td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>