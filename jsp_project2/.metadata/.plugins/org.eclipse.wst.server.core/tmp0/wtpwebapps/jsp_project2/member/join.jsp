<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join 회원가입 페이지</title>
</head>
<body>
	<h1>== 회원가입 페이지 ==</h1>
	<form action="/mem/register" method="post">
		id : <input type="text" name="id" placeholder="id"> <br>
		password : <input type="password" name="password" placeholder="password"> <br>
		email : <input type="text" name="email" placeholder="email"> <br>
		age : <input type="text" name="age" placeholder="age"> <br>
		<button type="submit">가입완료</button>
	</form>
</body>
</html>