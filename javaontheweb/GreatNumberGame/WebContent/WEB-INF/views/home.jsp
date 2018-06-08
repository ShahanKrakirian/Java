<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GNG</title>
</head>
<body>
	<h1>Welcome to the great number game!</h1>
	<p>I am thinking of a number between 1 and 100</p>
	<p>Take a guess!</p>
	<p>(Current answer: <%= (int) session.getAttribute("answer") %>)
	<form action="/GreatNumberGame/Home" method='post'>
		<input type='text' name="guess">
		<button type='submit'>Submit</button>
	</form>
	<% if (request.getAttribute("status") != null) { %>
		<% if ((String) request.getAttribute("status") == "high") { %>
		<p>Too High.</p>
		<% } %>
		<% if ((String) request.getAttribute("status") == "low") { %>
		<p>Too Low.</p>
		<% } %>
		<% if ((String) request.getAttribute("status") == "correct") { %>
		<p>Correct!</p>
		<form action="/GreatNumberGame/Home" method="get">
			<button type="submit">Play again.</button>
		</form>
		<% } %>
	<% } %>
</body>
</html>