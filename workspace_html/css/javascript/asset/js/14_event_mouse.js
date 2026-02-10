window.onload = function () {
    bind();
}

function bind() {

    const log = document.querySelector("#log");

    // 마우스 오른쪽 버튼 방지
    const area = document.querySelector("#area");
    area.oncontextmenu = function () {
        return false;
    }

    // area.addEventListener("contextmenu", function(){
    //     alert(1);
    //     return false; // 안먹음
    //     // 추후에 event.preventDefualt() 배우면 가능해짐
    // })

    // 마우스로 drag 방지
    area.onselectstart = function () {
        return false;
    }

    area.addEventListener("dblclick", function () {
        let div = document.createElement("div");
        div.innerHTML = "더블클릭 발생";
        log.prepend(div);
    });

    area.addEventListener("mousedown", function () {
        let div = document.createElement("div");
        div.innerHTML = "mousedown 발생";
        log.prepend(div);
    });

    area.addEventListener("mouseup", function () {
        let div = document.createElement("div");
        div.innerHTML = "mouseup 발생";
        log.prepend(div);
    });

    area.addEventListener("click", function (evt) {
        // let div = document.createElement("div");
        // div.innerHTML = "click 발생";
        // log.prepend(div);

        /*
            offet:  * Dom 좌상단 기준
            page:   * 스크롤에 관계없이 문서 좌상단 기준

            client: 지금 보이는 화면 좌상단 기준
            screen: 모니터 좌상단 기준
        */

        console.log("offsetY: ", evt.offsetY);
        console.log("pageY: ", evt.pageY);
        console.log("clientY: ", evt.clientY);
        console.log("screenY: ", evt.screenY);
        showlog("click 발생");
    });

    // area.addEventListener("mouseenter", function () {
    area.addEventListener("mouseover", function () {
        showlog("mouseover 발생");
        area.style.backgroundColor = "yellowgreen";
    });

    // area.addEventListener("mouseleave", function () {
    area.addEventListener("mouseout", function () {
        showlog("mouseout 발생");
        area.style.backgroundColor = "white";
    });

    area.addEventListener("mousemove", function (evt) {
        const offsetX = evt.offsetX;
        const offsetY = evt.offsetY;

        showlog(`offsetX: ${offsetX}, offsetY: ${offsetY}`);
    });

    document.querySelector("body").addEventListener("mousemove", function (evt) {
        const cursor = document.querySelector("#cursor");

        cursor.style.left = (evt.pageX + 10) + "px";
        cursor.style.top = (evt.pageY + 10) + "px";
    });
    document.querySelector("body").addEventListener("mousemove", function (evt) {
        const police = document.querySelector("#police");

        if (isDrag == true) {

            police.style.display = "block";

            setTimeout(() => {
                police.style.left = (evt.pageX + 100) + "px";
                police.style.top = (evt.pageY + 10) + "px";
            }, 100);
        }

    });

    document.querySelector("body").addEventListener("mousemove", function (evt) {
        // 마우스 따라다니는 코드
        // 단, 마우스를 눌렀을 때만
        if (isDrag) {
            let drag = document.querySelector("#drag");
            drag.style.top = (evt.pageY - drag_offset_y) + "px";
            drag.style.left = (evt.pageX - drag_offset_x) + "px";
        }
    });

    document.querySelector("#drag").addEventListener("mousedown", function (evt) {
        evt.preventDefault();
        isDrag = true;
        drag_offset_x = evt.offsetX;
        drag_offset_y = evt.offsetY;
    });
    document.querySelector("#drag").addEventListener("mouseup", function () {
        if (isDrag) {
            isDrag = false;
            police.style.display = "none";
        }
    });

}
let isDrag = false;
let drag_offset_x = 0;
let drag_offset_y = 0;

function showlog(msg) {
    let div = document.createElement("div");
    div.innerHTML = msg;
    log.prepend(div);
}