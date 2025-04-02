<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>생산 실적 대시보드</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<h2>생산 실적 대시보드</h2>

<!-- 주별, 월별, 분기별 버튼 -->
<button onclick="location.href='production?unit=week'">주별</button>
<button onclick="location.href='production?unit=month'">월별</button>
<button onclick="location.href='production?unit=quarter'">분기별</button>

<!-- 차트 -->
<canvas id="productionChart"></canvas>

<!-- 생산 실적 테이블 -->
<table border="1">
    <tr>
        <th>기간</th>
        <th>생산량</th>
    </tr>
    <c:forEach var="data" items="${productionList}">
        <tr>
            <td>${data.period}</td>
            <td>${data.totalProduction}</td>
        </tr>
    </c:forEach>
</table>

<script>
    var labels = [];
    var data = [];

    <c:forEach var="data" items="${productionList}">
        labels.push("${data.period}");
        data.push(${data.totalProduction});
    </c:forEach>

    var ctx = document.getElementById('productionChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: '생산량',
                data: data,
                backgroundColor: 'rgba(54, 162, 235, 0.5)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>

</body>
</html>