window.addEventListener("load", function () {
    /*
    문제1
    비밀번호
    비밀번호 확인
    
    로그인 버튼 클릭 시 
    두개의 값이 다르면 : 
    빨간글씨로 "비밀번호 확인하세요" 글씨 출력
    두개의 값이 같으면 : 확인문자 지우기
    
    
    문제2
    배송정보의 checkbox 클릭시
    주문정보의 내용을 배송정보에 복사
    
    문제3
    피자주문 시스템
    피자 종류 select
    사이즈 radio
    토핑 checkbox
    요청사항 input text
    
    주문하기 버튼 클릭 시
    주문 내역 표시 
    (총 금액까지 표시)
    */

    let pw = document.querySelector("#pw")
    let pwh = document.querySelector("#pwh")

    const btn = document.querySelector("#btn")
    btn.addEventListener("click", function () {
        if (pw.value != pwh.value) {
            document.querySelector("#tt").innerText = "비밀번호를 확인하세요."
            document.querySelector("#tt").style.color = "red"
        } else {
            document.querySelector("#tt").innerText = " "
        }
    
        if(pw.value == "" || pwh == ""){
            document.querySelector("#tt").innerText = "비밀번호를 확인하세요."
            document.querySelector("#tt").style.color = "red"
        }
    })



    let cbox = document.querySelector("#cbox")
    let name1 = document.querySelector(".name1")
    let name2 = document.querySelector(".name2")
    let hp1 = document.querySelector(".hp1")
    let hp2 = document.querySelector(".hp2")
    let a = document.querySelector(".a")
    let b = document.querySelector(".b")
    cbox.addEventListener("click", function () {
        if (cbox.checked) {
            console.log("체크")
            name2.value = name1.value
            hp2.value = hp1.value
            b.value = a.value
        } else {
            console.log("해제")
            name2.value = " "
            hp2.value = " "
            b.value = " "
        }
    })



    
    let btn1 = document.querySelector("#btn1")
    btn1.addEventListener("click", function () {
        let size = document.querySelector("input[name=cq]:checked")
        let menu = document.querySelector("#menu")
        
        let q = document.querySelector("#q")

        let cw1 = []
        if(document.querySelector("#cw1").checked){
            cw1.push("치즈추가")
        }
        if(document.querySelector("#cw2").checked){
            cw1.push("야채빼기")
        }
        
        

        console.log("선택된 메뉴 : ", menu.value)
        console.log("Size : ", size.value)

        
        console.log(cw1)
        console.log(q.value)

        document.querySelector("#dd").innerText = "선택된 메뉴 : "+menu.value+"\nSize : "+size.value+"\n토핑 : "+cw1+"\n요청사항\n"+q.value
        
        
    })


})