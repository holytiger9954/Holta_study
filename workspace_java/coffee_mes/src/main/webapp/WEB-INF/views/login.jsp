<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Coffee MES Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body class="login-body">
<div class="login-wrap">
    <div class="login-panel">
        <div class="hero-copy">
            <span class="eyebrow">COFFEE BEAN TO PRODUCT</span>
            <h1>원두 기반 커피 제품 MES 목업</h1>
            <p>기준정보, 자재관리, 작업관리, 생산관리, 생산리포팅을 관리자/작업자 권한으로 구분해 확인할 수 있는 데모 프로젝트입니다.</p>
            <div class="demo-card-grid">
                <div class="demo-card">
                    <h3>관리자</h3>
                    <p>admin / admin1234</p>
                </div>
                <div class="demo-card">
                    <h3>작업자</h3>
                    <p>worker / worker1234</p>
                </div>
            </div>
        </div>
        <form class="login-form" method="post" action="${pageContext.request.contextPath}/login">
            <h2>로그인</h2>
            <label>아이디
                <input type="text" name="userId" placeholder="아이디 입력" required>
            </label>
            <label>비밀번호
                <input type="password" name="password" placeholder="비밀번호 입력" required>
            </label>
            <button type="submit">접속하기</button>
            <div class="hint-box error">${errorMessage}</div>
            <div class="hint-box">
                <strong>데모 시나리오</strong>
                <ul>
                    <li>관리자: 작업지시 생성, 생산 현황 확인, 리포트 확인</li>
                    <li>작업자: 금일 작업지시 확인, 생산 실적 입력, 검사 완료 처리</li>
                </ul>
            </div>
        </form>
    </div>
</div>
</body>
</html>
