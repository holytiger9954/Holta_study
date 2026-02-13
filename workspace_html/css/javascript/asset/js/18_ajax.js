window.addEventListener("load", bind);

function bind() {
    const btn1 = document.querySelector("#btn1");
    btn1.addEventListener("click", function () {

        // ajax 객체 생성
        const xhr = new XMLHttpRequest();

        // 보낼 준비
        // 방식: method, 전달인자: 방식, 주소
        xhr.open("get", "https://jsonplaceholder.typicode.com/users");

        // 보내기
        xhr.send();
        console.log(0, xhr.responseText);

        // 다녀온 후
        xhr.onload = function () {
            console.log("다녀왔어");
            console.log(xhr.responseText); // text로 받는다

            // 깜짝 퀴즈
            const json = JSON.parse(xhr.responseText);
            // 두 번째 사람의 이름을 출력한다
            console.log(json[1].name);
            // 세 번째 사람의 lat를 출력한다
            console.log(json[2].address.geo.lat);

            const member = JSON.parse(xhr.responseText);

            console.log(member);
            console.log(member[1].name);
            console.log(member[1]["name"]);

            console.log(member[2].address.geo.lat);
            console.log(member[2]["address"]["geo"]["lat"]);
        };

    });

    document.querySelector("#btn2").addEventListener("click", function () {

        const xhr = new XMLHttpRequest();

        xhr.open("get", "17_json.html");
        xhr.send();

        xhr.onload = function () {
            console.log(xhr.responseText);
        }
    });

    document.querySelector("#btn3").addEventListener("click", function () {

        const xhr = new XMLHttpRequest();

        const key = "b66f24b7eced1ee05271a73630eb96afd5c4776f7396353ea57a7b050ce79330";
        let url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";
        url += '?serviceKey=' + key;
        url += '&numOfRows=1000';
        url += '&pageNo=1';
        url += '&dataType=JSON';
        url += '&base_date=20260212';
        url += '&base_time=1300';
        url += '&nx=63';
        url += '&ny=110';

        xhr.open("get", url);
        xhr.send();

        xhr.onload = function () {
            // console.log(xhr.responseText);

            const data = JSON.parse(xhr.responseText);
            console.log(data);

            // 1
            console.log(`
                첫번째 자료의 category, fcstValue: 
                ${data.response.body.items.item[0].category}, 
                ${data.response.body.items.item[0].fcstValue}
                `);

            // 2
            const item = data.response.body.items.item;
            const tbody = document.querySelector("#weather-body");

            let htmlContent = "";
            let index = 1;

            // 시간 별로 정렬하기
            // 방법1
            item.sort((a, b) => a.fcstTime.localeCompare(b.fcstTime));

            for (let i = 0; i < item.length; i++) {
                if (item[i].category === "T1H"
                    || item[i].category === "RN1"
                    || item[i].category === "REH") {
                    console.log(item[i]);

                    // 3            
                    htmlContent +=
                        `
                        <tr>
                            <td>${index++}</td>
                            <td>${item[i].baseDate}</td>
                            <td>${item[i].baseTime}</td>
                            <td>${item[i].category}</td>
                            <td>${item[i].fcstDate}</td>
                            <td>${item[i].fcstTime}</td>
                            <td>${item[i].fcstValue}</td>
                            <td>${item[i].nx}</td>
                            <td>${item[i].ny}</td>
                        </tr>
                    `;
                }
            }
            tbody.innerHTML = htmlContent;
        }
    });

    const btn4 = document.querySelector("#btn4");
    btn4.addEventListener("click", function () {

        const url = "https://jsonplaceholder.typicode.com/users";

        const option = {
            method: "get"
        };

        // const xhr = new XMLHttpRequest();
        // xhr.open(option.method, url);
        // xhr.send();
        // xhr.onload = function () {
        //     let response = xhr.responseText;
        //     let json = JSON.parse(response);
        //     console.log(xhr.responseText);
        // };


        fetch(url, option).then(function (response) {
            return response.json();
        }).then(function (json) {
            console.log(json);
        }).catch(function (error) {
            console.error(error);
        });

    });

    const btn5 = document.querySelector("#btn5");
    btn5.addEventListener("click", function () {

        const xhr = new XMLHttpRequest();
        xhr.open("get", "https://jsonplaceholder.typicode.com/users");
        xhr.send();
        xhr.onreadystatechange = function () {
            console.log(xhr.readyState);
            if (xhr.readyState == 4) {
                // if(xhr.readyState == XMLHttpRequest.DONE){
                console.log("다녀왔어");
            }
        };

    });

    const btn6 = document.querySelector('#btn6');
    btn6.addEventListener('click', function () {
        $.ajax({
            url: 'https://jsonplaceholder.typicode.com/userss',
            type: 'get',    // method
            success: function (data) {
                console.log('성공')
                // 자동으로 json으로 바뀌어 온다
                console.log(data);
            },
            error: function (error) {
                console.log('실패');
                console.log(error);
            },
            complete: function () {
                console.log('무조건 실행');
            }
        });
    });

    const btn7 = document.querySelector('#btn7');
    btn7.addEventListener('click', function () {
        $.ajax({
            url: 'https://jsonplaceholder.typicode.com/users',
            type: 'get'
        }).done(function (data) {
            console.log('성공');
            // 자동으로 json으로 바뀌어 온다
            console.log(data);
        }).fail(function (error) {
            console.log('실패');
            console.log(error);
        }).always(function () {
            console.log('무조건 실행');
        });

    });

    btn4.addEventListener('click', async function () {

        const url = 'https://jsonplaceholder.typicode.com/users';
        const option = {
            method: 'get'
        }

        // fetch(url, option)
        //     .then(function (response) {
        //         return response.json();
        //     }).then(function (json) {
        //         console.log(json);
        //     }).catch(function (error) {
        //         console.error(error);
        //     });

        let response = await fetch(url, option);
        let json = await response.json();
        console.log(json);
    })

}

// 방법2
// let json = {
//     "1400": {
//         T1H: 8,
//         RN1: "강수없음",
//         REH: 45
//     },
//     "1500": {
//         T1H: 8,
//         RN1: "강수없음",
//         REH: 48
//     },
// };
// // console.log(json["1700"]);
// // if(json["1700"] == undefined){
// if(!json["1700"]){
//     json["1700"] = {};
// }
// json["1700"]["T1H"] = 9;


// let json = {};

// if (!json[item[i].fcstTime]) {
//     json[item[i].fcstTime] = {};
// }
// json[item[i].fcstTime][item[i].category] = item[i].fcstValue;

// let newHtml = "";
// let count = 1;

// for (let time in json) {
//     const data = json[time];

//     newHtml +=
//         `
//             <tr>
//                 <td>${count++}</td>
//                 <td>${time.substring(0, 2)}:00</td> <td>${data.T1H || '-'}℃</td>
//                 <td>${data.RN1 || '-'}</td>
//                 <td>${data.REH || '-'}%</td>
//                 </tr>
//         `;
// }

// tbody.innerHTML = newHtml;