<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "관리자 대시보드");
%>
<%@ include file="common/layout-top.jspf" %>

<section class="grid two-two">
    <div class="metric-card"><span>금일 작업지시</span><strong>12건</strong><p>로스팅 배치 3건 / RTD 음료 9건</p></div>
    <div class="metric-card"><span>생산 달성률</span><strong>92%</strong><p>목표 1,250EA / 실적 1,148EA</p></div>
    <div class="metric-card"><span>불량률</span><strong>1.8%</strong><p>맛 편차 8건, 포장 불량 4건</p></div>
    <div class="metric-card"><span>출하 대기</span><strong>4건</strong><p>마트 납품용 RTD 캔커피 적재 예정</p></div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>주간 생산량 추이</h2><span class="tag">Output</span></div>
        <div class="chart-wrap"><canvas id="adminProductionChart"></canvas></div>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>불량 유형 비율</h2><span class="tag warn">Quality</span></div>
        <div class="chart-wrap"><canvas id="adminDefectChart"></canvas></div>
    </div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>공정별 진행 현황</h2><span class="tag accent">Process</span></div>
        <div class="chart-wrap chart-short"><canvas id="adminProcessChart"></canvas></div>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>자재 재고 현황</h2><span class="tag">Materials</span></div>
        <div class="chart-wrap chart-short"><canvas id="adminStockChart"></canvas></div>
    </div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>실시간 생산 현황</h2><span class="tag">Admin View</span></div>
        <table class="data-table">
            <thead><tr><th>라인</th><th>품목</th><th>진행공정</th><th>상태</th><th>달성률</th></tr></thead>
            <tbody>
            <tr><td>라인 A</td><td>콜드브루 330ml</td><td>충전/실링</td><td><span class="status doing">진행중</span></td><td>76%</td></tr>
            <tr><td>라인 B</td><td>카페라떼 250ml</td><td>추출 완료</td><td><span class="status waiting">검사대기</span></td><td>61%</td></tr>
            <tr><td>라인 C</td><td>원두 500g</td><td>포장</td><td><span class="status done">완료직전</span></td><td>93%</td></tr>
            </tbody>
        </table>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>금일 알림</h2><span class="tag warn">Attention</span></div>
        <ul class="timeline-list">
            <li><strong>09:10</strong> 콜드브루 배치 LOT-CB-260325-01 시작</li>
            <li><strong>10:35</strong> 카페라떼 라인 용량 편차 검사 필요</li>
            <li><strong>13:20</strong> 원두 포장 자재(파우치) 안전재고 15% 이하</li>
            <li><strong>15:00</strong> 대형마트 1차 출하 적재 예정</li>
        </ul>
    </div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>공정 흐름</h2><span class="tag">Bean to Product</span></div>
        <div class="flow-line">
            <div>원두 입고</div><div>배합/분쇄</div><div>추출</div><div>충전/포장</div><div>검사</div><div>출하대기</div>
        </div>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>관리자 빠른 실행</h2><span class="tag accent">Shortcut</span></div>
        <div class="button-grid">
            <a class="action-btn" href="${pageContext.request.contextPath}/work-orders">작업지시 등록</a>
            <a class="action-btn" href="${pageContext.request.contextPath}/materials">자재 재고 확인</a>
            <a class="action-btn" href="${pageContext.request.contextPath}/production">검사 승인</a>
            <a class="action-btn" href="${pageContext.request.contextPath}/reports">리포트 확인</a>
        </div>
    </div>
</section>

<script>
(() => {
    new Chart(document.getElementById('adminProductionChart'), {
        type: 'bar',
        data: {
            labels: ['월','화','수','목','금','토'],
            datasets: [{
                label: '생산량(EA)',
                data: [980, 1120, 1085, 1250, 1148, 860],
                borderRadius: 8
            }]
        },
        options: { responsive: true, maintainAspectRatio: false }
    });

    new Chart(document.getElementById('adminDefectChart'), {
        type: 'doughnut',
        data: {
            labels: ['맛 편차', '용량 부족', '포장 불량', '라벨 오류'],
            datasets: [{
                data: [8, 5, 4, 2]
            }]
        },
        options: { responsive: true, maintainAspectRatio: false }
    });

    new Chart(document.getElementById('adminProcessChart'), {
        type: 'bar',
        data: {
            labels: ['원두 입고', '배합/분쇄', '추출', '충전/포장', '검사', '출하대기'],
            datasets: [{
                label: '진행 건수',
                data: [14, 11, 9, 8, 6, 4],
                borderRadius: 8
            }]
        },
        options: {
            indexAxis: 'y',
            responsive: true,
            maintainAspectRatio: false
        }
    });

    new Chart(document.getElementById('adminStockChart'), {
        type: 'bar',
        data: {
            labels: ['원두', '우유', '시럽', '컵', '뚜껑', '파우치'],
            datasets: [{
                label: '재고',
                data: [420, 210, 160, 520, 490, 80],
                borderRadius: 8
            }]
        },
        options: { responsive: true, maintainAspectRatio: false }
    });
})();
</script>

<%@ include file="common/layout-bottom.jspf" %>
