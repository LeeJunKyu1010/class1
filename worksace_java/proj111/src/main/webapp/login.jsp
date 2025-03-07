<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>로그인</title>
    <style>
        body {
            background-color: #f4f4f4;
            padding: 20px;
        }

        #mainbox {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            margin: 150px auto;
            text-align: center;
        }

        #logo {
            width: 100px;
            height: 80px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto;
        }

        #logo img {
            width: 150%;
        }

        #id,
        #pw {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 10px;
        }

        .find_id,
        .find_pw,
        .create_id {
            margin-top: 20px;
            width: 30%;
            background-color: #4a90e2;
            color: white;
            padding: 5px;
            border: none;
            border-radius: 10px;
            font-size: 15px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
        }

        .find_id:hover,
        .find_pw:hover,
        .create_id:hover {
            background-color: #2f6baf;
            transform: scale(1.07);
        }

        .login {
            margin-top: 20px;
            width: 100%;
            background-color: #4a90e2;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 10px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
        }

        .login:hover {
            background-color: #2f6baf;
            transform: scale(1.05);
        }
    </style>
</head>

<body>
    <div id="mainbox">
        <div id="logo">
            <img src="GKBM_logo.jpg" alt="GKBM Logo">
        </div>
        <input type="text" id="id" placeholder="아이디를 입력하세요">
        <input type="password" id="pw" placeholder="비밀번호를 입력하세요">

        <input type="button" class="find_id" value="아이디찾기">
        <input type="button" class="find_pw" value="비밀번호찾기">
        <input type="button" class="create_id" value="회원가입">

        <input type="button" class="login" value="로그인" onclick="login()">
    </div>
    <script>
        function login() {
            var id = document.getElementById("id").value;
            var pw = document.getElementById("pw").value;

            // AJAX를 사용하여 서블릿에 데이터 전송
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "LoginServlet", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var response = xhr.responseText;
                    if (response == "success") {
                        alert("로그인 성공!");
                        window.location.href = "mainpage.html"; // 성공 시 이동할 페이지
                    } else {
                        alert("아이디 또는 비밀번호가 잘못되었습니다.");
                    }
                }
            };
            xhr.send("id=" + id + "&pw=" + pw);
        }
    </script>
</body>

</html>
