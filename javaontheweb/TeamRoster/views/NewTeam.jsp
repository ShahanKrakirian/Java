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
	<h4>Create a new Team</h4>
	<br>
	<form action="/TeamRoster/Teams" method="post">
		<p>Team Name</p>
		<input type="text" name="team">
		<button type="submit">Create</button>
	</form>
</body>
</html>