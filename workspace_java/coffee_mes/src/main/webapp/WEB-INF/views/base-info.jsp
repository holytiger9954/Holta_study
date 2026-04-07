<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "기준정보");
%>
<%@ include file="common/layout-top.jspf" %>
<section class="grid split">
    <div class="panel">
        <div class="panel-head"><h2>품목 기준정보</h2><span class="tag">ITEM</span></div>
        <table class="data-table">
            <thead><tr><th>품목코드</th><th>품목명</th><th>구분</th><th>단위</th><th>사용여부</th></tr></thead>
            <tbody>
            <tr><td>FG-001</td><td>콜드브루 330ml</td><td>완제품</td><td>EA</td><td>Y</td></tr>
            <tr><td>FG-002</td><td>카페라떼 250ml</td><td>완제품</td><td>EA</td><td>Y</td></tr>
            <tr><td>RM-001</td><td>콜롬비아 원두</td><td>원자재</td><td>KG</td><td>Y</td></tr>
            <tr><td>PM-001</td><td>330ml 캔</td><td>포장재</td><td>EA</td><td>Y</td></tr>
            </tbody>
        </table>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>BOM / 공정 기준</h2><span class="tag accent">STANDARD</span></div>
        <div class="info-block">
            <h3>콜드브루 330ml</h3>
            <p>원두 0.018kg + 정제수 0.31L + 캔 1EA + 라벨 1EA</p>
            <p>공정: 원두 계량 → 추출 → 숙성 → 충전 → 실링 → 검사</p>
        </div>
        <div class="info-block">
            <h3>카페라떼 250ml</h3>
            <p>원두 0.016kg + 우유 0.15L + 시럽 0.01L + 컵/뚜껑</p>
            <p>공정: 배합 → 추출 → 혼합 → 충전 → 포장 → 검사</p>
        </div>
    </div>
</section>
<%@ include file="common/layout-bottom.jspf" %>
