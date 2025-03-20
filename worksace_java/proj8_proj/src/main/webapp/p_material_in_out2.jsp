<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원자재현황</title>
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

.buttons {
	padding: 10px 15px;
	background-color: #4a90e2;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.buttons:hover {
	background-color: #0056b3;
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
		/* 모바일에서 간격 조정 */
		width: auto .buttons{
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

}
.active {
	background-color: #0056b3;
}

span {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<h1>◎ 원자재현황</h1>
		<form method="post" action="P_material_in_out2Controller" class="form">
			<div>
				조회할 상품코드를 입력해주세요 <input type="text" name="searchKeyword"
					id="searchKeyword">
			</div>
			<!-- 검색결과가 없을때 나온다 -->
			<c:if test="${not empty message}">
				<p style="color: red;">${message}</p>
			</c:if>

			<div>
				<input type="button" value="조회" class="buttons"
					onclick="searchSkus()">
			</div>
		</form>

		<table border=1>
			<thead>
				<tr>
					<th>원자재관리번호</th>
					<th>원자재수량</th>
					<th>원자재가격</th>
					<th>상품코드</th>
					<th>상품명</th>
					<th>규격</th>
					<th>분류</th>
					<th>등록날짜</th>
					<th>수정날짜</th>
					<th>비고사항</th>
					<th>상품고유번호</th>
					<th>등록번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${resultList}">
					<tr>

						<td>${dto.ib_id}</td>
						<td>${dto.material_count}</td>
						<td>${dto.material_price}</td>
						<td>${dto.sku_code}</td>
						<td>${dto.sku_name}</td>
						<td>${dto.sku_size}</td>
						<td>${dto.sku_type}</td>
						<td>${dto.create_date}</td>
						<td>${dto.modify_date}</td>
						<td>${dto.remarks}</td>
						<td>${dto.sku_id}</td>
						<td>${dto.bill_id}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

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

	<script>
		//조회버튼
		function searchSkus() {
			var searchKeyword = document.getElementById('searchKeyword').value;
			if (searchKeyword.trim() === "") {
				// 검색어가 없을 경우 전체 목록 조회
				window.location.href = "P_material_in_out2Controller";
			} else {
				// 검색어가 있을 경우 검색 결과 조회
				window.location.href = "P_material_in_out2Controller?searchKeyword="
						+ searchKeyword;
			}
		}
	</script>
</body>
</html>