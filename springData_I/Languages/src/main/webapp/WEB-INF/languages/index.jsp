<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Action</th>
		</tr>
		<c:forEach var="language" items="${languages}">
		<tr>
			<td><a href="/languages/${language.id}">${language.name}</a></td>
			<td>${language.creator}</td>
			<td>${language.currentVersion}</td>
			<td><a href="/languages/delete/${language.id}">Delete</a>&nbsp;<a href="/languages/edit/${language.id}">Edit</a></td>
		</tr>
    	</c:forEach>
	</table>
	<form:form action="/languages" method="post" modelAttribute="languageToAdd">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:label path="currentVersion">Language</form:label>
	        <form:errors path="currentVersion"/>
	        <form:input path="currentVersion"/>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>