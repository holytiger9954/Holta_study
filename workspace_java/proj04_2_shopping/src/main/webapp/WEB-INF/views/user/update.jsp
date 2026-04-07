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
<title>회원정보 수정</title>
</head>
<body>

	<h1>회원정보 수정</h1>

	<form method="post"
		action="<%=request.getContextPath()%>/user/update">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>아이디</th>
				<td><%=user.getUserId()%></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userPw"
					value="<%=user.getUserPw()%>"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userName"
					value="<%=user.getUserName()%>"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="userTel"
					value="<%=user.getUserTel()%>"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="userAddr"
					value="<%=user.getUserAddr()%>"></td>
			</tr>
		</table>

		<br>

		<button type="submit">수정 완료</button>
		<a href="<%=request.getContextPath()%>/user/mypage">마이페이지</a>
	</form>

</body>
</html>