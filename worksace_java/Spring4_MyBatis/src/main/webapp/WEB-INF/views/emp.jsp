<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.*"%>
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
	<article>
		<form method="get" action="emp">

			<select name="type">
				<option value="ename">ename</option>
				<option value="sal">sal(이상)</option>
				<option value="ej">ename , job</option>
			</select> <input type="text" name="keyword" value="${dto.ename}" />
			<button type="submit" name="action" value="click">검색</button>
			<a href="insertEmp"><button type="button">등록</button></a> <input
				type="submit" value="선택된 것만 조회">
			<table>
				<thead>
					<tr>
						<th>선택</th>
						<th>No.</th>
						<th>empno</th>
						<th>ename</th>
						<th>job</th>
						<th>mgr</th>
						<th>hiredate</th>
						<th>sal</th>
						<th>comm</th>
						<th>deptno</th>
				</thead>
				<tbody>
					<!-- 반복문 돌려서 배열로 된거 출력 -->
					<c:forEach var="dto" items="${select}" varStatus="loop">
						<tr>
							<td><input type="checkbox" name="empnos"
								value="${dto.empno}"></td>
							<td>${loop.count}</td>
							<td>${dto.empno}</td>
							<td><a href="detailEmp?empno=${dto.empno}">${dto.ename}</a></td>
							<td>${dto.job}</td>
							<td>${dto.mgr}</td>
							<td>${dto.hiredate}</td>
							<td>${dto.sal}</td>
							<td>${dto.comm}</td>
							<td>${dto.deptno}</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</form>
	</article>

	<div>
		<%
		Map map = (Map) request.getAttribute("map");
		Integer total = (Integer) map.get("total");
		%>

		<a href="emp?page=1">1</a> <a href="emp?page=2">2</a> <a
			href="emp?page=3">3</a>
	</div>

</body>
</html>