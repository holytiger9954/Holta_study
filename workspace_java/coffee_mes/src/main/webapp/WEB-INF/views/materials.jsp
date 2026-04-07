<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "자재관리");
%>
<%@ include file="common/layout-top.jspf" %>
<section class="grid split">
    <div class="panel">
        <div class="panel-head"><h2>자재 재고 현황</h2><span class="tag">MATERIAL</span></div>
        <table class="data-table">
            <thead><tr><th>자재명</th><th>현재고</th><th>안전재고</th><th>LOT</th><th>상태</th></tr></thead>
            <tbody>
            <tr><td>콜롬비아 원두</td><td>182 KG</td><td>80 KG</td><td>RM-CB-260320</td><td><span class="status done">정상</span></td></tr>
            <tr><td>우유</td><td>240 L</td><td>120 L</td><td>RM-ML-260324</td><td><span class="status doing">주의</span></td></tr>
            <tr><td>330ml 캔</td><td>680 EA</td><td>1000 EA</td><td>PM-CN-260318</td><td><span class="status danger">부족</span></td></tr>
            <tr><td>뚜껑</td><td>1900 EA</td><td>800 EA</td><td>PM-LD-260321</td><td><span class="status done">정상</span></td></tr>
            </tbody>
        </table>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>입출고 요약</h2><span class="tag warn">Daily</span></div>
        <ul class="timeline-list">
            <li><strong>입고</strong> 원두 100KG / 우유 80L</li>
            <li><strong>투입</strong> 콜드브루 배치에 원두 24KG 사용</li>
            <li><strong>출고예정</strong> 완제품 1,200EA 적재 대기</li>
            <li><strong>조치필요</strong> 330ml 캔 긴급 발주 검토</li>
        </ul>
    </div>
</section>
<%@ include file="common/layout-bottom.jspf" %>
