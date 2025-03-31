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
		<input type="text" name="empno"/>
		<button type="submit" name="action" value="click">클릭</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>empno</th>
				<th>ename</th>
		</thead>
		<tbody>
			<!-- 반복문 돌려서 배열로 된거 출력 -->
			<c:forEach var="dto" items="${select}" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${dto.empno}</td>
					<td><a href="detailEmp?empno=${dto.empno}">${dto.ename}</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>