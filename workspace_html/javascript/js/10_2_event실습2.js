
window.addEventListener("load", function () {

    // 조건문2
    // 로그인버튼을 눌렀을때
    // 아이디 또는 비밀번호에 쓴 글이 없다면
    // 비번 아래에 로그인버튼 위에
    // 빨간색으로 "아이디는 필수입니다.", "비밀번호는 필수입니다." 출력



    const btn1 = document.querySelector("#btn")
    btn1.addEventListener("click", function () {    // 로그인 클릭 버튼 이벤트
        console.log("로그인 버튼 클릭")
        const id1 = document.querySelector("#id")  // 아이디
        console.log(id1.value)
        const pw1 = document.querySelector("#pw")   // 비밀번호
        console.log(pw1.value)

        if (id1.value == "admin" && pw1.value == 1234) {
            location.href = "http://naver.com"
        }

        if (id1.value == '') {    // 아이디를 입력 안했을때
            console.log('아이디 없음')
            document.querySelector("#login_msg").style.color = "#f00"    // color를 빨간색으로
            document.querySelector("#login_msg").textContent = "아이디는 필수 입니다."
        }
        else if (pw1.value == '') {   // 비밀번호를 입력 안했을때
            document.querySelector("#login_msg").style.color = "red"    // color를 빨간색으로
            document.querySelector("#login_msg").textContent = "비밀번호는 필수 입니다."
        }
        else {  // 모두 입력했을때 위에 있는것들 공백처리
            document.querySelector("#login_msg").textContent = " "
        }
    })



    let date = new Date()
    console.log(date)
    let time = (""+date).split(" ")
    console.log(time[4])
    
    
    
    setInterval(function(){
        date = new Date()
        console.log(date)
        time = (""+date).split(" ")
        console.log(time[4])
        date = new Date()
        console.log(date)
        time = (""+date).split(" ")
        console.log(time[4])
        date = new Date()
        console.log(date)
        time = (""+date).split(" ")
        console.log(time[4])
        date = new Date()
        console.log(date)
        time = (""+date).split(" ")
        console.log(time[4])
            document.querySelector("#date").innerHTML = time[4]
        }, 1000)

    

})