<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>생산계획 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("plan");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "생산계획 수정"); request.setAttribute("pageSubTitle", "기존 생산계획 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/plan/update" method="post">
                    <input type="hidden" name="planId" value="<%= row.get("planId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" value="<%= row.get("itemId") == null ? "" : row.get("itemId") %>" required>
            </div>

            <div class="form-group">
                <label for="planDate">계획일자</label>
                <input type="date" id="planDate" name="planDate" value="<%= row.get("planDate") == null ? "" : row.get("planDate") %>" required>
            </div>

            <div class="form-group">
                <label for="planQty">계획수량</label>
                <input type="number" id="planQty" name="planQty" value="<%= row.get("planQty") == null ? "" : row.get("planQty") %>" required>
            </div>

            <div class="form-group">
                <label for="lineCode">라인코드</label>
                <input type="text" id="lineCode" name="lineCode" value="<%= row.get("lineCode") == null ? "" : row.get("lineCode") %>" required>
            </div>

            <div class="form-group">
                <label for="status">상태</label>
                <input type="text" id="status" name="status" value="<%= row.get("status") == null ? "" : row.get("status") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/plan/detail?planId=<%= row.get("planId") %>'">취소</button>
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
