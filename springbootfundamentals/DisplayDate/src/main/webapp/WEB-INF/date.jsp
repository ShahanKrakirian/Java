<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Date</title>
	<link rel="stylesheet" type="text/css" href="css/datestyles.css">
    <script type="text/javascript" src="js/dateengine.js"></script>
</head>
<body>
	<p><fmt:formatDate pattern = "E, d MMMM, y" value="${date}"/></p>
</body>
</html>