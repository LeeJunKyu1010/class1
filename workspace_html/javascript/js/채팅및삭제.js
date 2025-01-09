window.addEventListener("load", function () {

    // 입력버튼 class가 클릭되면 댓글칸 id에 value값 출력하기
    // 출력된 값 삭제 checkbox 와 submit 버튼 만들기
    // value가 출력 될 때 만 삭제 checkbox와 submit 버튼 나타내기
    // checkbox가 선택하고 submit 클릭하면 해당되는 댓글칸 삭제
    // del_chk가 체크 되면 중앙 선 긋기


    addEventListener("keydown", function (event) {
        if(event.keyCode == 13){
            document.querySelector(".입력버튼").click();
        }
    })


    const q = document.querySelector(".입력버튼")
    q.addEventListener("click", function () { // 입력 버튼 클릭 되면 실행

        // 입력버튼 class가 클릭되면 text_value id의 value값 mainbox에 출력
        let mainbox = document.querySelector("#mainbox")    // id가 mainbox를 찾기
        let text_value = document.querySelector(".입력칸")  // class가 입력칸 찾아서 text_value에 넣기

        console.log(text_value.value)   // text_value의 value 콘솔 출력

        // div 태그 만들기
        let div1 = document.createElement("div") // div 태그 생성
        div1.className = "div1" // div 태그에 className div1으로 할당

        // 삭제 체크박스 만들기
        let del_chk = document.createElement("input")    // del_chk에 input 속성 할당
        del_chk.type = "checkbox"   // del_chk의 타입을 checkbox로 할당
        del_chk.className = "del_chk"   // del_chk의 className을 del_chk로 할당

        // 삭제 submit 버튼 만들기
        let del_smt = document.createElement("input") // del_smt에 input 속성 할당
        del_smt.type = "button" // del_smt의 타입을 submit 할당
        del_smt.className = "del_smt"   // del_smt의 className을 del_smt으로 할당
        del_smt.value = "삭제" // del_smt의 value 값 삭제로 할당

        mainbox.append(div1) // 위에서 만든 del_chk 
        div1.append(del_chk) // 위에서 만든 del_chk 
        console.log("체크박스 출력 :", del_chk)  // 체크 박스 콘솔에 출력
        div1.append(text_value.value)   // 입력값을 출력하기
        div1.append(del_smt) // 위에서 만든 del_smt
        text_value.value = "" // 입력 하면 "" <- 공백으로 돌려줌


        del_chk.addEventListener("click", function () { // del_chk 가 클릭 되면 실행
            if (del_chk.checked) {  // del_chk가 체크면 div1 클래스에 del_chk_checked 클래스 추가
                div1.classList.add("del_chk_checked")
                console.log("선긋기")
            }
            else {    // del_chk가 풀리면면 div1 클래스에 del_chk_checked 클래스 제거
                div1.classList.remove("del_chk_checked")
                console.log("선빼기")
            }
        })


        // del_chk에 체크된 상태에서 del_smt를 클릭하면 삭제기능
        del_smt.addEventListener("click", function () {
            if (del_chk.checked) {
                div1.remove();
            }
        })


        let del_chk_all = document.querySelectorAll(".del_chk") // del_chk를 querySelectorAll 배열로 만들기
        console.log("del_chk_all :", del_chk_all)
        // 전체선택 체크되면 모두 체크 되는 기능
        document.querySelector("#allpick1")
            .addEventListener("click", function () { // allpick1을 클릭하면 실행 

                // del_chk 클래스를 querySelectorAll로 배열로 만들어서 del_chk_all에 넣기


                for (let i = 0; i < del_chk_all.length; i++) { // del_chk_all을 반복시킨다.
                    if (allpick1.checked) {   // allpick1 체크 되면 del_chk_all[i]를 true
                        del_chk_all[i].checked = true
                        div1.classList.add("del_chk_checked") // 선긋기
                    }
                    else {  // allpick1 체크 풀리면 del_chk_all[i]를 false
                        del_chk_all[i].checked = false
                        div1.classList.remove("del_chk_checked") // 선 빼기
                    }
                }


                // 자식 checkbox들이 모두 체크 되어 있으면 전체선택 체크
                // 자식 checkbox중에서 하나라도 풀려 있으면 전체선택 체크 해제
                for (let a of del_chk_all) {
                    // 각각 클릭 이벤트 주기
                    a.addEventListener("click", function () {
                        let flag = true;

                        // 하나라도 해제된게 있으면
                        for (let i of del_chk_all) {
                            if (!i.checked) {
                                flag = false;
                                break;
                            }
                        }
                        console.log(flag)
                        if (!flag) {
                            document.querySelector("#allpick1").checked = false;
                        } else {
                            document.querySelector("#allpick1").checked = true;
                        }
                    })
                }

            })

        // 선택삭제 기능
        document.querySelector("#all_del").addEventListener("click", function (event) {
            console.log("선택체크")
            for (let i = 0; i < del_chk_all.length; i++) {
                if (del_chk.checked) {
                    div1.remove();
                    document.querySelector("#allpick1").checked = false;
                }
            }
        })


    })
















































})