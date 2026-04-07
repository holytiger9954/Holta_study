<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "작업자 대시보드");
%>
<%@ include file="common/layout-top.jspf" %>

<section class="grid two-two">
    <div class="metric-card"><span>오늘 내 작업</span><strong>3건</strong><p>아메리카노 RTD / 카페라떼 / 드립백</p></div>
    <div class="metric-card"><span>현재 배치</span><strong>LOT-LT-260325-02</strong><p>카페라떼 250ml 800EA</p></div>
    <div class="metric-card"><span>내 실적</span><strong>540EA</strong><p>목표 대비 84%</p></div>
    <div class="metric-card"><span>검사 요청</span><strong>1건</strong><p>충전 후 샘플 검사 대기</p></div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>내 작업 처리량</h2><span class="tag">Worker View</span></div>
        <div class="chart-wrap chart-short"><canvas id="workerOutputChart"></canvas></div>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>작업 상태 비율</h2><span class="tag done">Today</span></div>
        <div class="chart-wrap chart-short"><canvas id="workerStatusChart"></canvas></div>
    </div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>금일 작업지시</h2><span class="tag">Worker View</span></div>
        <table class="data-table">
            <thead><tr><th>WO No</th><th>품목</th><th>목표수량</th><th>공정</th><th>액션</th></tr></thead>
            <tbody>
            <tr><td>WO-20260325-001</td><td>콜드브루 330ml</td><td>1,000EA</td><td>충전/실링</td><td><button class="mini-btn">실적입력</button></td></tr>
            <tr><td>WO-20260325-002</td><td>카페라떼 250ml</td><td>800EA</td><td>추출</td><td><button class="mini-btn">작업시작</button></td></tr>
            <tr><td>WO-20260325-005</td><td>드립백 10입</td><td>250BOX</td><td>포장</td><td><button class="mini-btn">완료처리</button></td></tr>
            </tbody>
        </table>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>작업 체크리스트</h2><span class="tag done">Ready</span></div>
        <ul class="check-list">
            <li><input type="checkbox" checked> LOT 번호 확인</li>
            <li><input type="checkbox" checked> 원자재 투입량 검증</li>
            <li><input type="checkbox"> 샘플 시음 검사 등록</li>
            <li><input type="checkbox"> 포장재 실링 상태 확인</li>
        </ul>
    </div>
</section>

<section class="panel mt16">
    <div class="panel-head"><h2>작업자 메모</h2><span class="tag warn">주의</span></div>
    <p class="note-box">카페라떼 라인은 14시 이후 우유 탱크 세척 후 재가동 예정입니다. 배치 전 CIP 확인이 필요합니다.</p>
</section>

<script>
(() => {
    new Chart(document.getElementById('workerOutputChart'), {
        type: 'line',
        data: {
            labels: ['09시', '10시', '11시', '12시', '13시', '14시'],
            datasets: [{
                label: '처리량(EA)',
                data: [62, 88, 94, 76, 103, 117],
                tension: 0.35,
                fill: false
            }]
        },
        options: { responsive: true, maintainAspectRatio: false }
    });

    new Chart(document.getElementById('workerStatusChart'), {
        type: 'pie',
        data: {
            labels: ['완료', '진행중', '대기'],
            datasets: [{
                data: [5, 2, 1]
            }]
        },
        options: { responsive: true, maintainAspectRatio: false }
    });
})();
</script>

<%@ include file="common/layout-bottom.jspf" %>
