<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="shop.DTO.ProductDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>

	<%
	ProductDTO product = (ProductDTO) request.getAttribute("product");
	%>
	
	<h1>상품 수정</h1>

	<form method="post"
		action="<%=request.getContextPath()%>/product/update">
		<input type="hidden" name="productNo"
			value="<%=product.getProductNo()%>">

		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>상품명</th>
				<td><input type="text" name="productName"
					value="<%=product.getProductName()%>"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="productPrice"
					value="<%=product.getProductPrice()%>"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td><textarea name="productContent" rows="5" cols="40"><%=product.getProductContent()%></textarea>
				</td>
			</tr>
			<tr>
				<th>재고</th>
				<td><input type="text" name="stockQty"
					value="<%=product.getStockQty()%>"></td>
			</tr>
		</table>

		<br>

		<button type="submit">수정 완료</button>
		<a
			href="<%=request.getContextPath()%>/product/detail?productNo=<%=product.getProductNo()%>">상세</a>
		<a href="<%=request.getContextPath()%>/product/list">목록</a>
	</form>

</body>
</html>