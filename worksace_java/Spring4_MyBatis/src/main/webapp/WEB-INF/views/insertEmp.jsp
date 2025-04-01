<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="insertEmp">
		<table border="1">
			<tr>
				<th>empno</th>
				<td><input type="text" name="empno"></td>
			</tr>
			<tr>
				<th>ename</th>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<th>job</th>
				<td><input type="text" name="job"></td>
			</tr>
			<tr>

				<th>mgr</th>
				<td><input type="text" name="mgr"></td>
			</tr>
			<tr>

				<th>hiredate</th>
				<td><input type="date" name="hiredate"></td>
			</tr>
			<tr>

				<th>sal</th>
				<td><input type="text" name="sal"></td>
			</tr>
			<tr>

				<th>comm</th>
				<td><input type="text" name="comm"></td>
			</tr>
			<tr>
				<th>deptno</th>
				<td><input type="text" name="deptno"></td>
			</tr>

		</table>

		<button type="submit" name="action" value="click">등록</button>
		<a href="emp"><button type="button">등록취소</button></a>
		<!-- <input type="button" id="modify" value="수정하기">
 -->
	</form>
</body>
</html>