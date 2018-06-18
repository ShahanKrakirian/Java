<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DojoOverview</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
		<c:forEach var="question" items="${questions}" varStatus="idx">
		<tr>
			<td><a href="/questions/${question.id}">${question.question}</a></td>
			<td>${tagLists[idx.index]}</td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="/questions/new">New Question</a>
</body>
</html>