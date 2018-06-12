<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold</title>
	<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
	<div id="wrapper">
		<p>Your Gold: <c:out value="${gold}"/></p>
		<br>
		<div class='locations margin'>
		    <h3>Farm</h3>
		    <p>(earn 10-20 gold)</p>
		    <form action="/calculate" method='post'>
		        <input type='hidden' name='location' value='farm'>
		        <input type='submit' value='Find Gold!'>
		    </form>
	    </div>
	    <div class='locations margin'>
		    <h3>Cave</h3>
		    <p>(earn 5-10 gold)</p>
		    <form action="/calculate" method='post'>
		        <input type='hidden' name='location' value='cave'>
		        <input type='submit' value='Find Gold!'>
		    </form>        
	    </div>
	    <div class='locations margin'>
		    <h3>House</h3>
		    <p>(earn 2-5 gold)</p>
		    <form action="/calculate" method='post'>
		        <input type='hidden' name='location' value='house'>
		        <input type='submit' value='Find Gold!'>
		    </form>        
	    </div>
	    <div class='locations margin'>
		    <h3>Casino</h3>
		    <p>(earn/takes 0-50 gold)</p>
		    <form action="/calculate" method='post'>
		        <input type='hidden' name='location' value='casino'>
		        <input type='submit' value='Gamble Gold!'>
		    </form>        
	    </div>
	    <div class='activities margin'>
            <p>Activities:</p>
            <div class='border'>
				<c:forEach var="message" items="${messages}">
					<p>${message}</p>
            	</c:forEach>
            </div>
        </div>
	</div>
</body>
</html>