<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body align="center">
	<h1>register 게시글 등록</h1>
	
	<form action="/brd/insert" method="post" enctype="multipart/form-data">
		title : <input type="text" name="title"> <br><br>
		writer : <input type="text" name="writer" value="${ses.id }" readonly="readonly"> <br><br>
		content : <textarea rows="3" cols="30" name="content"></textarea> <br><br>
		imageFile : <input type="file" id="file" name="image_file" 
					accept="image/png, image/jpg, image/jpeg, image/bmp, image/gif"> <br><br>
		<button type="submit">등록</button>
		<a href="/"><button type="button">취소</button></a>
	</form>
</body>
</html>