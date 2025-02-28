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
	kr.or.human.a.MemberDTO dto2 = new kr.or.human.a.MemberDTO();
	pageContext.setAttribute("dto2", dto2);
	pageContext.setAttribute("dto3", new kr.or.human.a.MemberDTO());
	
// 	dto2.setId("idid");
// 	dto2.getId("id");

	dto2.setPw(request.getParameter("pw") );
	
%>

<!-- 액션태그 -->
<!-- 
	class의 클래스를 생성해서
	id를 key로
	scope에 setAttribute 해줌
	scope 속성을 생략하면 page가 기본값이다.
 -->
<jsp:useBean id="dto" class="kr.or.human.a.MemberDTO" scope="page" ></jsp:useBean>
<jsp:setProperty name="dto" property="id" value="idid" />
\${dto.id } : ${dto.id }<br>
\${dto["id"] } : ${dto["id"] }<br>
<jsp:setProperty name="dto" property="pw" value='<%= request.getParameter("pw")%>' />
<jsp:setProperty name="dto" property="pw" value="${param.pw }" />
jsp:getProperty : <jsp:getProperty property="pw" name="dto"/><br>

<jsp:useBean id="dto4" class="kr.or.human.a.MemberDTO" scope="page" ></jsp:useBean>
<jsp:setProperty name="dto4" property="*" />
\${dto4.id } : ${dto4.id }<br>
\${dto4.pw } : ${dto4.pw }<br>









</body>
</html>