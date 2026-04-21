<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>접근 제한</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div style="display:flex;min-height:100vh;justify-content:center;align-items:center;">
    <div class="content-card" style="width:420px;text-align:center;">
        <h2 style="margin-top:0;">접근 권한이 없습니다.</h2>
        <p>해당 페이지에 접근할 수 있는 권한이 없습니다.</p>
        <button class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/dashboard'">대시보드로 이동</button>
    </div>
</div>
</body>
</html>
