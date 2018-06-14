<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Relationships</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses/new" method="post" modelAttribute="licenseToAdd">
	    <p>
	        <form:label path="person">Person</form:label>
	        <form:errors path="person"/>
	        <form:select path="person">
	        	<c:forEach var="person" items="${people}">
	        		<form:option label="${person.firstName} ${person.lastName}" value="${person}"/>
	        	</c:forEach>
	        </form:select>
	    </p>  
	    <p>
	        <form:label path="state">State:</form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p>
		<p>
	    	<label>Expiration Date:</label>
	    	<input type="date" name="date"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>