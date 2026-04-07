<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<h1>회원가입</h1>

	<form method="post" action="<%=request.getContextPath()%>/user/join">
		<div>
			아이디: <input type="text" name="userId">
		</div>
		<div>
			비밀번호: <input type="password" name="userPw">
		</div>
		<div>
			이름: <input type="text" name="userName">
		</div>
		<div>
			전화번호: <input type="text" name="userTel">
		</div>
		<div>
			주소: <input type="text" name="userAddr">
		</div>
		<div>
			<button type="submit">회원가입</button>
		</div>
	</form>

	<br>

	<a href="<%=request.getContextPath()%>/user/login">로그인으로</a>

</body>
</html>