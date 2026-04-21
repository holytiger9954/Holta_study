<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>공정 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body>
<%
    Map<String,Object> row = (Map<String,Object>) request.getAttribute("process");
%>
<div class="app">
    <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />
    <main class="main">
        <% request.setAttribute("pageTitle", "공정 수정"); request.setAttribute("pageSubTitle", "기존 공정 정보를 수정하는 화면입니다."); %>
        <jsp:include page="/WEB-INF/views/common/topbar.jsp" />
        <div id="content-area">
            <div class="content-card">
                <form action="${pageContext.request.contextPath}/process/update" method="post">
                    <input type="hidden" name="processId" value="<%= row.get("processId") %>">
                    <div class="form-row">
            <div class="form-group">
                <label for="processCode">공정코드</label>
                <input type="text" id="processCode" name="processCode" value="<%= row.get("processCode") == null ? "" : row.get("processCode") %>" required>
            </div>

            <div class="form-group">
                <label for="processName">공정명</label>
                <input type="text" id="processName" name="processName" value="<%= row.get("processName") == null ? "" : row.get("processName") %>" required>
            </div>

            <div class="form-group">
                <label for="useYn">사용여부</label>
                <input type="text" id="useYn" name="useYn" value="<%= row.get("useYn") == null ? "" : row.get("useYn") %>" required>
            </div>
        </div>
                    <div class="btn-area">
                        <button type="button" class="btn-secondary" onclick="location.href='${pageContext.request.contextPath}/process/detail?processId=<%= row.get("processId") %>'">취소</button>
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
