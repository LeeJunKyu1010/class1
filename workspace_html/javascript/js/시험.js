window.addEventListener("load", function () {

    const main_img_title = document.querySelector("#main_img_title")
        .addEventListener("click", function (event) {

            const info_title = document.querySelectorAll(".info_title");
            const 댓글 = document.querySelectorAll(".댓글")

            for (let i = 0; i < info_title.length; i++) {
                info_title[i].classList.add("hide")
            }

            for (let i = 0; i < 댓글.length; i++) {
                댓글[i].classList.add("hide")
            }

            // 클릭된 img_title에 해당하는 info_title을 표시
            // img_title1에 해당되는 if문
            if (event.target.classList.contains("img_title1")) {
                // img_title1가 클릭되면 true일때 data-info='info1 의 hide 클래스를 삭제
                document.querySelector("[data-info='info1']").classList.remove("hide");
                // img_title1가 클릭되면 true일때 data-cmt = 'cmt1 의 hide 클래스를 삭제
                document.querySelector("[data-cmt = 'cmt1']").classList.remove("hide")
            }
            // img_title2에 해당되는 if문
            else if (event.target.classList.contains("img_title2")) {
                // img_title2가 클릭되면 true일때 data-info='info2 의 hide 클래스를 삭제
                document.querySelector("[data-info='info2']").classList.remove("hide");
                // img_title2가 클릭되면 true일때 data-cmt = 'cmt2 의 hide 클래스를 삭제
                document.querySelector("[data-cmt = 'cmt2']").classList.remove("hide")
            }
            // img_title3에 해당되는 if문
            else if (event.target.classList.contains("img_title3")) {
                // img_title3가 클릭되면 true일때 data-info='info3 의 hide 클래스를 삭제
                document.querySelector("[data-info='info3']").classList.remove("hide");
                // img_title3가 클릭되면 true일때 data-cmt = 'cmt3 의 hide 클래스를 삭제
                document.querySelector("[data-cmt = 'cmt3']").classList.remove("hide")
            }
            // img_title4에 해당되는 if문
            else if (event.target.classList.contains("img_title4")) {
                // img_title4가 클릭되면 true일때 data-info='info4 의 hide 클래스를 삭제
                document.querySelector("[data-info='info4']").classList.remove("hide");
                // img_title4가 클릭되면 true일때 data-cmt = 'cmt4 의 hide 클래스를 삭제
                document.querySelector("[data-cmt = 'cmt4']").classList.remove("hide")
            }
        });



    // ------------------------------------------ 댓글 자바스크립트 ------------------------------------------



    document.querySelectorAll(".입력칸").forEach(입력칸 => {
        입력칸.addEventListener("keydown", function (event) {
            if (event.key === "Enter") {
                event.preventDefault(); // 기본 엔터 동작 방지
                const 댓글섹션 = this.closest('.댓글');
                const 입력버튼 = 댓글섹션.querySelector(".입력버튼");
                입력버튼.click(); // 해당 섹션의 입력 버튼 클릭
            }
        });
    });




    const 입력버튼들 = document.querySelectorAll(".입력버튼");
    입력버튼들.forEach(버튼 => {
        버튼.addEventListener("click", function (event) {// 입력 버튼 클릭 되면 실행
            const 댓글섹션 = event.target.closest('.댓글');
            const mainbox = 댓글섹션.querySelector(".mainbox"); // class가 mainbox를 찾기
            const text_value = 댓글섹션.querySelector(".입력칸"); // class가 입력칸 찾아서 text_value에 넣기

            console.log(text_value.value)   // text_value의 value 콘솔 출력

            if (text_value.value.trim() === "") {
                alert("내용을 입력하세요");
                return; // 함수 실행 중단
            }

            // div 태그 만들기
            let div1 = document.createElement("div") // div 태그 생성
            div1.className = "div1" // div 태그에 className div1으로 할당

            let span1 = document.createElement("span") // div 태그 생성
            span1.className = "span1" // div 태그에 className div1으로 할당

            // 삭제 체크박스 만들기
            let del_chk = document.createElement("input")    // del_chk에 input 속성 할당
            del_chk.type = "checkbox"   // del_chk의 타입을 checkbox로 할당
            del_chk.className = "del_chk"   // del_chk의 className을 del_chk로 할당

            // 삭제 submit 버튼 만들기
            let del_smt = document.createElement("input") // del_smt에 input 속성 할당
            del_smt.type = "button" // del_smt의 타입을 submit 할당
            del_smt.className = "del_smt"   // del_smt의 className을 del_smt으로 할당
            del_smt.value = "삭제" // del_smt의 value 값 삭제로 할당

            let 수정 = document.createElement("input")
            수정.type = "button"
            수정.className = "수정"
            수정.value = "수정"

            mainbox.append(div1) // 위에서 만든 div 출력





            // 출력한 div안에 내용 넣기--------------------------------------------------------------------------
            div1.append(del_chk) // 위에서 만든 del_chk 출력
            console.log("체크박스 출력 :", del_chk)  // 확인을 위한 체크 박스 콘솔에 출력 
            div1.append(span1)
            span1.append(text_value.value)   // 입력값을 출력하기
            div1.append(수정)
            div1.append(del_smt) // 위에서 만든 del_smt
            text_value.value = "" // 입력 하면 "" <- 공백으로 돌려줌




            del_chk.addEventListener("click", function () { // del_chk 가 클릭 되면 실행
                if (del_chk.checked) {  // del_chk가 체크면 div1 클래스에 del_chk_checked 클래스 추가
                    div1.classList.add("del_chk_checked")
                }
                else {    // del_chk가 풀리면면 div1 클래스에 del_chk_checked 클래스 제거
                    div1.classList.remove("del_chk_checked")
                }
            })


            // del_chk에 체크된 상태에서 del_smt를 클릭하면 삭제기능
            del_smt.addEventListener("click", function () {
                if (del_chk.checked) {
                    div1.remove();
                }
            })



            // 수정칸 ------------------------------------------------------------------------------------------
            수정.addEventListener("click", function (event) {

                if (del_chk.checked) {


                    const span1_value = event.target.parentNode.querySelector(".span1")
                    const span1_content = span1_value.textContent   // span1의 value를 span1_content 할당

                    span1.innerHTML = ""
                    del_chk.remove()    // 수정 버튼을 누르면 체크박스 삭제
                    del_smt.remove()    // 수정 버튼을 누르면 삭제버튼 삭제
                    수정.remove()

                    let 수정칸 = document.createElement("input")
                    수정칸.type = "text"
                    수정칸.className = "수정칸"

                    let 수정취소 = document.createElement("input")
                    수정취소.type = "button"
                    수정취소.value = "수정취소"
                    수정취소.className = "수정취소"

                    let 수정완료 = document.createElement("input")
                    수정완료.type = "button"
                    수정완료.value = "수정완료"
                    수정완료.className = "수정완료"

                    수정칸.value = span1_content


                    span1.append(수정칸)
                    div1.append(수정취소)
                    div1.append(수정완료)


                

                // 수정취소칸 -----------------------------------------------------------------------------------
                수정취소.addEventListener("click", function (event) {

                    수정취소.remove()
                    수정완료.remove()
                    수정칸.remove()

                    div1.append(del_chk) // 위에서 만든 del_chk 출력
                    console.log("체크박스 출력 :", del_chk)  // 확인을 위한 체크 박스 콘솔에 출력 
                    div1.append(span1)
                    span1.append(span1_content)   // 수정칸 위에 수정전 값을 빼놨음
                    div1.append(수정)
                    div1.append(del_smt)
                    console.log(del_chk.value)
                    del_chk.checked = false
                })




                // 수정완료칸 -----------------------------------------------------------------------------------
                수정완료.addEventListener("click", function () {
                    수정칸.remove()
                    수정완료.remove()
                    수정취소.remove()

                    div1.append(del_chk)
                    div1.append(span1)
                    span1.append(수정칸.value)
                    div1.append(수정)
                    div1.append(del_smt)
                    del_chk.checked = false
                })



            }
            });


        })


    })
})