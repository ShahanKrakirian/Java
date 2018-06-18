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
	<h1>What is your question?</h1>
	<form:form action="/questions/new" method="post" modelAttribute="questionToAdd">
	    <p>
	        <form:label path="question">Question:</form:label>
	        <form:errors path="question"/>
	        <form:textarea path="question"/>
	    </p>
	    <p>
	    	<label>Tags</label>
	    	<input type="text" name="tagss"/>
	    	<c:choose>
	    		<c:when test="${errors != null}">
        			<p><c:out value="${errors}"/></p>
    			</c:when>
    		</c:choose>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>