<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "생산리포팅");
%>
<%@ include file="common/layout-top.jspf" %>
<section class="grid two-two">
    <div class="metric-card"><span>월간 생산량</span><strong>26,400EA</strong><p>전월 대비 +8.2%</p></div>
    <div class="metric-card"><span>대표 불량유형</span><strong>맛 편차</strong><p>총 불량 중 42%</p></div>
    <div class="metric-card"><span>라인 가동률</span><strong>88%</strong><p>라인 A 최고 효율</p></div>
    <div class="metric-card"><span>출하 적재율</span><strong>95%</strong><p>지연 1건</p></div>
</section>

<section class="grid split mt16">
    <div class="panel">
        <div class="panel-head"><h2>주간 생산 리포트</h2><span class="tag">REPORT</span></div>
        <table class="data-table">
            <thead><tr><th>일자</th><th>품목</th><th>생산수량</th><th>불량수량</th><th>불량률</th></tr></thead>
            <tbody>
            <tr><td>03/21</td><td>콜드브루 330ml</td><td>3,200</td><td>41</td><td>1.28%</td></tr>
            <tr><td>03/22</td><td>카페라떼 250ml</td><td>2,900</td><td>63</td><td>2.17%</td></tr>
            <tr><td>03/23</td><td>원두 500g</td><td>1,200</td><td>11</td><td>0.92%</td></tr>
            </tbody>
        </table>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>리포트 인사이트</h2><span class="tag accent">INSIGHT</span></div>
        <ul class="timeline-list">
            <li>카페라떼 공정은 오후 시간대 맛 편차가 상대적으로 높음</li>
            <li>콜드브루 제품은 포장 이후 실링 불량이 주된 원인</li>
            <li>원두 500g 제품군은 가장 낮은 불량률을 유지</li>
            <li>다음 단계 확장 시 작업자별 생산 실적 분석 연결 가능</li>
        </ul>
    </div>
</section>
<%@ include file="common/layout-bottom.jspf" %>
