<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>설비등록</title>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: #f9f9f9;
	font-family: Arial, sans-serif;
}

.container {
	width: 95%;
	margin: auto;
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h1 {
	margin-bottom: 20px;
	border: 1px solid black;
	padding: 10px;
}

.form {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	margin-bottom: 20px;
}

.form-fields {
	flex: 1;
	display: flex;
	flex-direction: column;
	gap: 15px;
}

.form-row {
	display: flex;
	flex-wrap: wrap;
	align-items: center;
	gap: 10px;
}

label {
	min-width: 80px;
}

input {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 5px;
	flex: 1;
}

.buttons {
	display: flex;
	flex-direction: column;
	gap: 10px;
}

button {
	padding: 10px 15px;
	background-color: #4a90e2;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table th, table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.pagination {
	margin-top: 20px;
	display: flex;
	justify-content: center;
	gap: 5px;
}

.pagination button {
	padding: 5px 10px;
	border-radius: 5px;
}

@media screen and (max-width: 800px) {
	.form-row {
		flex-direction: column;
		align-items: stretch;
		gap: 5px !important;
	}
	.buttons {
		flex-direction: row;
		justify-content: center;
		margin-top: 10px;
	}
	button {
		width: auto;
	}
}

.edit-buttons {
	margin-top: 10px;
}

.active {
	background-color: #0056b3;
}

.hide {
	display: none;
}

.별 {
	color: red;
}
</style>
</head>

<body>
	<div class="container">
		<h1>◎ 설비등록</h1>

		<span class="별">* 모두기입</span>
		<form method="post" action="/EqServlet">
			<div class="form">
				<div class="form-fields">
					<div class="form-row">
						<label for="facilityCode">설비코드<span class="별"> *</span></label> <input
							type="text" id="facilityCode" name="facilityCode"> <label
							for="facilityManager">관리자<span class="별"> *</span></label> <input
							type="text" id="facilityManager" name="facilityManager">
					</div>

					<div class="form-row">
						<label for="installationDate">설치일<span class="별"> *</span></label>
						<input type="date" id="installationDate" name="installationDate">
						<label for="facilityName">설비명<span class="별"> *</span></label> <input
							type="text" id="facilityName" name="facilityName">
					</div>

					<div class="form-row">
						<label for="facilityLocation">설비위치<span class="별">
								*</span></label> <input type="text" id="facilityLocation"
							name="facilityLocation"> <label for="inspectionCycle">점검주기<span
							class="별"> *</span></label> <input type="text" id="inspectionCycle"
							name="inspectionCycle">
					</div>

					<div class="form-row">
						<label for="remarks">비고사항</label> <input type="text" id="remarks"
							name="remarks">
					</div>
				</div>

				<div class="buttons">
					<button id="등록" name="command" value="insert">등록</button>
					<button id="조회" name="command" value="select">조회</button>
					<button id="수정" name="command" value="update">수정</button>
					<button id="삭제" name="command" value="delete" onclick="">삭제</button>

				</div>
			</div>

			<div id="check"></div>

			<table>
				<tr>
					<th>설비 코드</th>
					<th>설비 이름</th>
					<th>관리자</th>
					<th>점검 주기</th>
					<th>설치 일자</th>
					<th>설비 위치</th>
					<th>비고 사항</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${eqList}" var="eq">
					<tr>
						<td>\${eq.facility_code}</td>
						<td>\${eq.facility_name}</td>
						<td>\${eq.facility_manager}</td>
						<td>\${eq.inspection_cycle}</td>
						<td>\${eq.installation_date}</td>
						<td>\${eq.facility_location}</td>
						<td>\${eq.remarks}</td>
						<td><a href="eqUpdate.jsp?facility_code=\${eq.facility_code}">수정</a></td>
						<td><a
							href="EqServlet?command=delete&facility_code=\${eq.facility_code}">삭제</a></td>
					</tr>
				</c:forEach>
			</table>

		</form>
		<!-- 페이지 넘길때 쓸 버튼들 -->
		<div class="pagination">
			<button>&lt;</button>
			<button>1</button>
			<button>2</button>
			<button>3</button>
			<button>4</button>
			<button>5</button>
			<button>6</button>
			<button>7</button>
			<button>8</button>
			<button>9</button>
			<button>10</button>
			<button>&gt;</button>
		</div>
	</div>
</body>

</html>
