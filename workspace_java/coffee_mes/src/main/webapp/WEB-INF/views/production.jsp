<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "생산관리");
%>
<%@ include file="common/layout-top.jspf" %>
<section class="grid split">
    <div class="panel">
        <div class="panel-head"><h2>생산 실적 입력</h2><span class="tag">PRODUCTION</span></div>
        <form class="form-mockup">
            <label>작업지시번호
                <select><option>WO-20260325-001</option><option>WO-20260325-002</option></select>
            </label>
            <label>생산수량
                <input type="number" value="760">
            </label>
            <label>정상수량
                <input type="number" value="748">
            </label>
            <label>불량수량
                <input type="number" value="12">
            </label>
            <label>불량사유
                <select><option>맛 편차</option><option>용량 부족</option><option>실링 불량</option></select>
            </label>
            <button type="button">실적 저장</button>
        </form>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>공정/검사/출하 연결</h2><span class="tag warn">FLOW</span></div>
        <div class="flow-column">
            <div class="flow-step">1. 추출 완료</div>
            <div class="flow-step">2. 혼합 및 충전</div>
            <div class="flow-step">3. 샘플 시음 검사</div>
            <div class="flow-step">4. 포장 완료</div>
            <div class="flow-step">5. 완제품 재고 반영</div>
            <div class="flow-step">6. 출하 대기 / 트럭 적재 전 상태</div>
        </div>
    </div>
</section>
<%@ include file="common/layout-bottom.jspf" %>
