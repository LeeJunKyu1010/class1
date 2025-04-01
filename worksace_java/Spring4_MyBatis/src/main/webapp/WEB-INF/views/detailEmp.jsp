<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<input type="hidden" name="empno" value="${dto.empno }">
	</form>
	<table border="1">
		<tr>
			<th>empno</th>
			<td>${dto.empno}</td>
		</tr>

		<tr>
			<th>ename</th>
			<td>${dto.ename}</td>
		</tr>

		<tr>
			<th>job</th>
			<td>${dto.job}</td>
		</tr>

		<tr>
			<th>mgr</th>
			<td>${dto.mgr}</td>
		</tr>

		<tr>
			<th>hiredate</th>
			<td>${dto.hiredate}</td>
		</tr>

		<tr>
			<th>sal</th>
			<td>${dto.sal}</td>
		</tr>

		<tr>
			<th>comm</th>
			<td>${dto.comm}</td>
		</tr>

		<tr>
			<th>deptno</th>
			<td>${dto.deptno}</td>
		</tr>
	</table>

	<a href="modifyEmp?empno=${dto.empno}"><button type="button">수정</button></a>
	<a href="deleteEmp?empno=${dto.empno}"><button type="button">삭제</button></a>
	<a href="emp"><button type="button">뒤로가기</button></a>

</body>
</html>