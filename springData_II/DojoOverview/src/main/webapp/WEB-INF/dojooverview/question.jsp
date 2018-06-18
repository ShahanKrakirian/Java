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
	<h2><c:out value="${currQuestion.question}"/></h2>
	Tags: <span><c:out value="${tags}"/></span>
	<br><br>
	<table>
		<tr>
			<th>Answers</th>
		</tr>
		<c:forEach var="answer" items="${answers}">
			<tr>
				<td><p>${answer.answer}</p></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<h2>Add your answer:</h2>
	<form:form action="/answer/new/${currQuestion.id}" method="post" modelAttribute="answerToAdd">
	    <p>
	        <form:label path="answer">Answer:</form:label>
	        <form:errors path="answer"/>
	        <form:textarea path="answer"/>
	    </p>
	    <p>
	    	<button type="submit">Send answer</button>
	    </p>
	</form:form>
</body>
</html>