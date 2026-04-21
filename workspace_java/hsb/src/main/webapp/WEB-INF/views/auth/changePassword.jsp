<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div style="display:flex;min-height:100vh;justify-content:center;align-items:center;">
    <div class="content-card" style="width:460px;">
        <h2 style="margin-top:0;">비밀번호 변경</h2>
        <p>최초 로그인 상태입니다. 새 비밀번호로 변경해주세요.</p>
        <form action="${pageContext.request.contextPath}/changePassword" method="post">
            <div class="form-group">
                <label>현재 비밀번호</label>
                <input type="password" name="currentPwd" required>
            </div>
            <div class="form-group">
                <label>새 비밀번호</label>
                <input type="password" name="newPwd" required>
            </div>
            <div class="form-group">
                <label>새 비밀번호 확인</label>
                <input type="password" name="newPwdConfirm" required>
            </div>
            <div class="btn-area" style="justify-content:flex-end;">
                <button type="submit" class="btn-primary">변경 완료</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
