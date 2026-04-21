<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Begin Again MES</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">
</head>
<body>
<div class="app">
    <aside class="sidebar">
        <div class="sidebar-top">
            <div class="brand">
                <div class="brand-logo"><img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="logo" style="width:28px;height:28px;object-fit:contain;"></div>
                <div>
                    <div class="brand-title">Begin Again MES</div>
                    <div class="brand-sub">2차 전지 양극재 분체 가공</div>
                </div>
            </div>

            <button id="openProfileBtn" type="button" class="profile-card">
                <div class="profile-icon">
                    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><path d="M20 21a8 8 0 0 0-16 0"></path><circle cx="12" cy="7" r="4"></circle></svg>
                </div>
                <div class="profile-text">
                    <div class="name">김령 / 부장</div>
                    <div class="role">MES 운영 관리자</div>
                </div>
                <div class="alarm">🔔</div>
            </button>

            <nav class="sidebar-nav">
                <button class="nav-home active" data-page="dashboard">대시보드</button>

                <div class="menu-group">
                    <button class="menu-title open" type="button">자재관리</button>
                    <div class="menu-items open">
                        <button data-page="materials-register">입출고 등록 / 관리</button>
                        <button data-page="materials-search">입출고 조회</button>
                        <button data-page="materials-stock">재고 조회</button>
                    </div>
                </div>

                <div class="menu-group">
                    <button class="menu-title open" type="button">생산관리</button>
                    <div class="menu-items open">
                        <button data-page="production-plan">생산계획 관리</button>
                        <button data-page="production-result">생산실적 조회</button>
                    </div>
                </div>
            </nav>
        </div>
        <div class="sidebar-bottom">
            <button id="logoutBtn" class="btn btn-ghost" style="width:100%;">로그아웃</button>
        </div>
    </aside>

    <main class="main">
        <button id="menuToggle" type="button">☰</button>
        <div class="global-topbar">
            <div class="global-box">
                <div class="page-heading">
                    <h2 id="pageMainTitle">대시보드</h2>
                    <p id="pageSubTitle">생산, 품질, 설비 현황을 한 눈에 보는 메인 화면</p>
                </div>
            </div>
            <div class="global-clock">
                <span id="liveCalendar">2026-04-12 일요일</span>
                <strong id="liveClock">09 : 00 : 00</strong>
            </div>
        </div>

        <div class="content-area">
            <section class="page-section active" id="page-dashboard" data-title="대시보드" data-subtitle="생산, 품질, 설비 현황을 한 눈에 보는 메인 화면">
                <div class="dashboard-grid">
                    <article class="summary-card accent-main"><span>오늘 생산량</span><strong>15,200 kg</strong><small>목표 대비 94%</small></article>
                    <article class="summary-card accent-blue"><span>작업중 라인</span><strong>3 / 3</strong><small>LN-A, LN-B, LN-C 가동중</small></article>
                    <article class="summary-card accent-orange"><span>불량률</span><strong>1.8%</strong><small>전일 대비 -0.3%</small></article>
                    <article class="summary-card accent-light"><span>설비 가동률</span><strong>89%</strong><small>정기 점검 1건 예정</small></article>
                </div>
                <div class="line-status-row">
                    <article class="line-card"><div class="line-top"><h3>1라인 · 열처리</h3><span>정상 가동</span></div><div class="progress"><span style="width:87%"></span></div><div class="line-bottom"><span>일일 목표 95%</span><strong>불량률 1.0%</strong></div></article>
                    <article class="line-card"><div class="line-top"><h3>2라인 · 혼합공정</h3><span>과부하</span></div><div class="progress"><span style="width:73%"></span></div><div class="line-bottom"><span>일일 목표 95%</span><strong>불량률 1.4%</strong></div></article>
                    <article class="line-card"><div class="line-top"><h3>3라인 · 포장공정</h3><span>점검중</span></div><div class="progress"><span style="width:55%"></span></div><div class="line-bottom"><span>점검 예정 14:00</span><strong>불량률 0.9%</strong></div></article>
                </div>
            </section>

            <section class="page-section" id="page-materials-register" data-title="자재관리" data-subtitle="입출고 등록 / 관리">
                <div class="section-title-chip">입출고 등록 / 관리</div>
                <div class="panel">
                    <div class="panel-head">
                        <h3>입출고 등록 내역</h3>
                        <div class="action-row">
                            <button class="btn btn-soft open-modal-btn" data-modal-target="actionModal">등록</button>
                            <button class="btn btn-outline open-modal-btn" data-modal-target="actionModal">수정</button>
                        </div>
                    </div>
                    <div class="table-wrap medium">
                        <table class="mes-table">
                            <thead>
                                <tr><th>NO</th><th>입/출고구분</th><th>품목코드</th><th>품목명</th><th>입고</th><th>출고</th><th>단위</th><th>발주서번호</th><th>일자</th></tr>
                            </thead>
                            <tbody>
                                <tr><td>12</td><td>입고</td><td>RM-LI-001</td><td>수산화리튬</td><td>2,000</td><td>-</td><td>kg</td><td>PO-20260407-001</td><td>2026-04-07</td></tr>
                                <tr><td>11</td><td>출고</td><td>RM-LI-002</td><td>탄산리튬</td><td>-</td><td>1,200</td><td>kg</td><td>-</td><td>2026-04-07</td></tr>
                                <tr><td>10</td><td>입고</td><td>RM-NI-001</td><td>니켈 분말</td><td>3,500</td><td>-</td><td>kg</td><td>PO-20260406-002</td><td>2026-04-06</td></tr>
                                <tr><td>9</td><td>출고</td><td>RM-CO-001</td><td>코발트 분말</td><td>-</td><td>800</td><td>kg</td><td>-</td><td>2026-04-05</td></tr>
                                <tr><td>8</td><td>입고</td><td>RM-MN-001</td><td>망간 분말</td><td>4,100</td><td>-</td><td>kg</td><td>PO-20260404-001</td><td>2026-04-04</td></tr>
                                <tr><td>7</td><td>입고</td><td>RM-AL-001</td><td>알루미나</td><td>2,400</td><td>-</td><td>kg</td><td>PO-20260403-002</td><td>2026-04-03</td></tr>
                                <tr><td>6</td><td>출고</td><td>RM-NI-001</td><td>니켈 분말</td><td>-</td><td>950</td><td>kg</td><td>-</td><td>2026-04-03</td></tr>
                                <tr><td>5</td><td>입고</td><td>RM-LI-001</td><td>수산화리튬</td><td>5,000</td><td>-</td><td>kg</td><td>PO-20260401-001</td><td>2026-04-01</td></tr>
                                <tr><td>4</td><td>출고</td><td>RM-LI-001</td><td>수산화리튬</td><td>-</td><td>4,500</td><td>kg</td><td>-</td><td>2026-04-02</td></tr>
                                <tr><td>3</td><td>입고</td><td>RM-CO-001</td><td>코발트 분말</td><td>2,700</td><td>-</td><td>kg</td><td>PO-20260331-001</td><td>2026-03-31</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>

            <section class="page-section" id="page-materials-search" data-title="자재관리" data-subtitle="입출고 조회">
                <div class="filter-bar">
                    <div class="field-group"><label>구분</label><select><option>전체</option><option>입고</option><option>출고</option></select></div>
                    <div class="field-group"><label>기간</label><select><option>최근 7일</option><option>최근 30일</option></select></div>
                    <div class="field-group field-grow"><label>검색키워드</label><div class="search-box"><input type="text" placeholder="품목명 / 품목코드 / 발주서번호 검색"><button>🔍</button></div></div>
                </div>
                <div class="table-wrap tall">
                    <table class="mes-table">
                        <thead><tr><th>NO</th><th>입/출고구분</th><th>품목코드</th><th>품목명</th><th>입고</th><th>출고</th><th>단위</th><th>발주서번호</th><th>일자</th></tr></thead>
                        <tbody>
                            <tr><td>10</td><td>입고</td><td>RM-LI-001</td><td>수산화리튬</td><td>2,000</td><td>-</td><td>kg</td><td>PO-20260407-001</td><td>2026-04-07</td></tr>
                            <tr><td>9</td><td>출고</td><td>RM-LI-002</td><td>탄산리튬</td><td>-</td><td>1,200</td><td>kg</td><td>-</td><td>2026-04-07</td></tr>
                            <tr><td>8</td><td>입고</td><td>RM-NI-001</td><td>니켈 분말</td><td>3,500</td><td>-</td><td>kg</td><td>PO-20260406-002</td><td>2026-04-06</td></tr>
                            <tr><td>7</td><td>출고</td><td>RM-CO-001</td><td>코발트 분말</td><td>-</td><td>800</td><td>kg</td><td>-</td><td>2026-04-05</td></tr>
                            <tr><td>6</td><td>입고</td><td>RM-MN-001</td><td>망간 분말</td><td>4,100</td><td>-</td><td>kg</td><td>PO-20260404-001</td><td>2026-04-04</td></tr>
                            <tr><td>5</td><td>입고</td><td>RM-AL-001</td><td>알루미나</td><td>2,400</td><td>-</td><td>kg</td><td>PO-20260403-002</td><td>2026-04-03</td></tr>
                            <tr><td>4</td><td>출고</td><td>RM-NI-001</td><td>니켈 분말</td><td>-</td><td>950</td><td>kg</td><td>-</td><td>2026-04-03</td></tr>
                            <tr><td>3</td><td>입고</td><td>RM-LI-001</td><td>수산화리튬</td><td>5,000</td><td>-</td><td>kg</td><td>PO-20260401-001</td><td>2026-04-01</td></tr>
                            <tr><td>2</td><td>출고</td><td>RM-LI-001</td><td>수산화리튬</td><td>-</td><td>4,500</td><td>kg</td><td>-</td><td>2026-04-02</td></tr>
                            <tr><td>1</td><td>입고</td><td>RM-CO-001</td><td>코발트 분말</td><td>2,700</td><td>-</td><td>kg</td><td>PO-20260331-001</td><td>2026-03-31</td></tr>
                        </tbody>
                    </table>
                </div>
            </section>

            <section class="page-section" id="page-materials-stock" data-title="자재관리" data-subtitle="재고 조회">
                <div class="panel">
                    <div class="panel-head"><h3>재고 현황</h3><div class="action-row"><button class="btn btn-soft open-modal-btn" data-modal-target="actionModal">수정</button></div></div>
                    <div class="table-wrap medium">
                        <table class="mes-table">
                            <thead><tr><th>NO</th><th>품목코드</th><th>품목명</th><th>재고</th><th>안전재고</th><th>단위</th><th>위치</th><th>비고</th></tr></thead>
                            <tbody>
                                <tr><td>1</td><td>RM-LI-001</td><td>수산화리튬</td><td>4,500</td><td>2,800</td><td>kg</td><td>WH-A-23</td><td>정상</td></tr>
                                <tr><td>2</td><td>RM-NI-001</td><td>니켈 분말</td><td>1,200</td><td>2,000</td><td>kg</td><td>WH-B-12</td><td>부족</td></tr>
                                <tr><td>3</td><td>RM-CO-001</td><td>코발트 분말</td><td>3,800</td><td>2,500</td><td>kg</td><td>WH-C-05</td><td>정상</td></tr>
                                <tr><td>4</td><td>RM-MN-001</td><td>망간 분말</td><td>2,100</td><td>1,600</td><td>kg</td><td>WH-C-07</td><td>정상</td></tr>
                                <tr><td>5</td><td>RM-AL-001</td><td>알루미나</td><td>850</td><td>1,000</td><td>kg</td><td>WH-D-02</td><td>안전재고 미만</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>

            <section class="page-section" id="page-production-plan" data-title="생산관리" data-subtitle="생산계획 관리">
                <div class="panel">
                    <div class="panel-head"><h3>생산계획 목록</h3><div class="action-row"><button class="btn btn-soft open-modal-btn" data-modal-target="actionModal">등록</button><button class="btn btn-outline open-modal-btn" data-modal-target="actionModal">수정</button></div></div>
                    <div class="table-wrap medium">
                        <table class="mes-table">
                            <thead><tr><th>NO</th><th>생산계획번호</th><th>시작예정일</th><th>종료예정일</th><th>제품코드</th><th>제품명</th><th>생산계획량</th><th>단위</th><th>라인</th><th>발주처</th><th>비고</th></tr></thead>
                            <tbody>
                                <tr><td>6</td><td>PP-20260412-006</td><td>2026-04-12</td><td>2026-04-12</td><td>FG-CAM-006</td><td>양극재 F</td><td>3,800</td><td>kg</td><td>LN-C</td><td>에코프로</td><td>긴급 납품</td></tr>
                                <tr><td>5</td><td>PP-20260411-005</td><td>2026-04-11</td><td>2026-04-11</td><td>FG-CAM-005</td><td>양극재 E</td><td>4,200</td><td>kg</td><td>LN-B</td><td>포스코퓨처엠</td><td>정상</td></tr>
                                <tr><td>4</td><td>PP-20260410-004</td><td>2026-04-10</td><td>2026-04-10</td><td>FG-CAM-004</td><td>양극재 D</td><td>5,000</td><td>kg</td><td>LN-A</td><td>삼성SDI</td><td>우선 생산</td></tr>
                                <tr><td>3</td><td>PP-20260409-003</td><td>2026-04-09</td><td>2026-04-09</td><td>FG-CAM-003</td><td>양극재 C</td><td>4,600</td><td>kg</td><td>LN-C</td><td>SK온</td><td>-</td></tr>
                                <tr><td>2</td><td>PP-20260408-002</td><td>2026-04-08</td><td>2026-04-08</td><td>FG-CAM-002</td><td>양극재 B</td><td>3,200</td><td>kg</td><td>LN-B</td><td>LG화학</td><td>재고 확보</td></tr>
                                <tr><td>1</td><td>PP-20260407-001</td><td>2026-04-07</td><td>2026-04-07</td><td>FG-CAM-001</td><td>양극재 A</td><td>5,000</td><td>kg</td><td>LN-A</td><td>LG화학</td><td>재고 확보</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>

            <section class="page-section" id="page-production-result" data-title="생산관리" data-subtitle="생산실적 조회">
                <div class="panel">
                    <div class="panel-head"><h3>생산실적 목록</h3><div class="action-row"><button class="btn btn-soft open-modal-btn" data-modal-target="actionModal">등록</button></div></div>
                    <div class="table-wrap medium">
                        <table class="mes-table">
                            <thead><tr><th>NO</th><th>작업지시번호</th><th>날짜</th><th>제품코드</th><th>제품명</th><th>생산량</th><th>단위</th><th>라인</th><th>LOT</th><th>발주처</th><th>비고</th></tr></thead>
                            <tbody>
                                <tr><td>6</td><td>WO-20260412-006</td><td>2026-04-12</td><td>FG-CAM-006</td><td>양극재 F</td><td>3,700</td><td>kg</td><td>LN-C</td><td>LOT-260412-006</td><td>에코프로</td><td>완료</td></tr>
                                <tr><td>5</td><td>WO-20260411-005</td><td>2026-04-11</td><td>FG-CAM-005</td><td>양극재 E</td><td>4,100</td><td>kg</td><td>LN-B</td><td>LOT-260411-005</td><td>포스코퓨처엠</td><td>완료</td></tr>
                                <tr><td>4</td><td>WO-20260410-004</td><td>2026-04-10</td><td>FG-CAM-004</td><td>양극재 D</td><td>4,950</td><td>kg</td><td>LN-A</td><td>LOT-260410-004</td><td>삼성SDI</td><td>완료</td></tr>
                                <tr><td>3</td><td>WO-20260409-003</td><td>2026-04-09</td><td>FG-CAM-003</td><td>양극재 C</td><td>4,550</td><td>kg</td><td>LN-C</td><td>LOT-260409-003</td><td>SK온</td><td>완료</td></tr>
                                <tr><td>2</td><td>WO-20260408-002</td><td>2026-04-08</td><td>FG-CAM-002</td><td>양극재 B</td><td>3,180</td><td>kg</td><td>LN-B</td><td>LOT-260408-002</td><td>LG화학</td><td>검사대기</td></tr>
                                <tr><td>1</td><td>WO-20260407-001</td><td>2026-04-07</td><td>FG-CAM-001</td><td>양극재 A</td><td>5,000</td><td>kg</td><td>LN-A</td><td>LOT-260407-001</td><td>LG화학</td><td>완료</td></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>
    </main>
