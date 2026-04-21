<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ROUTING 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("routing");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "ROUTING 상세"); request.setAttribute("pageSubTitle", "ROUTING 상세 정보를 확인하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <table class="detail-table">
                    <tr><th>ROUTING ID</th><td><%= row.get("routingId") %></td></tr><tr><th>품목코드</th><td><%= row.get("itemCode") %></td></tr><tr><th>품목명</th><td><%= row.get("itemName") %></td></tr><tr><th>공정코드</th><td><%= row.get("processCode") %></td></tr><tr><th>공정명</th><td><%= row.get("processName") %></td></tr><tr><th>설비코드</th><td><%= row.get("equipmentCode") %></td></tr><tr><th>설비명</th><td><%= row.get("equipmentName") %></td></tr><tr><th>공정순서</th><td><%= row.get("processSeq") %></td></tr><tr><th>사용여부</th><td><%= row.get("useYn") %></td></tr>
                </table>
                <div class="btn-area">
                    <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/routing/list'">목록</button>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/routing/updateForm?routingId=<%= row.get("routingId") %>'">수정</button>
                </div>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
