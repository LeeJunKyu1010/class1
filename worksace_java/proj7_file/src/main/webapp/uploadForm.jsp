<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	파일 첨부시 유의사항
	method는 꼭 post 여야 함
 	enctype은 원래 한글깨짐 방지에 사용하는 속성인데
 	파일 첨부시 multipart/form-data 를 써야함
 	accept-charset를 이용할 수 있음
 -->
<form
	method="post"
	action="upload.do"
	enctype="multipart/form-data"
	accept-charset="utf-8"
	>
	제목 : <input type="text" name="title" ><br>
	내용 : <textarea name="content" cols=40 rows=10></textarea><br>
	첨부파일 : <input type="file" name="file1"><br>
	<input type="submit" value="등록">
</form>

<img src="http://127.0.0.1:8080/proj7_file/downlaod.do?filename=1741154558898_06.%20%EC%8A%A4%EB%A7%88%ED%8A%B8%ED%8C%A9%ED%86%A0%EB%A6%AC%20MES%20%EA%B5%AC%EC%B6%95(%E2%85%A1)-%EA%B3%BC%EC%A0%9C-%EC%BA%A1%EC%B3%90-%EC%9D%B4%EC%A4%80%EA%B7%9C.png">

</body>
</html>