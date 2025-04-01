<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="emp">
		<table border="1">
			<tr>
				<th>empno</th>
				<td id="empno">${dto.empno}</td>
			</tr>
			<tr>
				<th>ename</th>
				<td><input type="text" name="ename" value="${dto.ename}"></td>
			</tr>
			<tr>
				<th>job</th>
				<td><input type="text" name="job" value="${dto.job}"></td>
			</tr>
			<tr>

				<th>mgr</th>
				<td><input type="text" name="mgr" value="${dto.mgr}"></td>
			</tr>
			<tr>

				<th>hiredate</th>
				<td><input type="date" name="hiredate" value="${dto.hiredate}"></td>
			</tr>
			<tr>

				<th>sal</th>
				<td><input type="text" name="sal" value="${dto.sal}"></td>
			</tr>
			<tr>

				<th>comm</th>
				<td><input type="text" name="comm" value="${dto.comm}"></td>
			</tr>
			<tr>
				<th>deptno</th>
				<td><input type="text" name="deptno" value="${dto.deptno}"></td>
			</tr>

		</table>

		<input type="hidden" name="empno" value="${dto.empno}">
		<input type="submit" value="수정하기">
		<a href="emp"><button type="button">수정취소</button></a>
		<!-- <input type="button" id="modify" value="수정하기">
 -->
	</form>
</body>
</html>