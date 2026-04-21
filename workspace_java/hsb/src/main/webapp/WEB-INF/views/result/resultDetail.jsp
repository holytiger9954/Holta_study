<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>생산실적 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("result");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "생산실적 상세"); request.setAttribute("pageSubTitle", "생산실적 상세 정보를 확인하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <table class="detail-table">
                    <tr><th>실적ID</th><td><%= row.get("resultId") %></td></tr><tr><th>작업지시ID</th><td><%= row.get("workOrderId") %></td></tr><tr><th>품목코드</th><td><%= row.get("itemCode") %></td></tr><tr><th>품목명</th><td><%= row.get("itemName") %></td></tr><tr><th>실적일자</th><td><%= row.get("resultDate") %></td></tr><tr><th>양품수량</th><td><%= row.get("goodQty") %></td></tr><tr><th>불량수량</th><td><%= row.get("defectQty") %></td></tr><tr><th>상태</th><td><%= row.get("status") %></td></tr>
                </table>
                <div class="btn-area">
                    <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/result/list'">목록</button>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/result/updateForm?resultId=<%= row.get("resultId") %>'">수정</button>
                </div>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
