<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>생산계획 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("plan");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "생산계획 상세"); request.setAttribute("pageSubTitle", "생산계획 상세 정보를 확인하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <table class="detail-table">
                    <tr><th>계획ID</th><td><%= row.get("planId") %></td></tr><tr><th>품목코드</th><td><%= row.get("itemCode") %></td></tr><tr><th>품목명</th><td><%= row.get("itemName") %></td></tr><tr><th>계획일자</th><td><%= row.get("planDate") %></td></tr><tr><th>계획수량</th><td><%= row.get("planQty") %></td></tr><tr><th>라인코드</th><td><%= row.get("lineCode") %></td></tr><tr><th>상태</th><td><%= row.get("status") %></td></tr>
                </table>
                <div class="btn-area">
                    <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/plan/list'">목록</button>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/plan/updateForm?planId=<%= row.get("planId") %>'">수정</button>
                </div>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
