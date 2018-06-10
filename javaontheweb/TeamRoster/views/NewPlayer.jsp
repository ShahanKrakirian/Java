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
	<p>Add a player to team <c:out value="${team.team_name}"/></p>
	<br>
	<form action="/TeamRoster/Players?team=<%= request.getParameter("team") %>" method="post">
		First Name:
		<input type='text' name="first_name">
		Last Name:
		<input type='text' name="last_name">
		Age: 
		<input type='number' name="age">
		<br>
		<button type='submit'>Add</button>
	</form>
</body>
</html>