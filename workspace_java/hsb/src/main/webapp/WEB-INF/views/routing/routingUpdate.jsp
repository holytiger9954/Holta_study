<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ROUTING 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("routing");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "ROUTING 수정"); request.setAttribute("pageSubTitle", "기존 ROUTING 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/routing/update" method="post">
                    <input type="hidden" name="routingId" value="<%= row.get("routingId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="itemId">품목ID</label>
                <input type="number" id="itemId" name="itemId" value="<%= row.get("itemId") == null ? "" : row.get("itemId") %>" required>
            </div>

            <div class="form-group">
                <label for="processId">공정ID</label>
                <input type="number" id="processId" name="processId" value="<%= row.get("processId") == null ? "" : row.get("processId") %>" required>
            </div>

            <div class="form-group">
                <label for="equipmentId">설비ID</label>
                <input type="number" id="equipmentId" name="equipmentId" value="<%= row.get("equipmentId") == null ? "" : row.get("equipmentId") %>" required>
            </div>

            <div class="form-group">
                <label for="processSeq">공정순서</label>
                <input type="number" id="processSeq" name="processSeq" value="<%= row.get("processSeq") == null ? "" : row.get("processSeq") %>" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" value="<%= row.get("useYn") == null ? "" : row.get("useYn") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/routing/detail?routingId=<%= row.get("routingId") %>'">취소</button>
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
