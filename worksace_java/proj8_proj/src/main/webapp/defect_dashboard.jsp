<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>불량률 추이</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<h2>불량률 추이</h2>

<button onclick="location.href='defect?unit=week'">주별</button>
<button onclick="location.href='defect?unit=month'">월별</button>
<button onclick="location.href='defect?unit=quarter'">분기별</button>

<table border="1">
    <thead>
        <tr>
            <th>기간</th>
            <th>불량 수량</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="defect" items="${defectList}">
            <tr>
                <td>${defect.defectDate}</td>
                <td>${defect.defectCount}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
  <body>
    <div class="dashboard-container">
        <div class="summary-section">
            <div class="summary-box">
                <h4>총 불량 개수</h4>
                <p>${totalDefectCount} 개</p>
            </div>
        </div>
        <div class="charts-section">
            <div class="chart-box">
                <h4>총 불량 개수 추이</h4>
                <canvas id="defectChart"></canvas>
            </div>
        </div>
    </div>

    <script>
        var labels = [];
        var data = [];

        <c:forEach var="item" items="${defectList}">
            labels.push("${item.defectDate}");
            data.push(${item.defectCount});
        </c:forEach>

        var ctx = document.getElementById('defectChart').getContext('2d');
        var chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: '불량 개수',
                    data: data,
                    backgroundColor: 'rgba(255, 99, 132, 0.5)',
                    borderColor: 'rgba(255, 99, 132, 1)',
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
