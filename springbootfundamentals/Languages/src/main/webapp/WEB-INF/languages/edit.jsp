<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages</title>
</head>
<body>
	<a href="/languages/delete/<c:out value='${id}'/>">Delete</a>
	<a href="/languages">Dashboard</a>
	<br><br>
	<form:form action="/languages/edit/${id}" method="post" modelAttribute="languageToEdit">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name" value="${name}"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator" value="${creator}"/>
	    </p>
	    <p>
	        <form:label path="currentVersion">Language</form:label>
	        <form:errors path="currentVersion"/>
	        <form:input path="currentVersion" value="${currentVersion}"/>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>