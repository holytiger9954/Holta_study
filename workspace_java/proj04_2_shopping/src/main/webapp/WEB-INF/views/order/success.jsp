<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료</title>
<script>
	alert("결제가 완료되었습니다.");
</script>
</head>
<body>

	<h1>주문 완료</h1>
	<p>결제가 완료되었습니다.</p>

	<a href="<%=request.getContextPath()%>/product/list">상품 목록으로</a>
	<a href="<%=request.getContextPath()%>/cart/list">장바구니로</a>

</body>
</html>