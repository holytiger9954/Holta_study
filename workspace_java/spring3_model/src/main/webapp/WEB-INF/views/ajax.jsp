<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
</head>
<body>

	<h1>ajax.jsp</h1>

	<button type="button" id="btn1">ajax 실행1</button>
	<button type="button" id="btn2">ajax 실행2</button>
	<button type="button" id="btn3">ajax 실행3</button>
	<button type="button" id="btn4">ajax 실행4</button>
	<button type="button" id="btn5">ajax 실행5</button>
	<button type="button" id="btn6">ajax 실행6</button>
	<button type="button" id="btn7">ajax 실행7</button>
	<div id="result"></div>

	<script>

	document.querySelector("#btn1").addEventListener("click", function(){
		console.log("1 click!!")
		
		const url = "http://localhost:8080/human3/ajax1?id=hambugi1";

        const option = {
            method: "get"
        };

        fetch(url, option).then(function (response) {
            return response.text();
        }).then(function (data) {
            console.log(data);
        }).catch(function (error) {
            console.error(error);
        });
	})
	
	document.querySelector("#btn2").addEventListener("click", function(){
		console.log("2 click!!")
		
		// const form = new FormData();
		// form.append();
		
		const url = "http://localhost:8080/human3/ajax1";

        const option = {
            method: "post",
            headers: {
            	'Content-Type': 'application/x-www-form-urlencoded'
            },
//          body: form
            body: "id=hambugi2"
        };

        fetch(url, option).then(function (response) {
            return response.text();
        }).then(function (data) {
            console.log(data);
        }).catch(function (error) {
            console.error(error);
        });
	})
	
	document.querySelector("#btn3").addEventListener("click", function(){
		console.log("3 click!!")
		
		let param = {
			id: 'hambugi3'
		}
		
		const url = "ajax2";

        fetch(url, {
//          method: "get", // get은 안됨
            method: "post",
            headers: {
            	'Content-Type': 'application/json'
            },
            body: JSON.stringify(param)
        }).then(function (response) {
            return response.text();
        }).then(function (data) {
            console.log(data);
        }).catch(function (error) {
            console.error(error);
        });
	})
	
	document.querySelector("#btn4").addEventListener("click", function(){
		console.log("4 click!!")
		
		const url = "ajax2";
		let param = {
			id: 'hambugi4'
		}

		const xhr = new XMLHttpRequest();
		xhr.open("post", url)
		xhr.setRequestHeader('Content-Type', 'application/json')
		xhr.send(JSON.stringify(param))
		xhr.onload = function() {
			console.log(xhr.responseText)
		}
		
	})	
	
	document.querySelector("#btn5").addEventListener("click", async function(){
		console.log("5 click!!")
		
		let param = {
			id: 'hambugi5'
		}
		
		const url = "ajax2";

        const response = 
        await fetch(url, {
            method: "post",
            headers: {
            	'Content-Type': 'application/json'
            },
            body: JSON.stringify(param)
        })
        
        const data = await response.text();
        console.log(data);
        
	})
	
	document.querySelector("#btn6").addEventListener("click", async function(){
		console.log("6 click!!")
		
		let param = {
			id: 'hambugi6'
		}
		
//		const url = "ajax3";
//		const url = "ajax4";
		const url = "ajax5";

        const response = 
        await fetch(url, {
            method: "post",
            headers: {
            	'Content-Type': 'application/json'
            },
            body: JSON.stringify(param)
        })
        
//      const data = await response.text();
        const data = await response.json();
        console.log(data);
        
	})
	
	document.querySelector("#btn7").addEventListener("click", async function(){
	    console.log("7 click!!");
	
	    const response = await fetch("ajax6", {
	        method: "POST"
	    });
	
	    const data = await response.json();
	    console.log(data);
	
	    let html = "";
	
	    html += `<p>totalCount: \${data.totalCount}</p>`;
	    html += `<p>pageNo: \${data.pageNo}</p>`;
	    html += `<p>keyword: \${data.keyword}</p>`;
	    
	    html += "<ul>";

	    data.list.forEach(function(item){
	        html += `
	            <li>
	                id: \${item.id} /
	                pw: \${item.pw} /
	                email: \${item.email}
	            </li>
	        `;
	    });

	    html += "</ul>";
	
	    const result7 = document.querySelector("#result");
	    console.log("result =", result);
	
	    result7.innerHTML = html;
	});
	
</script>

</body>
</html>