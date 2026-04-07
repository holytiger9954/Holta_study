<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<h1>로그인</h1>

	<form method="post" action="<%=request.getContextPath()%>/user/login">
		<div>
			아이디: <input type="text" name="userId">
		</div>
		<div>
			비밀번호: <input type="password" name="userPw">
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>

	<br>

	<a href="<%=request.getContextPath()%>/user/join">회원가입</a>

</body>
</html>