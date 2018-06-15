<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>P&C</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<h3>Categories:</h3>
	<ul>
		<c:forEach var="category" items="${associatedCategories}">
			<li>${category.name}</li>
    	</c:forEach>
	</ul>
	<br><br>
	<form:form action="/products/${product.id}/newcategoryassociation" method="post" modelAttribute="categoryToAdd">
	    <p>
	        <form:label path="category">Add Category:</form:label>
	        <form:errors path="category"/>
	        <form:select path="category">
	        	<c:forEach var="other" items="${others}">
	        		<form:option label="${other.name}" value="${other.id}"/>
	        	</c:forEach>
	        </form:select>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>