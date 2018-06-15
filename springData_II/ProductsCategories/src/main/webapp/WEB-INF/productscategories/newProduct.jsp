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
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="productToAdd">
	    <p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>  
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea rows="5" cols="30" path="description"/>
	    </p>
	    <p>
	        <form:label path="price">Price:</form:label>
	        <form:errors path="price"/>
	        <form:input type="number" step="any" path="price"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>