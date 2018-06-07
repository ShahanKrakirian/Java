<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Checkerboard</title>
	<link rel="stylesheet" type="text/css" href="./css/stylesheet.css">
</head>
<body>
	
	<% int width = Integer.parseInt(request.getParameter("width")); %>
	<% int height = Integer.parseInt(request.getParameter("height")); %>
	<% boolean startblue; %>
	
	<% for(int i=0; i<height; i++) { %>
	
		<% if (i % 2 == 0) { %>
			<div class='inline-block orange'>Orange</div>
		<% } else { %>
			<div class='inline-block blue'>Blue</div>
		<% } %>
		
		<% if (i % 2 == 0) { %>
				<% startblue = true; %>
		<% } else { %>
			<% startblue = false; %>
		<% } %>
		
		<% for(int j=1; j<width; j++) { %>
		
			<% if (startblue == true) { %>
				<div class='inline-block blue'>Blue</div>
				<% startblue = false; %>
			<% } else { %>
				<div class='inline-block orange'>Orange</div>
				<% startblue = true; %>
			<% } %>
		
		<% } %>
		<br>
	<% } %>
	
</body>
</html>