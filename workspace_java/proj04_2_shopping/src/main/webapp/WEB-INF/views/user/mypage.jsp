<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="shop.DTO.UserDTO"%>

<%
UserDTO user = (UserDTO) request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

	<h1>마이페이지</h1>

	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>회원번호</th>
			<td><%=user.getUserNo()%></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=user.getUserId()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=user.getUserName()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=user.getUserTel()%></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=user.getUserAddr()%></td>
		</tr>
		<tr>
			<th>권한</th>
			<td><%=user.getUserRole()%></td>
		</tr>
		<tr>
			<th>가입일</th>
			<td><%=user.getCreatedAt()%></td>
		</tr>
	</table>

	<br>

	<a href="<%=request.getContextPath()%>/product/list">상품 목록</a>
	<a href="<%=request.getContextPath()%>/user/update">내 정보 수정</a>
	<a href="<%=request.getContextPath()%>/user/logout">로그아웃</a>

	<form method="post"
		action="<%=request.getContextPath()%>/user/delete"
		onsubmit="return confirm('정말 탈퇴하시겠습니까?');" style="display: inline;">
		<button type="submit">회원 탈퇴</button>
	</form>

</body>
</html>