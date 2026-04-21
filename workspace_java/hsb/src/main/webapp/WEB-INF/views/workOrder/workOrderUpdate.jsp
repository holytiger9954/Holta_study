<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>작업지시 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("workOrder");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "작업지시 수정"); request.setAttribute("pageSubTitle", "기존 작업지시 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/workOrder/update" method="post">
                    <input type="hidden" name="workOrderId" value="<%= row.get("workOrderId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="planId">계획ID</label>
                <input type="number" id="planId" name="planId" value="<%= row.get("planId") == null ? "" : row.get("planId") %>" required>
            </div>

            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" value="<%= row.get("itemId") == null ? "" : row.get("itemId") %>" required>
            </div>

            <div class="form-group">
                <label for="startDate">시작일</label>
                <input type="date" id="startDate" name="startDate" value="<%= row.get("startDate") == null ? "" : row.get("startDate") %>" required>
            </div>

            <div class="form-group">
                <label for="endDate">종료일</label>
                <input type="date" id="endDate" name="endDate" value="<%= row.get("endDate") == null ? "" : row.get("endDate") %>" required>
            </div>

            <div class="form-group">
                <label for="orderQty">지시수량</label>
                <input type="number" id="orderQty" name="orderQty" value="<%= row.get("orderQty") == null ? "" : row.get("orderQty") %>" required>
            </div>

            <div class="form-group">
                <label for="status">상태</label>
                <input type="text" id="status" name="status" value="<%= row.get("status") == null ? "" : row.get("status") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/workOrder/detail?workOrderId=<%= row.get("workOrderId") %>'">취소</button>
                        <button type="submit" class="btn-primary">수정 완료</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
