<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>sal</th>
			<th>comm</th>
			<th>deptno</th>
		</tr>
		<tr>
			<td>${dto.empno}</td>
			<td>${dto.ename}</td>
			<td>${dto.job}</td>
			<td>${dto.mgr}</td>
			<td>${dto.hiredate}</td>
			<td>${dto.sal}</td>
			<td>${dto.comm}</td>
			<td>${dto.deptno}</td>
		</tr>
	</table>
</body>
</html>