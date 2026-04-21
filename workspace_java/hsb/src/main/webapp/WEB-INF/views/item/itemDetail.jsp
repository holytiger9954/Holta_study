<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>품목 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("item");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "품목 상세"); request.setAttribute("pageSubTitle", "품목 상세 정보를 확인하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <table class="detail-table">
                    <tr><th>품목 ID</th><td><%= row.get("itemId") %></td></tr><tr><th>품목코드</th><td><%= row.get("itemCode") %></td></tr><tr><th>품목명</th><td><%= row.get("itemName") %></td></tr><tr><th>품목유형</th><td><%= row.get("itemType") %></td></tr><tr><th>단위</th><td><%= row.get("unit") %></td></tr><tr><th>안전재고</th><td><%= row.get("safetyStock") %></td></tr><tr><th>사용여부</th><td><%= row.get("useYn") %></td></tr>
                </table>
                <div class="btn-area">
                    <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/item/list'">목록</button>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/item/updateForm?itemId=<%= row.get("itemId") %>'">수정</button>
                </div>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
