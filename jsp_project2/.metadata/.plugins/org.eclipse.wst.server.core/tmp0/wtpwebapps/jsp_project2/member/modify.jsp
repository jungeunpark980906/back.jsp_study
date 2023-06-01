<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify page</title>
</head>
<body>
		<h1>modify 제품 수정 페이지</h1>
	
	<br>
	
	<form action="/mem/modify" method="post">
	<input type="hidden" name="id" value="${ses.id }">
	<!-- ses은 현재 로그인되어있는 정보 -->
		아이디 : <input type="text" name="id" value="${ses.id }" disabled="disabled"> <br> 
		비밀번호 : <input type="password" name="password" value="${ses.password }"> <br>
		나이 : <input type="text" name="age" value="${ses.age }"> <br>
		이메일 : <input type="text" name="email" value="${ses.email }" > <br>
		등록일 : <input type="text" name="reg_date" value="${ses.reg_date }" disabled="disabled"> <br>
		<!-- disabled를 이용하면 post로 값을 가져가지 못함 =>  readonly=readonly를 사용하여 읽기상태로 설정하고 값은 가져오기 -->
		<input type="hidden" name = "reg_date" value="${ses.reg_date}"> 
		<!-- 이런방법으로 바꾸지 않는 값들도 같이 넘기기(화면에서는 안보임) -->
		
		
		<button type="submit">완료</button>
		<a href="/"><button type="button">취소</button></a>
	</form>
	
	<!-- hidden으로 숨겨서 -->
	<form action="/mem/delete" method="post">
		<input type="hidden" name="id" value="${ses.id }">
		<button type="submit">회원탈퇴</button>
	</form>
</body>
</html>