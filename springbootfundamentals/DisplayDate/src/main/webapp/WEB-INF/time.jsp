<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Time</title>
	<link rel="stylesheet" type="text/css" href="css/timestyles.css">
    <script type="text/javascript" src="js/timeengine.js"></script>
</head>
<body>
	<p><fmt:formatDate pattern = "K:m a" value="${time}"/></p>
</body>
</html>