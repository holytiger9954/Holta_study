<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="shop.DTO.CartViewDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
	<%
	List<CartViewDTO> cartList = (List<CartViewDTO>) request.getAttribute("cartList");

	int totalSum = 0;
	%>

	<h1>장바구니</h1>

	<a href="<%=request.getContextPath()%>/product/list">상품 목록</a>
	<a href="<%=request.getContextPath()%>/cart/list">새로고침</a>

	<table border="1">
		<tr>
			<th>상품명</th>
			<th>가격</th>
			<th>수량</th>
			<th>총금액</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>

		<%
		if (cartList != null) {
			for (CartViewDTO dto : cartList) {
				totalSum += dto.getTotalPrice();
		%>
		<tr>
			<td><%=dto.getProductName()%></td>
			<td><%=dto.getProductPrice()%></td>

			<td>
				<form method="post"
					action="<%=request.getContextPath()%>/cart/update">
					<input type="hidden" name="cartNo" value="<%=dto.getCartNo()%>">
					<input type="text" name="cartQty" value="<%=dto.getCartQty()%>"
						size="3">
					<button>수정</button>
				</form>
			</td>

			<td><%=dto.getTotalPrice()%></td>

			<td>
				<form method="post"
					action="<%=request.getContextPath()%>/cart/delete"
					onsubmit="return confirm('삭제하시겠습니까?');">
					<input type="hidden" name="cartNo" value="<%=dto.getCartNo()%>">
					<button>삭제</button>
				</form>
			</td>
		</tr>
		<%
		}
		}
		%>

		<tr>
			<td colspan="3">총 합계</td>
			<td colspan="3"><%=totalSum%></td>
		</tr>

	</table>

	<br>

	<form method="post" action="<%=request.getContextPath()%>/order/add"
		onsubmit="return confirm('주문하시겠습니까?');">
		<button type="submit">주문하기</button>
	</form>

</body>
</html>