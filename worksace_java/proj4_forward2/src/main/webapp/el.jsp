<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
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
	
	int a1 = (int)request.getAttribute("a");
	System.out.println("a1 :"+a1);
	
	List list = new ArrayList();
	request.setAttribute("list", list);
%>

<%= a1 %> <br>
<!-- 밑에 있는 두개 동일하다 -->
<!-- 아래가 편하다. -->
request.getAttribute("b") : [<%= request.getAttribute("b") %>] <br>
\${b} : [${b}]<br>
\${ 지역변수 a1 } : [${a1}]<br>
\${ null } : [${null}]<br>

\${10 + 1} : ${10 + 1}<br>
\${"10" + 1} : ${"10" + 1} el은 계산할때 문자를 숫자로 바꿔서 계산한다.<br>
<!-- \$["a"+1] : $["a"+1]<br> -->
\${a+5} : ${a+5}<br>
\${c+5} : ${c+5}<br>
\${null*5} : ${null*5} : null은 계산할때 0으로 계산한다. <br>

\${a/5} : ${a/5}<br>
\${a div 5} : ${a div 5}<br>

\${a % 5} : ${a % 5}<br>
\${a mod 5} : ${a mod 5}<br>

<---------------------------><br>

\${a == 10 } : ${a == 10 }<br>
\${a != 10 } : ${a != 10 }<br>

\${a eq 10 } : ${a eq 10 }<br>
\${a ne 10 } : ${a ne 10 }<br>

\${a > 10 } : ${a > 10 }<br>
\${a >= 10 } : ${a >= 10 }<br>
\${a < 10 } : ${a < 10 }<br>
\${a <= 10 } : ${a <= 10 }<br>

\${a gt 10 } : ${a gt 10 } &nbsp; &gt; &lt; &ge; &le; &eq; &ne;<br>
\${a ge 10 } : ${a ge 10 }<br>
\${a lt 10 } : ${a lt 10 }<br>
\${a le 10 } : ${a le 10 }<br>

\${(100 > 10) && (50 < 60) } : ${(100 > 10) && (50 < 60) }<br>
\${(100 > 10) and (50 < 60) } : ${(100 > 10) and (50 < 60) }<br>

\${(100 > 10) || (50 < 60) } : ${(100 > 10) || (50 < 60) }<br>
\${(100 > 10) or (50 < 60) } : ${(100 > 10) or (50 < 60) }<br>

\${(100 > 10) eq "true"} : ${(100 > 10) eq "true"}

\${ !(100 > 10) } : ${ !(100 > 10) }<br>
\${ not(100 > 10) } : ${ not(100 > 10) }<br>

${empty c } : ${empty c }<br>
${empty null } : ${empty null }<br>
${empty "" } : ${empty "" }<br>
${empty list } : ${empty list } 비어 있어도 empty가 true<br>

<%= request.getParameter("text") %><br>
\${Param.text } : ${param.text }<br>
\${paramValuses.text } : ${paramValuses.text } <br>
\${paramValuses.text[0] } : ${paramValuses.text[0] }<br>
\${paramValuses.text[10] } : ${paramValuses.text[10] } 배열 범위를 벗어나도 예외 발생하지 않음<br>









</body>
</html>