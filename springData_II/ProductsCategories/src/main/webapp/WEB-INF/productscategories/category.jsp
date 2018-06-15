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
	<h1><c:out value="${category.name}"/></h1>
	<h3>Products:</h3>
	<ul>
		<c:forEach var="product" items="${associatedProducts}">
			<li>${product.getName()}</li>
    	</c:forEach>
	</ul>
	<br><br>
	<form:form action="/categories/${category.id}/newproductassociation" method="post" modelAttribute="productToAdd">
	    <p>
	        <form:label path="product">Add Product:</form:label>
	        <form:errors path="product"/>
	        <form:select path="product">
	        	<c:forEach var="other" items="${others}">
	        		<form:option label="${other.name}" value="${other}"/>
	        	</c:forEach>
	        </form:select>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>