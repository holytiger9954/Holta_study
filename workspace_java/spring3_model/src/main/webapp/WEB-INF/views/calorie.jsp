<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calorie</title>
</head>
<body>

	<h2>체내 칼로리 관리</h2>

	<h3>
		현재 체내 칼로리 : <span id="bodyCalorie">0</span> kcal
	</h3>

	<hr>

	<h3>음식 선택</h3>
	<select id="foodSelect">
		<option value="아메리카노" data-calorie="100">아메리카노 (100)</option>
		<option value="햄버거" data-calorie="600">햄버거 (600)</option>
		<option value="초콜릿" data-calorie="300">초콜릿 (300)</option>
	</select>
	<button id="eatBtn">먹기</button>

	<hr>

	<h3>운동 선택</h3>
	<select id="exerciseSelect">
		<option value="걷기" data-calorie="50">걷기 (50)</option>
		<option value="달리기" data-calorie="150">달리기 (150)</option>
		<option value="자전거" data-calorie="100">자전거 (100)</option>
	</select>
	<button id="exerciseBtn">운동하기</button>

	<hr>

	<h3>결과</h3>
	<div id="resultArea"></div>

	<script>
const contextPath = "${pageContext.request.contextPath}";

document.querySelector("#eatBtn").addEventListener("click", () => send("food"));
document.querySelector("#exerciseBtn").addEventListener("click", () => send("exercise"));

async function send(type) {
    const select = type === "food"
        ? document.querySelector("#foodSelect")
        : document.querySelector("#exerciseSelect");

    const param = {
        type: type,
        name: select.value,
        calorie: Number(select.options[select.selectedIndex].dataset.calorie)
    };

    const response = await fetch(contextPath + "/calorieAjax", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(param)
    });

    const data = await response.json();

    document.querySelector("#bodyCalorie").innerText = data.bodyCalorie;

    // 경고 메시지 처리
    let warning = "";

    if (data.bodyCalorie >= 1000) {
        warning = "<div style='color:red;'>상민아 운동해라</div>";
    }

    document.querySelector("#resultArea").innerHTML =
        data.name + " 처리됨 → 현재 칼로리: " + data.bodyCalorie + " kcal"
        + warning;
}
</script>

</body>
</html>