<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            background-color: #f5f5f5;
        }

        .main-content {
            flex: 1;
            width: 95%;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .board-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .board-header button {
            padding: 8px 12px;
            background: #4a90e2;
            color: white;
            border: none;
            border-radius: 4px;
        }

        .active:hover {
            background-color: #357ab7;
            cursor: pointer;
        }

        .search-box {
            display: flex;
            gap: 10px;
            margin-bottom: 10px;
            align-items: center;
        }

        .search-box input,
        .search-box button {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .search-box button {
            background: #4a90e2;
            color: white;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th,
        td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        th {
            background: #4a90e2;
            color: white;
        }
    </style>

</head>
<body>
    <div class="main-content">
        <div class="board-header">
            <h2>게시판 목록</h2>
            <button type="button" class="active" onclick="window.location.href='board?action=form'">새 글 작성</button>
        </div>

        <div class="search-box">
            <label>작성일자</label>
            <input type="date">
            <span>~</span>
            <input type="date">
            <input type="text" placeholder="검색어 입력">
            <button class="active">🔍 검색</button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>사원번호</th>
                    <th>제목</th>
                    <th>공지</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
		<tbody>

			<c:forEach var="dto" items="${resultList}">
				<tr>
					<!-- 게시글 번호 -->
					<td>${dto.boardId}</td>

					<!-- 사원번호 -->
					<td>${dto.empno}</td>

					<!-- 게시글 제목 (클릭 시 상세보기) -->
					<td><a href="board?action=detail&boardId=${dto.boardId}">
					${dto.title}</a>
					</td>

					<!-- 공지사항 여부 -->
					<td>${dto.notice == 1 ? "공지" : "-"}</td>

					<!-- 작성일 -->
					<td>${dto.createDate}</td>

					<!-- 조회수 -->
					<td>${dto.views}</td>

					<td></td>
					<!-- 삭제 버튼 -->
					<td>
						<form method="post" action="board" enctype="multipart/form-data">
							<input type="hidden" name="command" value="delete"> <input
								type="hidden" name="boardId" value="${dto.boardId}"> <input
								type="submit" value="삭제"
								style="border-radius: 4px; background-color: #dc3545; color: white; border: none">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>