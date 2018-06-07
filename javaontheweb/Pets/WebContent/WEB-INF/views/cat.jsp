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
	<p>Your <%= request.getParameter("breed") %> cat, <%= request.getParameter("name") %>, looked at you with contempt.</p>
</body>
</html>