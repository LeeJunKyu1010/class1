window.addEventListener("load", function () {

    // let random = function () {
    //     return parseInt(Math.random() * 45) + 1
    // }
    // console.log(random())


    let lotto = []

    while (lotto.length < 6) {
        console.log("lotto.length :", lotto.length)

        let value = parseInt(Math.random() * 45) + 1;

        let dup = false;
        for (let i = 0; i < lotto.length; i++) {
            if (lotto[i] == value) {
                dup = true;
                break;
            }
        }

        if (!dup) {
            lotto.push(value)
        }

    }
    lotto.sort(function (x, y) {
        return x - y;
    })
    console.log("lotto : ", lotto)

    // for문으로 로또 뽑기 하다가 멈춘거

    // let e = 0
    // for (let i = 0; i < 6; i++) {
    //     lotto.push(random())
    //     // console.log(lotto)


    // }


    // lotto.sort(function (a, b) {         // 배열 정렬 하기
    //     return a - b
    // });
    // console.log("lotto :", lotto)


    //--------------------------------------------------------------------------



    let lotto2 = []
    lotto2.push(7);
    lotto2.push(3);
    lotto2.push(5);
    lotto2.push(8);
    console.log("lotto2_원본 : ", lotto2)

    let value = 5;


    //value 가 이미 lotto 있었는지 확인해서
    // "이미 있다", "없었다" 둘 중 하나를 출력
    let q = 0;
    for (let i = 0; i < lotto2.length; i++) {
        // console.log("lotto2[i] : ",lotto2[i])

        if (lotto2[i] == value) { // lotto2가 value의 값과 같을때까지 q에 1씩 더하기
            q++;
        }
    }
    // for문 밖에 적기
    // q가 0보다 크면 참
    if (q > 0) {
        console.log("lotto와 value의 값 중복이 있다.")
    } else
        console.log("lotto와 value의 값 중복이 없다.")


    //--------------------------------------------------------------------------   


    let dup = false;
    for (let i = 0; i < lotto2.length; i++) {
        if (lotto2[i] == value) {
            dup = true;
            console.log("있다")
            break;
        }


    }
    //--------------------------------------------------------------------------   


    const mail1 = "todair@naver.com";
    const arr_mail1 = mail1.split("@");

    let id1 = arr_mail1[0];
    console.log(id1)

    const idxAt = mail1.indexOf("@");
    console.log(idxAt)
    let id2 = mail1.substring(0, idxAt)
    let id3 = mail1.substr(0, idxAt);
    console.log(id2, id3)

    const left2 = id1.substring(0,2);
    const star_length = id1.length - 2;
    let star = "";
    for (let i=0; i<star_length; i++){
        star += "*";
    }
    left2+star+"@"+arr_mail1[1]
    console.log(left2+star+"@"+arr_mail1[1])

    //--------------------------------------------------------------------------



    let domain = "cafe.naver.com"
    let idx = domain.indexOf(".");
    console.log(idx)
    
    const domain2 = domain.substr(idx+1);
    console.log(domain2)
    idx = domain.indexOf(".");
    const domain3 = domain2.substr(0,idx);
    console.log(domain3)

})