<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>로그인</h2>

	<form method="post" action="${pageContext.request.contextPath}/login">
		사번: <input type="text" name="empno"><br>
		<br>
		<button type="submit">로그인</button>
	</form>

</body>
</html>