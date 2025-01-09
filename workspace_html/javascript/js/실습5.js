window.addEventListener("load", function () {

    // menu의 div를 클릭하면
    // content의 div가 출력

    // const menu = document.querySelectorAll("#menu div");
    // for (let i = 0; i < menu.length; i++) {
    //     menu[i].addEventListener('click', function (event) {
    //         // 클릭된 메뉴 항목의 value 속성 가져오기
    //         let clickedValue = event.target.getAttribute("value");

    //         // 모든 content 항목에 hide 클래스 추가
    //         let contentItems = document.querySelectorAll("#content div");
    //         for (let j = 0; j < contentItems.length; j++) {
    //             contentItems[j].classList.add('hide');
    //         }

    //         // 클릭된 메뉴에 해당하는 content 항목 찾기
    //         let targetContent = document.querySelector("#content div[value='" + clickedValue + "']");
    //         if (targetContent != null) {
    //             // hide 클래스 제거
    //             targetContent.classList.remove('hide');
    //         }
    //     });
    // }





    document.querySelector("#menu")
        .addEventListener("click", function (evt) {
            console.log(evt.target.textContent)
            console.log(evt.target.getAttribute("data-topping"))
            console.log(evt.target.getAttribute("data-view"))

            let id = evt.target.getAttribute("data-view")
            console.log(document.querySelector("#" + id))



            // id="content1"
            // content를 querySelectorAll 해서 배열로 만들기
            // content부터 시작하는 id를 찾기
            // 단, id가 content는 빼고
            const contents = document.querySelectorAll("[id^=content]:not(#content)")

            for (let i = 0; i < contents.length; i++) {   // i를 content의 length만큼 반복
                contents[i].classList.add("hide");  // content 모두 hide 클래스 추가
            }

            document.querySelector("#" + id).classList.remove("hide")
        })







    document.querySelector("#main")
        .addEventListener("click", function (evt) {

            let id = evt.target.getAttribute("data-img")
            // console.log(id)

            const img_big = document.querySelectorAll("[id^=img]")
            console.log(img_big)


            for (let i = 0; i < img_big.length; i++) {   // i를 content의 length만큼 반복
                img_big[i].classList.add("hide");  // content 모두 hide 클래스 추가
            }

            document.querySelector("#" + id).classList.remove("hide")

        })




    //-------------------------------------------------------------
    let left2 = 0;
    let top2 = 0;
    let step = 1;
    document.querySelector("#char").style.left = left2 + "px"
    addEventListener("keydown", function (event) {
        // console.log(event.keyCode)
        // 오른쪽 방향키
        if (event.keyCode == 39) {
            console.log(document.querySelector('#char').computedStyleMap.left)

            left2 += step
            document.querySelector("#char").style.left = left2 + "px"
        } else if (event.keyCode == 37) {
            left2 -= step
            document.querySelector("#char").style.left = left2 + "px"
        } else if (event.keyCode == 38) {
            top2 -= step
            document.querySelector("#char").style.top = top2 + "px"
        }else if (event.keyCode == 40){
            top2 +=step
            document.querySelector("#char").style.top = top2 + "px"
        }
    })












})