</div>

<div id="profileModal" class="modal-backdrop hidden">
    <div class="profile-modal">
        <div class="modal-header"><h3>내 정보</h3><button type="button" id="closeProfileBtn" class="modal-close">×</button></div>
        <div class="profile-body">
            <div class="profile-avatar">김</div>
            <div class="profile-grid">
                <div class="profile-field"><label>사번</label><input value="E25001" readonly></div>
                <div class="profile-field"><label>이름</label><input value="김령" readonly></div>
                <div class="profile-field"><label>부서</label><input value="생산관리부" readonly></div>
                <div class="profile-field"><label>직급</label><input value="부장" readonly></div>
                <div class="profile-field wide"><label>연락처</label><input value="010-1234-5678"></div>
                <div class="profile-field wide"><label>이메일</label><input value="kimryeong@beginagain.co.kr"></div>
            </div>
        </div>
        <div class="modal-footer"><button type="button" class="btn btn-outline close-modal-btn">닫기</button><button type="button" class="btn btn-primary">저장</button></div>
    </div>
</div>

<div id="actionModal" class="modal-backdrop hidden">
    <div class="profile-modal">
        <div class="modal-header"><h3 id="actionModalTitle">등록 / 수정</h3><button type="button" class="modal-close close-modal-btn">×</button></div>
        <div class="profile-body" style="grid-template-columns:1fr;">
            <div class="profile-grid">
                <div class="profile-field"><label>구분</label><input value="입고"></div>
                <div class="profile-field"><label>품목코드</label><input value="RM-LI-001"></div>
                <div class="profile-field"><label>품목명</label><input value="수산화리튬"></div>
                <div class="profile-field"><label>수량</label><input value="2000"></div>
                <div class="profile-field"><label>단위</label><input value="kg"></div>
                <div class="profile-field"><label>일자</label><input value="2026-04-12"></div>
                <div class="profile-field wide"><label>비고</label><input value="발표용 샘플 데이터"></div>
            </div>
        </div>
        <div class="modal-footer"><button type="button" class="btn btn-outline close-modal-btn">닫기</button><button type="button" class="btn btn-primary">저장</button></div>
    </div>
</div>

<div id="toast" class="toast">완료되었습니다.</div>
<script src="${pageContext.request.contextPath}/assets/js/common.js"></script>
</body>
</html>
