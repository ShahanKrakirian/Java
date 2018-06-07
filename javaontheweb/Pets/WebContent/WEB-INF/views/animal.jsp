<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pets</title>
</head>
<body>
	<div>
		<h4>Make a dog!</h4>
		<form action="/Pets/ShowDog">
			Name:
            <input type="text" name="name">
            <br>
            Breed: 
            <input type="text" name="breed">
            <br>
            Weight(lb): 
            <input type="text" name="weight">
            <br>
            <input type="submit">
		</form>
	</div>
	<div>
		<h4>Make a cat!</h4>
		<form action="/Pets/ShowCat">
			Name:
            <input type="text" name="name">
            <br>
            Breed: 
            <input type="text" name="breed">
            <br>
            Weight(lb): 
            <input type="text" name="weight">
            <br>
            <input type="submit">
		</form>
	</div>
</body>
</html>