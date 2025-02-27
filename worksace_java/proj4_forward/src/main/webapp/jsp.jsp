<%--
	jsp 주석
	java로 번역조차 되지 않음
 --%>
 <!-- 디렉티브 테그 -->
 <!-- java로 변경되는 class에 대한 정보 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 스크립틀릿 script + let = scriptlet -->   
    <%
    // 여기는 java 땅입니다
    System.out.println("java");
    %>
    
   <%
   int a = 10;
   System.out.println("a : " + a);
   %> 
<div><% out.println(a); %></div>   
<div><%= a+5 %></div>   
       
 <%!
 	// 선언문
 	// 필드 선언
 	String str = "글씨";
 	// 메소드 선언
 	String getStr(){
 		return this.str;
 	}
 %>    
 <!-- 이걸로  header.jsp껄 가져와서 쓸수있다 --> 
 <!-- 프론트엔드에 있는것들 가져와서 쓸수있음 -->
 <%@ include file="header.jsp" %>
 
 <!--jsp에 직접 text에 1234라는 값을 보내고-->
 <%
 	String text = request.getParameter("text");
	System.out.println("text : " + text);
   %>
   <!-- jsp에서 html로 그 값을 출력하시오  -->
   <%=text%>
 
 <script>
 let a = '<%= a%>'
 let b = 30;
 </script> 
       
</body>
</html>