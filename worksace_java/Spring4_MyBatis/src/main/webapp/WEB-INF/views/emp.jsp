<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<form method="post" action="emp">
		<button type="submit" name="action" value="click">클릭</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>job</th>
				<th>mgr</th>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${select}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
				</tr>
			</c:forEach>

		</tbody>


	</table>
	</tr>


</body>
</html>