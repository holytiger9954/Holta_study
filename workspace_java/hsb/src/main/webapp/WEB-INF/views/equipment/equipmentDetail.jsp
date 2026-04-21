<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>설비 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("equipment");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "설비 상세"); request.setAttribute("pageSubTitle", "설비 상세 정보를 확인하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <table class="detail-table">
                    <tr><th>설비 ID</th><td><%= row.get("equipmentId") %></td></tr><tr><th>설비코드</th><td><%= row.get("equipmentCode") %></td></tr><tr><th>설비명</th><td><%= row.get("equipmentName") %></td></tr><tr><th>모델명</th><td><%= row.get("modelName") %></td></tr><tr><th>위치</th><td><%= row.get("location") %></td></tr><tr><th>제조사</th><td><%= row.get("manufacturer") %></td></tr><tr><th>사용여부</th><td><%= row.get("useYn") %></td></tr>
                </table>
                <div class="btn-area">
                    <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/equipment/list'">목록</button>
                    <button type="button" class="btn-primary" onclick="location.href='${pageContext.request.contextPath}/equipment/updateForm?equipmentId=<%= row.get("equipmentId") %>'">수정</button>
                </div>
            </div>

        </div>
    </main>
</div>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
</body>
</html>
