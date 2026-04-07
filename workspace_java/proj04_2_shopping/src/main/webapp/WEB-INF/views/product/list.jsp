<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="shop.DTO.ProductDTO"%>
<%@ page import="shop.DTO.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>

	<%
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
	%>

	<%
	List<ProductDTO> productList = (List<ProductDTO>) request.getAttribute("productList");
	%>

	<div>
		<%
		if (loginUser != null) {
		%>
		<p><%=loginUser.getUserName()%>님 환영합니다</p>
		<a href="<%=request.getContextPath()%>/user/logout">로그아웃</a> 
		<a href="<%=request.getContextPath()%>/cart/list">장바구니</a>
		<a href="<%=request.getContextPath()%>/user/mypage">마이페이지</a>
		<%
		}
		%>
	</div>

	<hr>

	<h1>상품 목록</h1>

	<div>
		<a href="<%=request.getContextPath()%>/product/add">상품 등록</a>
	</div>

	<br>

	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>재고</th>
			<th>등록일</th>
		</tr>

		<%
		if (productList != null && !productList.isEmpty()) {
			for (ProductDTO dto : productList) {
		%>
		<tr>
			<td><%=dto.getProductNo()%></td>
			<td>
				<a href="<%=request.getContextPath()%>/product/detail?productNo=<%=dto.getProductNo()%>">
					<%=dto.getProductName()%>
				</a>
			</td>
			<td><%=dto.getProductPrice()%></td>
			<td><%=dto.getStockQty()%></td>
			<td><%=dto.getCreatedAt()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="5">등록된 상품이 없습니다.</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>