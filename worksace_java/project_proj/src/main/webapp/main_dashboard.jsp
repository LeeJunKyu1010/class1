<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MES System Dashboard</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.dashboard-container {
	width: 100%;
	max-width: 1200px;
	padding: 15px;
	background: white;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.summary-section {
	display: flex;
	gap: 15px;
	margin-bottom: 15px;
	justify-content: space-between;
}

.summary-box {
	flex: 1;
	background: white;
	padding: 15px;
	border-radius: 4px;
	border: 1px solid #ddd;
	text-align: center;
}

.summary-box h4 {
	font-size: 16px;
	color: #666;
	margin-bottom: 5px;
}

.summary-box p {
	font-size: 24px;
	font-weight: bold;
	color: #4a90e2;
}

.charts-section {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	grid-template-rows: repeat(2, 1fr);
	gap: 15px;
}

.chart-box {
	background: white;
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: 15px;
}

.chart-box h4 {
	font-size: 16px;
	margin-bottom: 10px;
	color: #333;
}

.chart-container {
	width: 100%;
	height: 250px;
}
</style>
</head>
<body>
    <div class="dashboard-container">
        <div class="summary-section">
            <div class="summary-box">
                <h4>생산량</h4>
                <p>10,000개</p>
            </div>
            <div class="summary-box">
                <h4>불량률</h4>
                <p>2.5%</p>
            </div>
            <div class="summary-box">
                <h4>설비가동률</h4>
                <p>95%</p>
            </div>
        </div>
        <div class="charts-section">
            <div class="chart-box">
                <h4>생산실적</h4>
                <div class="chart-container">
                    <canvas id="productionChart"></canvas>
                </div>
            </div>
            <div class="chart-box">
                <h4>경영실적</h4>
                <div class="chart-container">
                    <canvas id="managementChart"></canvas>
                </div>
            </div>
            <div class="chart-box" style="grid-column: span 2;">
                <h4>불량률 추이</h4>
                <div class="chart-container">
                    <canvas id="defectRateChart"></canvas>
                </div>
            </div>
        </div>
    </div>

    <script>
        function initCharts() {
            const commonOptions = {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: true,
                        position: 'top',
                        labels: {
                            boxWidth: 12,
                            font: {
                                size: 11
                            }
                        }
                    }
                }
            };

            new Chart(document.getElementById('productionChart').getContext('2d'), {
                type: 'bar',
                data: {
                    labels: ['01/20', '01/19', '01/18', '01/17', '01/16', '01/15'],
                    datasets: [{
                        label: '일일 생산량',
                        data: [120, 190, 150, 250, 180, 210],
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    }]
                },
                options: commonOptions
            });

            new Chart(document.getElementById('managementChart').getContext('2d'), {
                type: 'line',
                data: {
                    labels: ['1월', '2월', '3월', '4월', '5월', '6월'],
                    datasets: [{
                        label: '매출액 (백만원)',
                        data: [50, 55, 53, 61, 58, 62],
                        borderColor: 'rgba(255, 99, 132, 1)',
                        tension: 0.1,
                        fill: false
                    }]
                },
                options: commonOptions
            });
            
            new Chart(document.getElementById('defectRateChart').getContext('2d'), {
                type: 'line',
                data: {
                    labels: ['1월', '2월', '3월', '4월', '5월', '6월'],
                    datasets: [{
                        label: '불량률 (%)',
                        data: [1.2, 2.0, 1.8, 2.5, 2.3, 2.8],
                        borderColor: 'rgba(75, 192, 192, 1)',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        tension: 0.1,
                        fill: true
                    }]
                },
                options: commonOptions
            });
        }
        window.addEventListener('load', initCharts);
    </script>
</body>
</html>
