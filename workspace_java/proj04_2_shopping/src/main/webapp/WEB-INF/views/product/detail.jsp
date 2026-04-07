<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="shop.DTO.ProductDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="shop.DTO.ReviewDTO"%>
<%@ page import="shop.DTO.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
</head>
<body>

	<%
	ProductDTO product = (ProductDTO) request.getAttribute("product");
	List<ReviewDTO> reviewList = (List<ReviewDTO>) request.getAttribute("reviewList");
	Boolean canWriteReview = (Boolean) request.getAttribute("canWriteReview");
	ReviewDTO myReview = (ReviewDTO) request.getAttribute("myReview");
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
	%>
	<h1>상품 상세</h1>

	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>상품번호</th>
			<td><%=product.getProductNo()%></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><%=product.getProductName()%></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><%=product.getProductPrice()%></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><%=product.getProductContent()%></td>
		</tr>
		<tr>
			<th>재고</th>
			<td><%=product.getStockQty()%></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><%=product.getCreatedAt()%></td>
		</tr>
		<tr>
			<th>수정일</th>
			<td><%=product.getUpdatedAt()%></td>
		</tr>
	</table>

	<br>

	<a href="<%=request.getContextPath()%>/product/list">목록</a>
	<a href="<%=request.getContextPath()%>/product/update?productNo=<%=product.getProductNo()%>">수정</a>

	<form method="post"
		action="<%=request.getContextPath()%>/product/delete"
		onsubmit="return confirm('정말 삭제하시겠습니까?');" style="display: inline;">
		<input type="hidden" name="productNo"
			value="<%=product.getProductNo()%>">
		<button type="submit">삭제</button>
	</form>

	<form method="post" action="<%=request.getContextPath()%>/cart/add">
		<input type="hidden" name="productNo"
			value="<%=product.getProductNo()%>">

		<div>
			수량: <input type="text" name="qty" value="1">
		</div>

		<div>
			<button type="submit">장바구니 담기</button>
		</div>
	</form>

	<%
	String cartAdded = request.getParameter("cartAdded");
	%>

	<%
	if ("true".equals(cartAdded)) {
	%>
	<p style="color: blue;">장바구니에 담겼습니다.</p>
	<%
	}
	%>

	<%
	if ("false".equals(cartAdded)) {
	%>
	<p style="color: red;">장바구니 담기에 실패했습니다.</p>
	<%
	}
	%>
	<hr>
	<h2>리뷰</h2>

	<h3>리뷰 목록</h3>

	<%
	if (reviewList != null && !reviewList.isEmpty()) {
		for (ReviewDTO review : reviewList) {
	%>
	<div
		style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
		<p>
			작성자 번호:
			<%=review.getUserNo()%></p>
		<p>
			별점:
			<%=review.getRating()%></p>
		<p>
			내용:
			<%=review.getReviewContent()%></p>
		<p>
			작성일:
			<%=review.getCreatedAt()%></p>

		<%
		if (loginUser != null && loginUser.getUserNo() == review.getUserNo()) {
		%>
		<form method="post"
			action="<%=request.getContextPath()%>/review/update">
			<input type="hidden" name="reviewNo"
				value="<%=review.getReviewNo()%>"> <input type="hidden"
				name="productNo" value="<%=product.getProductNo()%>">

			<div>
				별점: <select name="rating">
					<option value="5" <%=review.getRating() == 5 ? "selected" : ""%>>5점</option>
					<option value="4" <%=review.getRating() == 4 ? "selected" : ""%>>4점</option>
					<option value="3" <%=review.getRating() == 3 ? "selected" : ""%>>3점</option>
					<option value="2" <%=review.getRating() == 2 ? "selected" : ""%>>2점</option>
					<option value="1" <%=review.getRating() == 1 ? "selected" : ""%>>1점</option>
				</select>
			</div>

			<div>
				<textarea name="reviewContent" rows="3" cols="40"><%=review.getReviewContent()%></textarea>
			</div>

			<button type="submit">수정</button>
		</form>

		<form method="post"
			action="<%=request.getContextPath()%>/review/delete"
			onsubmit="return confirm('리뷰를 삭제하시겠습니까?');">
			<input type="hidden" name="reviewNo"
				value="<%=review.getReviewNo()%>"> <input type="hidden"
				name="productNo" value="<%=product.getProductNo()%>">
			<button type="submit">삭제</button>
		</form>
		<%
		}
		%>
	</div>
	<%
	}
	} else {
	%>
	<p>등록된 리뷰가 없습니다.</p>
	<%
	}
	%>

	<%
	if (loginUser != null && Boolean.TRUE.equals(canWriteReview)) {
	%>
	<h3>리뷰 작성</h3>
	<form method="post" action="<%=request.getContextPath()%>/review/add">
		<input type="hidden" name="productNo"
			value="<%=product.getProductNo()%>">

		<div>
			별점: <select name="rating">
				<option value="5">5점</option>
				<option value="4">4점</option>
				<option value="3">3점</option>
				<option value="2">2점</option>
				<option value="1">1점</option>
			</select>
		</div>

		<div>
			내용:
			<textarea name="reviewContent" rows="4" cols="50"></textarea>
		</div>

		<div>
			<button type="submit">리뷰 등록</button>
		</div>
	</form>
	<%
	} else if (loginUser != null && myReview != null) {
	%>
	<p>이미 이 상품에 리뷰를 작성했습니다.</p>
	<%
	} else if (loginUser != null) {
	%>
	<p>이 상품을 주문한 회원만 리뷰를 작성할 수 있습니다.</p>
	<%
	}
	%>

</body>
</html>