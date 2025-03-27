<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>WebToon</title>
</head>
<style>
.wt-main-view {
	display: flex;
	justify-content: space-around;
	border: 1px solid black;
	text-align: center;
}

.wtview {
	width: 100%;
	border: 1px solid black;
}

.add-wt {
	border: 1px solid rgb(218, 236, 243);
	background-color: rgb(218, 236, 243);
	margin-bottom: 10px;
}

.add-wt:hover {
	border: 1px solid rgb(218, 236, 243);
	background-color: rgb(185, 225, 241);
}

.add-ob {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid black;
	width: 400px;
	z-index: 1000;
	background-color: white;
}

.add-ob-title {
	border-bottom: 1px solid black;
	font-weight: 700;
	padding: 5px;
	text-align: center;
}

.add-ob-select {
	padding: 20px;
	display: grid;
	grid-template-columns: 1fr auto;
	gap: 10px;
}

.button-container {
	grid-column: 2;
	margin-top: 10px;
	border: 1px solid rgb(218, 236, 243);
	background-color: rgb(218, 236, 243);
}

.button-container:hover {
	border: 1px solid rgb(218, 236, 243);
	background-color: rgb(185, 225, 241);
}

.hide {
	display: none;
}

.overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	z-index: 999;
}
</style>

<body>
	<form id="addWtForm" method="post" action="Wt">
		<div>
			<h3>요일별 전체 웹툰</h3>
		</div>
		<button type="button" class="add-wt">추가</button>
		<div class="wt-main-view">
			<!-- 웹툰 나오는칸 -->
			<!-- 월 -->
			<div class="wtview" data="week1">
				<div class="week">월요웹툰</div>
				${list}
			</div>
			<!-- 화 -->
			<div class="wtview" data="week2">
				<div>화요웹툰</div>
				<ul class="webtoon-list"></ul>
			</div>
			<!-- 수 -->
			<div class="wtview" data="week3">
				<div>수요웹툰</div>
				<ul class="webtoon-list"></ul>
			</div>
			<!-- 목 -->
			<div class="wtview" data="week4">
				<div>목요웹툰</div>
				<ul class="webtoon-list"></ul>
			</div>
			<!-- 금 -->
			<div class="wtview" data="week5">
				<div>금요웹툰</div>
				<ul class="webtoon-list"></ul>
			</div>
			<!-- 토 -->
			<div class="wtview" data="week6">
				<div>토요웹툰</div>
			</div>
			<!-- 일 -->
			<div class="wtview" data="week7">
				<div>일요웹툰</div>
				<ul class="webtoon-list"></ul>
			</div>
		</div>

		<div class="overlay hide"></div>

		<div class="add-ob hide">
			<div class="add-ob-title">
				<span>웹툰 추가</span>
			</div>
			<div class="add-ob-select">
				<span>요일선택</span> <select name="dayOfWeek">
					<option>월</option>
					<option>화</option>
					<option>수</option>
					<option>목</option>
					<option>금</option>
					<option>토</option>
					<option>일</option>
				</select>
				<div>이미지</div>
				<input type="text" name="img">
				<div>제목</div>
				<input type="text" name="title"><br>
				<button type="button" class="button-container add-wt-ob insert"
					value="insert">등록</button>
				<button type="button" class="button-container can-wt-ob cancel"
					value="cancel">취소</button>
			</div>
		</div>
	</form>
	<script>
		// 웹툰 추가버튼 이벤트
		document.querySelector(".add-wt").addEventListener("click", function() {
			document.querySelector(".add-ob").classList.remove("hide");
			document.querySelector(".overlay").classList.remove("hide");

			// 텍스트 입력 필드와 선택 요소 초기화
			var addObElement = document.querySelector(".add-ob");
			var inputs = addObElement.querySelectorAll("input[type='text']");
			var selects = addObElement.querySelectorAll("select");

			inputs.forEach(function(input) {
				input.value = '';
			});

			selects.forEach(function(select) {
				select.selectedIndex = 0;
			});
		});

		// 웹툰 등록을 위한 버튼 이벤트	
		document.querySelector(".insert").addEventListener("click", function() {
			document.querySelector(".add-ob").classList.add("hide");
			document.querySelector(".overlay").classList.add("hide");
		});

		// 웹툰 추가 클릭하고 취소 하고 싶을때 취소 이벤트
		document.querySelector(".cancel").addEventListener("click", function() {
			document.querySelector(".add-ob").classList.add("hide");
			document.querySelector(".overlay").classList.add("hide");
		});
	</script>
</body>

</html>