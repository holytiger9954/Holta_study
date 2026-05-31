<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 페이지</title>
</head>
<body>

	<form action="search" method="get">
		<%-- 		이름 검색: <input type="text" name="ename" value="${param.ename}">  --%>
		<%-- 		최소 급여: <input type="text" name="sal" value="${param.sal}"> --%>

		<select name="type">
			<option value="ename" ${param.type == 'ename' ? 'selected' : ''}>ename</option>
			<option value="sal" ${param.type == 'sal' ? 'selected' : ''}>sal(이상)</option>
			<option value="job" ${param.type == 'job' ? 'selected' : ''}>job</option>
		</select> <input type="text" name="keyword" value="${param.keyword}">

		<button type="submit">검색</button>
	</form>

	<hr>
	<form action="choice" method="get">
		<c:if test="${not empty list}">
			<h3>검색 결과</h3>
			<c:forEach var="item" items="${list}">
				<input type="checkbox" name="empnos" value="${item.empno }">
	        ${item.empno} / ${item.ename} / ${item.job}
	        <a
					href="${pageContext.request.contextPath}/detail?empno=${item.empno}">상세보기</a>
				<hr>
			</c:forEach>
		</c:if>

		<input type="submit" value="선택 조회">
	</form>

	<hr>
	<hr>

	<select id="type" name="type">
    <option value="ename">ename</option>
    <option value="sal">sal(이상)</option>
    <option value="job">job</option>
</select>

<input type="text" id="keyword" name="keyword">

<button type="button" id="searchBtn">검색</button>

<button type="button" id="choiceBtn">선택 조회</button>

<hr>

<div id="resultArea"></div>

<script>

	// URL 만들기 클래스
	class MyURLSearchParams {

	    constructor() {
	        this.params = [];
	    }
	
	    append(key, value) {
	        this.params.push(
	            encodeURIComponent(key) + "=" + encodeURIComponent(value)
	        );
	    }
	
	    toString() {
	        return this.params.join("&");
	    }
	}

    // 검색 AJAX
    document.querySelector("#searchBtn").addEventListener("click", async function() {

        const type = document.querySelector("#type").value;
        const keyword = document.querySelector("#keyword").value;

        const url = "ajaxSearch?type=" + type + "&keyword=" + encodeURIComponent(keyword);

        const response = await fetch(url);
        const list = await response.json();

        console.log(list);

        drawList(list);
    });


    // 선택 조회 AJAX
    document.querySelector("#choiceBtn").addEventListener("click", async function() {

        const checkedList =
            document.querySelectorAll("input[name='empnos']:checked");

        if (checkedList.length === 0) {
            alert("선택된 사원이 없습니다.");
            return;
        }

//         const params = new URLSearchParams();
        const params = new MyURLSearchParams();

        checkedList.forEach(function(chk) {
            params.append("empnos", chk.value);
        });

        console.log(params.toString());

        const response =
            await fetch("ajaxChoice?" + params.toString());

        const list = await response.json();

        console.log(list);

        drawList(list);
    });


    // 화면 출력 함수
    function drawList(list) {

        const resultArea =
            document.querySelector("#resultArea");

        resultArea.innerHTML = "";

        if (list.length === 0) {
            resultArea.innerHTML =
                "<p>검색 결과가 없습니다.</p>";
            return;
        }

        let html = "<h3>검색 결과</h3>";

        list.forEach(function(item) {

            html += `
                <div>
                    <input type="checkbox"
                           name="empnos"
                           value="\${item.empno}">

                    \${item.empno}
                    /
                    \${item.ename}
                    /
                    \${item.job}
                    /
                    \${item.sal}

                    <a href="${pageContext.request.contextPath}/detail?empno=\${item.empno}">
                        상세보기
                    </a>
                </div>

                <hr>
            `;
        });

        resultArea.innerHTML = html;
    }

</script>
</body>
</html>