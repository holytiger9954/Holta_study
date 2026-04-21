<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<style>
.login-wrap{min-height:100vh;display:flex;justify-content:center;align-items:center;padding:24px}
.login-card{width:100%;max-width:420px;background:#fff;border-radius:16px;padding:32px 28px;box-shadow:0 8px 24px rgba(0,0,0,.08)}
.login-title{font-size:28px;font-weight:bold;margin-bottom:8px;color:#1e293b}
.login-sub{color:#64748b;margin-bottom:24px}
.form-group{margin-bottom:16px}.form-group label{display:block;margin-bottom:6px;font-weight:bold;color:#334155}
.form-group input{width:100%;padding:12px 14px;border:1px solid #cbd5e1;border-radius:10px;font-size:14px}
.msg{margin-bottom:16px;padding:12px;border-radius:10px;background:#fee2e2;color:#b91c1c;font-size:14px}
.demo-box{margin-top:20px;padding:14px;border-radius:10px;background:#eff6ff;color:#1e40af;font-size:13px;line-height:1.5}
</style>
</head>
<body>
<div class="login-wrap">
    <div class="login-card">
        <div class="login-title">Begin Again MES</div>
        <div class="login-sub">사원번호와 비밀번호를 입력하세요.</div>
        <% if (request.getAttribute("errorMsg") != null) { %>
            <div class="msg"><%= request.getAttribute("errorMsg") %></div>
        <% } %>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label for="empNo">사원번호</label>
                <input type="text" id="empNo" name="empNo" placeholder="admin / manager / worker" required>
            </div>
            <div class="form-group">
                <label for="empPwd">비밀번호</label>
                <input type="password" id="empPwd" name="empPwd" placeholder="아무 값이나 입력" required>
            </div>
            <button type="submit" class="btn-primary" style="width:100%">로그인</button>
        </form>
        <div class="demo-box">
            발표/demo용 기본 계정:<br>
            admin = MES 관리자<br>
            manager = 현장관리자<br>
            worker = 현장작업자
        </div>
    </div>
</div>
</body>
</html>
