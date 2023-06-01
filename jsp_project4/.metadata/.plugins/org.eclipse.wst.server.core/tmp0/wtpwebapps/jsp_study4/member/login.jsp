<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body align="center">
	<h1>LogIn 로그인</h1>
	<form action="/mem/login_auth" method="post">
		ID : <input type="text" name="id"><br> 
		Password : <input type="password" name="password"><br>
		<button type="submit">login</button> 
	</form>
</body>
</html>