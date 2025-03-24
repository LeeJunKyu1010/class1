<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background: #4a90e2;
            color: white;
            width: 20%;
 		   	text-align: center;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 15px;
            text-decoration: none;
            color: white;
            background-color: #4a90e2;
            border-radius: 5px;
            text-align: center;
        }
        .btn:hover {
            background-color: #357ab7;
        }
        .delete-btn {
            background-color: #dc3545;
        }
        .delete-btn:hover {
            background-color: #a71d2a;
        }
        textarea {
            width: 100%;
            height: 100px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="main-content">
        <div class="board-header">
            <h2>게시글 상세보기</h2>
            <button type="button" class="active" onclick="window.location.href='board?action=form&boardId=${board.boardId}'">수정하기</button>
        </div>
        <table>
            <tr><th>번호</th><td>${board.boardId}</td></tr>
            <tr><th>작성자(사원번호)</th><td>${board.empno}</td></tr>
            <tr><th>제목</th><td>${board.title}</td></tr>
            <tr><th>내용</th><td>${board.boardContent}</td></tr>
            <tr><th>공지사항 여부</th><td>${board.notice == 1 ? "공지" : "-"}</td></tr>
            <tr><th>작성일</th><td>${board.createDate}</td></tr>
            <tr><th>조회수</th><td>${board.views}</td></tr>
        </table>
        <br>
        <form action="comment" method="post">
            <input type="hidden" name="command" value="insert">
            <input type="hidden" name="boardId" value="${board.boardId}">
            <textarea name="content" placeholder="댓글을 입력하세요..."></textarea>
            <input type="submit" class="btn" value="덧글등록">
        </form>
        <table>
            <c:forEach var="comment" items="${resultList}">
                <tr>
                    <td>${comment.writerName}</td>
                    <td>${comment.content}</td>
                    <td>${comment.createDate}</td>
                    <td>
                        <form action="comment" method="post">
                            <input type="hidden" name="command" value="update">
                            <input type="hidden" name="commentId" value="${comment.commentId}">
                            <input type="hidden" name="boardId" value="${board.boardId}">
                            <input type="text" name="content" value="${comment.content}">
                            <input type="submit" class="btn" value="수정">
                        </form>
                    </td>
                    <td>
                        <form action="comment" method="post">
                            <input type="hidden" name="command" value="delete">
                            <input type="hidden" name="boardId" value="${board.boardId}">
                            <input type="hidden" name="commentId" value="${comment.commentId}">
                            <input type="submit" class="btn delete-btn" value="삭제">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <th>첨부파일</th>
                <td>
                    <c:forEach var="file" items="${fileList}">
                        <a href="file?action=download&fileName=${file.fileName}">${file.fileName}</a>
                    </c:forEach>
                </td>
            </tr>
        </table>
        <div class="button-group">
            <a href="board" class="btn">목록으로</a>
        </div>
    </div>
</body>
</html>
