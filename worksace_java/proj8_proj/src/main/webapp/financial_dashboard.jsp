<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>경영 실적 대시보드</title>
</head>
<body>

<h2>경영 실적 대시보드</h2>
<hr>

<!-- 기간 선택 -->
<form method="get" action="financial">
    <input type="hidden" name="action" value="search">
    <label>시작 날짜: <input type="date" name="startDate"></label>
    <label>종료 날짜: <input type="date" name="endDate"></label>
    <input type="submit" value="조회">
</form>

<table border="1">
    <thead>
        <tr>
            <th>날짜</th>
            <th>총 매출</th>
            <th>영업이익</th>
            <th>순이익</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="dto" items="${financialList}">
            <tr>
                <td>${dto.reportDate}</td>
                <td>${dto.totalSales}</td>
                <td>${dto.operatingProfit}</td>
                <td>${dto.netProfit}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>