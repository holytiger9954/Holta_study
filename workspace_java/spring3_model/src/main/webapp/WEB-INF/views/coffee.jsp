<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coffee</title>
</head>
<body>

	<h2>커피 주문</h2>

	<!--  SSR용 FORM -->
	<form action="${pageContext.request.contextPath}/orderCoffeeSSR"
		method="post">

		<button type="button" id="addBtn">추가</button>

		<div id="orderArea">
			<div class="order-row">
				커피 종류 : 
				<select name="menu" class="coffeeType">
					<option value="아아" data-price="2000">아아</option>
					<option value="얼박사" data-price="1500">얼박사</option>
				</select> 
					  <input type="hidden" name="price" value="2000"> 
				개수: <input type="number" name="count" class="count" value="1" min="1">
			</div>
		</div>

		<!-- SSR 버튼 -->
		<button type="submit">주문하기 (SSR)</button>

		<!-- CSR 버튼 -->
		<button type="button" id="orderBtn">주문하기 (CSR)</button>

	</form>

	<hr>

	<h3>주문한 내역</h3>
	<div id="resultArea">

		<!--  SSR 결과 출력 -->
		<c:if test="${not empty orders}">
			<c:forEach var="order" items="${orders}">
				<div>${order.menu}x ${order.count}</div>
			</c:forEach>

			<hr>
			<div>총액 : ${totalPrice} 원</div>
		</c:if>

	</div>

	<script>

const contextPath = "${pageContext.request.contextPath}";

const coffeeList = [
    { name: "아아", price: 2000 },
    { name: "얼박사", price: 1500 }
];


//  행 추가
document.querySelector("#addBtn").addEventListener("click", function () {
    const orderArea = document.querySelector("#orderArea");

    const row = document.createElement("div");
    row.className = "order-row";

    row.innerHTML = `
        커피 종류 :
        <select name="menu" class="coffeeType">
            \${coffeeList.map(c => `
                <option value="\${c.name}" data-price="\${c.price}">
                    \${c.name}
                </option>
            `).join("")}
        </select>

        <input type="hidden" name="price" value="2000">

        개수:
        <input type="number" name="count" class="count" value="1" min="1">
    `;

    orderArea.appendChild(row);
});


//  select 바뀌면 price 갱신 (SSR용)
document.addEventListener("change", function (e) {
    if (e.target.classList.contains("coffeeType")) {
        const row = e.target.closest(".order-row");
        const priceInput = row.querySelector("input[name='price']");
        priceInput.value = e.target.options[e.target.selectedIndex].dataset.price;
    }
});


//  CSR 주문
document.querySelector("#orderBtn").addEventListener("click", async function () {

    const rows = document.querySelectorAll(".order-row");
    const orders = [];

    rows.forEach(row => {
        const select = row.querySelector(".coffeeType");
        const count = row.querySelector(".count");

        orders.push({
            menu: select.value,
            price: Number(select.options[select.selectedIndex].dataset.price),
            count: Number(count.value)
        });
    });

    const response = await fetch(contextPath + "/orderCoffee", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(orders)
    });

    const data = await response.json();

    renderResult(data);
    resetOrderArea();
});


//  CSR 결과 출력
function renderResult(data) {
    const resultArea = document.querySelector("#resultArea");

    let html = "";

    data.orders.forEach(order => {
        html += `
            <div>
                \${order.menu} x \${order.count}
            </div>
        `;
    });

    html += `
        <hr>
        <div>총액 : \${data.totalPrice} 원</div>
    `;

    resultArea.innerHTML = html;
}

// CSR - 주문 후 초기화
function resetOrderArea() {
    const orderArea = document.querySelector("#orderArea");

    // 첫 번째 row만 남김
    const firstRow = orderArea.querySelector(".order-row");

    orderArea.innerHTML = "";
    orderArea.appendChild(firstRow);

    // 값 초기화
    const select = firstRow.querySelector(".coffeeType");
    const count = firstRow.querySelector(".count");

    const priceInput = firstRow.querySelector("input[name='price']");

    select.selectedIndex = 0;
    count.value = 1;
    priceInput.value = select.options[select.selectedIndex].dataset.price;
}

</script>

</body>
</html>