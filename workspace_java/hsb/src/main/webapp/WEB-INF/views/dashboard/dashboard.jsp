<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>대시보드</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <%
            request.setAttribute("pageTitle", "대시보드");
            request.setAttribute("pageSubTitle", "생산, 작업, 실적, 설비 현황을 한 눈에 확인하는 화면입니다.");
        %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="dashboard-grid">
                <div class="dashboard-card"><h3>오늘 생산계획</h3><div class="value"><%= request.getAttribute("todayPlanCount") %></div></div>
                <div class="dashboard-card"><h3>진행 중 작업지시</h3><div class="value"><%= request.getAttribute("inProgressWorkOrderCount") %></div></div>
                <div class="dashboard-card"><h3>오늘 생산실적</h3><div class="value"><%= request.getAttribute("todayResultCount") %></div></div>
                <div class="dashboard-card"><h3>누적 양품 수량</h3><div class="value"><%= request.getAttribute("totalGoodQty") %></div></div>
                <div class="dashboard-card"><h3>누적 불량 수량</h3><div class="value"><%= request.getAttribute("totalDefectQty") %></div></div>
                <div class="dashboard-card"><h3>가동 설비 수</h3><div class="value"><%= request.getAttribute("activeEquipmentCount") %></div></div>
            </div>

            <div class="dashboard-section">
                <h3 style="margin-top:0;">최근 생산실적 5건</h3>
                <table class="mini-table">
                    <thead>
                        <tr><th>실적ID</th><th>작업지시ID</th><th>품목코드</th><th>품목명</th><th>실적일자</th><th>양품수량</th><th>불량수량</th><th>상태</th></tr>
                    </thead>
                    <tbody>
                    <%
                        List<Map<String,Object>> recentResultList = (List<Map<String,Object>>) request.getAttribute("recentResultList");
                        if (recentResultList != null) for (Map<String,Object> r : recentResultList) {
                    %>
                        <tr>
                            <td><%= r.get("resultId") %></td>
                            <td><%= r.get("workOrderId") %></td>
                            <td><%= r.get("itemCode") %></td>
                            <td><%= r.get("itemName") %></td>
                            <td><%= r.get("resultDate") %></td>
                            <td><%= r.get("goodQty") %></td>
                            <td><%= r.get("defectQty") %></td>
                            <td><%= r.get("status") %></td>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>

            <div class="dashboard-section">
                <h3 style="margin-top:0;">작업지시 상태별 집계</h3>
                <table class="mini-table">
                    <thead>
                        <tr><th>상태</th><th>건수</th></tr>
                    </thead>
                    <tbody>
                    <%
                        List<Map<String,Object>> workOrderStatusList = (List<Map<String,Object>>) request.getAttribute("workOrderStatusList");
                        if (workOrderStatusList != null) for (Map<String,Object> s : workOrderStatusList) {
                    %>
                        <tr>
                            <td><%= s.get("status") %></td>
                            <td><%= s.get("count") %></td>
                        </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
