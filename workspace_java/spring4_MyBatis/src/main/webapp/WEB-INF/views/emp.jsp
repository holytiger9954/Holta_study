<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP List</title>
</head>
<body>

	<form action="list" method="get">

		<button type="submit">리스트 보기</button>

		<c:if test="${not empty list}">
			<h3>리스트 결과</h3>
			<c:forEach var="item" items="${list}">
       			 ${item.empno} / ${item.ename} / ${item.job} 
       			 <a
					href="${pageContext.request.contextPath}/detail?empno=${item.empno}">상세보기</a>
				<hr>
			</c:forEach>
		</c:if>

	</form>

	<form action="one" method="get">

		<button type="submit">한 명 DTO</button>

		<c:if test="${not empty emp}">
			<h3>DTO 결과</h3>
    		사원번호 : ${emp.empno}<br>
    		이름 : ${emp.ename}<br>
    		직무 : ${emp.job}<br>
		</c:if>

	</form>

	<form action="oneMap" method="get">

		<button type="submit">한 명 Map</button>

		<c:if test="${not empty map}">
			<h3>Map 결과</h3>
    		사원번호 : ${map.EMPNO}<br>
    		이름 : ${map.ENAME}<br>
    		직무 : ${map.JOB}<br>
		</c:if>

	</form>

	<hr>

	<button type="button" id="btnList">리스트 조회</button>
	<button type="button" id="btnOne">DTO 한 명 조회</button>
	<button type="button" id="btnMap">Map 한 명 조회</button>

	<hr>

	<div id="result"></div>

	<script>
document.querySelector("#btnList").addEventListener("click", async function () {
    const response = await fetch("ajaxList");
    const list = await response.json();

    console.log(list);

    let html = "<h3>리스트 결과</h3>";

    list.forEach(function (emp) {
        html += `
            사원번호 : \${emp.empno}<br>
            이름 : \${emp.ename}<br>
            직무 : \${emp.job}<br>
            급여 : \${emp.sal}<br>
            <hr>
        `;
    });

    document.querySelector("#result").innerHTML = html;
});

document.querySelector("#btnOne").addEventListener("click", async function () {
    const response = await fetch("ajaxOne");
    const emp = await response.json();

    console.log(emp);

    let html = `
        <h3>DTO 한 명 결과</h3>
        사원번호 : \${emp.empno}<br>
        이름 : \${emp.ename}<br>
        직무 : \${emp.job}<br>
        급여 : \${emp.sal}<br>
    `;

    document.querySelector("#result").innerHTML = html;
});

document.querySelector("#btnMap").addEventListener("click", async function () {
    const response = await fetch("ajaxOneMap");
    const map = await response.json();

    console.log(map);

    let html = `
        <h3>Map 한 명 결과</h3>
        사원번호 : \${map.EMPNO}<br>
        이름 : \${map.ENAME}<br>
        직무 : \${map.JOB}<br>
        급여 : \${map.SAL}<br>
    `;

    document.querySelector("#result").innerHTML = html;
});
</script>

</body>
</html>