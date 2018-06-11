<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
</head>
<body>
	<form action="/display" method="post">
		Your Name:
		<input type="text" name="name">
		<br>
		Dojo Location:
		<select name="location">
			<option value="San Jose">San Jose</option>
			<option value="Burbank" selected>Burbank</option>
			<option value="Seattle">Seattle</option>
		</select>
		<br>
		Favorite Language:
		<select name="language">
			<option value="Python">Python</option>
			<option value="Javascript">JavaScript</option>
			<option value="Java" selected>Java</option>
		</select>
		<br>
		Comment (optional):
		<textarea name="comment" cols="50" rows="10"></textarea>
		<br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>