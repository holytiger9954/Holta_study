<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>

	<h1>상품 등록</h1>

	<form method="post"
		action="<%=request.getContextPath()%>/product/add">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>상품명</th>
				<td><input type="text" name="productName"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="productPrice" placeholder="숫자만 입력 (예: 10000)"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td><textarea name="productContent" rows="5" cols="40"></textarea></td>
			</tr>
			<tr>
				<th>재고</th>
				<td><input type="text" name="stockQty"></td>
			</tr>
		</table>

		<br>

		<button type="submit">등록</button>
		<a href="<%=request.getContextPath()%>/product/list">등록 취소</a>
	</form>

</body>
</html>