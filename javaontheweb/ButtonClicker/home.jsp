<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Button Clicker</title>
</head>
<body>
	<h3>Click to add to the counter!</h3>
	<form method="get" action="/ButtonClicker/Home">
		<button type="submit">Click Me</button>
	</form>
	<p>Total count is <%= (int) session.getAttribute("score") %></p>
</body>
</html>