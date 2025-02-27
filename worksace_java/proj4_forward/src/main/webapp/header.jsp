<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <h1>◎ 작업방식</h1>

        <!-- 입력할곳 및 등록, 조회, 수정, 삭제버튼 -->
        <span>* 모두 기입</span>
        <div class="form">
            <div class="form-fields">
                <div class="form-row">
                    <label for="작업양식">작업양식<span>*</span></label>
                    <input type="text" id="작업양식">

                    <label for="비고사항">비고사항</label>
                    <input type="text" id="비고사항">

                </div>
            </div>
            <div class="buttons">
                <button id="등록">등록</button>
                <button id="조회">조회</button>
                <button id="수정">수정</button>
                <button id="삭제">삭제</button>
            </div>
        </div>
        <!-- 내가 체크한것들을 조회버튼을 누르면 추출 -->
        <div id="check"></div>
        </div>
<header>
	<div>이거 해더임</div>
	<div>로고 here</div>
	<div>누구님 환영합니다</div>
</header>

</body>
</html>