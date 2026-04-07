<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("pageTitle", "작업관리");
%>
<%@ include file="common/layout-top.jspf" %>
<section class="grid split">
    <div class="panel">
        <div class="panel-head"><h2>작업지시 목록</h2><span class="tag">WORK ORDER</span></div>
        <table class="data-table">
            <thead><tr><th>작업지시번호</th><th>품목</th><th>계획수량</th><th>담당라인</th><th>상태</th></tr></thead>
            <tbody>
            <tr><td>WO-20260325-001</td><td>콜드브루 330ml</td><td>1000EA</td><td>라인 A</td><td><span class="status doing">진행중</span></td></tr>
            <tr><td>WO-20260325-002</td><td>카페라떼 250ml</td><td>800EA</td><td>라인 B</td><td><span class="status waiting">준비중</span></td></tr>
            <tr><td>WO-20260325-003</td><td>원두 500g</td><td>600EA</td><td>라인 C</td><td><span class="status done">완료</span></td></tr>
            </tbody>
        </table>
    </div>
    <div class="panel">
        <div class="panel-head"><h2>작업지시 등록 폼 목업</h2><span class="tag accent">FORM</span></div>
        <form class="form-mockup">
            <label>품목
                <select><option>콜드브루 330ml</option><option>카페라떼 250ml</option></select>
            </label>
            <label>계획수량
                <input type="number" value="1000">
            </label>
            <label>담당라인
                <select><option>라인 A</option><option>라인 B</option><option>라인 C</option></select>
            </label>
            <label>예정일자
                <input type="date" value="2026-03-25">
            </label>
            <button type="button">작업지시 등록</button>
        </form>
    </div>
</section>
<%@ include file="common/layout-bottom.jspf" %>
