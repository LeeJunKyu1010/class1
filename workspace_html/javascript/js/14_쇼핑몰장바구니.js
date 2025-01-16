window.addEventListener("load", function () {
    let cnt1 = 0; // 장바구니 카운트를 저장할 변수
    let item = []; // 장바구니에 담긴 아이템을 저장할 배열

    document.querySelector("#추가").addEventListener('click', function (event) {
        let q = document.querySelectorAll(".q"); // 라디오 선택칸
        document.querySelector(".cnt").classList.remove('hide'); // 장바구니에 담으면 장바구니에 숫자 카운트하는 div hide 클래스 제거
        let item_name = document.querySelectorAll(".item_name");

        // 선택 되면 장바구니에 추가하는 기능-------------------------------------------
        let checkedCount = 0;
        for (let i = 0; i < q.length; i++) {
            if (q[i].checked) {
                checkedCount++;
                let itemname = item_name[i].querySelector("span").textContent;
                let itemPrice = q[i].closest(`[class^="list"]`).querySelector(`[class^="pay"] span`).textContent;
                item.push({ name: itemname, price: itemPrice });
                q[i].checked = false;
            }
        }

        if (checkedCount > 0) {
            cnt1 += checkedCount;
            document.querySelector(".cnt").innerHTML = cnt1;
        }
    });
    //---------------------------------------------------------------------



    // 장바구니를 클릭하면 선택된 목록을 보여주는 기능
    document.querySelector("#장바구니").addEventListener("click", function () {


        let 장바구니목록 = document.querySelector("#장바구니목록");
        장바구니목록.classList.remove('hide')

        장바구니목록.innerHTML = ""; // 기존 목록 초기화

        let 결제칸 = document.createElement("div")
        결제칸.className = "결제칸"

        let 전체선택 = document.createElement("input");
        전체선택.type = "checkbox";
        전체선택.className = "전체선택";

        let 전체삭제 = document.createElement("button")
        전체삭제.className = "전체삭제"
        전체삭제.textContent = "전체삭제"

        let 결제버튼 = document.createElement("button")
        결제버튼.className = "결제버튼"
        결제버튼.textContent = "결제버튼"

        let div1 = document.createElement("div");
        div1.className = "div1"
        let h1 = document.createElement("h1")
        h1.textContent = "상품 LIST"
        h1.className = "h1"



        if (item.length === 0) {
            장바구니목록.innerHTML = "<p>장바구니가 비어있습니다.</p>";
        } else {


            item.forEach(item => {
                let div2 = document.createElement("div");
                div2.className = "div2"
                let div3 = document.createElement("div");
                let div4 = document.createElement("div");
                let chk = document.createElement("input") // 선택 박스
                chk.type = "checkbox"
                chk.className = "chk"
                let del = document.createElement("input")
                del.type = "button"
                del.className = "del"
                del.value = "삭제"

                div3.textContent = `상품명 : ${item.name}`;
                div4.textContent = `가격 : ${item.price}원`;
                div1.append(div2)
                div2.append(chk)
                div2.append(del);
                div2.append(div3);
                div2.append(div4);

                del.addEventListener("click", function (event) {
                    if (chk.checked) {
                        div2.remove();
                        // 카운트 감소
                        cnt1--;
                        document.querySelector(".cnt").innerHTML = cnt1;

                        // 카운트가 0이 되면 hide 클래스 추가
                        if (cnt1 === 0) {
                            document.querySelector(".cnt").classList.add('hide');
                        }

                        // item 배열에서도 해당 아이템 제거
                        let index = item.findIndex(i => i.name === item.name && i.price === item.price);
                        if (index > -1) {
                            item.splice(index, 1);
                        }
                    }
                });
            });

            장바구니목록.append(h1)
            장바구니목록.append(결제칸)
            결제칸.append(전체선택);
            결제칸.append(전체삭제)
            결제칸.append(결제버튼)
            장바구니목록.append(div1);


            전체선택.addEventListener("click", function () {
                let checkboxes = document.querySelectorAll('.chk');
                checkboxes.forEach(checkbox => {
                    checkbox.checked = this.checked;
                });
            });
            
            전체삭제.addEventListener("click",function(){
                if(전체선택.checked){
                    div1.remove();
                    전체선택.checked = false;
                    cnt1--;
                    document.querySelector(".cnt").innerHTML = cnt1;
                    document.querySelector(".cnt").classList.add("hide")
                    item = []
                    장바구니목록.classList.add("hide")
                    
                }
            })


            결제버튼.addEventListener("click", function () {
                let totalPrice = 0;
                let checkedItems = document.querySelectorAll('.div2 .chk:checked');

                checkedItems.forEach(checkbox => {
                    // 체크박스의 부모 div2에서 가격 정보를 찾습니다
                    let priceText = checkbox.closest('.div2').querySelector('div:last-child').textContent;
                    // "가격 : 300원" 같은 문자열에서 숫자만 추출합니다
                    let price = parseInt(priceText.replace(/[^0-9]/g, ''));
                    totalPrice += price;
                });

                if (checkedItems.length > 0) {
                    alert(`총 결제 금액: ${totalPrice}원`);
                    장바구니목록.classList.add("hide")
                    cnt1 = 0
                    document.querySelector(".cnt").innerHTML = cnt1;
                    document.querySelector(".cnt").classList.add("hide")
                    item = []
                } else {
                    alert('선택된 상품이 없습니다.');
                }

            });
        }

        장바구니목록.scrollIntoView({ behavior: "smooth" });


    });



});