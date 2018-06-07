<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pets</title>
</head>
<body>
	<p>You have created a <%= request.getParameter("breed") %>!</p>
	<br>
	<p><%= request.getParameter("name") %> hopped into your lap and cuddled you!</p>
</body>
</html>