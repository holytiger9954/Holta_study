<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>작업지시 관리</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "작업지시 관리"); request.setAttribute("pageSubTitle", "작업지시 등록 및 조회 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <div class="page-actions">
                    <form class="search-box">
                        <input type="text" placeholder="검색어 입력">
                        <button type="button" class="btn-secondary">검색</button>
                    </form>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/workOrder/insertForm'">작업지시 등록</button>
                </div>
                <table class="table-basic">
                    <thead><tr><th>지시ID</th><th>계획ID</th><th>품목명</th><th>시작일</th><th>종료일</th><th>지시수량</th><th>상태</th><th>관리</th></tr></thead>
                    <tbody>
                    <%
                        List<Map<String,Object>> list = (List<Map<String,Object>>) request.getAttribute("workOrderList");
                        if (list != null) for (Map<String,Object> row : list) {
                    %>
                        <tr>
                            <td><%= row.get("workOrderId") %></td><td><%= row.get("planId") %></td><td><%= row.get("itemName") %></td><td><%= row.get("startDate") %></td><td><%= row.get("endDate") %></td><td><%= row.get("orderQty") %></td><td><%= row.get("status") %></td>
                            <td>
                                <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/workOrder/detail?workOrderId=<%= row.get("workOrderId") %>'">상세</button>
                                <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/workOrder/updateForm?workOrderId=<%= row.get("workOrderId") %>'">수정</button>
                            </td>
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
