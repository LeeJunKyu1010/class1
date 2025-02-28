<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("a", 10);
	request.setAttribute("b", "abc");
	
	int a = (int)request.getAttribute("a");
	System.out.println("a :"+a);
%>
</body>
</html>