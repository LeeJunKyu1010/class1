<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #f5f5f5;
            padding: 20px;
        }
        .container {
            width: 80%;
            max-width: 800px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="file"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        button {
            padding: 10px 15px;
            border: none;
            background: #4a90e2;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background: #357ab7;
        }
        .required {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
<h2><c:out value="${boardDTO != null ? '게시글 수정' : '새 글 작성'}"/></h2>
        <span class="required">* 필수 입력</span>
        <form action="board" method="post" enctype="multipart/form-data">
            <input type="hidden" name="command" value="${boardDTO != null ? 'update' : 'insert'}">
            <c:if test="${boardDTO != null}">
                <input type="hidden" name="boardId" value="${boardDTO.boardId}">
            </c:if>
            <div class="form-group">
                <label for="title">제목<span class="required"> *</span></label>
                <input type="text" id="title" name="title" value="${boardDTO.title}" placeholder="제목을 입력하세요" required>
            </div>
            <div class="form-group">
                <label for="file">첨부파일</label>
                <input type="file" id="file" name="files" multiple>
            </div>
            <div class="form-group">
                <label for="content">내용<span class="required"> *</span></label>
                <textarea id="content" name="content" rows="6" placeholder="내용을 입력하세요" required>${boardDTO.boardContent}</textarea>
            </div>
            <div class="button-group">
                <button type="submit">${boardDTO != null ? '수정하기' : '작성하기'}</button>
                <button type="button" onclick="window.location.href='board'">목록</button>
            </div>
        </form>
    </div>
</body>
</html>
